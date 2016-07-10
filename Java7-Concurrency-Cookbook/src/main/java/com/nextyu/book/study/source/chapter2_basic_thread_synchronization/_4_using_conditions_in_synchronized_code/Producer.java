package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._4_using_conditions_in_synchronized_code;

/**
 * 生产者
 *
 * @author zhouyu
 */
public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
