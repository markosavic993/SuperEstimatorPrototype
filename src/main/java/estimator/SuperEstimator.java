package estimator;

import controller.StoryPointsCalculator;
import controller.StoryPointsCalculatorFactory;
import model.Project;
import model.StoryPoints;
import model.Team;

/**
 * Created by msav on 7/22/2017.
 */
class SuperEstimator extends Estimator {

    private static final String REPORT_PREFIX = "REPORT: ";
    private static final String REPORT_PATH_PREFIX = "report_";
    private final StoryPointsCalculator calculator;

    SuperEstimator() {
        calculator = StoryPointsCalculatorFactory.createRulesBasedCalculator(getType());
    }

    @Override
    public StoryPoints estimateProjectForTeam(Project project, Team team) {
        return calculator.calculateProjectEstimationsForTeamWithExplanations(
                project,
                team,
                REPORT_PREFIX + project.getProjectName(),
                REPORT_PATH_PREFIX + project.getProjectName());
    }
}
