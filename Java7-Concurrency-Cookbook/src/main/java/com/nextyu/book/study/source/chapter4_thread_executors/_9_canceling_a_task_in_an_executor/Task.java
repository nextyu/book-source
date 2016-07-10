package com.nextyu.book.study.source.chapter4_thread_executors._9_canceling_a_task_in_an_executor;

import java.util.concurrent.Callable;

/**
 * @author zhouyu
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true) {
            System.out.printf("Task: Test\n");
            Thread.sleep(100);
        }
    }
}
