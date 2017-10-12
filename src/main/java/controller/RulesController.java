package controller;

import mappable.Mappable;
import model.Project;
import model.StoryPoints;
import model.Team;
import rules.explanation.ExplanationProvider;
import rules.explanation.ExplanationProviderFactory;
import rules.RulesExecutionHandler;
import rules.RulesHandlerFactory;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesController extends StoryPointsCalculator{
    RulesController() {

        super();
    }

    private RulesExecutionHandler initRuleHandler() {
        RulesExecutionHandler rulesHandler;
        rulesHandler = RulesHandlerFactory.createKieHandler();
        return rulesHandler;
    }

    @Override
    protected RulesExecutionHandler initRulesHandler() {
        return RulesHandlerFactory.createKieHandler();
    }

    @Override
    protected StoryPoints estimate(Project projectToEstimate, Team team) {
        return rulesHandler.estimateProject(projectToEstimate, team);
    }

    @Override
    protected void initializeExplanationProvider() {
        explanationProvider = ExplanationProviderFactory.createJeffExplanationProvider();
    }

    @Override
    protected void generateExplanationReport(String reportTitle) {
        rulesHandler.setExplanationWizard(explanationProvider.getExplanationWizard());
        explanationProvider.initializeExplanationWizard(reportTitle);
    }
}
