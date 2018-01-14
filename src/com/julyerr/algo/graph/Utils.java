package com.julyerr.algo.graph;

import java.io.IOException;
import java.util.Scanner;

public class Utils {
    //标准输入获取一个Int
    public static int readInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    //标准输入获取一个char
    public static char readChar(){
        char ret = '0';
        do{
            try {
                ret = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!(ret >= 'a' && ret <= 'z' || ret >= 'A'&& ret <='Z'));
        return ret;
    }
    //添加新的边到next链表的尾部
    public static void linkEdge(Edge edge,Edge edge1){
        while(edge.next!=null){
            edge = edge.next;
        }
        edge.next = edge1;
    }
//        未可达的最大距离

    //对边进行排序
    public static void bubbleSort(EData[] eData){
        for (int i = 0; i < eData.length-1; i++) {
            for (int j = i+1; j < eData.length; j++) {
                if(eData[i].weight > eData[j].weight){
                    EData tmp = eData[i];
                    eData[i] = eData[j];
                    eData[j] = tmp;
                }
            }
        }
    }

    public final static int INF = Integer.MAX_VALUE;
}
