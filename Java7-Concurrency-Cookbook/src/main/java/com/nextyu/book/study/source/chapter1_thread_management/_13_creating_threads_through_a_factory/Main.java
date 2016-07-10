package com.nextyu.book.study.source.chapter1_thread_management._13_creating_threads_through_a_factory;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        for (int i = 0; i < 10; i++) {
            Thread thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n", factory.getStats());
    }
}
