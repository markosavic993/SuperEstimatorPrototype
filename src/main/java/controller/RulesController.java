package controller;

import exception.MissingProjectTypeException;
import model.Project;
import model.StoryPoints;
import model.Team;
import rules.RuleType;
import rules.explanation.ExplanationProviderFactory;
import rules.RulesExecutionHandler;
import rules.RulesHandlerFactory;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesController extends StoryPointsCalculator{
    RulesController(RuleType type) {
        super(type);
    }

    @Override
    protected RulesExecutionHandler initRulesHandler() {
        switch (ruleType) {
            case DEFAULT: return RulesHandlerFactory.createDefaultKieHandler();
            case BACKEND: return RulesHandlerFactory.createBackendKieHandler();
            case FRONTEND: return RulesHandlerFactory.createFrontendKieHandler();
            case MOBILE: return RulesHandlerFactory.createMobileKieHandler();
            default: throw new MissingProjectTypeException();
        }
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
