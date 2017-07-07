package com.nextyu.chapter4;

/**
 * 栈-先进后出-LIFO
 *
 * 单词逆序
 *
 * created on 2017-07-06 10:42
 *
 * @author nextyu
 */
public class StackX {
    private int maxSize; // size of stack array
    private long[] stackArray;
    private int top; // top of stack

    public StackX(int s) {
        this.maxSize = s;
        stackArray = new long[s];
        top = -1; // not item yet
    }

    public void push(long l) { // push item on top of stack
        stackArray[++top] = l; // increment top, insert item
    }

    public long pop() { // take item from top stack
        return stackArray[top--]; // access item, decrement top
    }

    public long peek() { // peek at top of stack
        return stackArray[top];
    }

    public boolean isEmpty() { // true if stack is empty
        return top == -1;
    }

    public boolean isFull() { // true if stack is full
        return top == (maxSize - 1);
    }


    public static void main(String[] args) {
        StackX stackX = new StackX(10);
        stackX.push(0);
        stackX.push(1);
        stackX.push(2);
        stackX.push(3);
        stackX.push(4);
        stackX.push(5);
        stackX.push(6);


        while (!stackX.isEmpty()) {
            long pop = stackX.pop();
            System.out.print(pop + " ");
        }

    }
}
