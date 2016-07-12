package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._8_Customizing_tasks_running_in_the_Fork_Join_framework;

import java.util.concurrent.ForkJoinPool;

/**
 * created on 2016-07-12 21:53
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000];
        ForkJoinPool pool = new ForkJoinPool();
        Task task = new Task("Task", array, 0, array.length);
        pool.invoke(task);

        pool.shutdown();
        System.out.printf("Main: End of the program.\n");
    }
}
