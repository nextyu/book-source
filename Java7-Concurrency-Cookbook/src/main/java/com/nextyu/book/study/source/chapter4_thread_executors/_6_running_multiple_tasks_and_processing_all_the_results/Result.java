package com.nextyu.book.study.source.chapter4_thread_executors._6_running_multiple_tasks_and_processing_all_the_results;

/**
 * 存储并行任务的结果
 * @author smile
 */
public class Result {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
