package com.nextyu.chapter5;

/**
 * created on 2017-07-07 14:48
 *
 * @author nextyu
 */
public class LinkList {
    private Link first; // ref to first link on list

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // insert at start of list
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first; // newLink --> old first
        first = newLink;      // first --> newLink
    }

    // delete first item and return it
    public Link deleteFirst() {
        Link temp = first;
        first = first.next; // delete it: first --> old next
        return temp;
    }

    // find link with given key
    public Link find(int key) {
        Link current = first;
        while (current.iData != key) { // while no match
            if (current.next == null) { // if end of list
                return null;            // didn't find it
            } else {                    // not end of list
                current = current.next; // go to next link
            }
        }
        return current; // found it
    }

    // delete link with given key
    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.iData != key) {
            if (current.next == null) {
                return null; // didn't find it
            } else {
                previous = current; // go next link
                current = current.next;
            }
        }

        // found it
        if (current == first) { // if first link
            first = first.next; // change first
        } else {                // otherwise
            previous.next = current.next; // bypass it
        }

        return current;

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
        LinkList linkList = new LinkList();

        linkList.insertFirst(11, 11.11);
        linkList.insertFirst(22, 22.22);
        linkList.insertFirst(33, 33.33);
        linkList.insertFirst(44, 44.44);
        linkList.insertFirst(55, 55.55);

        linkList.displayList();

        while (!linkList.isEmpty()) {
            Link link = linkList.deleteFirst();
            System.out.print("Deleted ");
            link.displayLink();
            System.out.println("");
        }


        linkList.displayList();

    }

}
