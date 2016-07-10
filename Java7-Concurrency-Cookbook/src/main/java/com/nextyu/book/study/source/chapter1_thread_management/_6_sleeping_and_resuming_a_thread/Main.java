package com.nextyu.book.study.source.chapter1_thread_management._6_sleeping_and_resuming_a_thread;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main  {
    public static void main(String[] args) {
        Thread thread = new Thread(new FileClock());
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
