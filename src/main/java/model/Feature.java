package model;

import java.util.Objects;

/**
 * Created by msav on 5/17/2017.
 */
public class Feature {

    private String name;
    private String description;

    public Feature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(getName(), feature.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
