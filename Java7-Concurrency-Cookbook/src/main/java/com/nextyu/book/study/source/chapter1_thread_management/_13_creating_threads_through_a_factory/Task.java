package com.nextyu.book.study.source.chapter1_thread_management._13_creating_threads_through_a_factory;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
