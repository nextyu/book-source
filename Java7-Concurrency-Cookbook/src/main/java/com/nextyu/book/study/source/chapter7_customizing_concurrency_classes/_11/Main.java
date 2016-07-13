package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._11;

/**
 * created on 2016-07-13 22:17
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingCounter counter = new ParkingCounter(5);
        Sensor1 sensor1 = new Sensor1(counter);
        Sensor2 sensor2 = new Sensor2(counter);

        Thread thread1 = new Thread(sensor1);
        Thread thread2 = new Thread(sensor2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.printf("Main: Number of cars: %d\n",counter.get());

        System.out.printf("Main: End of the program.\n");

    }
}
