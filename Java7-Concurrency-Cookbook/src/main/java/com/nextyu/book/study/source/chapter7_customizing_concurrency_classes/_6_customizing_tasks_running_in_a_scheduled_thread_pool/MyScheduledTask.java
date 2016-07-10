package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._6_customizing_tasks_running_in_a_scheduled_thread_pool;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author zhouyu
 */
public class MyScheduledTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {

    private RunnableScheduledFuture<V> task;

    private ScheduledThreadPoolExecutor executor;

    /**
     * 周期
     */
    private long period;

    private long startDate;


    /**
     * @param runnable the Runnable object that is going to be executed by a task,
     * @param result   the result that will be returned by this task
     * @param task     the RunnableScheduledFuture task that will be used to create the MyScheduledTask object
     * @param executor the ScheduledThreadPoolExecutor object that is going to execute the task
     */
    public MyScheduledTask(Runnable runnable, V result, RunnableScheduledFuture<V> task, ScheduledThreadPoolExecutor executor) {
        super(runnable, result);
        this.task = task;
        this.executor = executor;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    @Override
    public boolean isPeriodic() {
        return task.isPeriodic();
    }

    /**
     * Returns the remaining delay associated with this object, in the
     * given time unit.
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        if (!isPeriodic()) {
            // not Periodic tasks
            return task.getDelay(unit);
        } else {
            // Periodic tasks
            if (startDate == 0) {
                return task.getDelay(unit);
            } else {
                Date now = new Date();
                long delay = startDate - now.getTime();
                return unit.convert(delay, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override
    public int compareTo(Delayed o) {
        return task.compareTo(o);
    }

    @Override
    public void run() {
        // 是周期性任务
        if (isPeriodic() && (!executor.isShutdown())) {
            Date now = new Date();
            startDate = now.getTime() + period;
            executor.getQueue().add(this);
        }

        System.out.printf("Pre-MyScheduledTask: %s\n",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        System.out.printf("MyScheduledTask: Is Periodic: %s\n",isPeriodic());
        super.runAndReset();
        System.out.printf("Post-MyScheduledTask: %s\n",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
