package com.julyerr.leetcode.searchSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length ==0){
            return "";
        }

        int length = nums.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = ""+nums[i];
        }

//        自定义字典序排序规则
        Arrays.sort(strings, new Comparator<String>() {
//            系统调用比较的是 (o1+o2).compareTo(o2+o1)
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

//        0开头，整个数组都是0
        if(strings[0].equals("0")){
            return "0";
        }

        return String.join("",strings);
    }
}
