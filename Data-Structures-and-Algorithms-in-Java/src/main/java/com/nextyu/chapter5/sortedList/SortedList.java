package com.nextyu.chapter5.sortedList;

/**
 * 有序链表
 * 优先级队列可以用有序列表来实现
 * created on 2017-07-17 14:54
 *
 * @author nextyu
 */
public class SortedList {
    private Link first;

    public SortedList() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    // insert in order
    public void insert(long d) {
        Link newLink = new Link(d);

        Link previous = null;   // start at first
        Link current = first;

        // until end of list, or d > current
        while (current != null && d > current.data) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {         // at beginning of list
            first = newLink;            // first --> newLink
        } else {                        // not at beginning
            previous.next = newLink;    // old prev --> newLink
        }

        newLink.next = current;         // newLink --> old current

    }

    public long remove() {
        Link temp = first;
        first = first.next;
        return temp.data;
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

    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.insert(33);
        sortedList.insert(22);
        sortedList.insert(55);
        sortedList.insert(11);

        sortedList.displayList();

        sortedList.remove();

        sortedList.displayList();
    }

}
