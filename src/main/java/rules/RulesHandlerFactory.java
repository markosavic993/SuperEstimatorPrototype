package rules;

import rules.KieRulesExecutionHandler;
import rules.RulesExecutionHandler;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesHandlerFactory {

    public static RulesExecutionHandler createRulesHandler() {
        return new KieRulesExecutionHandler();
    }

    public static ExplanationProvider getExplanationManager() {
        return new ExplanationProvider();
    }
}
