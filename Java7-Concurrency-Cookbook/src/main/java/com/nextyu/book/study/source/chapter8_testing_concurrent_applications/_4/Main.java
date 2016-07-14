package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._4;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-14 10:20
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(random.nextInt(10000));
            executor.submit(task);
        }

        for (int i = 0; i < 5; i++) {
            showLog(executor);
            TimeUnit.SECONDS.sleep(1);
        }

        executor.shutdown();

        for (int i = 0; i < 5; i++) {
            showLog(executor);
            TimeUnit.SECONDS.sleep(1);
        }

        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.printf("Main: End of the program.\n");
    }

    private static void showLog(ThreadPoolExecutor executor) {
        System.out.printf("*********************\n");
        System.out.printf("Main: Executor Log\n");
        System.out.printf("Main: Executor: Core Pool Size: %d\n", executor.getCorePoolSize());
        System.out.printf("Main: Executor: Pool Size: %d\n", executor.
                getPoolSize());
        System.out.printf("Main: Executor: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Main: Executor: Task Count: %d\n", executor.
                getTaskCount());
        System.out.printf("Main: Executor: Completed Task Count: %d\n", executor.getCompletedTaskCount());
        System.out.printf("Main: Executor: Shutdown: %s\n", executor.
                isShutdown());
        System.out.printf("Main: Executor: Terminating: %s\n", executor.isTerminating());
        System.out.printf("Main: Executor: Terminated: %s\n", executor.
                isTerminated());
        System.out.printf("*********************\n");
    }
}