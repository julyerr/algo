package com.julyerr.targetOffer.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目要求：
 在一个长度为n的数组中，所有数字的取值范围都在[0,n-1]，
 但不知道有几个数字重复或重复几次，找出其中任意一个重复的数字。
 */
public class RepeatNumArray {
    public int repeatNumArray(int[] nums){
        int ret = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else{
                ret = nums[i];
                break;
            }
        }

        return ret;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,3};
        RepeatNumArray repeatNumArray = new RepeatNumArray();
        System.out.println(repeatNumArray.repeatNumArray(nums));
    }
}
