package com.julyerr.leetcode.searchSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = numbers[i] + "";
        }
        //default searchSort is asc
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if ("0".equals(strs[0])) {
            return "0";
        }
        return String.join("", strs);
    }
}
