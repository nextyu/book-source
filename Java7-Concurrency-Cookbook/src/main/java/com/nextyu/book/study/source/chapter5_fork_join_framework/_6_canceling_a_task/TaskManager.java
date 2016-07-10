package com.nextyu.book.study.source.chapter5_fork_join_framework._6_canceling_a_task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * We will use this class to store all the tasks
 * executed in ForkJoinPool used in the example. Due to the limitations of the
 * ForkJoinPool and ForkJoinTask classes, you will use this class to cancel all the
 * tasks of the ForkJoinPool class.
 *
 * @author zhouyu
 */
public class TaskManager {

    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(ForkJoinTask<Integer> task) {
        tasks.add(task);
    }

    public void cancelTasks(ForkJoinTask<Integer> cancelTask) {
        for (ForkJoinTask<Integer> task : tasks) {
            if (task != cancelTask) {
                task.cancel(true);
                ((SearchNumberTask) task).writeCancelMessage();
            }
        }

    }

}
