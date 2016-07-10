package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._8_using_multiple_conditions_in_a_Lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用来实现在生产者与消费者之间共享的缓冲区
 * 一个锁可能伴随着多个条件。这些条件声明在Condition接口中。 这些条件的目的是允许线程拥有锁的控制并且检查条件是否为true，
 * 如果是false，那么线程将被阻塞，直到其他线程唤醒它们。Condition接口提供一种机制，阻塞一个线程和唤醒一个被阻塞的线程。
 * 在并发编程中，生产者与消费者是经典的问题。我们有一个数据缓冲区，一个或多个数据生产者往缓冲区存储数据，一个或多个数据消费者从缓冲区中取出数据。
 *
 * @author zhouyu
 */
public class Buffer {

    /**
     * 用来存储共享数据
     */
    private LinkedList<String> buffer;
    /**
     * 用来存储缓冲区的长度
     */
    private int maxSize;
    /**
     * 用来控制修改缓冲区代码块的访问
     */
    private ReentrantLock lock;
    private Condition lines; // 缓存是否有值条件
    private Condition space; // 缓存是否有空间条件
    /**
     * 表示缓冲区是否有值
     */
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                // 缓存没有空间
                space.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.
                    currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        String line = null;
        lock.lock();
        try {
            while ((buffer.size() == 0) && hasPendingLines()) {
                // 缓存为空
                lines.await();
            }
            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.
                        currentThread().getName(), buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }

    /**
     * It will be called by the producer when it has no more lines to produce.
     * @param pendingLines
     */
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }
}
