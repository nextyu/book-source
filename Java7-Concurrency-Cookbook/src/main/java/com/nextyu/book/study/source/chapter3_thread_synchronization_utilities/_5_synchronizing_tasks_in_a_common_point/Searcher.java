package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._5_synchronizing_tasks_in_a_common_point;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 在同一个点同步任务
 * <p/>
 * 这个类会在随机数字的矩阵中的特定的行里查找数字
 *  use divide and conquer technique
 * @author zhouyu
 */
public class Searcher implements Runnable {

    /**
     * 这2个属性是用来确定将要查找的子集的行
     */
    private int firstRow;
    private int lastRow;

    /**
     * 此类随机生成一个在1-10之间的 数字矩阵，我们将从中查找数字
     */
    private MatrixMock mock;

    /**
     * 此类会保存被查找的数字在矩阵的每行里出现的次数
     */
    private Results results;

    /**
     * 用来储存我们要查找的数字
     */
    private int number;

    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        // 用来查找数字。它使用内部变量，名为counter，用来储存要查找的数字在每行出现的次数
        int counter;
        System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);
        // 处理分配给这个线程的全部行。对于每行，记录正在查找的数字出现的次数，并在相对于的 Results 对象中保存此数据
        for (int i = firstRow; i < lastRow; i++) {
            int[] row = mock.getRow(i);
            counter = 0;

            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }

            results.setData(i, counter);
        }

        // 打印信息到操控台表明此对象已经结束搜索
        System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
