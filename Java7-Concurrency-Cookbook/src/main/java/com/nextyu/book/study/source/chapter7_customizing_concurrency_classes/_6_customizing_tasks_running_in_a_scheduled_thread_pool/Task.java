package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._6_customizing_tasks_running_in_a_scheduled_thread_pool;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.printf("Task: Begin.\n");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task: End.\n");
    }
}
