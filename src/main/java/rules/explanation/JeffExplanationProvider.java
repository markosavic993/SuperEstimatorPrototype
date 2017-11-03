package rules.explanation;

import org.goodoldai.jeff.wizard.JEFFWizard;

/**
 * Created by msav on 5/22/2017.
 */
public class JeffExplanationProvider implements ExplanationProvider {

    private JEFFWizard jeffWizard;

    JeffExplanationProvider() {
        jeffWizard = initializeExplanationWizard();
    }

    private JEFFWizard getJeffWizard() {
        return jeffWizard;
    }

    @Override
    public void initializeExplanationWizard(String title) {
        initializeExplanation(title);
    }

    @Override
    public void generateReport(String path) {
        jeffWizard.generateTXTReport(path, false);
    }

    @Override
    public JEFFWizard getExplanationWizard() {
        return getJeffWizard();
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
