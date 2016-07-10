package com.nextyu.book.study.source.chapter4_thread_executors._4_executing_tasks_in_an_executor_that_returns_a_result;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 阶乘计算
 *
 * @author zhouyu
 */
public class FactorialCalculator implements Callable<Integer> {

    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1)) {
            return 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.printf("%s: %d\n", Thread.currentThread().
                getName(), result);
        return result;
    }
}
