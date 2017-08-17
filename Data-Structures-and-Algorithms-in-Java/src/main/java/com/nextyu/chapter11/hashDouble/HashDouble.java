package com.nextyu.chapter11.hashDouble;

/**
 * 再哈希法
 * created on 2017-08-17 9:51
 *
 * @author nextyu
 */
public class HashDouble {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashDouble(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    /**
     * 找到原始位置
     *
     * @param key
     * @return
     */
    public int hashFunc(int key) {
        return key % arraySize;
    }

    /**
     * 生成步长
     *
     * @param key
     * @return
     */
    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;

    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        return null;

    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() != -1) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        return null;
    }


}
