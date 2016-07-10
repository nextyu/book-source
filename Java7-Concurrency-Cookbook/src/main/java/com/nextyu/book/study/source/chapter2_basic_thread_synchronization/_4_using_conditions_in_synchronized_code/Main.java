package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._4_using_conditions_in_synchronized_code;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}
