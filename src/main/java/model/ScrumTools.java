package model;

/**
 * Created by msav on 5/17/2017.
 */
public class ScrumTools {
    private String name;
    private String description;

    public ScrumTools(String name, String description) {
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
}
