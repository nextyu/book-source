package com.nextyu.chapter4;

/**
 * 栈-先进后出-LIFO
 * 单词逆序
 * created on 2017-07-06 10:42
 *
 * @author nextyu
 */
public class StackXInt {
    private int maxSize; // size of stack array
    private int[] stackArray;
    private int top; // top of stack

    public StackXInt(int s) {
        this.maxSize = s;
        stackArray = new int[s];
        top = -1; // not item yet
    }

    public void push(int l) { // push item on top of stack
        stackArray[++top] = l; // increment top, insert item
    }

    public int pop() { // take item from top stack
        return stackArray[top--]; // access item, decrement top
    }

    public int peek() { // peek at top of stack
        return stackArray[top];
    }

    public int size() {
        return top + 1;
    }

    // return item at index n
    public int peekN(int n) {
        return stackArray[n];
    }

    public boolean isEmpty() { // true if stack is empty
        return top == -1;
    }

    public boolean isFull() { // true if stack is full
        return top == (maxSize - 1);
    }


    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom --> top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println(" ");
    }

}
