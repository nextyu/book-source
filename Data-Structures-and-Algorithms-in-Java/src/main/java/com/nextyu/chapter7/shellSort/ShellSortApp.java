package com.nextyu.chapter7.shellSort;

/**
 * 希尔排序
 * created on 2017-07-24 9:57
 *
 * @author nextyu
 */
public class ShellSortApp {
    public static void main(String[] args) {
        int maxSize = 10;             // array size
        ArrayShell arr = new ArrayShell(maxSize);   // create the array

        for (int j = 0; j < maxSize; j++) {     // fill array with
            // random numbers
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
        arr.display();                // display unsorted array
        arr.shellSort();              // shell sort the array
        arr.display();                // display sorted array
    }
}
