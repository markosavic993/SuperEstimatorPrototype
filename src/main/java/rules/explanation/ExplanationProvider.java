package rules.explanation;

import org.goodoldai.jeff.wizard.JEFFWizard;

/**
 * Created by msav on 10/12/2017.
 */
public interface ExplanationProvider {
    void generateReport(String pathToReport);

    JEFFWizard getExplanationWizard();

    void initializeExplanationWizard(String reportTitle);
}
