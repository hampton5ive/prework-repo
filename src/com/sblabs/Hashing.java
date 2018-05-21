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

        String s = "abcabcbb";
        int len = lengthOfLongestSubstring(s);

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
        //region myattempt
        /*char[] a = A.toCharArray();
        // char is primitive so you can't do Arrays.asList(a)
        List<Character> charList = new ArrayList<>();
        for(int i =0; i < a.length; i++) {
            charList.add(a[i]);
        }
        HashSet<Character> seenSet = new HashSet<Character>(charList);
        String longestSubstr = "";
        String currentSubstr = "";
        int startIndex = 0;
        for (int i=0; i < A.length(); i++) {
            char currChar = A.charAt(i);
            if (!seenSet.contains(currChar)) {
                seenSet.add(currChar);
            } else {
                // start set over, compare currentSubstr to longestSubstr, start str over
                seenSet.clear();
                seenSet.add(currChar);
                currentSubstr = A.substring(startIndex, i);
                if (currentSubstr.length() > longestSubstr.length()) {
                    longestSubstr = currentSubstr;
                }
                startIndex = i;
                // start over as far back as you can
            }
        }

        currentSubstr = A.substring(startIndex, A.length());
        if (currentSubstr.length() > longestSubstr.length()) {
            longestSubstr = currentSubstr;
        }
        return longestSustr.length();*/
        //endregion myattempt
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

    private static int findIndex2(int i, int otherNum, int[] a) {
        for (int x=i+1; x < a.length; x++) {
            if (a[x] == otherNum)
                return x;
        }
        return -2;
    }
}
