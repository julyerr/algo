package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class SignInOutTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int M = scanner.nextInt();
            Time inTime = new Time(100,100,100);
            Time outTime = new Time(-1,-1,-1);
            String early = null,last = null;
            for (int i = 0; i < M; i++) {
                String id = scanner.next();
                String[] in = scanner.next().split(":");
                String[] out = scanner.next().split(":");
                Time time1 = new Time(Integer.parseInt(in[0]),Integer.parseInt(in[1]),Integer.parseInt(in[2]));
                Time time2 = new Time(Integer.parseInt(out[0]),Integer.parseInt(out[1]),Integer.parseInt(out[2]));
                if(inTime.compareTo(time1)>0){
                    inTime = time1;
                    early = id;
                }
                if(outTime.compareTo(time2)<0){
                    outTime = time2;
                    last = id;
                }
            }
            System.out.println(early+" "+last);
        }
    }

    private static class Time implements Comparable<Time>{
        int hour,minute,second;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        @Override
        public int compareTo(Time o) {
            if(this.hour==o.hour){
                if(this.minute == o.minute){
                    return this.second - o.second;
                }
                return this.minute - o.minute;
            }
            return this.hour - o.hour;
        }
    }
}
