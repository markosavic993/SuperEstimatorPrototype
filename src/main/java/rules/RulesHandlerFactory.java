package rules;

/**
 * Created by msav on 5/21/2017.
 */
public class RulesHandlerFactory {

    public static RulesExecutionHandler createDefaultKieHandler() {
        return new KieRulesExecutionHandler(ProjectRulesType.DEFAULT);
    }

    public static RulesExecutionHandler createFrontendKieHandler() {
        return new KieRulesExecutionHandler(ProjectRulesType.FRONTEND);
    }

    public static RulesExecutionHandler createBackendKieHandler() {
        return new KieRulesExecutionHandler(ProjectRulesType.BACKEND);
    }

    public static RulesExecutionHandler createMobileKieHandler() {
        return new KieRulesExecutionHandler(ProjectRulesType.MOBILE);
    }

}
