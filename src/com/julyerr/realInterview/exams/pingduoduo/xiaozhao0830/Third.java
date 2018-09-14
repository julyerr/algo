package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0830;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int len = 0;
        int start = 0;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int left= a % b;
        boolean isDiv = false;
        while(!l2.contains(left)){
            l2.add(left);
            left*=10;
            int quotient=left / b;
            l1.add(quotient);
            left%=b;
            if(left==0){
                isDiv = true;
                start = l1.size();
                len = 0;
                break;
            }
        }
        if(!isDiv){
            start=l2.indexOf(left);
            len = l1.size() - start;
        }
        System.out.println(start+" "+len);
    }
}