package rules;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesHandlerFactory {

    public static RulesExecutionHandler createDefaultKieHandler() {
        return new KieRulesExecutionHandler(RuleType.DEFAULT);
    }

    public static RulesExecutionHandler createFrontendKieHandler() {
        return new KieRulesExecutionHandler(RuleType.FRONTEND);
    }

    public static RulesExecutionHandler createBackendKieHandler() {
        return new KieRulesExecutionHandler(RuleType.BACKEND);
    }

    public static RulesExecutionHandler createMobileKieHandler() {
        return new KieRulesExecutionHandler(RuleType.MOBILE);
    }

}
