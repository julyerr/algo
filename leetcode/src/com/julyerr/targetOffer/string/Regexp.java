package com.julyerr.targetOffer.string;

/**
 * 实现正则表达式中.和*的功能。
 * .表示任意一个字符，*表示他前面的字符的任意次（含0次）。比如aaa与a.a和b*ac*aa匹配，但与aa.a和ab*a不匹配。
 */

/**
 * 简单题目做起来还算顺手，遇到难题还是懵逼，需要针对性的练习一些难题，基本上简单题目直接就上代码不用思路
 * 难题的话，借鉴思路，试试自己实现（现在基本上还不能自己实现），摘抄部分代码，练习几遍，最后实现
 */


/**
 * 讲解比较好的blog:http://blog.csdn.net/hll174/article/details/51001253
 * 每次取出s,p中一个字符进行比较
 * 如果i+1存在且为*，进行如下处理
 * mathch(strIndex,pIndex+2) 匹配0个元素
 * mathch(strIndex+1,pIndex+2) 匹配一个元素
 * mathch(strIndex+1,pIndex) 匹配多个元素
 * 如果不为*，直接相等或者.处理
 * str[i] == p[i] || str[i] == '.'
 */


public class Regexp {
    public boolean match(String s, String p) {
//        check validation
        if (s == null || p == null) {
            return false;
        }
        return match(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    //    不断递归实现
    private boolean match(char[] str, int s, char[] ps, int p) {
//        递归结束条件
//        s,p均结束
        if (str.length <= s && ps.length <= p) {
            return true;
        }
//        str 未结束，但是p已经结束
        if (str.length > s && ps.length <= p) {
            return false;
        }
//        处理×的情况
        if (p + 1 < ps.length && ps[p + 1] == '*') {
            if (str[s] == ps[p] || ps[p] == '.') {
//                各种可能情况
                return match(str, s + 1, ps, p + 2) ||
                        match(str, s + 1, ps, p) || match(str, s, ps, p + 2);
            }
//            处理0相等的情况
            return match(str, s, ps, p + 2);
        }
//        不存在*的情况
        if (str.length <= s || ps.length <= p) return false;
//        处理都取出1的情况
        if (str[s] == ps[p] || ps[p] == '.') {
            return match(str, s + 1, ps, p + 1);
        }
        return false;
    }
    public static void main(String[] args){
        Regexp regexp = new Regexp();
        System.out.println(regexp.match("aaa","a.a"));
        System.out.println(regexp.match("aaa","b*ac*aa"));
        System.out.println(regexp.match("aaa","aa.a"));
        System.out.println(regexp.match("aaa","ab*a"));
    }
}

