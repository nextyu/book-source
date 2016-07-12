package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * created on 2016-07-12 21:06
 *
 * @author nextyu
 */
public class MyWorkerThread extends ForkJoinWorkerThread {

    private static ThreadLocal<Integer> taskCounter = new ThreadLocal<>();

    /**
     * Creates a ForkJoinWorkerThread operating in the given pool.
     *
     * @param pool the pool this thread works in
     * @throws NullPointerException if pool is null
     */
    protected MyWorkerThread(ForkJoinPool pool) {
        super(pool);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.printf("MyWorkerThread %d: Initializing task counter.\n", getId());
        taskCounter.set(0);
    }

    @Override
    protected void onTermination(Throwable exception) {
        System.out.printf("MyWorkerThread %d: %d\n", getId(), taskCounter.get());
        super.onTermination(exception);
    }

    public void addTask() {
        int counter = taskCounter.get();
        counter++;
        taskCounter.set(counter);

    }
}
