package com.nextyu.chapter11.hash;

/**
 * created on 2017-08-16 17:01
 *
 * @author nextyu
 */
public class DataItem {
    private int iData;

    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }
}
