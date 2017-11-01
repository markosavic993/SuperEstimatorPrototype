package rules;

import com.google.common.annotations.VisibleForTesting;
import mappable.Mappable;
import model.Complexity;
import model.Project;
import model.StoryPoints;
import model.Team;
import org.goodoldai.jeff.wizard.JEFFWizard;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import rules.cache.EstimationRequest;
import rules.cache.EstimationsCache;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by msav on 5/21/2017.
 */
public class KieRulesExecutionHandler implements RulesExecutionHandler {

    private static final String COMPLEXITY_VARIABLE = "complexity";
    private ProjectRulesType projectRulesType;
    private KieSession kieSession;

    KieRulesExecutionHandler(ProjectRulesType projectRulesType) {
        this.projectRulesType = projectRulesType;
        kieSession = loadKnowledgeBase();
    }

    @VisibleForTesting
    KieRulesExecutionHandler(KieSession kieSession, ProjectRulesType projectRulesType) {
        this.projectRulesType = projectRulesType;
        this.kieSession = kieSession;
    }

    @Override
    public StoryPoints estimateProject(Project projectToEstimate, Team team) {
        if(projectToEstimate == null) {
            throw new IllegalArgumentException("Given project must not be null!");
        }

        if(team == null) {
            throw  new IllegalArgumentException("Given team must not be null!");
        }

        return doEstimateProject(projectToEstimate, team);
    }

    private StoryPoints doEstimateProject(Project projectToEstimate, Team team) {
        Optional<StoryPoints> cachedValue = EstimationsCache.findInCache(new EstimationRequest(team, projectToEstimate));
        if(cachedValue.isPresent()) {
            return cachedValue.get();
        }

        fillWorkingMemory(kieSession, team, projectToEstimate);

        setComplexityGlobalVariable();

        executeRules();

        EstimationsCache.put(new EstimationRequest(team, projectToEstimate), projectToEstimate.getStoryPoints());

        return projectToEstimate.getStoryPoints();
    }

    @Override
    public void setExplanationWizard(JEFFWizard jeffWizard) {
        kieSession.setGlobal("ef", jeffWizard);
    }

    private void executeRules() {
        kieSession.fireAllRules();
    }

    private void setComplexityGlobalVariable() {
        Complexity initialComplexity = new Complexity(0, 0, 0);
        kieSession.setGlobal(COMPLEXITY_VARIABLE, initialComplexity);
    }

    private void fillWorkingMemory(KieSession kieSession, Object... objects) {
        Arrays.stream(objects)
                .forEach(kieSession::insert);
    }

    private KieSession loadKnowledgeBase() {
        if(kieSession != null) {
            return kieSession;
        }

        return Mappable.of(KieServices.Factory.get())
                .map(KieServices::getKieClasspathContainer)
                .map(kieContainer -> kieContainer.newKieSession(projectRulesType.getKsessionName()))
                .get();
    }

}
