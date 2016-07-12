package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._7;

import javafx.concurrent.Task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-12 21:14
 *
 * @author nextyu
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {

    private int[] array;
    private int start, end;

    public MyRecursiveTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    /**
     * sum all the elements of the array between
     * the start and end positions
     *
     * @return
     */
    @Override
    protected Integer compute() {
        MyWorkerThread thread = (MyWorkerThread) Thread.currentThread();
        thread.addTask();
        int result = 0;
        for (int i = start; i < end; i++) {
            result += array[i];
        }
        return result;
    }


    public Integer addResults(Task<Integer> task1, Task<Integer> task2) {
        int value;
        try {
            value = task1.get() + task2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            value = 0;
        } catch (ExecutionException e) {
            e.printStackTrace();
            value = 0;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }
}
