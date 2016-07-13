package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._11;

/**
 * created on 2016-07-13 22:16
 *
 * @author nextyu
 */
public class Sensor1 implements Runnable {

    private ParkingCounter counter;

    public Sensor1(ParkingCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carOut();
        counter.carOut();
        counter.carOut();
        counter.carIn();
        counter.carIn();
        counter.carIn();
    }
}
