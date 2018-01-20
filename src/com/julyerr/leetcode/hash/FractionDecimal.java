package com.julyerr.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */

/**
 * 1. Math.abs有个注意点，就是如果为负数最小值不能取到绝对值，因为没有正数可以表示
 * 因此，可以进行强类型转换，后面直接取负即可
 * 2. 判断是否循环小数，设置map记录对应的index（直到余数累计到比除数更大）
 */
public class FractionDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        String sign = "";
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sign = "-";
        }
        long m = numerator;
        long n = denominator;
        m = Math.abs(m);
        n = Math.abs(n);
//        如果为负数最小，不能绝对值取到
//        System.out.println("m:"+m+",n:"+n);
        long p = m / n;
        long q = m % n;
        if (q == 0) {
            return sign + p;
        }
        String signPart = p + "";
//        sign part
        q *= 10;
//        小数部分
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; q != 0; i++) {
            long t = q / n;
//            map 保存的是能够整除的每一位对应的位置
            if (map.containsKey(q / 10)) {
                stringBuilder.insert(map.get(q / 10), "(");
                stringBuilder.append(")");
                break;
            }
//            stringBuilder添加的是循环小数部分
//            针对，最小值负数的情况，只能通过添加绝对方式解决
            stringBuilder.append(t);
            map.put(q / 10, i);
            q = q % n;
            q *= 10;
        }
        String sbStr = stringBuilder.toString();
        return sign + signPart + "." + sbStr;
    }

    public static void main(String[] args) {
        FractionDecimal fractionDecimal = new FractionDecimal();
        System.out.println(fractionDecimal.fractionToDecimal(-1, -2147483648));
        System.out.println(fractionDecimal.fractionToDecimal(-2147483648, 1));
    }
}
