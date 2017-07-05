package com.nextyu.chapter3;

/**
 * 插入排序
 * created on 2017-07-05 17:25
 *
 * @author nextyu
 */
public class ArrayInsertion {
    private long[] a;
    private int nElems; // number of data items

    public ArrayInsertion(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }


    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void insertionSort() {
        // out变量从1开始，向右移动
        // in变量从out开始，向左移动
        int out, in;
        for (out = 1; out < nElems; out++) {
            long temp = a[out]; // 缓存 被标记的成员
            in = out;
            while (in > 0 && a[in - 1] > temp) {
                // 被标记成员的左边的元素，如果比被标记的成员大的或者等于的，都往右移一位
                a[in] = a[in - 1];
                in--; // 左移一位
            }
            a[in] = temp; // 插入 被标记的成员
            display();
        }

    }

    public static void main(String[] args) {
        int max = 100;
        ArrayInsertion array = new ArrayInsertion(max);
        array.insert(99);
        array.insert(11);
        array.insert(22);
        array.insert(66);
        array.insert(33);
        array.insert(44);
        array.insert(55);
        array.insert(88);
        array.insert(77);

        //array.display();

        array.insertionSort();

        //array.display();

    }


}
