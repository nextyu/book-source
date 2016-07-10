package com.nextyu.book.study.source.chapter1_thread_management._12_processing_uncontrolled_exceptions_in_a_group_of_threads;

import java.util.Random;

/**
 * @author zhouyu
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / ((int) (random.nextDouble() * 1000));
            System.out.println(Thread.currentThread().getId() + " : " + result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
