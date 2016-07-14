package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._3;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-14 9:51
 *
 * @author nextyu
 */
public class Task implements Runnable {
    private int time;
    private Phaser phaser;

    public Task(int time, Phaser phaser) {
        this.time = time;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.arrive();
        System.out.printf("%s: Entering phase 1.\n",Thread.
                currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 1.\n",Thread.
                currentThread().getName());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Entering phase 2.\n",Thread.
                currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 2.\n",Thread.
                currentThread().getName());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Entering phase 3.\n",Thread.
                currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 3.\n",Thread.
                currentThread().getName());
        phaser.arriveAndDeregister();
    }
}
