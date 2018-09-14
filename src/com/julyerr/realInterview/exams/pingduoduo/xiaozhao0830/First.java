package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0830;

import java.util.Scanner;

public class First {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hp =scanner.nextInt();
        int nor =scanner.nextInt();
        int buf =scanner.nextInt();
        int ret = 0;
        if(2*nor>=buf){
            ret += hp / nor;
            if(hp>ret*nor){
                ret++;
            }
        }else{
            ret = hp/buf;
            int delta = hp - ret*buf;
            ret *= 2;
            if(delta>0){
                if(delta>nor){
                    ret+=2;
                }else{
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
}
