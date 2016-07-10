package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._4_implementing_the_threadfactory_interface_to_generate_custom_threads;

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
