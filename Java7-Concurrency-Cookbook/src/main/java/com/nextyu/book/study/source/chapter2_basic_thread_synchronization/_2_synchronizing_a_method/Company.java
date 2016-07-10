package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._2_synchronizing_a_method;

/**
 * @author zhouyu
 */
public class Company implements Runnable {

    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            account.addAmount(1000);
        }
    }
}
