package com.julyerr.leetcode.string;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one0327 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one0327 2, then one0327 1" or 1211.
 * <p>
 * Given an integer n, generate the nth sequence.
 * <p>
 * Note: The sequence of integers will be represented as a string.
 */

/**
 * using for loop
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String init = "1";
//        迭代上次计算的结果
        for (int i = 0; i < n-1; i++) {
            init = dfs(init);
        }
        return init;
    }

    private String dfs(String string) {
        int length = string.length();
        int count;
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < length) {
//            统计每个不相等字符的个数
            count = 1;
            char tmp = string.charAt(index);
            while (index + 1 < length && string.charAt(index) == string.charAt(index + 1)) {
                index++;
                count++;
            }
            index++;
            stringBuilder.append(count).append(tmp);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
    }
}
