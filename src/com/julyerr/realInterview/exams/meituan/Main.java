package com.julyerr.niuke.company.meituan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();
            System.out.println(help(first,second));
        }
    }
    
    private static long help(String first,String second){
        long ret = 0;

        for (int i = 0; i < first.length()-second.length()+1; i++) {
            for (int j = 0; j < second.length(); j++) {
                if(first.charAt(i+j)!=second.charAt(j)){
                    ret++;
                }
            }
        }
        return ret;
    }
}
