package model;

/**
 * Created by msav on 5/21/2017.
 */
public enum StoryPoints {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FIVE(5),
    EIGHT(8),
    THIRTEEN(13),
    TWENTY_ONE(21),
    THIRTY_FOUR(34),
    FIFTY_FIVE(55),
    EIGHTY_NINE(89),
    TOO_BIG_TO_ESTIMATE(100);

    public int getNumOfStoryPoints() {
        return numOfStoryPoints;
    }

    private int numOfStoryPoints;

    private StoryPoints(int numOfStoryPoints) {
        this.numOfStoryPoints = numOfStoryPoints;
    }

    public static StoryPoints findByComplexity(Complexity complexity) {
        double complexityValue = calculateComplexityValue(complexity);

        if(complexityValue <= 1) {
            return StoryPoints.ONE;
        }

        for (int i = 0; i < StoryPoints.values().length; i++) {
            if(i == StoryPoints.values().length && complexityValue > 55 && complexityValue <= 89) {
                return StoryPoints.EIGHTY_NINE;
            }

            if(i == StoryPoints.values().length && complexityValue > 89) {
                return StoryPoints.TOO_BIG_TO_ESTIMATE;
            }

            if (mapComplexityToStoryPoints(complexityValue, i)) {
                return StoryPoints.values()[i+1];
            }
        }

        return StoryPoints.values()[0];
    }

    private static boolean mapComplexityToStoryPoints(double complexityValue, int i) {
        return StoryPoints.values()[i].numOfStoryPoints < complexityValue
                && StoryPoints.values()[i+1].numOfStoryPoints >= complexityValue;
    }

    private static double calculateComplexityValue(Complexity complexity) {
        return complexity.getCommunicationComplexity()
                + complexity.getCoordinationComplexity()
                + complexity.getTechnicalComplexity();
    }
}
