package com.nextyu.book.study.source.chapter4_thread_executors._10_controlling_a_task_finishing_in_an_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class ExecutableTask implements Callable {

    /**
     * 任务名称
     */
    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object call() throws Exception {
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, world. I'm " + name;
    }
}
