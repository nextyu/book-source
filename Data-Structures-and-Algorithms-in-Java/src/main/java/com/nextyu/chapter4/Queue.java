package com.nextyu.chapter4;

/**
 * 队列
 * created on 2017-07-06 11:59
 *
 * @author nextyu
 */
public class Queue {
    private int maxSize; // 数组大小
    private long[] queueArray;
    private int front; // 对头元素index
    private int rear; // 队尾元素index
    private int nItems; // 实际保存的元素个数

    public Queue(int s) {
        maxSize = s;
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }


    public void insert(long l) { // put item at rear of queue
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        if (rear == maxSize - 1) { // deal with wraparound
            rear = -1; // 回绕到数组的底端
        }
        queueArray[++rear] = l; // increment rear and insert
        nItems++; // one more item
    }

    public long remove() { // take item from front of queue
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        long temp = queueArray[front++]; // get value and increment front
        if (front == maxSize) { // deal with wraparound
            front = 0; // 回绕到数组下标为0的位置
        }
        nItems--; // one less item
        return temp;
    }

    public long peekFront() { // peek at front of queue
        return queueArray[front];
    }

    public boolean isEmpty() { // true if queue is empty
        return nItems == 0;
    }

    public boolean isFull() { // true if queue is full
        return nItems == maxSize;
    }

    public int size() { // number of items in queue
        return nItems;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);


        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(11);
        queue.insert(22);
        queue.insert(33);
        queue.insert(44);
        queue.insert(55);

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }

}
