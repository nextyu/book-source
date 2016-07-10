package com.nextyu.book.study.source.chapter5_fork_join_framework._2_creating_a_fork_join_pool;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * 不需要返回值
 *
 * @author zhouyu
 */
public class Task extends RecursiveAction {

    private static final long serialVersionUID = 1L;
    private List<Product> products;
    /**
     * determine the block of products this task has to process
     */
    private int first;
    private int last;

    /**
     * store the increment of the price of the products
     */
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks:%s\n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle + 1, increment);
            Task t2 = new Task(products, middle + 1, last, increment);
            /*
            To execute the subtasks that a task creates, it calls the invokeAll()  method. This is a
            synchronous call, and the task waits for the fialization of the subtasks before continuing
            (potentially fiishing) its execution.
             */
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + increment));
        }
    }
}
