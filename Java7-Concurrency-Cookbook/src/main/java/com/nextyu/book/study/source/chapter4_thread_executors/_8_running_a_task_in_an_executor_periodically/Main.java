package com.nextyu.book.study.source.chapter4_thread_executors._8_running_a_task_in_an_executor_periodically;

import org.joda.time.DateTime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author smile
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        Task task = new Task("Task");
        // scheduleWithFixedRate()
        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            System.out.printf("Main: Delay: %d\n", scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
            try {
                // Sleep the thread during 500 milliseconds.
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        /*
        The default behavior is that the scheduled tasks fiish when you call that method

         You can change this behavior using the
        setContinueExistingPeriodicTasksAfterShutdownPolicy()  method of the
        ScheduledThreadPoolExecutor class with a true value. The periodic tasks won't fiish
        upon calling the shutdown()  method.
         */
        executor.shutdown();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Finished at: %s\n", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
