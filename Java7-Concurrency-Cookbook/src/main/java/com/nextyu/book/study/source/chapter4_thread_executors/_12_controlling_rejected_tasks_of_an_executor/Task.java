package com.nextyu.book.study.source.chapter4_thread_executors._12_controlling_rejected_tasks_of_an_executor;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + ": Starting");

        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("Task %s: ReportGenerator: Generating a report during %d seconds\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
            System.out.printf("Task %s: Ending\n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return name;
    }
}
