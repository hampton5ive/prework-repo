package com.sblabs;

import java.util.ArrayList;

public class Recursion {
    ArrayList<Integer> combinations;
    int num;
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        partition(a, 0, new ArrayList<String>(),result);
        return result;
    }

    private void partition(String s, int start, ArrayList<String> list, ArrayList<ArrayList<String>> result) {
        if (start >= s.length())
            result.add(new ArrayList<String>(list));

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                partition(s, i + 1, list,result);
                list.remove(list.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {
        int l = start, r = end;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public ArrayList<Integer> grayCode(int a) {
        combinations = new ArrayList<Integer>();

        if (a == 0) {

            combinations.add(0);
            return combinations;
        }

        num = 0;

        GrayCodeHelper(a);
        return combinations;

    }
    private void GrayCodeHelper(int n)
    {
        if (n == 0)
        {
            combinations.add(num);
            return;
        }

        // ignore the bit.
        GrayCodeHelper(n - 1);

        // invert the bit.
        num = num ^ (1 << (n - 1));
        GrayCodeHelper(n - 1);
    }
}
