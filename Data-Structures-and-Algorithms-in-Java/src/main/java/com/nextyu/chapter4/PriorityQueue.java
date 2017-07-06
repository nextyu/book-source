package com.nextyu.chapter4;

/**
 * 优先级队列
 * 使用数组实现
 * 适用数据量小，不关心速度
 * created on 2017-07-06 14:27
 *
 * @author nextyu
 */
public class PriorityQueue {

    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queueArray;
    private int nItems;

    public PriorityQueue(int s) {
        maxSize = s;
        queueArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;
        if (nItems == 0) { // if no items
            queueArray[nItems++] = item; // insert at 0
        } else { // if items
            for (j = nItems - 1; j >= 0; j--) { // start at end
                if (item > queueArray[j]) { // if new item larger
                    queueArray[j + 1] = queueArray[j]; // shift upward
                } else { // if smaller
                    break; // down shifting
                }
            }
            queueArray[j + 1] = item; // insert it
            nItems++;
        }
    }

    // remove minimum item
    public long remove() {
        return queueArray[--nItems];
    }

    // peek at minimum item
    public long peekMin() {
        return queueArray[nItems - 1];
    }

    // true if queue is empty
    public boolean isEmpty() {
        return nItems == 0;
    }

    // true if queue is full
    public boolean isFull() {
        return nItems == maxSize;
    }


    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(99);
        priorityQueue.insert(11);
        priorityQueue.insert(55);
        priorityQueue.insert(33);
        priorityQueue.insert(88);

        while (!priorityQueue.isEmpty()) {
            long remove = priorityQueue.remove();
            System.out.print(remove + " ");
        }
    }

}
