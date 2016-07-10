package com.nextyu.book.study.source.chapter6_concurrent_collections._2_using_non_blocking_thread_safe_lists;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author zhouyu
 */
public class AddTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }
}
