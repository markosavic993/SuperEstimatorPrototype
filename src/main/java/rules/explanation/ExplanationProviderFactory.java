package rules.explanation;

/**
 * Created by msav on 10/12/2017.
 */
public class ExplanationProviderFactory {

    public static ExplanationProvider createJeffExplanationProvider() {
        return new JeffExplanationProvider();
    }
}
