package com.julyerr.realInterview.exams.haoweilai;

import java.util.Scanner;

public class LongestNumberStr {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            int max = 0;
            int end = 0;
            int prev = 0;
            for (int i = 0; i < line.length(); i++) {
                if(Character.isDigit(line.charAt(i))){
                    prev++;
                }else{
                    prev=0;
                }
                if(max<prev){
                    max = prev;
                    end = i;
                }
            }
            System.out.println(line.substring(end-max+1,end+1));
        }
    }
}
