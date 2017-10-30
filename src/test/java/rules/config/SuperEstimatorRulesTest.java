package rules.config;

import mappable.Mappable;
import model.Complexity;
import model.Project;
import model.StoryPoints;
import model.Team;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.goodoldai.jeff.wizard.JEFFWizard;
import org.junit.Before;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import rules.ProjectRulesType;

import static org.junit.Assert.assertEquals;

/**
 * Created by msav on 10/30/2017.
 */
public class SuperEstimatorRulesTest {
    protected KieSession session;
    protected int executedRules;
    protected TrackingAgendaEventListener listener;

    @Before
    public void setUp() throws Exception {
        executedRules = 0;
        listener = new TrackingAgendaEventListener();
        session = initSession();
        setGlobals();

    }

    protected void assertRulesAreNotExecutedTwice() {
        assertEquals(executedRules, listener.getMatchList().size());
    }

    protected void assertStoryPoints(StoryPoints storyPoints) {
        assertEquals(storyPoints, TestDataFixture.getProjectA().getStoryPoints());
    }

    protected void assertCoordinationComplaxity(double coordinationComplexity) {
        assertEquals(coordinationComplexity, ((Complexity)session.getGlobal("complexity")).getCoordinationComplexity(), 0.01);
    }

    protected void assertCommunicationComplexity(double communicationComplexity) {
        assertEquals(communicationComplexity, ((Complexity)session.getGlobal("complexity")).getCommunicationComplexity(), 0.01);
    }

    protected void assertTechnicalComplexity(double technicalComplexity) {
        assertEquals(technicalComplexity, ((Complexity)session.getGlobal("complexity")).getTechnicalComplexity(), 0.01);
    }

    protected void whenExecutedRuleWithName(String ruleName) {
        RuleNameEqualsAgendaFilter ruleNameFilter = new RuleNameEqualsAgendaFilter(ruleName);
        executedRules = session.fireAllRules(ruleNameFilter);
    }

    protected void whenExecutedAllRules() {
        session.addEventListener(listener);
        executedRules = session.fireAllRules();
    }

    protected void assertNumberOfExecutedRules(int num) {
        assertEquals(num, executedRules);
    }

    protected void assertRuleIsNotExecuted(){
        assertNumberOfExecutedRules(0);
    }

    protected void assertRuleIsExecuted() {
        assertNumberOfExecutedRules(1);
    }

    protected void insertTestFacts(Team teamA, Project projectA) {
        session.insert(teamA);
        session.insert(projectA);
    }

    private KieSession initSession() {
        KieServices.Factory.get().getKieClasspathContainer();
        return Mappable.of(KieServices.Factory.get())
                .map(KieServices::getKieClasspathContainer)
                .map(kieContainer -> kieContainer.newKieSession(String.valueOf(ProjectRulesType.DEFAULT.getKsessionName())))
                .get();
    }

    private void setGlobals() {
        JEFFWizard ef = new JEFFWizard();
        ef.setInternationalization(false);
        ef.setTitle("Test title");
        ef.createExplanation();
        session.setGlobal("ef", ef);
        session.setGlobal("complexity", new Complexity(0, 0, 0));
    }
}
