package com.nextyu.book.study.source.chapter6_concurrent_collections._3_using_blocking_thread_safe_lists;

import org.joda.time.DateTime;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
        Client client = new Client(list);
        new Thread(client).start();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    String request = list.take();
                    System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new DateTime().toString("yyyy-MM-dd HH:mm:ss"), list.size());
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.printf("Main: End of the program.\n");
    }
}
