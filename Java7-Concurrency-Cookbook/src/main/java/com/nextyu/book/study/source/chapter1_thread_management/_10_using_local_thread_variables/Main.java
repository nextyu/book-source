package com.nextyu.book.study.source.chapter1_thread_management._10_using_local_thread_variables;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
