package com.nextyu.book.study.source.chapter5_fork_join_framework._2_creating_a_fork_join_pool;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = new ProductListGenerator().generate(10000);
        Task task = new Task(products, 0, products.size(), 0.20);
        /**
         *  It creates a pool with a number of threads equal to the number of processors
         of the computer
         */
        ForkJoinPool pool = new ForkJoinPool();
        /*
        In this case, it's an asynchronous call, and the main thread continues its execution.

        invoke()  the invoke()  method makes a synchronous call to the ForkJoinPool class
         */
        pool.execute(task);

        do {
            System.out.printf("Main: Thread Count: %d\n", pool.
                    getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n", pool.
                    getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.
                    getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally.\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.
                        getName(), product.getPrice());
            }
        }

        System.out.println("Main: End of the program.\n");
    }
}
