package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._7_modifying_Lock_fairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印队列
 * 使用Lock同步代码块
 *
 * @author zhouyu
 */
public class PrintQueue {

    /*

    The constructor of the ReentrantLock and ReentrantReadWriteLock classes admits
a boolean parameter named fair that allows you to control the behavior of both classes.
The false value is the default value and it's called the non-fair mode. In this mode, when
there are some threads waiting for a lock (ReentrantLock or ReentrantReadWriteLock)
and the lock has to select one of them to get the access to the critical section, it selects one
without any criteria. The true value is called the fair mode.

     */
    private final Lock queueLock = new ReentrantLock(true);

    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
