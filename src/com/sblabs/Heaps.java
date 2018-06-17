package com.sblabs;

import java.util.TreeSet;
/**
 * Created by alextam on 6/15/18.
 */
public class Heaps {

    public static void main(String[] args) {
        int[] secondArr = {2, 4};
        int[] firstArr = {1, 2, 3};

        for (int i=0; i < secondArr.length; i++) {
            System.out.println("There are " + lessThanEqualToNaive(secondArr[i], firstArr) +
                    " numbers less than or equal to " + secondArr[i]);
        }

        TreeSet<Integer> tm = new TreeSet<Integer>();
        for (int j=0; j < firstArr.length; j++) {
            tm.add(firstArr[j]);
        }

        for (int i=0; i < secondArr.length; i++) {

        }
    }

    /*public static int lessThanEqualToN(int n, int[] firstArr) {

    }*/

    public static int lessThanEqualToNaive(int n, int[] firstArr) {
        int count=0;
        for (int j=0; j < firstArr.length; j++) {
            if (firstArr[j] <= n) {
                count++;
            }
        }
        return count;
    }

}
