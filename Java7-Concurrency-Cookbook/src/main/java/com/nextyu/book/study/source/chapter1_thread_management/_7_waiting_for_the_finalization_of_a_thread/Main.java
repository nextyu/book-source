package com.nextyu.book.study.source.chapter1_thread_management._7_waiting_for_the_finalization_of_a_thread;

import java.util.Date;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DataSourcesLoader());
        Thread thread2 = new Thread(new NetworkConnectionsLoader());

        thread1.start();
        thread2.start();

        try {
            /*
            public final void join() throws InterruptedException
            Waits for this thread to die.
            join()方法的作用，是等待这个线程结束；但显然，这样的定义并不清晰。个人认为"Java 7 Concurrency Cookbook"的定义较为清晰：
            join() method suspends the execution of the calling thread until the object called finishes its execution.
            也就是说，t.join()方法阻塞调用此方法的线程(calling thread)，直到线程t完成，此线程再继续；
            通常用于在main()主线程内，等待其它线程完成再结束main()主线程。
             */
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main: Configuration has been loaded: " + new Date());
    }
}
