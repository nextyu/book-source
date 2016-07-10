package com.nextyu.book.study.source.chapter1_thread_management._8_creating_and_running_a_daemon_thread;

import java.util.Date;

/**
 * @author zhouyu
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
