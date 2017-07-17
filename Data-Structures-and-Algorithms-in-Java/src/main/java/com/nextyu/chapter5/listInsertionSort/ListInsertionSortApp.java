package com.nextyu.chapter5.listInsertionSort;

/**
 * 表插入排序
 * created on 2017-07-17 15:14
 *
 * @author nextyu
 */
public class ListInsertionSortApp {
    public static void main(String[] args) {
        int size = 10;
        // create array of links
        Link[] linkArray = new Link[size];

        for (int j = 0; j < size; j++)  // fill array with links
        {                            // random number
            int n = (int) (java.lang.Math.random() * 99);
            Link newLink = new Link(n);  // make link
            linkArray[j] = newLink;      // put in array
        }
        // display array contents
        System.out.print("Unsorted array: ");
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].data + " ");
        System.out.println("");

        // create new list
        SortedList theSortedList = new SortedList(linkArray);

        for (int j = 0; j < size; j++)  // links from list to array
            linkArray[j] = theSortedList.remove();

        // display array contents
        System.out.print("Sorted Array:   ");
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].data + " ");
        System.out.println("");
    }
}
