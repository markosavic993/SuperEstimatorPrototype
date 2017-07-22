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
        return getStoryPoints(complexityValue);
    }

    private static StoryPoints getStoryPoints(double complexityValue) {
        if (complexityValue <= 4.05) {
            return StoryPoints.ZERO;
        }

        if(complexityValue <= 4.2) {
            return StoryPoints.ONE;
        }

        if(complexityValue <= 4.3) {
            return StoryPoints.TWO;
        }

        if(complexityValue <= 4.4) {
            return StoryPoints.THREE;
        }

        if(complexityValue <= 4.5) {
            return StoryPoints.FIVE;
        }

        if(complexityValue <= 4.65) {
            return StoryPoints.EIGHT;
        }

        if(complexityValue <= 4.75) {
            return StoryPoints.THIRTEEN;
        }

        if(complexityValue <= 4.9) {
            return StoryPoints.TWENTY_ONE;
        }

        if(complexityValue <= 5.1) {
            return StoryPoints.THIRTY_FOUR;
        }

        if(complexityValue <= 5.3) {
            return StoryPoints.FIFTY_FIVE;
        }

        if(complexityValue <= 5.65) {
            return StoryPoints.EIGHTY_NINE;
        }

        return StoryPoints.TOO_BIG_TO_ESTIMATE;
    }

    private static double calculateComplexityValue(Complexity complexity) {
        return sumComplexities(complexity) / 5;
    }

    private static double sumComplexities(Complexity complexity) {
        return complexity.getCommunicationComplexity()
                + complexity.getCoordinationComplexity()
                + complexity.getTechnicalComplexity();
    }
}
