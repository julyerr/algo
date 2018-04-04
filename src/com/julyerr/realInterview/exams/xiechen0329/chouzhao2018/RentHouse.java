package com.julyerr.realInterview.exams.xiechen0329.chouzhao2018;

import java.util.Scanner;

public class RentHouse {
    private static int price = Integer.MAX_VALUE;
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            price = Integer.MAX_VALUE;
            int n = scanner.nextInt();
            House[] houses = new House[n];
            for (int i = 0; i < n; i++) {
                int old = scanner.nextInt();
                int young = scanner.nextInt();
                int price = scanner.nextInt();
                houses[i] = new House(old, young, price);
            }
            int old = scanner.nextInt();
            int young = scanner.nextInt();
            int times = scanner.nextInt();
            int[] nums = new int[n];
            dfs(houses,0,old,young,times,nums);
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + ",");
            }
            System.out.printf("%.1f\n",1.0*price);
        }
    }

    private static void dfs(House[] houses, int cur, int old, int young, int times,int[] nums) {
        if (old <= 0 && young <= 0) {
            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                tmp += houses[i].price * nums[i];
            }
            tmp *= times;
            if (price > tmp) {
                array = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    array[i] = nums[i];
                }
                price = tmp;
            }
            return;
        }
        for (int i = cur; i < houses.length; i++) {
            nums[i]++;
            dfs(houses, i, old - houses[i].old, young - houses[i].young, times,nums);
            nums[i]--;
        }
    }

    private static class House {
        int old, young, price;

        public House(int old, int young, int price) {
            this.old = old;
            this.young = young;
            this.price = price;
        }
    }
}

/*
2
2 2 100
4 3 180
3 2 1
* */