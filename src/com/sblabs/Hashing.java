package com.sblabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/**
 * Created by alextam on 5/20/18.
 */
public class Hashing {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] indices = twoSum(arr, 9);

        String s = "abcanmzxyd";
        //int len = lengthOfLongestSubstring(s);
        String str = "pwwkew";
        int length = lengthOfLongestSubstr(str);
        System.out.println(length);
    }

    public static int[] twoSum(final int[] A, int B) {
        //region myattempt
        /*int[] result = new int[2];
        // map of the number to the smallest index it's in if there are duplicates
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for (int i=0; i < A.length; i++) {
            if (!numberToIndex.containsKey(A[i])) {
                numberToIndex.put(A[i], i);
            }
        }
        // solutions
        List<Tuple> tuples = new ArrayList<>();
        // i will be index1
        for (int i=0; i < A.length; i++) {
            int diff = B-A[i];
            if (numberToIndex.containsKey(diff)) {
                // index won't be zero based
                result[0] = i+1;
                int smallestIndex = numberToIndex.get(diff);
                // index2 > index1
                if (smallestIndex > i) {
                    result[0] = smallestIndex+1;
                } else {
                    result[1] = findIndex2(i, diff, A)+1;
                }
                break;
            }
        }
        return result;*/
        //endregion myattempt
        List<Integer> a = new ArrayList<Integer>();
        for (int num: A) {
            a.add(num);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] result = new int[2];
        for (int i = 0; i < a.size(); i++){
            int curr = a.get(i);

            if (map.containsKey(B-curr)){
                int index = map.get(B-curr);
                result[0] = index;
                result[1] = i+1;
                return result;
            }else if (!map.containsKey(curr)){
                map.put(curr, i + 1);
            }
        }
        return new int[]{};
    }

    public static int lengthOfLongestSubstring(String A) {
        HashSet<Character> hashSet = new HashSet<Character>();
        int maxCount = 0;
        int start = 0;
        for (char c : A.toCharArray()) {
            while (hashSet.contains(c)) {
                hashSet.remove(A.charAt(start));
                start++;
            }
            hashSet.add(c);
            maxCount = Math.max(maxCount, hashSet.size());
        }

        return maxCount;
    }

    public static int lengthOfLongestSubstr(String A) {
        // used to track distinct characters
        HashSet<Character> map = new HashSet<Character>();
        int l = 0;
        int r = 0;

        int maxLen = 0;

        // optional: keep track of the substring with max length
         String str = "";

        while(r < A.length()) {
            Character c = A.charAt(r);
            if(map.contains(c)) {
                // remove duplicate character from the map
                map.remove(A.charAt(l));
                // shrink window
                l++;
            } else {
                // add character to the map
                map.add(c);
                // increase the window
                r++;
                // optional: update with the substring with max length
                 if (r - l > maxLen) {
                 	str = A.substring(l, r);
                 }
                // is the substring longer?
                maxLen = Math.max(maxLen, r - l);
            }
        }

        System.out.println(str);
        return maxLen;
    }

    private static int findIndex2(int i, int otherNum, int[] a) {
        for (int x=i+1; x < a.length; x++) {
            if (a[x] == otherNum)
                return x;
        }
        return -2;
    }
}
