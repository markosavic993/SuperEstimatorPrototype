package controller;

import rules.ExplanationProvider;
import model.Project;
import model.StoryPoints;
import model.Team;
import rules.RulesExecutor;
import rules.UtilityFactory;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesController {
    private final RulesExecutor rulesExecutor;
    private ExplanationProvider explanationProvider;

    public RulesController() {
        rulesExecutor = UtilityFactory.createRulesExecutor();
        explanationProvider = UtilityFactory.createExplanationProvider();
    }

    public StoryPoints calculateProjectEstimationsForTeam(Project projectToEstimate, Team team) {
        return rulesExecutor.estimateProject(projectToEstimate, team);
    }

    public StoryPoints calculateProjectEstimationsForTeamWithExplanations(Project projectToEstimate, Team team, String reportTitle, String pathToReport) {
        generateExplanationReport(reportTitle);
        StoryPoints points = rulesExecutor.estimateProject(projectToEstimate, team);
        explanationProvider.generateReport(pathToReport);

        return points;
    }

    private void generateExplanationReport(String reportTitle) {
        explanationProvider = UtilityFactory.createExplanationProvider();
        rulesExecutor.setExplanationWizard(explanationProvider.getJeffWizard());
        explanationProvider.initializeExplanationWizard(reportTitle);
    }
}
