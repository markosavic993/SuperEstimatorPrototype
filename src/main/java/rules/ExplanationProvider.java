package rules;

import org.goodoldai.jeff.wizard.JEFFWizard;

/**
 * Created by msav on 5/22/2017.
 */
public class ExplanationProvider {

    private JEFFWizard jeffWizard;

    ExplanationProvider() {
        jeffWizard = initializeExplanationWizard();
    }

    public JEFFWizard getJeffWizard() {
        return jeffWizard;
    }

    public void initializeExplanationWizard(String title) {
        initializeExplanation(title);
    }

    public void generateReport(String path) {
        jeffWizard.generatePDFReport(path, false);
    }

    private void initializeExplanation(String title) {
        jeffWizard.setTitle(title);
        jeffWizard.createExplanation();
    }

    private JEFFWizard initializeExplanationWizard() {
        jeffWizard = new JEFFWizard();
        jeffWizard.setInternationalization(false);
        return jeffWizard;
    }

}