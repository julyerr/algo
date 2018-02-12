package com.julyerr.targetOffer.string;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */


// 利用split之后进行分段处理，反而比较鸡肋麻烦
// 通过设置flag进行分段判断
/* [-|+]d*[.d+][[e|E][-|+]D[d+]]] , D=[1-9] ,d = [0-9]
 * 依次遍历，针对不同情况进行处理
 * */

/**
 * 这道题，自己感觉难度还是比较大的，参考了很多资料
 * 解题思路：
 * 1.利用正则去匹配，或者库提供的字符串转数字的方法做到，比较巧妙
 * 2.自己实现正则表达式，难度比较大，现场一般难以做到
 * 3.利用数字前后关系，通过设置flag进行判断，考虑周到即可
 */

public class IsNumberic {
    public boolean isNumeric(char[] str) {
/*
        //通过正则表达式库实现
        String string = new String(str);
        return string.matches("[-\\+]?[0-9]*(\\.[0-9]+)?([eE][-\\+]?[1-9]+[0-9]*)?");
*/
        boolean hasE = false;
        boolean hasDot = false;
        boolean signed = false;
        int length = str.length;
        for (int i = 0; i < length; i++) {
            if (str[i] == '+' || str[i] == '-') {
//                后接.或者数字
                if (i + 1 >= length || str[i + 1] != '.' && !(str[i + 1] >= '1' && str[i + 1] <= '9')) {
                    return false;
                }
//               第二次出现，前面必须是eE
                if (signed && (str[i - 1] != 'E' && str[i - 1] != 'e')) {
                    return false;
                }
//                第一次出现，但是不是开始位置
                if (i > 0 && !signed && (str[i - 1] != 'E' && str[i - 1] != 'e')) {
                    return false;
                }
                signed = true;
            } else if (str[i] == '.') {
//                前面不能存在.,eE
                if (hasE || hasDot) return false;
//                后面必须是数字
                if (i + 1 >= length || !(str[i + 1] >= '0' && str[i + 1] <= '9')) {
                    return false;
                }
                hasDot = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
//              不能出现eE,前面是数字,后面存在其他的元素
                if (hasE || i > 0 && !(str[i - 1] >= '0' && str[i - 1] <= '9') || i + 1 >= length) {
                    return false;
                }
                hasE = true;
            } else if (str[i] < '0' || str[i] > '9') {
//                invalid number
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsNumberic isNumberic = new IsNumberic();
        System.out.println(isNumberic.isNumeric("-1E-16".toCharArray()));
        System.out.println(isNumberic.isNumeric("12e".toCharArray()));
    }
}
