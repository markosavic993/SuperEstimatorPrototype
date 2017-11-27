package rules.cache;

import model.StoryPoints;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static org.junit.Assert.*;

/**
 * Created by msav on 11/27/2017.
 */
public class EstimationsCacheTest {

    @Before
    public void setUp() throws Exception {
        EstimationsCache.resetCache();
    }

    @Test
    public void testConcurrencyOnCache() throws InterruptedException {
        List<Callable<StoryPoints>> insertTasks = givenLotOfUpdateTasks();

        List<Future<StoryPoints>> futures = whenExecutingUpdateTasksInParallel(insertTasks);

        thenAllTheTasksAreFinishedCorrectly(futures);

    }

    private void thenAllTheTasksAreFinishedCorrectly(List<Future<StoryPoints>> futures) {
        assertEquals(1000, futures.size());
        assertEquals(100000, EstimationsCache.getSize());
    }

    private List<Future<StoryPoints>> whenExecutingUpdateTasksInParallel(List<Callable<StoryPoints>> insertTasks) throws InterruptedException {
        ExecutorService executorService = new ScheduledThreadPoolExecutor(10);
        int counter = 0;
        List<Future<StoryPoints>> futures;
        do {
            futures = executorService.invokeAll(insertTasks);
            counter++;
        } while (counter < 100);

        executorService.shutdown();
        return futures;
    }

    private List<Callable<StoryPoints>> givenLotOfUpdateTasks() {
        List<Callable<StoryPoints>> insertTasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            insertTasks.add(createInsertTask());
        }
        return insertTasks;
    }

    private Callable<StoryPoints> createInsertTask() {
        return () -> {
            StoryPoints points = getRandomStoryPoints();
            EstimationsCache.put(Mockito.mock(EstimationRequest.class), points);
            return points;
        };
    }

    private StoryPoints getRandomStoryPoints() {
        Random random = new Random();
        int randomIndex = random.nextInt(StoryPoints.values().length);

        return StoryPoints.values()[randomIndex];
    }

}