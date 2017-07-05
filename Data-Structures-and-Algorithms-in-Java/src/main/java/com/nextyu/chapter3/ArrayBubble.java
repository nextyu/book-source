package com.nextyu.chapter3;

/**
 * 冒泡排序
 * created on 2017-07-05 17:25
 *
 * @author nextyu
 */
public class ArrayBubble {
    private long[] a;
    private int nElems; // number of data items

    public ArrayBubble(int max) {
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

    public void bubbleSort() {
        int out, in;

        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

    private void swap(int left, int right) {
        long temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }


    public static void main(String[] args) {
        int max = 100;
        ArrayBubble array = new ArrayBubble(max);
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

        array.bubbleSort();

        array.display();

    }


}
