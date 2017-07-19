package com.nextyu.chapter6.anagram;

import javax.sound.midi.Soundbank;
import javax.swing.text.Position;

/**
 * 变位字 -- 全排列
 * created on 2017-07-18 9:26
 *
 * @author nextyu
 */
public class AnagramApp {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) {
        String input = "cats";
        size = input.length();
        count = 0;
        for (int i = 0; i < size; i++) {
            arrChar[i] = input.charAt(i);
        }
        doAnagram(size);
    }

    private static void doAnagram(int newSize) {
        if (newSize == 1) {                     // if too small, go no further
            return;
        }

        for (int i = 0; i < newSize; i++) {     // for each position
            doAnagram(newSize - 1);     // anagram remaining
            if (newSize == 2) {                 // if innermost
                displayWord();                  // display it
            }
            rotate(newSize);                    // rotate word
        }

    }

    private static void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        }

        if (count < 9) {
            System.out.print(" ");
        }

        System.out.print(++count + " ");

        for (int i = 0; i < size; i++) {
            System.out.print(arrChar[i]);
        }

        System.out.print("   ");

        if (count % 6 == 0) {
            System.out.println("");
        }


    }

    // rotate left all chars from position to end
    private static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char temp = arrChar[position];  // save first letter
        for (j = position + 1; j < size; j++) { // shift others left
            arrChar[j - 1] = arrChar[j];
        }
        arrChar[j - 1] = temp;    // put first on right
    }
}
