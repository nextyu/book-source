package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._8_changing_data_between_concurrent_tasks;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author zhouyu
 */
public class Consumer implements Runnable {

    // This will be the data structure that the producer will interchange with the consumer.
    private List<String> buffer;

    // This will be the exchanger object that will be used to synchronize producer and consumer.
    private final Exchanger<List<String>> exchanger;

    public Consumer(Exchanger<List<String>> exchanger, List<String> buffer) {
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Cycle %d\n", cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: " + buffer.size());
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer: " + message);
                buffer.remove(0);
            }
            cycle++;
        }
    }
}
