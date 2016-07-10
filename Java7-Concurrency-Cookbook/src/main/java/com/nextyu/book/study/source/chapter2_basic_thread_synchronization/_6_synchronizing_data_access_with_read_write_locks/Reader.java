package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._6_synchronizing_data_access_with_read_write_locks;

/**
 * @author zhouyu
 */
public class Reader implements Runnable {

    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Price 1: %f\n", Thread.
                    currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s: Price 2: %f\n", Thread.
                    currentThread().getName(), pricesInfo.getPrice2());
        }

    }
}
