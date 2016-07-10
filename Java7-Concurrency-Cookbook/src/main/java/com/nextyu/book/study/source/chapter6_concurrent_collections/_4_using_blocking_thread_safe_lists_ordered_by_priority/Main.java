package com.nextyu.book.study.source.chapter6_concurrent_collections._4_using_blocking_thread_safe_lists_ordered_by_priority;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(i, queue);
            threads[i] = new Thread(task);
        }


        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Queue Size: %d\n",queue.size());

        for (int i = 0; i < threads.length * 1000; i++) {
            Event event = queue.poll();
            System.out.printf("Thread %s: Priority %d\n",event.
                    getThread(),event.getPriority());
        }

        System.out.printf("Main: Queue Size: %d\n",queue.size());
        System.out.printf("Main: End of the program\n");

    }
}
