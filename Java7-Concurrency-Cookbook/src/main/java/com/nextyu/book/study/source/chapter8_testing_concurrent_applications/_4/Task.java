package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._4;

import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-14 10:19
 *
 * @author nextyu
 */
public class Task implements Runnable {

    private long milliseconds;

    public Task(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        System.out.printf("%s: Begin\n", Thread.currentThread().
                getName());
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: End\n", Thread.currentThread().
                getName());
    }
}
