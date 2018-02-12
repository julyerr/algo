package com.julyerr.targetOffer.bitmap;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

/**
 * 基本上不能自己想到，分析比较好的blog:
 *  https://www.jianshu.com/p/e1e77b010ecc
 *  位运算,^表示两个数不需要进位的,&表示两个数需要进位的
 *      对于存在负数参与的情况，由于计算机内部通过补码运算，也符合这种运算规则
 * 对于这种面试题，只能自己积累经验吧，当场发挥
 */
public class Sum {
    public int Add(int num1, int num2) {
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        while(carry != 0){
            int tmp = sum;
            sum ^= carry;
            carry = (tmp & carry) << 1;
        }
        return sum;
    }

    public static void main(String[] args){
        Sum sum = new Sum();
        System.out.println(sum.Add(3,5));
        System.out.println(sum.Add(3,-5));
        System.out.println(sum.Add(3,-3));
    }
}
