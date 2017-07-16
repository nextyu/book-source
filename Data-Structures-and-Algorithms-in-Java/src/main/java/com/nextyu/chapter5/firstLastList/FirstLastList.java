package com.nextyu.chapter5.firstLastList;

/**
 * 双端链表
 * 如果链表中只有一个节点，first 和 last 都指向它，如果没有节点，两者都为 null
 * 2017-07-16 17:13
 *
 * @author nextyu
 */
public class FirstLastList {
    private Link first; // ref to first link
    private Link last; // ref to last link

    public FirstLastList() {
        first = null;
        last = null;
    }

    // true if no links
    public boolean isEmpty() {
        return first == null;
    }

    // insert at front of list
    public void insertFirst(long data) {
        Link newLink = new Link(data); // make new link
        if (isEmpty()) {               // if empty list
            last = newLink;            // newLink <-- last
        }
        newLink.next = first;      // newLink --> old first
        first = newLink;           // first --> newLink

    }

    // insert at end of list
    public void insertLast(long data) {
        Link newLink = new Link(data); // make new link
        if (isEmpty()) {               // if empty list
            first = newLink;           // first --> newLink
        } else {
            last.next = newLink;       // old last --> newLink
        }
        last = newLink;            // newLink <-- last
    }

    public long deleteFirst() {         // delete first link
        long temp = first.data;
        if (first.next == null) {       // if only one item
            last = null;                // null <-- last
        }
        first = first.next;         // first --> old next

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

    public static void main(String[] args) {
        FirstLastList firstLastList = new FirstLastList();
        firstLastList.insertFirst(22);
        firstLastList.insertFirst(33);
        firstLastList.insertFirst(44);


        firstLastList.insertLast(55);
        firstLastList.insertLast(66);


        firstLastList.displayList();

        firstLastList.deleteFirst();
        firstLastList.deleteFirst();

        firstLastList.displayList();

    }

}
