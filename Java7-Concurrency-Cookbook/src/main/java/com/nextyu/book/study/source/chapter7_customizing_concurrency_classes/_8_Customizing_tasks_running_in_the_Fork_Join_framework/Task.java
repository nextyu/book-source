package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._8_Customizing_tasks_running_in_the_Fork_Join_framework;

import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-12 21:47
 *
 * @author nextyu
 */
public class Task extends MyWorkerTask {

    private int[] array;
    private int start, end;

    public Task(String name, int[] array, int start, int end) {
        super(name);
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start > 100) {
            int mid = (start + end)/2;
            Task task1 = new Task(getName() + "1", array, start, mid);
            Task task2 = new Task(getName() + "2", array, mid, end);
            invokeAll(task1,task2);
        } else {
            for (int i = start ; i < end; i++) {
                array[i]++;
            }
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
