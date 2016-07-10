package com.nextyu.book.study.source.chapter1_thread_management._5_controlling_the_interruption_of_a_thread;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("c:\\", "XshellCore.tlb");
        Thread thread = new Thread(searcher);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

    }
}
