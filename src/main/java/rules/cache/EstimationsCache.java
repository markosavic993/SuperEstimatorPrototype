package rules.cache;

import model.StoryPoints;
import sun.security.util.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by msav on 11/1/2017.
 */
public class EstimationsCache {

    private static Map<EstimationRequest, StoryPoints> cache = new HashMap<>();

    public static void put(EstimationRequest estimationRequest, StoryPoints storyPoints) {
        cache.put(estimationRequest, storyPoints);
    }

    public static Optional<StoryPoints> findInCache(EstimationRequest estimationRequest) {
        return Optional.ofNullable(cache.get(estimationRequest));
    }
}
