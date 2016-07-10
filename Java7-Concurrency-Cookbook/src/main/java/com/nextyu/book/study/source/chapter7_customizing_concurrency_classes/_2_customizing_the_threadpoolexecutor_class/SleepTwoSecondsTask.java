package com.nextyu.book.study.source.chapter7_customizing_concurrency_classes._2_customizing_the_threadpoolexecutor_class;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class SleepTwoSecondsTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return new DateTime().toString("yyyy-MM-dd HH:mm:ss");
    }
}
