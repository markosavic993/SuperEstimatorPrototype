package controller;

import rules.RuleType;

/**
 * Created by msav on 10/12/2017.
 */
public class StoryPointsCalculatorFactory {

    public static StoryPointsCalculator createRulesBasedCalculator(RuleType type) {
        return new RulesController(type);
    }

}
