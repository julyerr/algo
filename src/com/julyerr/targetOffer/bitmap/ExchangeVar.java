package com.julyerr.targetOffer.bitmap;

/**
 * 不使用新的变量完成交换两个原有变量的值。
 */


/**
 * 做这道题目开始没有反应过来，做完之后感觉有点坑啊
 */
public class ExchangeVar {
    public static void main(String[] args) {
        int a = 10;
        int b = 11;

//        使用和加减方法进行
//        a = a + b;
//        b = a - b;
//        a = a - b ;
//

//        使用亦或方式进行
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
