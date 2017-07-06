package com.nextyu.chapter4;

/**
 * 队列
 * 没有数据项计数字段的队列实现
 * created on 2017-07-06 11:59
 *
 * @author nextyu
 */
public class Queue2 {
    private int maxSize; // 数组大小
    private long[] queueArray;
    private int front; // 对头元素index
    private int rear; // 队尾元素index

    public Queue2(int s) {
        maxSize = s + 1; // array is 1 cell larger than requested
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
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
        return temp;
    }

    public long peekFront() { // peek at front of queue
        return queueArray[front];
    }

    public boolean isEmpty() { // true if queue is empty
        return rear + 1 == front || front + maxSize - 1 == rear;
    }

    public boolean isFull() { // true if queue is full
        return rear + 2 == front || front + maxSize - 2 == rear;
    }

    public int size() { // assumes queue not empty
        if (rear >= front) { // contiguous sequence
            return rear - front + 1;
        } else { // broken sequence
            return (maxSize - front) + (rear + 1);
        }
    }

    public static void main(String[] args) {
        Queue2 queue = new Queue2(5);
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
