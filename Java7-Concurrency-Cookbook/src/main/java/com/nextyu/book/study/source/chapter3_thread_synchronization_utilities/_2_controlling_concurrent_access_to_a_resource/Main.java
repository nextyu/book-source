package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._2_controlling_concurrent_access_to_a_resource;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(new Job(printQueue),"Thread"+i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
