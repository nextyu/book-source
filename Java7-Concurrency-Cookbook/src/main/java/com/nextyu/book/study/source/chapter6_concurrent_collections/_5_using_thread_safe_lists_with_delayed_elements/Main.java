package com.nextyu.book.study.source.chapter6_concurrent_collections._5_using_thread_safe_lists_with_delayed_elements;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        DelayQueue<Event> queue = new DelayQueue<>();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(i + 1, queue);
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

        do {
            int counter = 0;
            Event event;
            do {
                event = queue.poll();
                if (event != null) {
                    counter++;
                }
            } while (event != null);
            System.out.printf("At %s you have read %d events\n",new DateTime().toString("yyyy-MM-dd HH:mm:ss"),counter);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (queue.size() > 0);
    }
}
