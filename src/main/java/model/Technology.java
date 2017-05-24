package model;

/**
 * Created by msav on 5/17/2017.
 */
public class Technology {

    private String name;
    private Popularity popularity;

    public Technology(String name, Popularity popularity) {
        this.name = name;
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }
}
