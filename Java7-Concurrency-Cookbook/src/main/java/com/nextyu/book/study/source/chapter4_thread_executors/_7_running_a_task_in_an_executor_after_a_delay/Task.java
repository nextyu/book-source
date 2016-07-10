package com.nextyu.book.study.source.chapter4_thread_executors._7_running_a_task_in_an_executor_after_a_delay;

import org.joda.time.DateTime;

import java.util.concurrent.Callable;

/**
 * @author smile
 */
public class Task implements Callable<String> {

    /**
     * 任务名称
     */
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n", name, new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        return "Hello, world";
    }
}
