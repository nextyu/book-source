package com.nextyu.book.study.source.chapter1_thread_management._10_using_local_thread_variables;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class UnsafeTask implements Runnable {

    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.
                currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.
                currentThread().getId(), startDate);
    }
}
