package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._4_implementing_the_threadfactory_interface_to_generate_custom_threads;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        MyTask task = new MyTask();
        Thread thread = factory.newThread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Thread information.\n");
        System.out.printf("%s\n",thread);
        System.out.printf("Main: End of the example.\n");
    }
}
