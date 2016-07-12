package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._9;

import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-12 22:56
 *
 * @author nextyu
 */
public class Task implements Runnable {

    private MyLock lock;
    private String name;


    public Task(MyLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.printf("Task: %s: Take the lock\n", name);
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("Task: %s: Free the lock\n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
