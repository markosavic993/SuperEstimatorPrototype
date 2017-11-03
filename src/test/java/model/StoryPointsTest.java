package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by msav on 5/21/2017.
 */
public class StoryPointsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFindByComplexity() {
        Complexity complexity = new Complexity(11, 4, 7);
        StoryPoints points = StoryPoints.findByComplexity(complexity);

        assertEquals(StoryPoints.THREE, points);
    }

    @Test
    public void testFindByComplexityLowEstimations() {
        Complexity complexity = new Complexity(0.5, 0, 0.5);
        StoryPoints points = StoryPoints.findByComplexity(complexity);

        assertEquals(StoryPoints.ONE, points);
    }

    @Test
    public void testFindByComplexityTooBigEstimations() {
        Complexity complexity = new Complexity(50, 22, 21);
        StoryPoints points = StoryPoints.findByComplexity(complexity);

        assertEquals(points, StoryPoints.TOO_BIG_TO_ESTIMATE);
    }

}