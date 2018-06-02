package com.sblabs;

import java.util.ArrayList;
/**
 * Created by alextam on 5/28/18.
 */
public class MyArrays {
    public static void main(String[] args) {
        MyArrays a = new MyArrays();
    }

    /*Given a non-negative number represented as an array of digits,
      add 1 to the number ( increment the number represented by the digits ).
      The digits are stored such that the most significant digit is at the head of the list.*/
    public static int[] plusOne(int[] A) {
        int[] result = new int[A.length];
        boolean carry = false;
        if (A[A.length-1] + 1 == 10) {
            carry = true;
            result[A.length-1] = 0;
        } else {
            result[A.length-1] = A[A.length-1]+1;
        }

        for (int i=A.length-2; i>=0; i--) {
            if (carry) {
                if (A[i] + 1 == 10) {
                    result[i] = 0;
                    // 0 carry the 1
                } else {
                    carry = false;
                    result[i] = A[i] + 1;
                }
            } else {
                result[i] = A[i];
            }
        }
        // if the most sig bit is 0

        if (result[0] == 0) {
            if (carry) {
                int[] fullResult = new int[A.length+1];
                fullResult[0] = 1;
                for (int i=0; i < result.length; i++) {
                    fullResult[i+1] = result[i];
                }
                return fullResult;
            } else {
                int numLead=0;
                for (;numLead < result.length; numLead++) {
                    if (result[numLead] != 0) {
                        break;
                    }
                }
                // create array without the leading zeroes
                int[] fullResult = new int[A.length-numLead];
                for (int i=0; i < fullResult.length; i++) {
                    fullResult[i] = result[i+numLead];
                }
                return fullResult;
            }
        }
        else {
            return result;
        }
    }

    // find maximum sub array of non negative integers
    public int[] maxset(int[] A) {
        ArrayList<ArrayList<Integer>> listOfSlices = collectArrays(A);

        long largestSum = sumArray(listOfSlices.get(0));
        ArrayList<ArrayList<Integer>> sameSum = new ArrayList<ArrayList<Integer>>();
        sameSum.add(listOfSlices.get(0));

        for (int i=1; i < listOfSlices.size(); i++) {
            ArrayList<Integer> currentSlice = listOfSlices.get(i);

            long currentSum = sumArray(currentSlice);
            if (currentSum < largestSum) {
                continue;
            }

            if (currentSum > largestSum) {
                sameSum.clear();
                largestSum = currentSum;
            }
            sameSum.add(currentSlice);
        }

        int longestLength = sameSum.get(0).size();
        ArrayList<Integer> result = sameSum.get(0);

        for (int i=1; i < sameSum.size(); i++) {
            ArrayList<Integer> currentList = sameSum.get(i);
            if (currentList.size() > longestLength) {
                longestLength = currentList.size();
                result = currentList;
            }
        }

        return toArray(result);
    }

    public int[] toArray(ArrayList<Integer> arrayList) {
        int[] intArr = new int[arrayList.size()];
        for (int i=0; i < arrayList.size(); i++) {
            intArr[i] = arrayList.get(i);
        }
        return intArr;
    }

    public ArrayList<ArrayList<Integer>> collectArrays(int[] a) {
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        int start = 0;
        int end = a.length-1;
        for(int i=0; i<a.length; i++) {
            if (a[i] < 0) {
                ArrayList<Integer> slice = sliceArray(a, start, i);
                listOfLists.add(slice);
                start = i+1;
            }
        }
        // slice the last one
        if (start != a.length) {
            listOfLists.add(sliceArray(a, start, a.length));
        }
        return listOfLists;
    }

    public ArrayList<Integer> sliceArray(int[] a, int start, int end) {
        ArrayList<Integer> slice = new ArrayList<Integer>();
        for (int i=start; i < end; i++) {
            slice.add(a[i]);
        }
        return slice;
    }

    public long sumArray(ArrayList<Integer> list) {
        long sum=0;
        for (Integer i: list) {
            sum+=i;
        }
        return sum;
        }
}
