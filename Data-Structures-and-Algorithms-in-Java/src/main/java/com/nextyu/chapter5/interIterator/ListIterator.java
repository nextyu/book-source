package com.nextyu.chapter5.interIterator;

/**
 * created on 2017-07-17 16:39
 *
 * @author nextyu
 */
public class ListIterator {
    private Link current;
    private Link previous;
    private LinkList linkList;

    public ListIterator(LinkList linkList) {
        this.linkList = linkList;
        reset();
    }

    public void reset() {                   // start at 'first'
        current = linkList.getFirst();
        previous = null;
    }

    public boolean atEnd() {                // true if last link
        return current.next == null;
    }

    public void nextLink() {                // go to next link
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long dd) { // insert after current link
        Link newLink = new Link(dd);

        if (linkList.isEmpty()) {           // empty list
            linkList.setFirst(newLink);
            current = newLink;
        } else {                            // not empty
            newLink.next = current.next;
            current.next = newLink;
            nextLink();                     // point to new link
        }
    }

    public void insertBefore(long dd) { // insert before current link
        Link newLink = new Link(dd);

        if (previous == null) {         // beginning of list or empty list
            newLink.next = linkList.getFirst();
            linkList.setFirst(newLink);
            reset();
        } else {                        // not beginning
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }

    }

    public long deleteCurrent() {   // delete item at current
        long value = current.data;

        if (previous == null) {      // beginning of list
            linkList.setFirst(current.next);
            reset();
        } else {                     // not beginning
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return value;
    }
}
