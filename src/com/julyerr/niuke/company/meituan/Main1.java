package com.julyerr.niuke.company.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    private static char[] chars = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                Integer tmp;
                char c = line.charAt(i);
                if((tmp=map.get(c))==null){
                    tmp = 0;
                }
                tmp+=1;
                map.put(c,tmp);
            }

            int min = 0;
            char tmp = 0;
            for (int i = 1; i < 10; i++) {
                tmp = chars[i];
                if(map.get(tmp)==null){
                    min = 0;
                    break;
                }
                if(min==0){
                    min = map.get(tmp);
                }else{
                    min = Math.min(min,map.get(tmp));
                }
            }
            if(min==0){
                System.out.println(tmp);
            }else{
                if(map.get('0')==null){
                    System.out.println(10);
                }else{
                    int zeroTimes = map.get('0');
                    if(zeroTimes<=min){
                        System.out.println(Math.pow(10,zeroTimes));
                    }else{
                        char tmp1 = 0;
                        for (int i = 1; i < 10; i++) {
                            if(map.get(chars[i])==min){
                                tmp1 = chars[i];
                                break;
                            }
                        }
                        int tmp2 = 0;
                        for (int i = 0; i < min+1; i++) {
                            tmp2 = tmp2*10+(tmp1-'0');
                        }
                        System.out.println(tmp2);
                    }
                }
            }
        }
    }
}
