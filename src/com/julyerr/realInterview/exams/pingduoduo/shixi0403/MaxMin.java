package com.julyerr.realInterview.exams.pingduoduo.shixi0403;

import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =  scanner.nextInt();
            int k =  scanner.nextInt();
            int[] x1 = new int[n];
            int[] x2 = new int[n];
            for (int i = 0; i < n; i++) {
                x1[i] = scanner.nextInt();
                x2[i] = scanner.nextInt();
            }

            int min = 100;
            int max = -100;
            for (int i = 0; i < n; i++) {
                int times1 = 0;
                int times2 = 0;
                for (int j = 0; j < n; j++) {
                    if(x1[i]>x1[j] && x1[i] < x2[j]){
                        times1++;
                        if(times1 == k-1){
                            min = Math.min(min,x1[i]);
                        }
                    }
                    if(x2[i]>x1[j] && x2[i] < x2[j]){
                        times2++;
                        if(times2 == k-1){
                            max = Math.max(max,x2[i]);
                        }
                    }
                }
            }
            if(min==100||max == -100){
                System.out.println("error");
            }else{
                System.out.println(min+" "+max);
            }
        }
    }
}
/*
4 2
0 1
1 3
2 4
3 5
* */