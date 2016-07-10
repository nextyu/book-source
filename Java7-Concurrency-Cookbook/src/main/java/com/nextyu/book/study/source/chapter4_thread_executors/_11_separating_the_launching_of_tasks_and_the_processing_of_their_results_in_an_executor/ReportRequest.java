package com.nextyu.book.study.source.chapter4_thread_executors._11_separating_the_launching_of_tasks_and_the_processing_of_their_results_in_an_executor;

import java.util.concurrent.CompletionService;

/**
 * simulate some report requests
 * 报告请求
 *
 * @author zhouyu
 */
public class ReportRequest implements Runnable {

    /**
     * store the name of ReportRequest
     */
    private String name;

    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
        service.submit(reportGenerator);
    }
}
