package com.tmax.superappspringbenchmark;

import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ThreadTracker {
    private final ConcurrentHashMap<Long, Boolean> threadIds = new ConcurrentHashMap<>();
    public void addThreadId(long threadId) {
        threadIds.put(threadId, true);
    }

    public int getTotalThreadsUsed() {
        return threadIds.size();
    }
}
