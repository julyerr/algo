package com.julyerr.realInterview.exams.netease;

import java.util.Scanner;

public class RearrangeOk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int times = scanner.nextInt();
            while(times-- >0){
                int count = scanner.nextInt();
                int[] nums = new int[count];
                int Count4 = 0;
                int CountOdd = 0;
                for (int i = 0; i < count; i++) {
                    nums[i] = scanner.nextInt();
                    if(nums[i] % 4==0){
                        Count4++;
                    }else if(nums[i] % 2 !=0){
                        CountOdd++;
                    }
                }

                int CountNot4 = nums.length - Count4;
                if(Count4 >= CountNot4-1){
                    System.out.println("Yes");
                }else{
                    if(CountOdd > Count4){
                        System.out.println("NO");
                    }else{
                        System.out.println("Yes");
                    }
                }
            }
        }
    }
}
