package com.nextyu.chapter6.power;

/**
 * 求一个数的乘方
 * created on 2017-07-21 11:20
 *
 * @author nextyu
 */
public class PowerApp {
    public static void main(String[] args) {

        int num = 2;
        int power = 5;

        System.out.println(power(num, power));

    }

    private static int power(int num, int power) {
        System.out.println(num + " -- " + power);
        if (power == 1) {
            return num;
        }
        if (power % 2 == 0) {
            return power(num, power / 2) * power(num, power / 2);
        } else {
            return num * power(num, power / 2) * power(num, power / 2);
        }
    }
}
