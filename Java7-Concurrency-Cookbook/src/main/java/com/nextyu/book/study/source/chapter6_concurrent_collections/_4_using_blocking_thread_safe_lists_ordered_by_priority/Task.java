package com.nextyu.book.study.source.chapter6_concurrent_collections._4_using_blocking_thread_safe_lists_ordered_by_priority;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zhouyu
 */
public class Task implements Runnable {

    /**
     * store the number that identifies the task
     */
    private int id;

    private PriorityBlockingQueue<Event> queue;

    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event event = new Event(id, i);
            queue.add(event);
        }
    }
}
