package model;

/**
 * Created by msav on 5/21/2017.
 */
public enum StoryPoints {
    ZERO(0, "XS"),
    ONE(1, "XS"),
    TWO(2, "S"),
    THREE(3, "S"),
    FIVE(5, "M"),
    EIGHT(8, "M"),
    THIRTEEN(13, "L"),
    TWENTY_ONE(21, "L"),
    THIRTY_FOUR(34, "XL"),
    FIFTY_FIVE(55, "XL"),
    EIGHTY_NINE(89, "XL"),
    TOO_BIG_TO_ESTIMATE(100, "XL");

    public int getNumOfStoryPoints() {
        return numOfStoryPoints;
    }

    public String getTshirtSize() {
        return tshirtSize;
    }

    private int numOfStoryPoints;

    private String tshirtSize;

    private StoryPoints(int numOfStoryPoints, String tshirtSize) {
        this.numOfStoryPoints = numOfStoryPoints;
        this.tshirtSize = tshirtSize;
    }

    public static StoryPoints findByComplexity(Complexity complexity) {
        double complexityValue = calculateComplexityValue(complexity);
        return getStoryPoints(complexityValue);
    }

    private static StoryPoints getStoryPoints(double complexityValue) {
        if (complexityValue <= 4.2) {
            return StoryPoints.ONE;
        }

        if (complexityValue <= 4.3) {
            return StoryPoints.TWO;
        }

        if (complexityValue <= 4.5) {
            return StoryPoints.THREE;
        }

        if (complexityValue <= 4.65) {
            return StoryPoints.FIVE;
        }

        if (complexityValue <= 4.75) {
            return StoryPoints.EIGHT;
        }

        if (complexityValue <= 4.9) {
            return StoryPoints.THIRTEEN;
        }

        if (complexityValue <= 5.0) {
            return StoryPoints.TWENTY_ONE;
        }

        if (complexityValue <= 5.1) {
            return StoryPoints.THIRTY_FOUR;
        }

        if (complexityValue <= 5.3) {
            return StoryPoints.FIFTY_FIVE;
        }

        if (complexityValue <= 5.65) {
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
