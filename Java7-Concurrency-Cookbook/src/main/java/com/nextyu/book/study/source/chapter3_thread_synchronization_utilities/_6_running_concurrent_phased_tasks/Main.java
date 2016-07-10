package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._6_running_concurrent_phased_tasks;

import java.util.concurrent.Phaser;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        // three participants
        // 用来在每个阶段（phase）结尾的控制线程的同步。
        // 这个参数告诉 Phaser ，在Phaser改变阶段（phase）和唤醒休眠中的线程之前，必须要执行arriveAndAwaitAdvance()方法的线程的个数
        Phaser phaser = new Phaser(3);

        FileSearch system=new FileSearch("C:\\Windows", "log",
                phaser);
        FileSearch apps=
                new FileSearch("C:\\Program Files","log",phaser);
        FileSearch documents=
                new FileSearch("C:\\Documents And Settings","log",phaser);

        /*FileSearch _360=
                new FileSearch("D:\\360","log",phaser);*/



        Thread systemThread=new Thread(system,"System");
        systemThread.start();

        Thread appsThread=new Thread(apps,"Apps");
        appsThread.start();

        Thread documentsThread=new Thread(documents, "Documents");
        documentsThread.start();

        /*Thread _360Thread=new Thread(_360, "360");
        _360Thread.start();*/

        // Wait for the finalization of the three threads
        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
            //_360Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Terminated: "+ phaser.isTerminated());

    }
}
