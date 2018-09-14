package com.julyerr.realInterview.exams.xiechen0329.qiu_2018;

import java.util.*;

public class ThirdF {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        LRUF lruf = new LRUF(n);
        while(scanner.hasNext()){
            String string = scanner.next();
            if(string.equals("p")){
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                lruf.set(key,value);
            }else if(string.equals("g")){
                int key = scanner.nextInt();
                System.out.println(lruf.get(key));
            }
        }
    }
}

/*
对应的例子：
    https://yikun.github.io/2015/04/03/%E5%A6%82%E4%BD%95%E8%AE%BE%E8%AE%A1%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AALRU-Cache%EF%BC%9F/

2
p 1 1
p 2 2
g 1
p 2 102
p 3 3
g 1
g 2
g 3
* */