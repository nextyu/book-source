package com.nextyu.book.study.source.chapter6_concurrent_collections._9_using_atomic_arrays;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author zhouyu
 */
public class Incrementer implements Runnable {

    /**
     * store an array of integer numbers
     */
    private AtomicIntegerArray vector;

    public Incrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            // increments all the elements of the array
            vector.getAndIncrement(i);
        }
    }
}
