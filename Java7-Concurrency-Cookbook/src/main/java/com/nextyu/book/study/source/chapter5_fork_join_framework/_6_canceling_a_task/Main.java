package com.nextyu.book.study.source.chapter5_fork_join_framework._6_canceling_a_task;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * The ForkJoinTask class provides the cancel()  method that allows you to cancel a
 * task if it hasn't been executed yet. This is a very important point. If the task has begun its
 * execution, a call to the cancel()  method has no effect.
 *
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new ArrayGenerator().generateArray(100, 5);
        TaskManager manager = new TaskManager();
        ForkJoinPool pool = new ForkJoinPool();
        SearchNumberTask task = new SearchNumberTask(array, 0, array.length, 5, manager);

        // Execute the task in the pool asynchronously using the execute()  method
        pool.execute(task);
        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: The program has finished\n");
    }
}
