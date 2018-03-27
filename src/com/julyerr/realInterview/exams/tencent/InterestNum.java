package com.julyerr.niuke.company.tencent;

import java.util.Arrays;
import java.util.Scanner;

/*
* 开始没有理接题目意思，参考大神的解题思路：http://www.bijishequ.com/detail/521391
*
* 先进行排序，如果所有的元素值都相等的话，大小组合就是n*(n-1)/2;
* 然后分别统计计算最小和最大值;
* 如果最小值为0,需要处理迭代组合的情况;否则，两两判断即可;
* 最大差值的组合数 = 最小值次数*最大值次数
* */
public class InterestNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int length = nums.length;
//            如果所有的元素值都相等
            if(nums[0]==nums[length-1]){
                int tmp = (length-1)*length/2;
                System.out.println(tmp+' '+tmp);
            }else{
                int minTimes = 0;
                int maxTimes = 0;
                int min = Integer.MAX_VALUE;
//                计算最小值
                for (int i = 0; i < length-1; i++) {
                    min = Math.min(min,nums[i+1]-nums[i]);
                }
                if(min == 0){
//                    需要迭代组合情况
                    for (int i = 0; i < length - 1; i++) {
                        for (int j = i+1;j < length && nums[i]== nums[j]; j++) {
                            minTimes++;
                        }
                    }
                }else{
//                    两两判断即可
                    for (int i = 0; i < length - 1; i++) {
                        if(nums[i+1]-nums[i]==min){
                            minTimes++;
                        }
                    }
                }
                int a = 1;
                int b= 1;
//                最小值的次数
                for (int i = 0; i < length-1&&nums[i]==nums[i+1]; i++) {
                    a++;
                }
//                最大值的次数
                for (int i = length-1; i > 0 && nums[i]==nums[i-1]; i--) {
                    b++;
                }
                maxTimes = a*b;
                System.out.println(minTimes+" "+maxTimes);
            }
        }
    }
}
