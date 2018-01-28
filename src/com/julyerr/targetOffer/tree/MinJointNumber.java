package com.julyerr.targetOffer.tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class MinJointNumber {
    public String PrintMinNumber(int[] numbers) {
//    check validation
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int length = numbers.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
//        自定义字典排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MinJointNumber minJointNumber = new MinJointNumber();
        int[] nums = new int[]{3, 32, 321};
        System.out.println(minJointNumber.PrintMinNumber(nums));
    }
}
