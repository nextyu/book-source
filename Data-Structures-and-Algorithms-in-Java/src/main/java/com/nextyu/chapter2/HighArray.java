package com.nextyu.chapter2;

/**
 * created on 2017-07-05 14:39
 *
 * @author nextyu
 */
public class HighArray {
    private long[] a;
    private int nElems; // number of data items

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        // 线性查找
        int j;
        for (j = 0; j < nElems; j++) {
            if (searchKey == a[j]) {
                break;
            }
        }
        return !(j == nElems);
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        // 删除元素的index
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == a[j]) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        }

        // 把删除元素的后面元素，位置依次往上挪一位
        for (int k = j; k < nElems; k++) {
            a[k] = a[k + 1];
        }

        nElems--;

        return true;

    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int max = 100;
        HighArray array = new HighArray(max);
        array.insert(11);
        array.insert(22);
        array.insert(33);
        array.insert(44);
        array.insert(55);
        array.insert(66);
        array.insert(77);
        array.insert(88);
        array.insert(99);

        array.display();

        System.out.println("find 88 " + array.find(88));
        System.out.println("find 100 " + array.find(100));

        System.out.println("delete 88 " + array.delete(88));
        System.out.println("delete 100 " + array.delete(100));

        array.display();

    }


}
