package com.nextyu.book.study.source.chapter1_thread_management._10_using_local_thread_variables;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class SafeTask implements Runnable {

    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        /*
        The fist time you access the value of a thread-local variable, if it has no value
for the Thread object that it is calling, the thread-local variable calls the initialValue()
method to assign a value for that Thread and returns the initial value.
         */
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", Thread.
                currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.
                currentThread().getId(), startDate.get());
    }
}
