package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._2_monitoring_a_Lock_interface;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created on 2016-07-14 9:28
 *
 * @author nextyu
 */
public class MyLock extends ReentrantLock {

    /**
     * returns the name of the thread that has the control of a lock (if any)
     *
     * @return
     */
    public String getOwnerName() {
        return getOwner() == null ? "None" : getOwner().getName();
    }

    /**
     * returns a list of threads queued in a lock
     *
     * @return
     */
    public Collection<Thread> getThreads() {
        return getQueuedThreads();
    }

}
