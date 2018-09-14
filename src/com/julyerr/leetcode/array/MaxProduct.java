package com.julyerr.leetcode.array;

public class MaxProduct {
    public static int maxProduct(String[] words) {
        int n = words.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] |= (1<<(words[i].charAt(j)-'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if((nums[i]&nums[j])==0){
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        String[] strings = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(strings));
    }
}
