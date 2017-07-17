package com.nextyu.chapter5.interIterator;

/**
 * created on 2017-07-17 16:54
 *
 * @author nextyu
 */
public class InterIterApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();           // new list
        ListIterator iter1 = theList.getIterator();  // new iter
        long value;

        iter1.insertAfter(20);             // insert items
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);

        theList.displayList();
    }
}
