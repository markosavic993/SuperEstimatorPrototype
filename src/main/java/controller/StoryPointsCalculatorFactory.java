package controller;

/**
 * Created by msav on 10/12/2017.
 */
public class StoryPointsCalculatorFactory {

    public static StoryPointsCalculator createRulesBasedCalculator() {
        return new RulesController();
    }

}
