package com.sblabs;

import java.util.Arrays;
public class Bit {

    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<A.length-1; i++) {
            int xor = A[i] ^ A[i+1];
            min = Math.min(min, xor);
        }

        return min;
    }

    public int numSetBits(long a) {
        int count = 0;
        while (a > 0){
            count+= a%2;
            a = a>> 1;
        }
        return count;
    }

}
