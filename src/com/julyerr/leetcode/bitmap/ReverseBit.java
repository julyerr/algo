package com.julyerr.leetcode.bitmap;

public class ReverseBit {
    public int reverseBits(int n) {
//        针对每一位进行判断
//        for (int i = 0; i < 16; i++) {
//            boolean firstBit = ((1 << i)&n)==0;
//            boolean secondBit = ((1 << (31-i))&n)==0;
//            if(firstBit!=secondBit){
//                if(firstBit){
//                    n |= (1<<i);
//                    n ^= (1<<(31-i));
//                }else{
//                    n ^= (1<<i);
//                    n |= (1<<(31-i));
//                }
//            }
//        }
//        return n;

//        将n上第i的值移动到31-i上
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret |= ((n >> i) & 1) << (31 - i);
        }
        return ret;
    }

    public static void main(String[] args) {
        ReverseBit reverseBit = new ReverseBit();
        System.out.println(reverseBit.reverseBits(43261596));
    }
}
