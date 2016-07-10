package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._5_synchronizing_tasks_in_a_common_point;

/**
 * 现在，实现一个类来计算数字在这个矩阵里出现的总数。它使用储存了矩阵中每行里数字出现次数的 Results 对象来进行运算
 *
 * @author zhouyu
 */
public class Grouper implements Runnable {

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        // 用来计算结果array里数字出现次数的总和
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        // 使用 results 对象的 getData() 方法来获得每行数字出现的次数。然后，处理array的全部元素，把每个元素的值加给 finalResult 变量
        int[] data = results.getData();
        for (int number : data) {
            finalResult += number;
        }

        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }
}
