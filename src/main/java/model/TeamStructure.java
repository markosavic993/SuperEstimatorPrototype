package model;

/**
 * Created by msav on 5/17/2017.
 */
public class TeamStructure {

    private int numberJuniors;
    private int numberSeniors;

    public TeamStructure(int numberJuniors, int numberSeniors) {
        this.numberJuniors = numberJuniors;
        this.numberSeniors = numberSeniors;
    }

    public void setNumberJuniors(int numberJuniors) {
        this.numberJuniors = numberJuniors;
    }

    public void setNumberSeniors(int numberSeniors) {
        this.numberSeniors = numberSeniors;
    }

    public double getPercentageOfJuniors() {
        return 100 * numberJuniors / (numberJuniors + numberSeniors);
    }

    public double getPercentageOfSeniors() {
        return 100 * numberSeniors / (numberJuniors + numberSeniors);
    }
}
