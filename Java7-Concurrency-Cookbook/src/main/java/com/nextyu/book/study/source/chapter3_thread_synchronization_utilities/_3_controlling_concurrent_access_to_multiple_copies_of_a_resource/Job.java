package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._3_controlling_concurrent_access_to_multiple_copies_of_a_resource;

/**
 * @author zhouyu
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

}
