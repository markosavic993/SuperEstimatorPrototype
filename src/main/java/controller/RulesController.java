package controller;

import explanation.ExplanationManager;
import model.Project;
import model.StoryPoints;
import model.Team;
import rules.RulesManager;
import utils.ManagerInitializator;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesController {
    private final RulesManager rulesManager;
    private final ExplanationManager explanationManager;

    public RulesController() {
        rulesManager = ManagerInitializator.getRulesManager();
        explanationManager = ManagerInitializator.getExplanationManager();
    }

    public StoryPoints calculateProjectEstimationsForTeam(Project projectToEstimate, Team team) {
        return rulesManager.estimateProject(projectToEstimate, team);
    }

    public StoryPoints calculateProjectEstimationsForTeamWithExplanations(Project projectToEstimate, Team team, String reportTitle, String pathToReport) {
        generateExplanationReport(reportTitle);
        StoryPoints points = rulesManager.estimateProject(projectToEstimate, team);
        explanationManager.generateReport(pathToReport);

        return points;
    }

    public void generateExplanationReport(String reportTitle) {
        rulesManager.setExplanationWizard(explanationManager.getJeffWizard());
        explanationManager.initializeExplanationWizard(reportTitle);
    }
}
