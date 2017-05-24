package model;

/**
 * Created by msav on 5/17/2017.
 */
public class Complexity {
    private double technicalComplexity;
    private double communicationComplexity;
    private double coordinationComplexity;

    public Complexity(double technicalComplexity, double communicationComplexity, double coordinationComplexity) {
        this.technicalComplexity = technicalComplexity;
        this.communicationComplexity = communicationComplexity;
        this.coordinationComplexity = coordinationComplexity;
    }

    public double getTechnicalComplexity() {
        return technicalComplexity;
    }

    public void setTechnicalComplexity(double technicalComplexity) {
        this.technicalComplexity = technicalComplexity;
    }

    public double getCommunicationComplexity() {
        return communicationComplexity;
    }

    public void setCommunicationComplexity(double communicationComplexity) {
        this.communicationComplexity = communicationComplexity;
    }

    public double getCoordinationComplexity() {
        return coordinationComplexity;
    }

    public void setCoordinationComplexity(double coordinationComplexity) {
        this.coordinationComplexity = coordinationComplexity;
    }

    @Override
    public String toString() {
        return "Complexity{" +
                "technicalComplexity=" + technicalComplexity +
                ", communicationComplexity=" + communicationComplexity +
                ", coordinationComplexity=" + coordinationComplexity +
                '}';
    }
}
