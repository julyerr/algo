package com.julyerr.targetOffer.string;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

/**
 * 开始考虑比较复杂，显然直接运算比较复杂，使用递归完美解决
 * 递归比较重要，而且难度相对来说比较大
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> rt = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return rt;
        }
        permutation(str.toCharArray(), 0, rt);
        Collections.sort(rt);
        return rt;
    }

    private void permutation(char[] cs, int start, List<String> rt) {
        if (start == cs.length - 1) {
            String str = new String(cs);
            if (!rt.contains(str)) {
                rt.add(str);
            }
        } else {
            for (int i = start; i < cs.length; i++) {
                swap(cs, start, i);
//              代码的关键之处，交换元素之后还是从原来的位置开始
                permutation(cs, start + 1, rt);
                swap(cs, start, i);
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String str = "abc";
        for (String string :
                permutation.Permutation(str)) {
            System.out.print(string + " ");
        }
        System.out.println();
    }


}
