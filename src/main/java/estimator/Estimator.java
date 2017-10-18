package estimator;

import model.Project;
import model.StoryPoints;
import model.Team;
import rules.ProjectRulesType;

/**
 * Created by msav on 7/22/2017.
 */
public abstract class Estimator {

    private ProjectRulesType type = ProjectRulesType.DEFAULT;

    public abstract StoryPoints estimateProjectForTeam(Project project, Team team);

    void setType(ProjectRulesType type) {
        this.type = type;
    }

    protected ProjectRulesType getType() {
        return this.type;
    }
}
