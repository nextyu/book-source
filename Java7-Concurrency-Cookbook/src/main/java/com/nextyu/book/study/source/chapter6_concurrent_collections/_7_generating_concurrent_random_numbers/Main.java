package com.nextyu.book.study.source.chapter6_concurrent_collections._7_generating_concurrent_random_numbers;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            TaskLocalRandom random = new TaskLocalRandom();
            threads[i] = new Thread(random);
            threads[i].start();
        }
    }
}
