package com.sblabs;

/**
 * Created by alextam on 6/25/18.
 */
public class DP {

    public static void main(String[] args) {

    }

    public int longestSubsequenceLength(final int[] A) {
        if(A.length<=1) return A.length;
        int a[] = new int[A.length];
        int b[]= new int[A.length];
        for(int i=0;i<a.length;i++){
            a[i]=1;
            b[i]=1;
        }
        //calculating longest increasing subsequence from left to right
        for(int i=1;i<A.length;i++){
            for(int j=0;j<i;j++){
                if(A[j] <A[i])
                    a[i]=Math.max(a[i],(a[j]+1));
            }
        }
        // calculating longest decreasing subsequence from right to left
        for(int i=A.length-2;i>=0;i--){
            for(int j=A.length-1;j>i;j--){
                if(A[j] < A[i])
                    b[i]=Math.max(b[i],(b[j]+1));
            }
        }
        for(int i=0;i<a.length;i++){
            a[i]=a[i]+b[i]-1;
        }
        int max=0;
        for(int i=0;i<a.length;i++)
        {
            if (max < a[i])
                max=a[i];
        }
        return max;
    }

    public int climbStairs(int A) {
        int[] ways = new int[A+1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= A; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[A];
    }

    public int isMatch(final String s, final String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex+1;
                iIndex++;
            } else {
                return 0;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }

        return j == p.length() ? 1 : 0;

    }

    // given a string return the min number of steps needed to convert it to another
    public int minDistance(String A, String B) {
        int mat[][]=new int[B.length()+1][A.length()+1];
        for(int i=0;i<mat.length;i++)
            mat[i][0]=i;

        for(int i=0;i<mat[0].length;i++)
            mat[0][i]=i;
        for(int i=1;i<mat[0].length;i++){
            for(int j=1;j<mat.length;j++){
                if(A.charAt(i-1)!=B.charAt(j-1))
                    mat[j][i]=Math.min(mat[j-1][i-1],Math.min(mat[j-1][i],mat[j][i-1]))+1;
                else
                    mat[j][i]=mat[j-1][i-1];
            }
        }
        return mat[B.length()][A.length()];
    }


}
