package com.nextyu.chapter5.interIterator;


/**
 *
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

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public void displayList() {
        Link current = first; // start at beginning of list
        while (current != null) {
            current.displayLink();
            current = current.next; // move to next link
        }
        System.out.println("");
    }
}
