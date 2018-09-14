package com.julyerr.leetcode.array;

/*
* 参考思路：https://blog.csdn.net/u013554860/article/details/80153460
* */

public class NthReverse {
    public int bulbSwitch(int n) {
        if(n<=0){
            return 0;
        }
        return (int) Math.sqrt(n);
    }
}
