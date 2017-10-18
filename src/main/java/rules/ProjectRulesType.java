package rules;

/**
 * Created by msav on 10/13/2017.
 */
public enum ProjectRulesType {
    DEFAULT("ksession-rules"),
    FRONTEND("rules-frontend"),
    BACKEND("rules-backend"),
    MOBILE("rules-mobile");

    private String ksessionName;

    ProjectRulesType(String ksessionName) {
        this.ksessionName = ksessionName;
    }

    public String getKsessionName() {
        return ksessionName;
    }
}
