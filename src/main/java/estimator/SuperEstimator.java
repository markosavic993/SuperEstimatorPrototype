package estimator;

import controller.RulesController;
import model.Project;
import model.StoryPoints;
import model.Team;

/**
 * Created by msav on 7/22/2017.
 */
public class SuperEstimator implements IEstimator {

    private static final String REPORT_PREFIX = "REPORT: ";
    private static final String REPORT_PATH_PREFIX = "report_";
    private final RulesController controller;

    SuperEstimator() {
        controller = new RulesController();
    }

    @Override
    public StoryPoints estimateProjectForTeam(Project project, Team team) {
        return controller.calculateProjectEstimationsForTeamWithExplanations(
                project,
                team,
                REPORT_PREFIX + project.getProjectName(),
                REPORT_PATH_PREFIX + project.getProjectName());
    }
}
