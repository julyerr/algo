package com.julyerr.realInterview.exams.Qiniu.chunzhao2018Two;

import java.util.Arrays;
import java.util.Comparator;

public class BigEn {
    public static String getLargestSeq(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
//        先将整形数组转换成字符串数组
        String[] tmp = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i] + "";
        }
//        自定义排序
        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        return String.join("", tmp);
    }
}
