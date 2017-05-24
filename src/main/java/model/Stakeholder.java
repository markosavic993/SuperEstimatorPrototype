package model;

/**
 * Created by msav on 5/17/2017.
 */
public class Stakeholder {
    private String name;
    private StakeholderType type;

    public Stakeholder(String name, StakeholderType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StakeholderType getType() {
        return type;
    }

    public void setType(StakeholderType type) {
        this.type = type;
    }
}
