package com.nextyu.chapter6.triangle;

/**
 * 三角数字
 * 不过，基于循环的方法效率最高
 * 2017-07-17 20:25
 *
 * @author nextyu
 */
public class Triangle {
    public static int triangle(int n) {
        if (n == 1) { // 判断基值，等于1，递归结束
            return 1;
        } else {
            return (n + triangle(n - 1));
        }
    }

    public static void main(String[] args) {
        int triangle = Triangle.triangle(5);

        System.out.println(triangle);
    }
}
