package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._4_implementing_the_threadfactory_interface_to_generate_custom_threads;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
