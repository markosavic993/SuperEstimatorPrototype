package estimator;

import model.Project;
import model.StoryPoints;
import model.Team;

/**
 * Created by msav on 7/22/2017.
 */
public interface IEstimator {
    StoryPoints estimateProjectForTeam(Project project, Team team);
}
