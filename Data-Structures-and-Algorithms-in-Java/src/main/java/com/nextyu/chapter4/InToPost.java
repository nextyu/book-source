package com.nextyu.chapter4;

/**
 * infix to postfix conversion
 * created on 2017-07-06 15:58
 *
 * @author nextyu
 */
public class InToPost {
    private StackXChar stackXChar;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        stackXChar = new StackXChar(stackSize);
    }
}
