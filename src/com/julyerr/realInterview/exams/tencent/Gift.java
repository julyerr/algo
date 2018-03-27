package com.julyerr.niuke.company.tencent;

public class Gift {
    public int getValue(int[] gifts, int n) {
        int m = gifts[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(gifts[i]==m){
                count++;
            }else if(count>1){
                count--;
            }else{
                m = gifts[i];
            }
        }
        int times = 0;
        for (int i = 0; i < n; i++) {
            if(gifts[i]==m){
                times++;
            }
        }
        return times>n/2?m:0;
    }

    public static void main(String[] args){
        int[] gifts = new int[]{1,2,3,2,2};
        Gift gift = new Gift();
        System.out.println(gift.getValue(gifts,gifts.length));
    }
}
