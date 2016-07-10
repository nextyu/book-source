package com.nextyu.book.study.source.chapter6_concurrent_collections._3_using_blocking_thread_safe_lists;

import org.joda.time.DateTime;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Client implements Runnable {

    private LinkedBlockingDeque<String> requestList;

    public Client(LinkedBlockingDeque<String> requestList) {
        this.requestList = requestList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder request = new StringBuilder();
                request.append(i).append(":").append(j);
                try {
                    requestList.put(request.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("Client: %s at %s.\n", request, new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.printf("Client: End.\n");
    }
}
