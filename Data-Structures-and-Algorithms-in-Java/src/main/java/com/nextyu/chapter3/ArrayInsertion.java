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
        int out, in;
        for (out = 1; out < nElems; out++) {
            long temp = a[out]; // 被标记的成员
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                in--; // 左移一位
            }
            a[in] = temp;
        }

    }

    private void swap(int left, int right) {
        System.out.println("swap " + a[left] + " " + a[right]);
        long temp = a[left];
        a[left] = a[right];
        a[right] = temp;
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

        array.display();

        array.insertionSort();

        array.display();

    }


}
