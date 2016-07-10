package com.nextyu.book.study.source.chapter6_concurrent_collections._8_using_atomic_variables;

/**
 * simulate the withdrawal of money from the account
 * 从账户里面扣钱
 * @author zhouyu
 */
public class Bank implements Runnable {

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subtractAmount(1000);
        }
    }
}
