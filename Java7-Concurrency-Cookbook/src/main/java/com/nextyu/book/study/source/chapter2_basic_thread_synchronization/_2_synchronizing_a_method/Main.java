package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._2_synchronizing_a_method;

/**
 * The synchronized keyword penalizes the performance of the application
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Thread thread1 = new Thread(new Bank(account));
        Thread thread2 = new Thread(new Company(account));

        System.out.printf("Account : Initial Balance: %f\n", account.
                getBalance());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

            System.out.printf("Account : Final Balance: %f\n",account.
                    getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
