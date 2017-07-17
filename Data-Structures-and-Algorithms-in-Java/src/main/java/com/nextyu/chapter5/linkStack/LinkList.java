package com.nextyu.chapter5.linkStack;


import com.nextyu.chapter5.linkQueue.Link;

/**
 * 单链表
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
    public void insertFirst(long id) {
        Link newLink = new Link(id);
        newLink.next = first; // newLink --> old first
        first = newLink;      // first --> newLink
    }

    // delete first item and return it
    public long deleteFirst() {
        Link temp = first;
        first = first.next; // delete it: first --> old next
        return temp.data;
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
