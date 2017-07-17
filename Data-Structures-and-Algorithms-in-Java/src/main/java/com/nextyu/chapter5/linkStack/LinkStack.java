package com.nextyu.chapter5.linkStack;

/**
 * 用链表实现的栈
 * created on 2017-07-17 14:11
 *
 * @author nextyu
 */
public class LinkStack {
    private LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }

    public void push(long dd) {
        linkList.insertFirst(dd);
    }

    public long pop() {
        return linkList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (first-->last): ");
        linkList.displayList();
    }

    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        linkStack.push(11);
        linkStack.push(22);


        linkStack.displayStack();

        linkStack.push(33);
        linkStack.push(44);

        linkStack.displayStack();

        linkStack.pop();
        linkStack.pop();

        linkStack.displayStack();
    }
}
