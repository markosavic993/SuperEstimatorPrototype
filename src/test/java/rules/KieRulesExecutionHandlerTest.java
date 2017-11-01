package rules;

import model.*;
import org.drools.core.common.DefaultFactHandle;
import org.drools.core.impl.StatefulKnowledgeSessionImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import rules.config.TestDataFixture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by msav on 10/11/2017.
 */
public class KieRulesExecutionHandlerTest {

    private StatefulKnowledgeSessionImpl kieSessionMock;
    private KieRulesExecutionHandler rulesExecutionHandler;

    @Before
    public void setUp() {
        kieSessionMock = mock(StatefulKnowledgeSessionImpl.class);
        rulesExecutionHandler = new KieRulesExecutionHandler(kieSessionMock, ProjectRulesType.DEFAULT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullProject_whenEstimate_thenExceptionIsThrown() {
        rulesExecutionHandler.estimateProject(null, mock(Team.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullTeam_whenEstimate_thenExceptionIsThrown() {
        rulesExecutionHandler.estimateProject(mock(Project.class), null);
    }

    @Test
    public void givenCorrectTeamAndProject_whenEstimate_thenCorrectNumOfStoryPointsCalculated() {
        when(kieSessionMock.insert(any())).thenReturn(new DefaultFactHandle());
        doCallRealMethod().when(kieSessionMock).setGlobal("complexity", new Complexity(0, 0, 0));
        when(kieSessionMock.fireAllRules()).thenReturn(0);

        StoryPoints storyPoints = rulesExecutionHandler.estimateProject(new ProjectBuilder().createProject(), new TeamBuilder().createTeam());

        assertNull(storyPoints);
    }

    @Test
    public void givenCorrectTeamAndProject_whenEstimateTwice_thenCachedValuesAreUsed() {
        when(kieSessionMock.insert(any())).thenReturn(new DefaultFactHandle());
        doCallRealMethod().when(kieSessionMock).setGlobal("complexity", new Complexity(0, 0, 0));
        when(kieSessionMock.fireAllRules()).thenCallRealMethod();

        Project projectMock = mock(Project.class);
        when(projectMock.getStoryPoints()).thenReturn(StoryPoints.FIVE);
        Team teamMock = mock(Team.class);
        StoryPoints storyPoints = rulesExecutionHandler.estimateProject(projectMock, teamMock);
        StoryPoints storyPointsCached = rulesExecutionHandler.estimateProject(projectMock, teamMock);

        verify(kieSessionMock, times(1)).fireAllRules();


        assertEquals(storyPoints, storyPointsCached);
    }
}