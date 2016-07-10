package com.nextyu.book.study.source.chapter4_thread_executors._7_running_a_task_in_an_executor_after_a_delay;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author smile
 */
public class Main {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task_" + i);
            executor.schedule(task, i + 1, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // System.out.printf("Main: Ends at: %s\n", new Date());
        logger.debug("Main: Ends at: {}", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
