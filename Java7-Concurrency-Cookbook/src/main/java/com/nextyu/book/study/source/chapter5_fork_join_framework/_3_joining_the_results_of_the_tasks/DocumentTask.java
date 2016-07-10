package com.nextyu.book.study.source.chapter5_fork_join_framework._3_joining_the_results_of_the_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * calculate the number of appearances of the word in a set of lines
 *
 * @author zhouyu
 */
public class DocumentTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    private String document[][];
    private int start, end;
    private String word;

    public DocumentTask(String[][] document, int start, int end, String word) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (end - start < 10) {
            result = processLines(document, start, end, word);
        } else {
            int mid = (start + end) / 2;
            DocumentTask task1 = new DocumentTask(document, start, mid, word);
            DocumentTask task2 = new DocumentTask(document, mid, end, word);
            invokeAll(task1, task2);
            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer groupResults(Integer num1, Integer num2) {
        return num1 + num2;
    }

    private Integer processLines(String[][] document, int start, int end, String word) {
        List<LineTask> tasks = new ArrayList<>();
        for (int i = start; i < end; i++) {
            LineTask lineTask = new LineTask(document[i], 0, document[i].length, word);
            tasks.add(lineTask);
        }
        invokeAll(tasks);
        // Sum the value returned by all these tasks and return the result
        int result = 0;
        for (int i = 0; i < tasks.size(); i++) {
            LineTask lineTask = tasks.get(i);
            try {
                result += lineTask.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}
