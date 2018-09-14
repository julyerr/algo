package com.julyerr.realInterview.exams.toutiao.qiuzhao2018;


import java.util.*;


/*
3
1,10;32,45
78,94;5,16
80,100;200,220;16,32
* */
public class Bingjubiaozhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] inputs = line.split(";");
            for (int j = 0; j < inputs.length; j++) {
                String[] segs = inputs[j].split(",");
                intervals.add(new Interval(Integer.parseInt(segs[0]),Integer.parseInt(segs[1])));
            }
        }

        List<Interval> newIntervals = merge(intervals);
        StringBuilder sb = new StringBuilder();
        for(Interval interval :newIntervals){
            sb.append(interval.start).append(",").append(interval.end).append(";");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }


    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size()<1){
            return res;
        }
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval i1,Interval i2){
                return i1.start - i2.start;
            }
        });

        Interval temp = null;
        for(Interval interval:intervals){

            if(temp == null || temp.end < interval.start){
                res.add(interval);
                temp = interval;
            }else {
                temp.end = Math.max(temp.end,interval.end);
            }
        }
        return res;
    }

    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


