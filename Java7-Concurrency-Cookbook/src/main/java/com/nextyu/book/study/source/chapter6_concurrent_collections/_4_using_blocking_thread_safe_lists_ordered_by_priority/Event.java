package com.nextyu.book.study.source.chapter6_concurrent_collections._4_using_blocking_thread_safe_lists_ordered_by_priority;

/**
 * @author zhouyu
 */
public class Event implements Comparable<Event> {

    /**
     * store the number of the thread that has created the event
     */
    private int thread;

    /**
     * store the priority of the event
     */
    private int priority;

    public Event(int thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    public int getThread() {
        return thread;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Event e) {
        // 倒序，从大到小
        if (this.priority > e.getPriority()) {
            return -1;
        } else if (this.priority < e.getPriority()) {
            return 1;
        }
        return 0;
    }
}
