package com.nextyu.book.study.source.chapter1_thread_management._11_grouping_threads_into_a_group;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class SearchTask implements Runnable {

    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread " + name + " start");
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " Interrupted");
            return;
        }
        System.out.println("Thread " + name + " end");
        System.out.println("Result name " + result.getName());
    }

    private void doTask() throws InterruptedException {
        String name = Thread.currentThread().getName();
        Random random = new Random(new Date().getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.println("Thread " + name + " " + value);
        TimeUnit.SECONDS.sleep(value);
    }
}
