package com.nextyu.chapter6.factorial;

/**
 * 阶乘
 * 2017-07-17 20:31
 *
 * @author nextyu
 */
public class Factorial {

    public static int factorial(int n) {
        if (n == 0) { // 判断基值，等于0，递归结束
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    public static void main(String[] args) {
        int factorial = Factorial.factorial(5);

        System.out.println(factorial);
    }
}
