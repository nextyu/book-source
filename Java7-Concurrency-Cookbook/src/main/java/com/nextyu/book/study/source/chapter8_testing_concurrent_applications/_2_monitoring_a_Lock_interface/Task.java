package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._2_monitoring_a_Lock_interface;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * created on 2016-07-14 9:31
 *
 * @author nextyu
 */
public class Task implements Runnable {

    private Lock lock;

    public Task(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            lock.lock();
            System.out.printf("%s: Get the Lock.\n", Thread.
                    currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.printf("%s: Free the Lock.\n", Thread.
                        currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
