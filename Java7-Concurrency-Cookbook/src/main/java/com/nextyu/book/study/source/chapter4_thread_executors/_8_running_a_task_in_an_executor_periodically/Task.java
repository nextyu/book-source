package com.nextyu.book.study.source.chapter4_thread_executors._8_running_a_task_in_an_executor_periodically;

import org.joda.time.DateTime;

/**
 * @author smile
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s\n", name, new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
