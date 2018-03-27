package com.julyerr.niuke.company.toutiao;

import java.util.Scanner;

public class OpsTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n%2!=0){
                System.out.println(n-1);
            }else{
                int count = 1;
                while(true){
                    int tmp = 1 << count;
                    if(tmp == n){
                        break;
                    }else if(tmp>n){
                        count--;
                        break;
                    }
                    count++;
                }
                int res = n - (1<<count);
                if(res!=0){
                    int bit = 1;
                    int tmp = count;
                    for (int i = 1; i < tmp; i++) {
                        if((res&(1<<bit))!=0){
                            count++;
                        }
                        bit++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
