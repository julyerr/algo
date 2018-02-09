package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如：
"car" < "carriage" < "cats" < "doggies < "koala"
2.根据字符串的长度排序。例如：
"car" < "cats" < "koala" < "doggies" < "carriage"
考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
输入描述:
输入第一行为字符串个数n(n ≤ 100)
接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
输出描述:
如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",

如果根据长度排列而不是字典序排列输出"lengths",

如果两种方式都符合输出"both"，否则输出"none"
示例1
输入

3
a
aa
bbb
输出

both
* */
public class TwoWaysOfSort {
    public static void main(String[] args) {
        TwoWaysOfSort waysOfSort = new TwoWaysOfSort();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            switch (waysOfSort.waysOfSort(strings)) {
                case 0:
                    System.out.println("none");
                    break;
                case 1:
                    System.out.println("both");
                    break;
                case 2:
                    System.out.println("lexicographically");
                    break;
                case 3:
                    System.out.println("lengths");
                    break;
            }
        }
    }

    public int waysOfSort(String[] strings) {
        /*
         * 0 none
         * 1 both
         * 2 lexicographically
         * 3 lengths
         * */
        int ret = 0;
        boolean lenSort = true;
        boolean dictSort = true;
        int length = strings.length;
        for (int i = 0; i < length - 1; i++) {
            if (strings[i].length() > strings[i + 1].length()) {
                lenSort = false;
            }
            if (strings[i].compareTo(strings[i + 1]) > 0) {
                dictSort = false;
            }
        }
        if (lenSort && dictSort) {
            ret = 1;
        } else if (!lenSort && !dictSort) {
            ret = 0;
        } else if (lenSort) {
            ret = 3;
        } else {
            ret = 2;
        }
        return ret;
    }
}
