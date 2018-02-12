package com.julyerr.targetOffer.string;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * 输入
 * <p>
 * +2147483647
 * 1a33
 * 输出
 * <p>
 * 2147483647
 * 0
 */

/**
 * 考虑情况比较多，可以考虑先将不符合数字的输入过滤掉，然后主要针对边界条件判断
 */
public class Str2Int {
    public int StrToInt(String str) {
//        check validation
        if (str == null || str.length() == 0) {
            return 0;
        }
        String string = str.trim();
        if (!string.matches("[-\\+]?[0-9]{1,10}")) {
            return 0;
        }
        long ret = 0;
        int index = 0;
        boolean isMinus = false;
        char c = string.charAt(index);
        if (c == '-') {
            isMinus = true;
            index++;
        } else if (c == '+') {
            index++;
        }
        for (int i = index; i < string.length(); i++) {
            ret = ret * 10 + string.charAt(i) - '0';
        }
        if (isMinus) {
            ret = 0 - ret;
        }
        if (string.length() - index == 10) {
            if (!isMinus && ret > 2147483647) {
                return 0;
            } else if (isMinus && ret < -2147483648) {
                return 0;
            }
        }

        return (int) ret;
    }

    public static void main(String[] args) {
        Str2Int str2Int = new Str2Int();
        System.out.println(str2Int.StrToInt("+2147483647"));
        System.out.println(str2Int.StrToInt("   1a33"));
        System.out.println(str2Int.StrToInt("-2147483648"));
        System.out.println(str2Int.StrToInt("2147483648"));
        System.out.println(str2Int.StrToInt("-2147483649"));
    }
}
