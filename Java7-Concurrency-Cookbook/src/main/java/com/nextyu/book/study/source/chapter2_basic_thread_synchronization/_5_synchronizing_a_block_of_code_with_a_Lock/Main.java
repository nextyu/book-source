package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._5_synchronizing_a_block_of_code_with_a_Lock;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        for (int i = 0; i < 10; i++) {
            new Thread(new Job(printQueue), "Thread_" + i).start();
        }
    }
}
