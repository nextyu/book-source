package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._2_monitoring_a_Lock_interface;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-14 9:33
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyLock lock = new MyLock();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(lock);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 15; i++) {
            System.out.printf("Main: Logging the Lock\n");
            System.out.printf("************************\n");
            System.out.printf("Lock: Owner : %s\n", lock.getOwnerName());
            System.out.printf("Lock: Queued Threads: %s\n", lock.hasQueuedThreads());

            // Display the number and the name of the threads queued for the lock
            if (lock.hasQueuedThreads()) {
                System.out.printf("Lock: Queue Length: %d\n", lock.
                        getQueueLength());
                System.out.printf("Lock: Queued Threads: ");
                Collection<Thread> lockedThreads = lock.getThreads();
                for (Thread lockedThread : lockedThreads) {
                    System.out.printf("%s ", lockedThread.getName());
                }
                System.out.printf("\n");
            }

            System.out.printf("Lock: Fairness: %s\n", lock.isFair());
            System.out.printf("Lock: Locked: %s\n", lock.isLocked());
            System.out.printf("************************\n");

            TimeUnit.SECONDS.sleep(1);

        }

    }
}
