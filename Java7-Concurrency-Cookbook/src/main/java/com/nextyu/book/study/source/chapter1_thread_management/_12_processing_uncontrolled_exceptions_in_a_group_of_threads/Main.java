package com.nextyu.book.study.source.chapter1_thread_management._12_processing_uncontrolled_exceptions_in_a_group_of_threads;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(myThreadGroup, task);
            thread.start();
        }
    }
}
