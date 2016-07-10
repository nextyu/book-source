package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._3_implementing_a_priority_based_executor_class;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {

    private int priority;
    private String name;

    public MyPriorityTask(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(MyPriorityTask o) {
        // 倒序，从大到小
        return o.getPriority() - this.priority;
    }

    @Override
    public void run() {
        System.out.printf("MyPriorityTask: %s Priority : %d\n", name, priority);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
