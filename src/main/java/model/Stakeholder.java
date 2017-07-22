package model;

import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stakeholder that = (Stakeholder) o;
        return Objects.equal(getName(), that.getName()) &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getType());
    }
}
