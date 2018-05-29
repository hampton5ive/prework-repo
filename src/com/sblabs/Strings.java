package com.sblabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by alextam on 5/26/18.
 */
public class Strings {
    Map<Character, Integer> romansToDecimals = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        Strings s = new Strings();
        System.out.println("" + s.romanToInt("MDCCCIV"));
    }

    public static int isPalindrome(String A) {
        String stripped = A.replaceAll("[^A-Za-z0-9]", "");

        int left = 0;
        int right = stripped.length()-1;
        while(left < right) {
            String lChar = String.valueOf(stripped.charAt(left));
            String rChar = String.valueOf(stripped.charAt(right));
            if (!lChar.equalsIgnoreCase(rChar)) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }

    public int romanToInt(String A) {
        romansToDecimals.put('I', 1);
        romansToDecimals.put('V', 5);
        romansToDecimals.put('X', 10);
        romansToDecimals.put('L', 50);
        romansToDecimals.put('C', 100);
        romansToDecimals.put('D', 500);
        romansToDecimals.put('M', 1000);

        int result = 0;
        for (int i=0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (i-1 >=0) {
                char prevChar = A.charAt(i-1);
                if (precededByLesser(prevChar, c)) {
                    result = result - 2*romansToDecimals.get(prevChar);
                }
            }
            result = result + romansToDecimals.get(c);
        }
        return result;
    }

    private boolean precededByLesser(char prev, char curr) {
        List<Character> romansSorted = new ArrayList<Character>();
        romansSorted.add('I');
        romansSorted.add('V');
        romansSorted.add('X');
        romansSorted.add('L');
        romansSorted.add('C');
        romansSorted.add('D');
        romansSorted.add('M');

        int indexP = romansSorted.indexOf(prev);
        int indexC = romansSorted.indexOf(curr);
        if (indexP < indexC) {
            return true;
        }
        return false;
    }

}
