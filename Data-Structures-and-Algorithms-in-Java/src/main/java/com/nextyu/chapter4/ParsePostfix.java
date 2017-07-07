package com.nextyu.chapter4;

/**
 * 解析后缀表达式
 * created on 2017-07-07 10:56
 *
 * @author nextyu
 */
public class ParsePostfix {
    private StackXInt theStack;
    private String input;

    public ParsePostfix(String s) {
        input = s;
    }

    public int doParse() {
        theStack = new StackXInt(20);
        char ch;
        int j;
        int num1, num2, interAns;
        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            theStack.displayStack("For " + ch + " ");
            if (ch >= '0' && ch <= '9') { // if it's a number
                theStack.push((ch - '0'));  // push it
            } else { // it's an operator
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop(); // get answer
        return interAns;
    }

    public static void main(String[] args) {
        String input = "3-4*7-(5+3)/2";
        InToPost inToPost = new InToPost(input);
        String postFix = inToPost.doTrans();
        System.out.println("Postfix is " + postFix);


        ParsePostfix parsePostfix = new ParsePostfix(postFix);

        int output = parsePostfix.doParse();


        System.out.println("Evaluates to " + output);

    }
}
