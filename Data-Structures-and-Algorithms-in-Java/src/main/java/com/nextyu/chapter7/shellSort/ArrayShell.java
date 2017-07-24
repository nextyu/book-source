package com.nextyu.chapter7.shellSort;

/**
 * 希尔排序
 * created on 2017-07-24 9:43
 *
 * @author nextyu
 */
public class ArrayShell {
    private long[] theArray;
    private int nElems;

    public ArrayShell(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {

        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println("");
    }

    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;              // find initial value of h
        while (h <= nElems / 3) {
            h = h * 3 + 1;      // (1,4,13,40,121,...)
        }

        while (h > 0) {         // decrease h ,until h = 1
                                // h - sort the file
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;
                                // one subpass (eg 0,4,8)
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }

                theArray[inner] = temp;

            }

            h = (h - 1) / 3;      // decrease h
        }
    }
}
