package com.nextyu.chapter5.listInsertionSort;

/**
 * 有序链表
 * 优先级队列可以用有序列表来实现
 * created on 2017-07-17 14:54
 *
 * @author nextyu
 */
public class SortedList {
    private Link first;

    public SortedList(Link[] linkArr) {
        first = null;
        for (Link link : linkArr) {
            insert(link);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    // insert in order
    public void insert(Link d) {

        Link previous = null;   // start at first
        Link current = first;

        // until end of list, or d > current
        while (current != null && d.data > current.data) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {         // at beginning of list
            first = d;            // first --> newLink
        } else {                        // not at beginning
            previous.next = d;    // old prev --> newLink
        }

        d.next = current;         // newLink --> old current

    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while (current != null) {
            current.displayLink();
            current = current.next; // move to next link
        }
        System.out.println("");
    }

}
