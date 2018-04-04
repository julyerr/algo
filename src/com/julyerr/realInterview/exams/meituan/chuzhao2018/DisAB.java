package com.julyerr.realInterview.exams.meituan.chuzhao2018;

import java.util.Scanner;

/*

参考大神的解题思路：https://www.nowcoder.com/discuss/70063

如果暴力求解的话，显然是会超时的，原博主比较巧妙的方法：
将重点放在字符串T上，计算每个T[i]对整个结果的贡献量，具体参见实现代码
* */

public class DisAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();
            System.out.println(help(first, second));
        }
    }

    private static long help(String first, String second) {
        int lenA = first.length();
        int lenB = second.length();
//        长为T的S子串中a,b分别出现的次数
        int a = 0;
        int b = 0;
        for (int i = 0; i < lenA - lenB + 1; i++) {
            if (first.charAt(i) == 'a') {
                a++;
            } else {
                b++;
            }
        }

        int rt = 0;
        for (int i = 0; i < lenB; i++) {
            rt += second.charAt(i) == 'a' ? b : a;
//            移出一个字符
            if (first.charAt(i) == 'a') {
                a--;
            } else {
                b--;
            }
            int tmp = i + lenA - lenB + 1;
//            如果是T中最后一个字符，跳出
            if (tmp >= lenA) {
                break;
            }
//            添加一个字符
            if (first.charAt(tmp) == 'a') {
                a++;
            } else {
                b++;
            }
        }
        return rt;
    }

    //    如果拓展到任意小写字母，只需要设置cnt数组
    private static int helpAny(String s, String t) {
        int lenS = s.length();
        int lenT = s.length();
        int[] cnt = new int[26];

        for (int i = 0; i < lenS - lenT + 1; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        int rt = 0;
        for (int i = 0; i < lenT; i++) {
            rt += cnt[t.charAt(i) - 'a'];
            --cnt[s.charAt(i) - 'a'];
            int tmp = lenS - lenT + 1 + i;
            if (tmp >= lenT) {
                break;
            }
            cnt[s.charAt(tmp) - 'a']++;
        }
        return rt;
    }
}
