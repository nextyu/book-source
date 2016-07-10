package com.nextyu.book.study.source.chapter4_thread_executors._11_separating_the_launching_of_tasks_and_the_processing_of_their_results_in_an_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 报告生成器
 *
 * @author zhouyu
 */
public class ReportGenerator implements Callable<String> {

    /**
     * 寄件人
     */
    private String sender;
    private String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n", this.sender, this.title, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String ret = sender + ": " + title;
        return ret;
    }
}
