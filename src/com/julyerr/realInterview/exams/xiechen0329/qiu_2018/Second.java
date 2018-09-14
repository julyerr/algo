package com.julyerr.realInterview.exams.xiechen0329.qiu_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String label = scanner.next();
            int start  =scanner.nextInt();
            int end  =scanner.nextInt();
            if(A>=start && A<= end){
                list.add(label);
            }
        }
        if(list.isEmpty()){
            System.out.println("null");
        }else{
            Collections.sort(list);
            for (String string :
                    list) {
                System.out.println(string);
            }
        }
    }
}
