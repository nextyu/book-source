package com.nextyu.chapter3;

/**
 * 选择排序
 * created on 2017-07-05 17:25
 *
 * @author nextyu
 */
public class ArraySelect {
    private long[] a;
    private int nElems; // number of data items

    public ArraySelect(int max) {
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

    public void selectSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) { // 外层循环
            min = out;
            for (in = out + 1; in < nElems; in++) { // 内层循环
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            if (out != min) {
                swap(out, min);
                display();
            }
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
        ArraySelect array = new ArraySelect(max);
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

        array.selectSort();

        //array.display();

    }


}
