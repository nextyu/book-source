package com.nextyu.book.study.source.chapter1_thread_management._4_interrupting_a_thread;

/**
 * 质数（Prime number），又称素数，指在大于1的自然数中，除了1和该数自身外，
 * 无法被其他自然数整除的数（也可定义为只有1与该数本身两个因数的数）。
 * 大于1的自然数若不是素数，则称之为合数。
 *
 * @author zhouyu
 */
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
//            System.out.println("3333333");
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted\n");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (long i = 2; i <= number/2; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
