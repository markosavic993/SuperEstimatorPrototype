package rules;

import com.sun.istack.internal.NotNull;
import model.Project;
import model.StoryPoints;
import model.Team;
import org.goodoldai.jeff.wizard.JEFFWizard;

/**
 * Created by msav on 10/11/2017.
 */
public interface RulesExecutionHandler {

    StoryPoints estimateProject(@NotNull Project projectToEstimate, @NotNull Team team);

    void setExplanationWizard(JEFFWizard jeffWizard);
}
