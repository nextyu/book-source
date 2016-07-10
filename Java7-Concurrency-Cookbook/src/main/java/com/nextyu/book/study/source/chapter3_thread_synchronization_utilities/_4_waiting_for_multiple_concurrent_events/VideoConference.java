package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._4_waiting_for_multiple_concurrent_events;

import java.util.concurrent.CountDownLatch;

/**
 * 等待多个并发事件完成
 * video-conference 系统将等待全部参与者到达后才会开始
 *
 * @author zhouyu
 */
public class VideoConference implements Runnable {

    private final CountDownLatch controller;

    /**
     * 实现类的构造函数，初始 CountDownLatch 属性。VideoConference 类接收将要等待的参与者的量为参数。
     *
     * @param number
     */
    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    /**
     * 每次有参与者到达都会调用此方法
     *
     * @param name
     */
    public void arrive(String name) {
        System.out.println(name + " has arrived.");

        // decrement the internal counter
        controller.countDown();

        //  最后，使用CountDownLatch对象的 getCount() 方法输出另一条关于还未确定到达的参与者数
        System.out.println("VideoConference: Waiting for " + controller.getCount() + " participants.");
    }

    @Override
    public void run() {
        // 首先，使用 getCount() 方法来输出这次video conference的参与值的数量信息
        System.out.println("VideoConference: Initialization " + controller.getCount() + " participants.");

        try {
            // 然后， 使用 await() 方法来等待全部的参与者
            controller.await();

            /**
             * Every time a thread calls the countDown()  method, the
             CountDownLatch object decrements the internal counter in one unit. When the internal
             counter arrives to 0, the CountDownLatch object wakes up all the threads that were waiting
             in the await()  method.
             */

            // 最后，输出信息表明全部参与者已经到达
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
