package controller;

import rules.ProjectRulesType;

/**
 * Created by msav on 10/12/2017.
 */
public class StoryPointsCalculatorFactory {

    public static StoryPointsCalculator createRulesBasedCalculator(ProjectRulesType type) {
        return new RulesController(type);
    }

}
