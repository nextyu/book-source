package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._5_synchronizing_tasks_in_a_common_point;

/**
 * 此类会保存被查找的数字在矩阵的每行里出现的次数
 *
 * @author zhouyu
 */
public class Results {
    private int[] data;

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position,int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
