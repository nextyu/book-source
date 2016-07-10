package com.nextyu.book.study.source.chapter6_concurrent_collections._7_generating_concurrent_random_numbers;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhouyu
 */
public class TaskLocalRandom implements Runnable {

    public TaskLocalRandom() {
        /*
        This is a static method that returns the ThreadLocalRandom
        object associated with the current thread
         */
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            /*
            make a call to the current() method to get the random
            generator associated with this thread,
             */
            // provide a number as a parameter to generate random numbers between zero and that number
            System.out.printf("%s: %d\n", name, ThreadLocalRandom.current().nextInt(10));
        }
    }
}
