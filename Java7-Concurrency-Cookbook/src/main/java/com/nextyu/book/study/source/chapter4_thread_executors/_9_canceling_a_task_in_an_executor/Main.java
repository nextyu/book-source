package com.nextyu.book.study.source.chapter4_thread_executors._9_canceling_a_task_in_an_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.printf("Main: Executing the Task\n");
        Future<String> future = executor.submit(task);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Canceling the Task\n");
        future.cancel(true);

        System.out.printf("Main: Canceled: %s\n", future.isCancelled());
        System.out.printf("Main: Done: %s\n", future.isDone());

        executor.shutdown();
        System.out.printf("Main: The executor has finished\n");

    }
}
