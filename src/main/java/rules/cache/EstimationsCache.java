package rules.cache;

import com.google.common.annotations.VisibleForTesting;
import model.StoryPoints;
import sun.security.util.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by msav on 11/1/2017.
 */
public class EstimationsCache {

    private static Map<EstimationRequest, StoryPoints> cache = new HashMap<>();
    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    private static Lock readLock = lock.readLock();
    private static Lock writeLock = lock.writeLock();

    public static void put(EstimationRequest estimationRequest, StoryPoints storyPoints) {
        writeLock.lock();
        try {
            cache.put(estimationRequest, storyPoints);
        } finally {
            writeLock.unlock();
        }
    }

    public static Optional<StoryPoints> findInCache(EstimationRequest estimationRequest) {
        readLock.lock();
        try {
            return Optional.ofNullable(cache.get(estimationRequest));
        } finally {
            readLock.unlock();
        }
    }

    public static void resetCache() {
        writeLock.lock();
        try {
            cache = new HashMap<>();
        } finally {
            writeLock.unlock();
        }
    }

    @VisibleForTesting
    static int getSize() {
        readLock.lock();
        try {
            return cache.size();
        } finally {
            readLock.unlock();
        }
    }
}
