package controller;

import model.Project;
import model.StoryPoints;
import model.Team;
import rules.RulesExecutionHandler;
import rules.explanation.ExplanationProvider;

/**
 * Created by msav on 10/12/2017.
 */
public abstract class StoryPointsCalculator {

    final RulesExecutionHandler rulesHandler;
    ExplanationProvider explanationProvider;

    StoryPointsCalculator() {
        rulesHandler = initRulesHandler();
    }

    public StoryPoints calculateProjectEstimationsForTeam(Project projectToEstimate, Team team) {
        return estimate(projectToEstimate, team);
    }

    public StoryPoints calculateProjectEstimationsForTeamWithExplanations(Project projectToEstimate, Team team, String reportTitle, String pathToReport) {
        initializeExplanationProvider();
        generateExplanationReport(reportTitle);
        StoryPoints points = estimate(projectToEstimate, team);
        generateEstimationExplanationReport(pathToReport);

        return points;
    }

    protected abstract RulesExecutionHandler initRulesHandler();

    protected abstract StoryPoints estimate(Project projectToEstimate, Team team);

    private void generateEstimationExplanationReport(String pathToReport) {
        explanationProvider.generateReport(pathToReport);
    }

    protected abstract void generateExplanationReport(String reportTitle);

    protected abstract void initializeExplanationProvider();
}