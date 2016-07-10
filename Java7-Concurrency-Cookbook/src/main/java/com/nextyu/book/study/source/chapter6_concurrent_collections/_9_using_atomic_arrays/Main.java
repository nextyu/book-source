package com.nextyu.book.study.source.chapter6_concurrent_collections._9_using_atomic_arrays;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        final int THREADS = 100;
        AtomicIntegerArray vector = new AtomicIntegerArray(1000);
        Incrementer incrementer = new Incrementer(vector);
        Decrementer decrementer = new Decrementer(vector);

        Thread[] threadIncrementer = new Thread[THREADS];
        Thread[] threadDecrementer = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            threadIncrementer[i] = new Thread(incrementer);
            threadDecrementer[i] = new Thread(decrementer);

            threadIncrementer[i].start();
            threadDecrementer[i].start();
        }

        for (int i = 0; i < THREADS; i++) {
            try {
                threadIncrementer[i].join();
                threadDecrementer[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < vector.length(); i++) {
            System.out.println("Vector["+i+"] : "+vector.get(i));
        }

        System.out.println("Main: End of the example");

    }
}
