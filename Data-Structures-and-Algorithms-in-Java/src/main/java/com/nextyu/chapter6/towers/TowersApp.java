package com.nextyu.chapter6.towers;

/**
 * created on 2017-07-20 10:50
 *
 * @author nextyu
 */
public class TowersApp {
    private static int nDisks = 3;

    public static void main(String[] args) {
        doTowers(nDisks, 'A', 'B', 'C');
    }

    private static void doTowers(int topN, char src, char inter, char dest) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + src + " to " + dest);
        } else {
            doTowers(topN - 1, src, dest, inter);
            System.out.println("Disk " + topN +   // move bottom
                    " from " + src + " to " + dest);
            doTowers(topN - 1, inter, src, dest); // inter to dest
        }
    }
}
