package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._5_using_our_ThreadFactory_in_an_Executor_object;

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
