package com.nextyu.book.study.source.chapter4_thread_executors._6_running_multiple_tasks_and_processing_all_the_results;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author smile
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = (ExecutorService) Executors.
                newCachedThreadPool();

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task_" + i);
            tasks.add(task);
        }

        List<Future<Result>> futures = null;
        try {
            // wait for the finalization of all of them
            futures = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        System.out.println("Main: Printing the results");
        for (Future<Result> future : futures) {
            try {
                Result result = future.get();
                System.out.println(result.getName() + ": " + result.
                        getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
