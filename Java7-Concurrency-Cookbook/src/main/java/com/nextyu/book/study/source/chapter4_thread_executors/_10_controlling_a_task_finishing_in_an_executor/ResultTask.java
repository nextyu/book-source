package com.nextyu.book.study.source.chapter4_thread_executors._10_controlling_a_task_finishing_in_an_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhouyu
 */
public class ResultTask extends FutureTask<String> {

    /**
     * 任务名称
     */
    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask) callable).getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been canceled\n", name);
        } else {
            System.out.printf("%s: Has finished\n", name);
        }

    }
}
