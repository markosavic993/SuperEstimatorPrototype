package rules;

import model.Complexity;
import model.Project;
import model.StoryPoints;
import model.Team;
import org.goodoldai.jeff.wizard.JEFFWizard;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Arrays;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesManager {
    private KieSession kieSession;

    public RulesManager() {
        kieSession = loadKnowledgeBase();
    }

    public StoryPoints estimateProject(Project projectToEstimate, Team team) {
        fillWorkingMemory(kieSession, team, projectToEstimate);
        Complexity complexity = new Complexity(0, 0, 0);
        kieSession.setGlobal("complexity", complexity);
        kieSession.fireAllRules();

        return projectToEstimate.getStoryPoints();
    }

    private void fillWorkingMemory(KieSession kieSession, Object... objects) {
        Arrays.stream(objects)
                .forEach(kieSession::insert);
    }

    private KieSession loadKnowledgeBase() {
        if(kieSession != null) {
            return kieSession;
        }
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        return kContainer.newKieSession("ksession-rules");
    }

    public void setExplanationWizard(JEFFWizard jeffWizard) {
        kieSession.setGlobal("ef", jeffWizard);
    }
}
