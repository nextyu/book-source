package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._6;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * created on 2016-07-14 11:18
 *
 * @author nextyu
 */
public class Task implements Runnable {


    @Override
    public void run() {
        Logger logger = MyLogger.getLogger(this.getClass().getName());
        logger.entering(Thread.currentThread().getName(), "run()");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.exiting(Thread.currentThread().getName(),
                "run()", Thread.currentThread());
    }
}
