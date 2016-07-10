package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._6_customizing_tasks_running_in_a_scheduled_thread_pool;

import org.joda.time.DateTime;

import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-10 20:56
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
        Task task = new Task();
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        executor.schedule(task, 1, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(3);
        task = new Task();
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        executor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(10);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.printf("Main: End of the program.\n");
    }
}
