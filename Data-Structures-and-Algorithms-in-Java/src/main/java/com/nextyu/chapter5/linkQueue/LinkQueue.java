package com.nextyu.chapter5.linkQueue;

/**
 * created on 2017-07-17 14:19
 *
 * @author nextyu
 */
public class LinkQueue {
    private FirstLastList list;

    public LinkQueue() {
        list = new FirstLastList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(long dd) {
        list.insertLast(dd);
    }

    public long remove() {
        return list.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        list.displayList();
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.insert(11);
        linkQueue.insert(22);

        linkQueue.displayQueue();

        linkQueue.insert(33);
        linkQueue.insert(44);

        linkQueue.displayQueue();

        linkQueue.remove();

        linkQueue.displayQueue();

    }
}
