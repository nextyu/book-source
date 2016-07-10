package com.nextyu.book.study.source.chapter4_thread_executors._2_creating_a_thread_executor;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task_" + i);
            server.executeTask(task);
        }

        server.endServer();
    }
}
