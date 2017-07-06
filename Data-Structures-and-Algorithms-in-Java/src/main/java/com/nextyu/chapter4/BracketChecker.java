package com.nextyu.chapter4;

/**
 * 分隔符匹配
 * created on 2017-07-06 11:09
 *
 * @author nextyu
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        StackXChar stack = new StackXChar(stackSize);

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            switch (aChar) {
                case '{': // opening symbols
                case '[':
                case '(':
                    stack.push(aChar);
                    break;
                case '}': // closing symbols
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char pop = stack.pop();
                        if (aChar == '}' && pop != '{'
                                || aChar == ']' && pop != '['
                                || aChar == ')' && pop != '(') {
                            System.out.println("error: " + aChar + " at " + i);
                        }
                    } else {
                        System.out.println("error: " + aChar + " at " + i); // prematurely empty
                    }
                    break;
                default:
                    break;
            }
        }

        // at this point, all characters have been processed
        if (!stack.isEmpty()) {
            System.out.println("error: missing right delimiter");
        }

    }


    public static void main(String[] args) {
        BracketChecker bracketChecker = new BracketChecker("454{[[5((44))]]}554");
        bracketChecker.check();

        BracketChecker bracketChecker2 = new BracketChecker("454{[[5((44))}]]}554");
        bracketChecker2.check();
    }
}
