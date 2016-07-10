package com.nextyu.book.study.source.chapter4_thread_executors._10_controlling_a_task_finishing_in_an_executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ResultTask[] resultTasks = new ResultTask[5];

        for (int i = 0; i < resultTasks.length; i++) {
            ExecutableTask executableTask = new ExecutableTask("Task_" + i);
            resultTasks[i] = new ResultTask(executableTask);
            executor.submit(resultTasks[i]);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        for (int i = 0; i < resultTasks.length; i++) {
            resultTasks[i].cancel(true);
        }

        for (int i = 0; i < resultTasks.length; i++) {
            try {
                if (!resultTasks[i].isCancelled()) {
                    System.out.printf("%s\n", resultTasks[i].get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();


    }
}
