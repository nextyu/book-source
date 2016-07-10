package com.nextyu.book.study.source.chapter5_fork_join_framework._5_throwing_exceptions_in_the_tasks;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];
        Task task = new Task(array, 0, array.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        When you throw an unchecked exception in a task, it also affects its parent task (the task
that sent it to the ForkJoinPool class) and the parent task of its parent task, and so on.v
         */
        if (task.isCompletedAbnormally()) {
            System.out.printf("Main: An exception has ocurred\n");
            System.out.printf("Main: %s\n", task.getException());
        }

        System.out.printf("Main: Result: %d", task.join());
    }
}
