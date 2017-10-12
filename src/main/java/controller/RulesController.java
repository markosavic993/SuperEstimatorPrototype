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
public class RulesController {
    private final RulesExecutionHandler rulesHandler;
    private ExplanationProvider explanationProvider;

    public RulesController() {
        rulesHandler = RulesHandlerFactory.createKieHandler();
    }

    public StoryPoints calculateProjectEstimationsForTeam(Project projectToEstimate, Team team) {
        return rulesHandler.estimateProject(projectToEstimate, team);
    }

    public StoryPoints calculateProjectEstimationsForTeamWithExplanations(Project projectToEstimate, Team team, String reportTitle, String pathToReport) {
        explanationProvider = ExplanationProviderFactory.createJeffExplanationProvider();
        generateExplanationReport(reportTitle);
        StoryPoints points = rulesHandler.estimateProject(projectToEstimate, team);
        explanationProvider.generateReport(pathToReport);

        return points;
    }

    private void generateExplanationReport(String reportTitle) {
        rulesHandler.setExplanationWizard(explanationProvider.getExplanationWizard());
        explanationProvider.initializeExplanationWizard(reportTitle);
    }
}
