package estimator;

import controller.RulesController;
import model.Project;
import model.StoryPoints;
import model.Team;

/**
 * Created by msav on 7/22/2017.
 */
public class BasicEstimator implements IEstimator {

    private final RulesController controller;

    BasicEstimator() {
        controller = new RulesController();
    }

    @Override
    public StoryPoints estimateProjectForTeam(Project project, Team team) {
        return controller.calculateProjectEstimationsForTeam(project, team);
    }
}
