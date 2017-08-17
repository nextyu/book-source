package com.nextyu.chapter11.hashChain;

/**
 * created on 2017-08-17 10:29
 *
 * @author nextyu
 */
public class Link {
    private int iData;
    public Link next;

    public Link(int it) {
        iData = it;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.println(iData + " ");
    }
}
