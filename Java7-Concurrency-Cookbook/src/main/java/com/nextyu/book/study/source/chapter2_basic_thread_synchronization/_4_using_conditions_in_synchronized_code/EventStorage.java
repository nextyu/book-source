package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._4_using_conditions_in_synchronized_code;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 在并发编程中的一个经典问题是生产者与消费者问题，我们有一个数据缓冲区，一个或多个数据的生产者在缓冲区存储数据，而一个或多个数据的消费者，把数据从缓冲区取出。
 * 由于缓冲区是一个共享的数据结构，我们必须采用同步机制，比如synchronized关键字来控制对它的访问。但是我们有更多的限制因素，如果缓冲区是满的，
 * 生产者不能存储数据，如果缓冲区是空的，消费者不能取出数据。
 *
 * @author zhouyu
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.printf("Set: %d \n", storage.size());
        notifyAll();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s \n", storage.
                size(), storage.remove(storage.size() - 1));
        notifyAll();
    }
}
