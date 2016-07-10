package com.nextyu.book.study.source.chapter5_fork_join_framework._6_canceling_a_task;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class SearchNumberTask extends RecursiveTask<Integer> {

    private int[] array;
    private int start, end;
    /**
     * 要查找的数
     */
    private int number;

    private TaskManager manager;

    private static final int NOT_FOUND = -1;

    public SearchNumberTask(int[] array, int start, int end, int number, TaskManager manager) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.number = number;
        this.manager = manager;
    }

    @Override
    protected Integer compute() {
        System.out.println("Task: " + start + ":" + end);
        int result;
        if (end - start > 10) {
            result = launchTasks();
        } else {
            result = lookForNumber();
        }
        return result;
    }

    private int launchTasks() {
        int mid = (start + end) / 2;
        SearchNumberTask task1 = new SearchNumberTask(array, start, mid, number, manager);
        SearchNumberTask task2 = new SearchNumberTask(array, mid, end, number, manager);
        manager.addTask(task1);
        manager.addTask(task2);
        // Execute the two tasks asynchronously using the fork()  method
        task1.fork();
        task1.fork();

        int result;
        result = task1.join();
        if (result != NOT_FOUND) {
            return result;
        }
        result = task2.join();
        return result;
    }

    private int lookForNumber() {
        for (int i = start; i < end; i++) {
            if (array[i] == number) {
                System.out.printf("Task: Number %d found in position %d\n", number, i);
                manager.cancelTasks(this);
                return i;
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return NOT_FOUND;
    }

    public void writeCancelMessage() {
        System.out.printf("Task: Canceled task from %d to %d\n", start, end);
    }
}
