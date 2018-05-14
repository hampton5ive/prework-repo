package com.sblabs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
public class Main {

    public static void main(String[] args) {
        int[][] matrix = prettyPrint(5);
        printTable(matrix);
        int[] A = {1, 2, 3};
        System.out.println(kthsmallest(A, 2));
        matrix = permute(A);
        printTable(matrix);
    }

    // checkpt 2
    public static int[][] prettyPrint(int a) {
        int size = (a-1)*2 + 1;
        int[][] matrix = new int[size][size];
        int start = a-1;
        int end = a;

        int num = 1;
        while(start >= 0) {
            for (int row = start; row < end; row++) {
                for (int col = start; col < end; col++) {
                    // only fill in cells that aren't filled by a previous iteration
                    if (matrix[row][col] == 0) {
                        matrix[row][col] = num;
                    }
                }
            }
            start--;
            end++;
            num++;
        }
        return matrix;
    }

    // checkpt 3
    public static int kthsmallest(final int[] A, int B) {
        //List<Integer> integers = Arrays.asList(A);
        List<Integer> integers = new ArrayList<Integer>();
        for (int i=0; i < A.length; i++) {
            integers.add(A[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue(integers);
        int result = 0;
        for (int k=1; k<=B; k++) {
            result = pq.poll();
        }
        return result;
    }

    // checkpt 4
    public int[] nextGreater(int[] A) {
        int[] result = new int[A.length];
        if (result.length == 1) {
            result[0] = -1;
        }
        for (int i=0; i < A.length; i++) {
            result[i] = -1;
            for (int j=i+1; j < A.length; j++) {
                if (A[j] > A[i]) {
                    result[i] = A[j];
                    break;
                }
            }
        }
        return result;
    }

    // checkpt 5
    static int[][] permute(int[] A) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        resultList.add(new ArrayList<Integer>());

        for (int i=0; i < A.length; i++) {
            Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

            for (List<Integer> currList : resultList) {
                for (int j = 0; j < currList.size() + 1; j++) {
                    currList.add(j, A[i]);
                    ArrayList<Integer> T = new ArrayList<Integer>(currList);
                    currList.remove(j);
                    set.add(T);
                }
            }

            resultList = new ArrayList<ArrayList<Integer>>(set);
        }

        return nestedListToArr(resultList);
    }

    static int[][] nestedListToArr(ArrayList<ArrayList<Integer>> nested) {
        int index = 0;
        int[][] result = new int[nested.size()][];

        for (List<Integer> list: nested) {
            int[] arr = new int[list.size()];

            for(int i=0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
            result[index] = arr;
            index++;
        }
        return result;
    }

    static void printTable(int[][] matrix) {
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
