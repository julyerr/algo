package com.julyerr.leetcode.array;

/*
 * 参考解题思路:
 *   比较巧妙：https://blog.csdn.net/qq508618087/article/details/52483893
 *   一般能够想到的方法：https://blog.csdn.net/mebiuw/article/details/52445248
 * */
public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (count == 0) {
                if ((data[i] >> 3) == 0b11110) {
                    count = 3;
                } else if ((data[i] >> 4) == 0b1110) {
                    count = 2;
                } else if ((data[i] >> 5) == 0b110) {
                    count = 1;
                } else if ((data[i] >> 7) != 0) {
                    return false;
                }
            }else{
                if ((data[i] >> 6) != 0b10) {
                    return false;
                }
                count--;
            }
        }
        return count > 0 ?false:true;
    }
}
