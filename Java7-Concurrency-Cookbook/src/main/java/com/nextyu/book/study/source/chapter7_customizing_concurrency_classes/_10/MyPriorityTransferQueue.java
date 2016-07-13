package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._10;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created on 2016-07-13 21:58
 *
 * @author nextyu
 */
public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> implements TransferQueue<E> {

    /**
     * store the number of consumers that are waiting for elements to consume
     */
    private AtomicInteger counter;

    private LinkedBlockingQueue<E> transfered;

    private ReentrantLock lock;

    public MyPriorityTransferQueue() {
        counter = new AtomicInteger(0);
        transfered = new LinkedBlockingQueue<>();
        lock = new ReentrantLock();
    }

    /**
     * This method tries to send the
     * element to a waiting consumer immediately, if possible. If there isn't any
     * waiting consumer, the method returns the false value
     *
     * @param e
     * @return
     */
    @Override
    public boolean tryTransfer(E e) {
        lock.lock();
        boolean value;
        if (counter.get() == 0) {
            value = false;
        } else {
            put(e);
            value = true;
        }
        lock.unlock();
        return value;
    }

    @Override
    public void transfer(E e) throws InterruptedException {
        // TODO 重新看书
    }

    @Override
    public boolean tryTransfer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public boolean hasWaitingConsumer() {
        return false;
    }

    @Override
    public int getWaitingConsumerCount() {
        return 0;
    }
}
