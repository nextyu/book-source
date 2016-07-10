package com.nextyu.book.study.source.chapter1_thread_management._11_grouping_threads_into_a_group;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // 返回当前线程组以及子线程组里面的活动线程个数的估计值
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();


        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for (Thread thread : threads) {
            System.out.printf("Thread %s: %s\n", thread.getName(), thread.getState());
        }


        waitFinish(threadGroup);

        threadGroup.interrupt();

    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 4) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
