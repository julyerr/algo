package com.julyerr.leetcode.array;

/*
 * 参考解题思路
 *   https://blog.csdn.net/a_ran/article/details/17374277
 * */
public class Shuihu {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z){
            return false;
        }
//        对于0的情况进行判断
        if (x == 0 || y == 0) {
            if (x == 0 && y == 0) {
                if (z == 0) {
                    return true;
                }
                return false;
            }
            if (x == 0) {
                return z % y == 0 ? true : false;
            }
            return z % x == 0 ? true : false;
        }
        if (x < y) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        int cd = gcd(x, y);
        return z % cd == 0 ? true : false;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        int z = 4;
        System.out.println(new Shuihu().canMeasureWater(x, y, z));
    }
}
