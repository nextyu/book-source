package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._5_using_our_ThreadFactory_in_an_Executor_object;

import java.util.concurrent.ThreadFactory;

/**
 * @author zhouyu
 */
public class MyThreadFactory implements ThreadFactory {

    private int counter;
    private String prefix;

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
        counter = 1;
    }

    @Override
    public Thread newThread(Runnable r) {
        MyThread myThread = new MyThread(r, prefix + "_" + counter);
        counter++;
        return myThread;
    }
}
