package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._8_Customizing_tasks_running_in_the_Fork_Join_framework;

import java.util.Date;
import java.util.concurrent.ForkJoinTask;

/**
 * created on 2016-07-12 21:42
 *
 * @author nextyu
 */
public abstract class MyWorkerTask extends ForkJoinTask<Void> {

    private String name;

    public MyWorkerTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Void getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Void value) {

    }

    @Override
    protected boolean exec() {
        Date startDate = new Date();
        compute();
        Date finishDate = new Date();
        long diff = finishDate.getTime() - startDate.getTime();
        System.out.printf("MyWorkerTask: %s : %d Milliseconds to complete.\n", name, diff);
        return true;
    }

    /**
     * this method will
     * implement the logic of the tasks and must be implemented by the child classes of the
     * MyWorkerTask class
     */
    protected abstract void compute();
}