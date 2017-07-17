package com.nextyu.chapter5.doublyLinkedList;

/**
 * 基于双向链表的双端队列
 * created on 2017-07-17 15:37
 *
 * @author nextyu
 */
public class DoublyLinkedList {
    private Link first;
    private Link last;


    public DoublyLinkedList() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    // insert at front of list
    public void insertFirst(long data) {
        Link newLink = new Link(data);
        if (isEmpty()) {        // if empty list
            last = newLink;     // newLink <-- last
        } else {
            first.previous = newLink;   // newLink <-- old first
        }
        newLink.next = first;           // newLink >-- old first
        first = newLink;                // first --> newLink
    }

    // insert at end of list
    public void insertLast(long data) {
        Link newLink = new Link(data);
        if (isEmpty()) {        // if empty list
            first = newLink;    // first --> newLink
        } else {
            last.next = newLink;    // old last --> newLink
            newLink.previous = last;// old last <-- newLink
        }
        last = newLink;
    }

    // delete first link
    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {   // if only one item
            last = null;            // null <-- last
        } else {
            first.next.previous = null; // null <-- old next
        }
        first = first.next; // first --> old next
        return temp;
    }

    // delete last link
    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {   // if only one item
            first = null;           // first --> null
        } else {
            last.previous.next = null;  // old previous --> null
        }
        last = last.previous;   // old previous <-- last
        return temp;
    }

    // insert data just after key
    public boolean insertAfter(long key, long data) {
        Link current = first;
        while (current.data != key) {   // until match is found
            current = current.next;
            if (current == null) {
                return false;           // didn't find it
            }
        }

        Link newLink = new Link(data);
        if (current == last) {      // if last link
            newLink.next = null;    // newLink --> null
            last = newLink;         // newLink <-- last
        } else {                    // not last link
            newLink.next = current.next;    // newLink --> old next
            current.next.previous = newLink;// newLink <-- old next
        }

        newLink.previous = current; // old current <-- newLink
        current.next = newLink;     // old current --> newLink
        return true;                // found it, did insertion

    }

    // delete item with given key
    public Link deleteKey(long key) {
        Link current = first;
        while (current.data != key) {   // until match is found
            current = current.next;
            if (current == null) {
                return null;           // didn't find it
            }
        }

        if (current == first) {                     // found it; first item
            first = current.next;                   // first --> old next
        } else {                                    // not first
            current.previous.next = current.next;   // old previous --> old next
        }

        if (current == last) {                      // last item
            last = current.previous;                // old previous <-- last
        } else {
            current.next.previous = current.previous;   // old previous <-- old next
        }

        return current;                             // return value

    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while (current != null) {
            current.displayLink();
            current = current.next; // move to next link
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Link current = last; // start at end of list
        while (current != null) {
            current.displayLink();
            current = current.previous; // move to previous link
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(11);
        list.insertFirst(22);
        list.insertFirst(66);


        list.insertLast(99);
        list.insertLast(110);

        list.displayForward();
        list.displayBackward();

        list.deleteFirst();

        list.displayForward();
        list.displayBackward();

        list.deleteLast();

        list.displayForward();
        list.displayBackward();

        list.deleteKey(22);

        list.displayForward();
        list.displayBackward();

        list.insertAfter(11, 77);

        list.displayForward();
        list.displayBackward();
    }

}
