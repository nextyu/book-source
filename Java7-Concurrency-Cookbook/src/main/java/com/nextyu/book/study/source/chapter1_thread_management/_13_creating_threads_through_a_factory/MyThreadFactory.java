package com.nextyu.book.study.source.chapter1_thread_management._13_creating_threads_through_a_factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @author zhouyu
 */
public class MyThreadFactory implements ThreadFactory {

    private int counter; // 储存线程对象的数量
    private String name; // 每个创建线程的名字
    private List<String> stats; // 储存创建的线程对象的统计数据

    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
        return t;
    }

    /**
     * 返回全部的创建的 Thread 对象的统计数据
     *
     * @return
     */
    public String getStats() {
        StringBuilder sb = new StringBuilder();
        for (String stat : stats) {
            sb.append(stat).append("\n");
        }
        return sb.toString();
    }
}
