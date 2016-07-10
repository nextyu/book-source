package com.nextyu.book.study.source.chapter1_thread_management._8_creating_and_running_a_daemon_thread;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();

        WriteTask writeTask = new WriteTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writeTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
