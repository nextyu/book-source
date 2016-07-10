package com.nextyu.book.study.source.chapter6_concurrent_collections._8_using_atomic_variables;

import java.util.concurrent.atomic.AtomicLong;

/**
 * simulate a bank account
 *
 * @author zhouyu
 */
public class Account {

    /**
     * 账户余额
     */
    private AtomicLong balance;

    public Account() {
        balance = new AtomicLong();
    }

    public long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }

    public void subtractAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }

}

