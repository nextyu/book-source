package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created on 2016-07-13 22:08
 *
 * @author nextyu
 */
public class ParkingCounter extends AtomicInteger {
    /**
     * store the maximum number
     * of cars admitted in the parking lot
     */
    private int maxNumber;

    public ParkingCounter(int maxNumber) {
        super(0);
        this.maxNumber = maxNumber;
    }

    public boolean carIn() {
        for (; ; ) {
            int value = get();
            if (value == maxNumber) {
                System.out.printf("ParkingCounter: The parking lot is full.\n");
                return false;
            } else {
                int newValue = value + 1;
                boolean changed = compareAndSet(value, newValue);
                if (changed) {
                    System.out.printf("ParkingCounter: A car has entered.\n");
                    return true;
                }

            }
        }
    }

    public boolean carOut() {
        for (; ; ) {
            int value = get();
            if (value == 0) {
                System.out.printf("ParkingCounter: The parking lot is empty.\n");
                return false;
            } else {
                int newValue = value - 1;
                boolean changed = compareAndSet(value, newValue);
                if (changed) {
                    System.out.printf("ParkingCounter: A car has gone out.\n");
                    return true;
                }
            }
        }
    }
}
