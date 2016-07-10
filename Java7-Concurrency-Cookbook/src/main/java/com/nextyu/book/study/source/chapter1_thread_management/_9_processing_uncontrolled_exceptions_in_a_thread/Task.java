package com.nextyu.book.study.source.chapter1_thread_management._9_processing_uncontrolled_exceptions_in_a_thread;

/**
 * @author zhouyu
 */
public class Task implements Runnable {
    @Override
    public void run() {
        // 测试非检查异常
        Integer.parseInt("TT");
    }
}
