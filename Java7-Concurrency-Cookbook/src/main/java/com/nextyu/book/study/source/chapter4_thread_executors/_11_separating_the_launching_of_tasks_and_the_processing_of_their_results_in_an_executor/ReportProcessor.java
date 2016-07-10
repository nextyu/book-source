package com.nextyu.book.study.source.chapter4_thread_executors._11_separating_the_launching_of_tasks_and_the_processing_of_their_results_in_an_executor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 报告处理
 * This class will get the results of the ReportGenerator tasks
 *
 * @author zhouyu
 */
public class ReportProcessor implements Runnable {

    private CompletionService<String> service;

    private boolean end;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        end = false;
    }

    @Override
    public void run() {
        while (!end) {
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if (result != null) {
                    String report = result.get();
                    System.out.printf("ReportReceiver: Report Received:%s\n", report);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("ReportSender: End\n");
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
