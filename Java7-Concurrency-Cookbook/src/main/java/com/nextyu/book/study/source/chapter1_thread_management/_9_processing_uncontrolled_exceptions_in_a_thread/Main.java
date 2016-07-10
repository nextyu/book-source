package com.nextyu.book.study.source.chapter1_thread_management._9_processing_uncontrolled_exceptions_in_a_thread;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
