package com.julyerr.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * 参考网上大神的解题思路，https://www.nowcoder.com/questionTerminal/493d71a992f44554a500ed818056e1a6
 * 大致是统计每个特殊字母出现次数，然后通过计算可以确定每个数字出现的次数，还原原来的数字，字典顺序输出。
 * 比较巧妙的方法是，统计的时候就可以还原原来的字符串，比如Z的次数表示0出现的次数，对应原来表示2出现次数，具体参见实现代码
 * */


public class PhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            while (n-- > 0) {
                String string = scanner.next();
//                已经还原为原来的位置
                char[] chars = new char[]{'G', 'N', 'Z', 'O', 'W', 'R', 'U', 'F', 'X', 'V'};
                int[] count = new int[10];
                for (int i = 0; i < string.length(); i++) {
                    for (int j = 0; j < 10; j++) {
//                        找到匹配的就退出
                        if (string.charAt(i) == chars[j]) {
                            count[j]++;
                            break;
                        }
                    }
                }
//               计算还不能确定的字符次数
                count[3] = count[3] - count[2] - count[4] - count[6];
                count[5] = count[5] - count[6] - count[2];
                count[7] = count[7] - count[6];
                count[9] = count[9] - count[7];
                count[1] = (count[1] - count[3] - count[9]) / 2;
//                直接从小到大输出
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < count[i]; j++) {
                        System.out.print(i);
                    }
                }
                System.out.println();
            }
        }
    }
}
