package com.nextyu.book.study.source.chapter6_concurrent_collections._8_using_atomic_variables;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Thread companyThread = new Thread(new Company(account));
        Thread bankThread = new Thread(new Bank(account));

        System.out.printf("Account : Initial Balance: %d\n",account.
                getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %d\n",account.
                    getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
}
