package estimator;

import model.Project;
import model.StoryPoints;
import model.Team;
import rules.RuleType;

/**
 * Created by msav on 7/22/2017.
 */
public abstract class Estimator {

    private RuleType type = RuleType.DEFAULT;

    public abstract StoryPoints estimateProjectForTeam(Project project, Team team);

    void setType(RuleType type) {
        this.type = type;
    }

    protected RuleType getType() {
        return this.type;
    }
}
