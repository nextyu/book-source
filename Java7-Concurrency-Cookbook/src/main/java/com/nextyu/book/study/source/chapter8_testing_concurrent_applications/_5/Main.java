package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-14 10:53
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = new int[1000];
        Task task = new Task(array, 0, array.length);
        pool.execute(task);

        while (!task.isDone()) {
            showLog(pool);
            TimeUnit.SECONDS.sleep(1);
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);

        showLog(pool);
        System.out.printf("Main: End of the program.\n");
    }

    private static void showLog(ForkJoinPool pool) {
        System.out.printf("**********************\n");
        System.out.printf("Main: Fork/Join Pool log\n");
        System.out.printf("Main: Fork/Join Pool: Parallelism: %d\n", pool.getParallelism());
        System.out.printf("Main: Fork/Join Pool: Pool Size: %d\n", pool.getPoolSize());
        System.out.printf("Main: Fork/Join Pool: Active Thread Count: %d\n", pool.getActiveThreadCount());
        System.out.printf("Main: Fork/Join Pool: Running Thread Count: %d\n", pool.getRunningThreadCount());
        System.out.printf("Main: Fork/Join Pool: Queued Submission: %d\n", pool.getQueuedSubmissionCount());
        System.out.printf("Main: Fork/Join Pool: Queued Tasks: %d\n", pool.getQueuedTaskCount());
        System.out.printf("Main: Fork/Join Pool: Queued Submissions: %s\n", pool.hasQueuedSubmissions());
        System.out.printf("Main: Fork/Join Pool: Steal Count: %d\n", pool.getStealCount());
        System.out.printf("Main: Fork/Join Pool: Terminated : %s\n", pool.isTerminated());
        System.out.printf("**********************\n");
    }
}
