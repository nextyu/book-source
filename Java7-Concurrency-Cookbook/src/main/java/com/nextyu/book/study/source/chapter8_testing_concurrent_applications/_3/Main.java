package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._3;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * created on 2016-07-14 9:56
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        for (int i = 0; i < 3; i++) {
            Task task = new Task(i + 1, phaser);
            Thread thread = new Thread(task);
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("********************\n");
            System.out.printf("Main: Phaser Log\n");
            System.out.printf("Main: Phaser: Phase: %d\n", phaser.
                    getPhase());
            System.out.printf("Main: Phaser: Registered Parties: %d\n", phaser.getRegisteredParties());
            System.out.printf("Main: Phaser: Arrived Parties: %d\n", phaser.getArrivedParties());
            System.out.printf("Main: Phaser: Unarrived Parties: %d\n", phaser.getUnarrivedParties());
            System.out.printf("********************\n");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
