package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._5_synchronizing_tasks_in_a_common_point;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        final int ROWS = 10000; // 矩阵的行数
        final int NUMBERS = 1000; // 矩阵的列数
        final int SEARCH = 5; // 要查找的数字
        final int PARTICIPANTS = 5; // 统计数字的线程个数
        final int LINES_PARTICIPANT = 2000;

        MatrixMock matrixMock = new MatrixMock(ROWS, NUMBERS, SEARCH);

        Results results = new Results(ROWS);

        Grouper grouper = new Grouper(results);

        // 创建 CyclicBarrier 对象，叫 barrier，这个对象将等待5个线程。当这5个线程都执行完毕，它将执行上面创建的 Grouper 对象
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        Searcher[] searchers = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, matrixMock, results, 5, barrier);
            new Thread(searchers[i]).start();
        }

        System.out.printf("Main: The main thread has finished.\n");


    }
}
