package com.nextyu.chapter2;

/**
 * 有序数组
 * 查找速度快
 * created on 2017-07-05 15:37
 *
 * @author nextyu
 */
public class OrderedArray {
    private long[] a;
    private int nElems; // number of data items

    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int find(long searchKey) {
        // 二分查找
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currentIndex;
        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (searchKey == a[currentIndex]) {
                // 找到了
                return currentIndex;
            } else if (lowerBound > upperBound) {
                // 未找到
                return nElems;
            } else {
                if (searchKey > a[currentIndex]) {
                    // 查找的数在数组后半段
                    lowerBound = currentIndex + 1;
                } else {
                    // 查找的数在数组前半段
                    upperBound = currentIndex - 1;
                }
            }


        }

    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            // 线性查找
            if (a[j] > value) {
                break;
            }
        }

        //
        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }

        a[j] = value;

        nElems++;

    }

    public boolean delete(long value) {
        // 删除元素的index
        int j = find(value);
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
        OrderedArray array = new OrderedArray(max);
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

        System.out.println("find 88 " + array.find(88));
        System.out.println("find 100 " + array.find(100));

        System.out.println("delete 88 " + array.delete(88));
        System.out.println("delete 100 " + array.delete(100));

        array.display();

    }
}
