package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._10;

import edu.umd.cs.mtc.MultithreadedTestCase;

import java.util.concurrent.LinkedTransferQueue;

/**
 * created on 2016-07-14 11:48
 *
 * @author nextyu
 */
public class ProducerConsumerTest extends MultithreadedTestCase {
    private LinkedTransferQueue<String> queue;

    @Override
    public void initialize() {
        super.initialize();
        queue = new LinkedTransferQueue<>();
        System.out.printf("Test: The test has been initialized\n");
    }

    /**
     * It will implement the logic of the first consumer
     *
     * @throws InterruptedException
     */
    public void thread1() throws InterruptedException {
        String result = queue.take();
        System.out.printf("Thread 1: %s\n", result);
    }

    /**
     * It will implement the logic of the second consumer
     * First, wait until the first thread has slept in the take() method using
     * the waitForTick() method
     *
     * @throws InterruptedException
     */
    public void thread2() throws InterruptedException {
        waitForTick(1);
        String result = queue.take();
        System.out.printf("Thread 2: %s\n", result);
    }

    /**
     * It will implement the logic of a producer.
     */
    public void thread3() {
        waitForTick(1);
        waitForTick(2);
        queue.put("Event 1");
        queue.put("Event 2");
        System.out.printf("Thread 3: Inserted two elements\n");
    }

    public void finish() {
        super.finish();
        System.out.printf("Test: End\n");
        assertEquals(true, queue.size() == 0);
        System.out.printf("Test: Result: The queue is empty\n");
    }


}
