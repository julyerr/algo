package com.julyerr.realInterview.exams.haoweilai;

import java.util.Scanner;

/*
3 9 3 2 5 6 7 3 2 3 3 3
* */

public class MoreThanHalf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] inputs = line.split(" ");
            int[] nums = new int[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                nums[i] = Integer.parseInt(inputs[i]);
            }
            int rt = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == rt) {
                    count++;
                }else{
                    count--;
                    if(count==0){
                        count=1;
                        rt = nums[i];
                    }
                }
            }
            System.out.println(rt);
        }
    }
}
