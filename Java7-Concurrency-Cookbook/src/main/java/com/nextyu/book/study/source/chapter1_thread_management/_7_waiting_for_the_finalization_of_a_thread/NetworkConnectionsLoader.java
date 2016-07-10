package com.nextyu.book.study.source.chapter1_thread_management._7_waiting_for_the_finalization_of_a_thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("Beginning network connections sources loading: " + new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Network connections loading has finished: " + new Date());
    }
}
