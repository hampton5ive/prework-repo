package com.sblabs;

import java.util.List;
/**
 * Created by alextam on 6/3/18.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        int[] B = {-2, -1, 2, 3, 3, 3, 5, 5};

        System.out.println(findCount(A, 8));
        System.out.println(findCount(B, -1));
        System.out.println(findCount(B, 5));

        System.out.println(sqrt(2147483647));
    }

    private static  int sqrt(int a) {
        // 0 or 1
        if (a <= 1) return a;
        if (a == 2) return 1;
        long low = 0;
        long high = a-1;
        long mid = 0;
        while (low <= high) {
            mid = (low+high)/2;
            long squared = mid*mid;
            if (squared == a) {
                return (int)mid;
            }
            else if(squared < a) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        //return mid -1;
        return (int)high;
    }
    private static int findCount(final int[] A, int B) {
        int first = findEdgeIndex(A, B, true);
        int last = findEdgeIndex(A, B, false);
        if (first == -1) return 0;
        return last - first + 1;
    }

    private static int findEdgeIndex(int[] A, int B, boolean searchFirst) {
        int low = 0;
        int high = A.length-1;
        int result = -1;
        while(low <= high) {
            int midIndex = (low + high)/2;

            // B is less than middle element
            if (A[midIndex] > B) {
                high = midIndex-1;
            } else if (A[midIndex] < B) {
                low = midIndex+1;
            } else {
                // found it, now do a bseaerch on the left
                // keep at it until you get the lowest index
                result = midIndex;
                if (searchFirst) {
                    high = midIndex-1;
                } else {
                    low = midIndex+1;
                }
            }
        }
        return result;
    }

    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int len = A.size() + B.size();
        if(len % 2 == 1) return findKth(A, 0, B, 0, len / 2 + 1);
        else return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }

    public int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
        if(A_start >= A.size()) return B.get(B_start + k - 1);
        if(B_start >= B.size()) return A.get(A_start + k - 1);
        if(k == 1) return Math.min(A.get(A_start), B.get(B_start));

        int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;

        if(A_key < B_key){
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        }
        else
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }

}
