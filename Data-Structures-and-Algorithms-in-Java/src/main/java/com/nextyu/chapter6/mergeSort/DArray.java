package com.nextyu.chapter6.mergeSort;

/**
 * created on 2017-07-21 10:35
 *
 * @author nextyu
 */
public class DArray {
    private long[] theArray;
    private int nElems;     // number of data items

    public DArray(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    // put element into array
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

    public void mergeSort() {   // called by main()
        long[] workSpace = new long[nElems];    // provides workspace
        recMergeSort(workSpace, 0, nElems - 1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {     // if range is 1, not use sorting
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;    // find midpoint

            recMergeSort(workSpace, lowerBound, mid);   // sort low half

            recMergeSort(workSpace, mid + 1, upperBound);   // sort high halt

            merge(workSpace, lowerBound, mid + 1, upperBound);          // merge them
        }
    }

    private void merge(long[] workSpace, int lowPtr,
                       int highPtr, int upperBound) {
        int j = 0;                  // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;    // of items

        while (lowPtr <= mid && highPtr <= upperBound)
            if (theArray[lowPtr] < theArray[highPtr]) {
                workSpace[j++] = theArray[lowPtr++];
            } else {
                workSpace[j++] = theArray[highPtr++];
            }

        while (lowPtr <= mid) {
            workSpace[j++] = theArray[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = theArray[highPtr++];
        }

        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }


    }


}
