package com.julyerr.realInterview.exams.meituan.chuzhao2018;

import java.util.Scanner;

/*
参考大神的解题思路：https://www.nowcoder.com/discuss/70063

做题的时候考虑到了统计最小数字出现的次数，但是没有很好地处理0出现次数，结果没有ac；

分别统计0-9出现次数，先不考虑0；
找到所有数字出现最小次数minTimes的字母c，minTimes+1次的c便不能表示出来（若相等，优先下标小的数字）；
1.如果0出现的次数小于等于minTimes，最小数字为1开头然后接上所有0；
2.否则，还是最minTimes+1次的c
* */
public class MinDigComposed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            int[] cnt = new int[10];
            for (int i = 0; i < line.length(); i++) {
                cnt[line.charAt(i) - '0']++;
            }
            int min = Integer.MAX_VALUE;
            int index = 0;
//            统计最小出现次数和下标
            for (int i = 1; i < 10; i++) {
                if (min > cnt[i]) {
                    min = cnt[i];
                    index = i;
                }
            }
//            第一种情况
            if (cnt[0] < min) {
                System.out.print(1);
                for (int i = 0; i < cnt[0] + 1; i++) {
                    System.out.print(0);
                }
                System.out.println();
//                第二种情况
            } else {
                for (int i = 0; i < cnt[index] + 1; i++) {
                    System.out.print(index);
                }
                System.out.println();
            }
        }
    }
}
