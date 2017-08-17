package com.nextyu.chapter11.hashChain;

/**
 * created on 2017-08-17 10:29
 *
 * @author nextyu
 */
public class SortedList {
    private Link first;

    public SortedList() {
        first = null;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = theLink;
        } else {
            previous.next = theLink;
        }
        theLink.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

    }

    public Link find(int key) {
        Link current = first;

        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while (current != null) {    // until end of list,

            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }

}
