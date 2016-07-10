package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._6_running_concurrent_phased_tasks;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * 查找最近24小时之内修改过的指定后缀名的文件
 * <p/>
 * 分3个阶段：
 * 1. 找到指定目录以及子目录里面指定后缀名.log的文件列表
 * 2. 过滤文件列表，删除修改时间超过24小时的文件
 * 3. 打印文件列表
 * <p/>
 * At the end of the steps 1 and 2 we check if the list has any elements or not. If it hasn't any
 * element, the thread ends its execution and is eliminated from the the phaser class.
 *
 * @author zhouyu
 */
public class FileSearch implements Runnable {

    /**
     * 将要查找的文件夹路径
     */
    private String initPath;

    /**
     * 要查找的文件后缀名
     */
    private String end;

    /**
     * 保存查找到文件的全路径
     */
    private List<String> results;

    /**
     * 来控制不同阶段任务的同步
     */
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        results = new ArrayList<>();
    }

    /**
     * 处理目录以及子目录
     *
     * @param file
     */
    private void directoryProcess(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File eachFile : files) {
                if (eachFile.isDirectory()) {
                    directoryProcess(eachFile);
                } else {
                    fileProcess(eachFile);
                }
            }
        }
    }

    /**
     * 处理文件
     *
     * @param file
     */
    private void fileProcess(File file) {
        if (file.getName().endsWith(end)) {
            results.add(file.getAbsolutePath());
        }
    }

    /**
     * 过滤
     */
    private void filterResults() {
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();
        for (String result : results) {
            File file = new File(result);
            long fileDate = file.lastModified();
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(result);
            }
        }
        results = newResults;
    }


    /**
     * 此方法在第一个和第二个阶段的结尾被调用，并检查结果是否为空。
     *
     * @return
     */
    private boolean checkResults() {
        if (results.isEmpty()) {
            System.out.printf("%s: Phase %d: 0 results.\n", Thread.
                    currentThread().getName(), phaser.getPhase());
            System.out.printf("%s: Phase %d: End.\n", Thread.
                    currentThread().getName(), phaser.getPhase());
            // to notify it that this thread has finished the actual phase, and it leaves the phased operation
            // Arrives at this phaser and deregisters from it without waiting for others to arrive
            // 因为结果为空，所以不需要等待其他线程
            // This notifies the phaser that this thread has finished the actual phase, but it won't participate in the future phases,
            // so the phaser won't have to wait for it to continue
            phaser.arriveAndDeregister();
            return false;
        } else {
            // to notify it that this thread has finished the actual phase and it wants to be blocked until all the participant threads in the phased
            // operation finish the actual phase
            System.out.printf("%s: Phase %d: %d results.\n", Thread.
                    currentThread().getName(), phaser.getPhase(), results.size());
            // 阻塞，等待其他参与的线程也执行完这个阶段的任务
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }


    private void showInfo() {
        for (String result : results) {
            File file = new File(result);
            System.out.printf("%s: %s\n", Thread.currentThread().
                    getName(), file.getAbsolutePath());
        }
        // Arrives at this phaser and awaits others
        phaser.arriveAndAwaitAdvance();
    }

    @Override
    public void run() {
        // The search won't begin until all the threads have been created
        // Arrives at this phase and awaits others，makes none of the FileSearch threads begin their
        // job until all the threads have been created
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Starting.\n", Thread.currentThread().
                getName());
        // 1.
        File file = new File(initPath);
        if (file.isDirectory()) {
            directoryProcess(file);
        }
        if (!checkResults()) {
            return;
        }

        // 2.
        filterResults();
        if (!checkResults()) {
            return;
        }

        // 3.
        showInfo();
        phaser.arriveAndDeregister();
        System.out.printf("%s: Work completed.\n", Thread.
                currentThread().getName());

    }
}
