package com.nextyu.chapter6.binarySearch;

/**
 * 分治算法
 * 例如：递归的二分查找
 * 把一个大问题分成两个小问题，再把小问题分成两个更小的问题，并且分别解决每一个小问题。
 * 分治算法常常是一个方法，在这个方法中含有两个对自身的递归调用，分别对应于问题的两个部分。
 * created on 2017-07-20 10:01
 *
 * @author nextyu
 */
public class BinarySearchApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);

        arr.insert(72);                // insert items
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);

        arr.display();                 // display array

        int searchKey = 99;            // search for item
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

    }
}
