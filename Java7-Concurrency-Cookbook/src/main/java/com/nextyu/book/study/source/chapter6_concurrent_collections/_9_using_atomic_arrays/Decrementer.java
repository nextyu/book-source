package com.nextyu.book.study.source.chapter6_concurrent_collections._9_using_atomic_arrays;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author zhouyu
 */
public class Decrementer implements Runnable {

    private AtomicIntegerArray vector;

    public Decrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            // decrements all the elements of the array
            vector.getAndDecrement(i);
        }
    }
}
