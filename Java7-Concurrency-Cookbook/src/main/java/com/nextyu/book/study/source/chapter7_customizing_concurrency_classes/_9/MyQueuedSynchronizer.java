package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._9;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * created on 2016-07-12 22:48
 *
 * @author nextyu
 */
public class MyQueuedSynchronizer extends AbstractQueuedSynchronizer {
    private AtomicInteger state;

    public MyQueuedSynchronizer() {
        state = new AtomicInteger(0);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return state.compareAndSet(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return state.compareAndSet(1, 0);
    }
}
