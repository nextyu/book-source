package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._6_customizing_tasks_running_in_a_scheduled_thread_pool;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public MyScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
    }

    /**
     * 包装Task
     *
     * @param runnable
     * @param task
     * @param <V>
     * @return
     */
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        MyScheduledTask<V> myScheduledTask = new MyScheduledTask<>(runnable, null, task, this);
        return myScheduledTask;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        ScheduledFuture<?> task = super.scheduleAtFixedRate(command, initialDelay, period, unit);
        MyScheduledTask<?> myTask = (MyScheduledTask<?>) task;
        myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period, unit));
        return myTask;
    }
}
