package rules;

import com.sun.javaws.exceptions.InvalidArgumentException;
import model.*;
import org.drools.core.common.DefaultFactHandle;
import org.drools.core.impl.StatefulKnowledgeSessionImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by msav on 10/11/2017.
 */
public class KieRulesExecutionHandlerTest {

    private StatefulKnowledgeSessionImpl kieSessionMock;
    private KieRulesExecutionHandler rulesExecutionHandler;

    @Before
    public void setUp() {
        kieSessionMock = mock(StatefulKnowledgeSessionImpl.class);
        rulesExecutionHandler = new KieRulesExecutionHandler(kieSessionMock);
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

}