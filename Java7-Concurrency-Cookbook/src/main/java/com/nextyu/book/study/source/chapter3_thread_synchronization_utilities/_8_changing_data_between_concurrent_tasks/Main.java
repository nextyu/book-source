package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._8_changing_data_between_concurrent_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * When the two threads arrive to this point, they
 * interchange a data structure so the data structure of the fist thread goes to the second one
 * and the data structure of the second thread goes to the fist one.
 * <p/>
 * use the Exchanger class to solve the producer-consumer
 * problem with one producer and one consumer.
 *
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        // Create the two buffers that will be used by the producer and the consumer.
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        // Create the Exchanger object that will be used to synchronize the producer and the consumer.
        Exchanger<List<String>> exchanger = new Exchanger<>();
        Producer producer = new Producer(exchanger, buffer1);
        Consumer consumer = new Consumer(exchanger, buffer2);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
