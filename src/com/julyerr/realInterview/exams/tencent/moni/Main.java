package com.julyerr.niuke.company.tencent.moni;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int times = scanner.nextInt();
            while(times-->0){
                int x1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int x3 = scanner.nextInt();
                int x4 = scanner.nextInt();

                int y1 = scanner.nextInt();
                int y2 = scanner.nextInt();
                int y3 = scanner.nextInt();
                int y4 = scanner.nextInt();

                int x1Mid = x1+x4;
                int x2Mid = x2 + x3;
                int y1Mid = y1+y4;
                int y2Mid = y2+y3;
                if(x1Mid!=x2Mid||y1Mid!=y2Mid){
                    System.out.println("No");
                }else{
                    x1Mid /=2;
                    y1Mid /=2;
                    int dis1 = (x1-x1Mid)*(x1-x1Mid)+(y1-y1Mid)*(y1-y1Mid);
                    int dis2 = (x2-x1Mid)*(x2-x1Mid)+(y2-y1Mid)*(y2-y1Mid);
                    if(dis1!=dis2){
                        System.out.println("No");
                    }else{
                        int a1 = x4-x1;
                        int b1 = y4-y1;
                        int a2 = x3-x2;
                        int b2 = y3-y2;
                        if(a1*a2+b1*b2!=0){
                            System.out.println("No");
                        }else{
                            System.out.println("Yes");
                        }
                    }
                }
            }
        }
    }
}
