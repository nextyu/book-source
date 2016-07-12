package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-12 21:23
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyWorkerThreadFactory factory = new MyWorkerThreadFactory();
        ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);
        pool.execute(task);

        task.join();

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);

        System.out.printf("Main: Result: %d\n",task.get());
        System.out.printf("Main: End of the program\n");
    }
}
