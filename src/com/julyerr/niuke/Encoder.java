package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
输入描述:
输入一个待编码的字符串,字符串长度小于等于100.
输出描述:
输出这个编码的index
示例1
输入

baca
输出

16331
* */

/*
 * 以baca为例：
 * i=0,char = b,出现次数+(1+25+25*25+25*25*25)+1,后面加一因为包含b
 * i=1,char a,出现次数+1
 * i=2,char c,出现次数+2*(1+25)+1
 * i=3,char a,出现次数+1
 * 参见实现代码
 * */
public class Encoder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            System.out.println(waysOfEncoder(string));
        }
    }

    private static int waysOfEncoder(String string) {
        int ret = 0;
        //        check validation
        if (string == null || string.equals("")) {
            return ret;
        }
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            if (c > 'a') {
                int times = c - 'a';
                int tmp = 1;
                int pre = 25;
                for (int j = i + 1; j < 4; j++) {
                    tmp += pre;
                    pre *= 25;
                }
                ret += times * tmp;
//                包含本身出现的情况
                ret++;
            } else {
                ret++;
            }
        }
        return ret - 1;
    }
}
