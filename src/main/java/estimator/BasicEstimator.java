package estimator;

import controller.RulesController;
import controller.StoryPointsCalculator;
import controller.StoryPointsCalculatorFactory;
import model.Project;
import model.StoryPoints;
import model.Team;

/**
 * Created by msav on 7/22/2017.
 */
public class BasicEstimator implements IEstimator {

    private final StoryPointsCalculator calculator;

    BasicEstimator() {
        calculator = StoryPointsCalculatorFactory.createRulesBasedCalculator();
    }

    @Override
    public StoryPoints estimateProjectForTeam(Project project, Team team) {
        return calculator.calculateProjectEstimationsForTeam(project, team);
    }
}
