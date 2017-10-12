package rules;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesHandlerFactory {

    public static RulesExecutionHandler createKieHandler() {
        return new KieRulesExecutionHandler();
    }

}
