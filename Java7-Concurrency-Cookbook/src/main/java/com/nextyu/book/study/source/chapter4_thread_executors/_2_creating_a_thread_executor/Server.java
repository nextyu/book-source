package com.nextyu.book.study.source.chapter4_thread_executors._2_creating_a_thread_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * that will execute every task it receives using an
 * executor.
 *
 * @author zhouyu
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);

        // write some executor data to the console to see its status

        System.out.printf("Server: Pool Size: %d\n", executor.
                getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.
                getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.
                getCompletedTaskCount());
    }

    public void endServer() {
        /*
         * To indicate to the executor that you want to fiish it, you can use the shutdown()
         method of the ThreadPoolExecutor class. When the executor fiishes the execution
         of all pending tasks, it fiishes its execution.
         */
        executor.shutdown();
    }
}
