package utils;

import explanation.ExplanationManager;
import rules.RulesManager;

/**
 * Created by msav on 5/21/2017.
 */
public class ManagerInitializator {

    public static RulesManager getRulesManager() {
        return new RulesManager();
    }

    public static ExplanationManager getExplanationManager() {
        return new ExplanationManager();
    }
}
