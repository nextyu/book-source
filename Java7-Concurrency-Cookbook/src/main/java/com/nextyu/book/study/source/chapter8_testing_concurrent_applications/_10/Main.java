package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._10;

import edu.umd.cs.mtc.TestFramework;

/**
 * created on 2016-07-14 11:56
 *
 * @author nextyu
 */
public class Main {
    public static void main(String[] args) throws Throwable {
        ProducerConsumerTest test = new ProducerConsumerTest();
        System.out.printf("Main: Starting the test\n");
        TestFramework.runOnce(test);
        System.out.printf("Main: The test has finished\n");
    }
}
