package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._7_modifying_Lock_fairness;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        for (int i = 0; i < 10; i++) {
            new Thread(new Job(printQueue), "Thread_" + i).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
