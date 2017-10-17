package estimator;

import controller.StoryPointsCalculator;
import controller.StoryPointsCalculatorFactory;
import model.Project;
import model.StoryPoints;
import model.Team;

/**
 * Created by msav on 7/22/2017.
 */
class BasicEstimator extends Estimator {

    private final StoryPointsCalculator calculator;

    BasicEstimator() {
        calculator = StoryPointsCalculatorFactory.createRulesBasedCalculator(getType());
    }

    @Override
    public StoryPoints estimateProjectForTeam(Project project, Team team) {
        return calculator.calculateProjectEstimationsForTeam(project, team);
    }
}
