package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._9;

import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-12 22:58
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(myLock, "Task-" + i);
            new Thread(task).start();
        }

        boolean value;
        do {
            try {
                value = myLock.tryLock(1, TimeUnit.SECONDS);
                if (!value) {
                    System.out.printf("Main: Trying to get the Lock\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                value = false;
            }
        } while (!value);

        System.out.printf("Main: Got the lock\n");
        myLock.unlock();

        System.out.printf("Main: End of the program\n");
    }
}
