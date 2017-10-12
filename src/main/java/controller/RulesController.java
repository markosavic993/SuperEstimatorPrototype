package controller;

import model.Project;
import model.StoryPoints;
import model.Team;
import rules.ExplanationProvider;
import rules.RulesExecutionHandler;
import rules.RulesHandlerFactory;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesController {
    private final RulesExecutionHandler rulesManager;
    private ExplanationProvider explanationProvider;

    public RulesController() {
        rulesManager = RulesHandlerFactory.createRulesHandler();
        explanationProvider = RulesHandlerFactory.getExplanationManager();
    }

    public StoryPoints calculateProjectEstimationsForTeam(Project projectToEstimate, Team team) {
        return rulesManager.estimateProject(projectToEstimate, team);
    }

    public StoryPoints calculateProjectEstimationsForTeamWithExplanations(Project projectToEstimate, Team team, String reportTitle, String pathToReport) {
        generateExplanationReport(reportTitle);
        StoryPoints points = rulesManager.estimateProject(projectToEstimate, team);
        explanationProvider.generateReport(pathToReport);

        return points;
    }

    private void generateExplanationReport(String reportTitle) {
        explanationProvider = RulesHandlerFactory.getExplanationManager();
        rulesManager.setExplanationWizard(explanationProvider.getJeffWizard());
        explanationProvider.initializeExplanationWizard(reportTitle);
    }
}
