package com.nextyu.book.study.source.chapter1_thread_management._4_interrupting_a_thread;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        PrimeGenerator generator = new PrimeGenerator();
        generator.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        generator.interrupt();
    }
}
