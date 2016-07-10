package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._8_changing_data_between_concurrent_tasks;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 生产者
 *
 * @author zhouyu
 */
public class Producer implements Runnable {

    /**
     * This will be the data structure that
     * the producer will interchange with the consumer
     */
    private List<String> buffer;

    // This will be the exchanger object that will be used to synchronize producer and consumer.
    private final Exchanger<List<String>> exchanger;

    public Producer(Exchanger<List<String>> exchanger, List<String> buffer) {
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer: Cycle %d\n", cycle);
            for (int j = 0; j < 10; j++) {
                String message = "Event " + ((i * 10) + j);
                System.out.printf("Producer: %s\n", message);
                buffer.add(message);
            }

            try {
                // Call the exchange()  method to interchange data with the consumer.
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Producer: " + buffer.size());
            cycle++;
        }
    }
}
