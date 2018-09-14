
import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Comparator;

import java.util.List;


public class Tmp {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        while (m>0){

            String in = br.readLine();

            list.add(in);

            m--;

        }

        List<Interval> intervals = new ArrayList<>();

        for(String s : list){

            String[] split = s.split(";");

            for(int i = 0;i<split.length;i++){

                String[] ss = split[i].split(",");

                Interval interval = new Interval(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]));

                intervals.add(interval);

            }

        }

        List<Interval> mergeRt = merge(intervals);

        StringBuilder sb = new StringBuilder();

        for(Interval interval :mergeRt){

            sb.append(interval.getStart()).append(",").append(interval.getEnd()).append(";");

        }

        System.out.println(sb.substring(0,sb.length()-1));

    }




    /**

     * @param intervals, a collection of intervals

     * @return: A new sorted interval list.

     */

    public static List<Interval> merge(List<Interval> intervals) {

        // write your code here

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

            if(temp == null || temp.end<interval.start){

                res.add(interval);

                temp = interval;

            }else {

                temp.end = Math.max(temp.end,interval.end);

            }

        }

        return res;

    }

}


class Interval {

    int start, end;


    Interval(int start, int end) {

        this.start = start;

        this.end = end;

    }


    public int getStart() {

        return start;

    }


    public void setStart(int start) {

        this.start = start;

    }


    public int getEnd() {

        return end;

    }


    public void setEnd(int end) {

        this.end = end;

    }


}
