package rules;

/**
 * Created by msav on 5/21/2017.
 */
public class UtilityFactory {

    public static RulesExecutor createRulesExecutor() {
        return new RulesExecutor();
    }

    public static ExplanationProvider createExplanationProvider() {
        return new ExplanationProvider();
    }
}
