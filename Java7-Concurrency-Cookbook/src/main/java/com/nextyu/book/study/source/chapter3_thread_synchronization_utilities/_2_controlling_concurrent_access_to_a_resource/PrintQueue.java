package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._2_controlling_concurrent_access_to_a_resource;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 控制并发访问一个资源
 *
 * @author zhouyu
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        /*
        . This print queue will be protected by a binary semaphore,
            so only one thread can print at a time.
         */
        // Fairness in semaphores
        semaphore = new Semaphore(1,true);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
