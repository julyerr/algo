package com.julyerr.targetOffer.bitmap;

/**
 * 实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。例如9->1001,输出2；
 * -3->11111111111111111111111111111101,输出31。

 */

/**
 * 利用计算机内部自动处理补码的性质
 */
public class NumOfOne {
    public int numOfOne(int n){
        int ret = 0;
        int pow = 1;
        for (int i = 0; i < 32; i++) {
            if((pow & n) != 0 ){
                ret++;
            }
            pow = pow <<1;
        }

        return ret;
    }

    /**
     * 其他类似的题目
     * 使用一条语句判断一个正整数是不是2的整数次方
     public static boolean isPowerOfTwo(int n){
         return (n&(n-1))==0;
     }

     输入两个整数m，n，计算最少需要改变m的多少位才能得到n
     public int numOfChange(int m,int n){
        int tmp = m ^ n;
        return numOfOne(tmp);
     }
     */

    public static void main(String[] args){
        NumOfOne numOfOne = new NumOfOne();
        System.out.println(numOfOne.numOfOne(-3));
        System.out.println(numOfOne.numOfOne(9));
    }
}
