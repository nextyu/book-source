package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._3_controlling_concurrent_access_to_multiple_copies_of_a_resource;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 控制并发访问多个资源
 *
 * @author zhouyu
 */
public class PrintQueue {
    private final Semaphore semaphore;

    /**
     * This array stores printers that are free to print a job and
     printers that are printing a document
     */
    private boolean[] freePrinters;

    /**
     * 将要使用这个对象来保护freePrinters array的访问
     */
    private Lock lockPrinters;

    public PrintQueue() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < freePrinters.length; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            //  接着使用私有方法 getPrinter()来获得被安排打印任务的打印机的号码。
            int assignedPrinter = getPrinter();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer%d during %d seconds\n", Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

            // 标记打印机为空闲
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    /**
     * 获取空闲的打印机索引
     *
     * @return 索引值
     */
    private int getPrinter() {
        int index = -1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    index = i;
                    // 标记打印机为使用中
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return index;
    }
}
