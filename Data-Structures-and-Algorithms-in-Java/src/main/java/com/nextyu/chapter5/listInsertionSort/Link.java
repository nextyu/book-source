package com.nextyu.chapter5.listInsertionSort;

/**
 * 2017-07-16 17:19
 *
 * @author nextyu
 */
public class Link {
    public long data;
    public Link next;

    public Link(long data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
