package rules;

import model.*;
import org.junit.Test;
import rules.config.SuperEstimatorRulesTest;
import rules.config.TestDataFixture;

import static org.junit.Assert.assertEquals;

/**
 * Created by msav on 10/27/2017.
 */
public class RulesExecutionTest extends SuperEstimatorRulesTest{



    @Test
    public void testCommunicationProtocolRules() {
        givenTestData();

        whenExecutedRuleWithName("Project requires REST as a communication protocol.");

        assertRuleIsExecuted();
        assertTechnicalComplexity(0.5);
        assertCommunicationComplexity(0.0);
        assertCoordinationComplaxity(0.0);
    }

    @Test
    public void testTeamStructure() {
        givenTestData();

        whenExecutedRuleWithName("Too many juniors in team.");

        assertRuleIsExecuted();
        assertTechnicalComplexity(3.0);
        assertCommunicationComplexity(0.0);
        assertCoordinationComplaxity(0.0);
    }

    @Test
    public void testAutomationTestImpact() {
        givenTestData();

        whenExecutedRuleWithName("Only unit testing and integration testing will be performed.");

        assertRuleIsExecuted();
        assertTechnicalComplexity(2.0);
        assertCommunicationComplexity(0.0);
        assertCoordinationComplaxity(2.0);
    }

    @Test
    public void testDistributedDevelopmentImpact() {
        givenTestData();

        whenExecutedRuleWithName("Big and distributed team.");

        assertRuleIsExecuted();
        assertTechnicalComplexity(0.0);
        assertCommunicationComplexity(3.0);
        assertCoordinationComplaxity(0.0);
    }

    @Test
    public void testComplexCondition() {
        givenTestData();

        whenExecutedRuleWithName("Unknown features exist when team is made mostly of juniors.");

        assertRuleIsExecuted();
        assertTechnicalComplexity(4.0);
        assertCommunicationComplexity(1.0);
        assertCoordinationComplaxity(0.0);
    }

    @Test
    public void testRuleNotExecuted() {
        givenTestData();

        whenExecutedRuleWithName("Team overusing scrum tools.");

        assertRuleIsNotExecuted();
    }

    @Test
    public void testRulsExecution() {
        givenTestData();

        whenExecutedAllRules();

        assertNumberOfExecutedRules(16);
        assertStoryPoints(StoryPoints.EIGHT);
        assertRulesAreNotExecutedTwice();
    }



    private void givenTestData() {
        Team teamA = TestDataFixture.getTeamA();
        Project projectA = TestDataFixture.getProjectA();
        insertTestFacts(teamA, projectA);
    }
}
