package com.nextyu.chapter5.linkList;

/**
 * 单链表
 * created on 2017-07-07 14:11
 *
 * @author nextyu
 */
public class Link {
    public int iData;
    public double dData;
    public Link next; // next link in list

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
