package com.julyerr.realInterview.exams.zhaoshangyinghang;

import java.util.Arrays;
import java.util.Scanner;

public class First {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        String[] firsts = first.split(" ");
        int[] childs = new int[firsts.length];
        for (int i = 0; i < firsts.length; i++) {
            childs[i] = Integer.parseInt(firsts[i]);
        }
        Arrays.sort(childs);

        String[] seconds = second.split(" ");
        int[] caddies = new int[second.length()];
        for (int i = 0; i < seconds.length; i++) {
            caddies[i] = Integer.parseInt(seconds[i]);
        }
        Arrays.sort(caddies);

        int rt = 0;
        int index = 0;
        for (int i = 0; i < childs.length && index<caddies.length; i++) {
            for (;index < caddies.length; index++) {
                if(childs[i]<=caddies[index]){
                    rt++;
                    index++;
                    break;
                }
            }
        }
        System.out.println(rt);
    }
}
