package com.nextyu.chapter11.hash;

/**
 * created on 2017-08-16 17:25
 *
 * @author nextyu
 */
public class HashTableApp {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        for (int i = 0; i < 5; i++) {
            int aKey = (int) (java.lang.Math.random() *
                    10 * 8);
            DataItem aDataItem = new DataItem(aKey);
            hashTable.insert(aDataItem);
        }

        hashTable.displayTable();
    }
}
