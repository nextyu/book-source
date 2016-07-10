package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._4_waiting_for_multiple_concurrent_events;

import java.util.concurrent.TimeUnit;

/**
 * 这个类表示每个video conference的参与者
 *
 * @author zhouyu
 */
public class Participant implements Runnable {

    private VideoConference conference;

    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        // 首先，让线程随机休眠一段时间
        long duration=(long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 然后，使用VideoConference 对象的arrive() 方法来表明参与者的到达
        conference.arrive(name);
    }
}
