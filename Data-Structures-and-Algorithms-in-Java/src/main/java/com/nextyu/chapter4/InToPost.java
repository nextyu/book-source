package com.nextyu.chapter4;

/**
 * 中缀表达式转换为后缀表达式
 * infix to postfix conversion
 * created on 2017-07-06 15:58
 *
 * @author nextyu
 */
public class InToPost {
    private StackXChar theStack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new StackXChar(stackSize);
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':                   // it's + or -
                case '-':
                    gotOper(ch, 1); // go pop operators
                    break;                 // (precedence 1)

                case '*':                   // it's * or /
                case '/':
                    gotOper(ch, 2); // go pop operators
                    break;                 // (precedence 2)

                case '(':                   // it's a left paren
                    theStack.push(ch);      // push it
                    break;

                case ')':                    // it's a right paren
                    gotParen(ch);            //  go pop operators
                    break;

                default:                    // must be an operand
                    output = output + ch;   // write it to output
                    break;
            }
        }

        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }

        theStack.displayStack("End ");
        return output;

    }


    // got operator from input
    private void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') { // if it's a '('
                theStack.push(opTop); // restore '('
                break;
            } else { // it's an operator
                int prec2; // precedence of new op

                if (opTop == '+' || opTop == '-') { // find new op prec
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) { // if prec of new op less than prec of old
                    theStack.push(opTop); // save newly-popped op
                    break;
                } else { // prec of new not less than prec of old
                    output = output + opTop;  // it's an operator
                }
            }
        }
        theStack.push(opThis); // push new operator
    }


    // got right paren from input（右括弧）
    private void gotParen(char ch) {
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(') { // if poped '('
                break; // we're done
            } else { // if poped operator
                output = output + chx; // output it
            }
        }
    }


    public static void main(String[] args) {
        String input = "2+3*4";
        System.out.println("Infix is " + input);
        InToPost theTrans = new InToPost(input);
        String output = theTrans.doTrans();
        System.out.println("Postfix is " + output);
    }

}
