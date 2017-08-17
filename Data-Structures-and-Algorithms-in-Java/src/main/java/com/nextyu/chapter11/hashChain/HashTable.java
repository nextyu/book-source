package com.nextyu.chapter11.hashChain;

/**
 * 链地址法
 * created on 2017-08-17 10:30
 *
 * @author nextyu
 */
public class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) { // for each cell,
            System.out.print(j + ". "); // display cell number
            hashArray[j].displayList(); // display list
        }
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }
}
