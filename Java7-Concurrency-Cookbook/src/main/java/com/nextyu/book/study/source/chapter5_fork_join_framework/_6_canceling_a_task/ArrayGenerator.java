package com.nextyu.book.study.source.chapter5_fork_join_framework._6_canceling_a_task;

import java.util.Random;

/**
 * @author zhouyu
 */
public class ArrayGenerator {
    public int[] generateArray(int size, int number) {
        int counter = 0;
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomInt = random.nextInt(10);
            array[i] = randomInt;
            if (randomInt == number) {
                System.out.println("找到:" + counter);
            }
            counter++;
        }
        return array;
    }
}
