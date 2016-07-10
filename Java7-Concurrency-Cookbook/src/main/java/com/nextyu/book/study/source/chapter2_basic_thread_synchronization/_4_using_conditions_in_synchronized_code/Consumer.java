package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._4_using_conditions_in_synchronized_code;

/**
 * 消费者
 *
 * @author zhouyu
 */
public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
