package rules;

/**
 * Created by msav on 10/13/2017.
 */
public enum RuleType {
    DEFAULT("ksession-rules"),
    FRONTEND("rules-frontend"),
    BACKEND("rules-backend"),
    MOBILE("rules-mobile");

    private String ksessionName;

    RuleType(String ksessionName) {
        this.ksessionName = ksessionName;
    }

    public String getKsessionName() {
        return ksessionName;
    }
}
