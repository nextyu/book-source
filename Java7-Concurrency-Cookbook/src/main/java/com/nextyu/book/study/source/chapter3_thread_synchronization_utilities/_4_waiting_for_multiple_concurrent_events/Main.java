package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._4_waiting_for_multiple_concurrent_events;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        // 创建 VideoConference 对象名为 conference，将等待10个参与者
        VideoConference conference = new VideoConference(10);

        // 创建 Thread 来运行这个 VideoConference 对象并开始运行
        new Thread(conference).start();

        // 创建 10个 Participant 对象，为每个对象各创建一个 Thread 对象来运行他们，开始运行全部的线程
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(conference, "Participant:" + i);
            new Thread(participant).start();
        }

    }
}
