package com.julyerr.algo.tmp;

import java.io.IOException;
import java.util.*;

/**
 * 邻接表和矩阵之间的比较
 * dijkstra时间复杂度
 */
public class ListUdg {

    private class Edge {
        public Edge(int index, int weight, Edge next) {
            this.index = index;
            this.weight = weight;
            this.next = next;
        }

        int index;
        int weight;
        Edge next;
    }

    private class Vnode {
        char data;
        Edge firstEdge;
    }

    private Vnode[] Vnodes;
    private Map<Character, Integer> map;
    private int edgeNumL;

    private char readChar() {
        char c = '0';
        do {
            try {
                c = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')));
        return c;
    }

    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public ListUdg() {
        System.out.println("please input the number of the vnodes");
        int vNum = readInt();
        System.out.println("please input the number of the edges");
        int edgeNum = readInt();
        edgeNumL = edgeNum;

        if(vNum < 1 || edgeNum < 1 || edgeNum > vNum *(vNum -1)){
            System.out.println("input number error");
            return;
        }
        System.out.println("please input the char of each Node");
        Vnodes = new Vnode[vNum];
        map = new HashMap<>();
        for (int i = 0; i < vNum; i++) {
            char c = readChar();
            map.put(c, i);
            Vnodes[i] = new Vnode();
            Vnodes[i].data = c;
            Vnodes[i].firstEdge = null;
        }

        System.out.println("input the edges at the format :start end length ");
        for (int i = 0; i < edgeNum; i++) {
            char startNode = readChar();
            char endNode = readChar();
            int length = readInt();

            int index1 = map.get(startNode);
            int index2 = map.get(endNode);

            Edge edge1 = new Edge(index2, length, null);
            Edge edge2 = new Edge(index1, length, null);

            if (Vnodes[index1].firstEdge == null) {
                Vnodes[index1].firstEdge = edge1;
            } else {
                linkEdge(Vnodes[index1].firstEdge, edge1);
            }

            if (Vnodes[index2].firstEdge == null) {
                Vnodes[index2].firstEdge = edge2;
            } else {
                linkEdge(Vnodes[index2].firstEdge, edge2);
            }
        }
    }

    public ListUdg(char[] inodes, EData[] eData) {
        int length = inodes.length;
        Vnodes = new Vnode[length];
        map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inodes[i], i);
        }
//        initial the Node
        for (int i = 0; i < length; i++) {
            Vnodes[i] = new Vnode();
            Vnodes[i].data = inodes[i];
            Vnodes[i].firstEdge = null;
        }
        edgeNumL = eData.length;

        for (int i = 0; i < eData.length; i++) {
            int index1 = map.get(eData[i].start);
            int index2 = map.get(eData[i].end);

            Edge edge1 = new Edge(index2, eData[i].weight, null);
            Edge edge2 = new Edge(index1, eData[i].weight, null);

            if (Vnodes[index1].firstEdge == null) {
                Vnodes[index1].firstEdge = edge1;
            } else {
                linkEdge(Vnodes[index1].firstEdge, edge1);
            }

            if (Vnodes[index2].firstEdge == null) {
                Vnodes[index2].firstEdge = edge2;
            } else {
                linkEdge(Vnodes[index2].firstEdge, edge2);
            }
        }
    }

    private void linkEdge(Edge list, Edge next) {
        while (list.next != null) {
            list = list.next;
        }
        list.next = next;
    }

    private static class EData {
        char start, end;
        int weight;

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public void bfs() {
        int length = Vnodes.length;
        int[] queue = new int[length];
        int head = 0;
        int rear = 0;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        System.out.println("BFS:");
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.println("visited:" + Vnodes[i].data);
                queue[rear++] = i;
            }

            while (head != rear) {
                int index = queue[head++];
                Edge edge = Vnodes[i].firstEdge;
                while (edge != null) {
                    int tIndex = edge.index;
                    if (!visited[tIndex]) {
                        visited[tIndex] = true;
                        System.out.println("visited:" + Vnodes[tIndex].data);
                        queue[rear++] = tIndex;
                    }
                    edge = edge.next;
                }
            }
        }
        System.out.println();
    }

    public void dfs() {
        int length = Vnodes.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            visited[i] = false;
        }
        System.out.println("DFS:");
        for (int i = 0; i < length; i++) {
            if(!visited[i])
                dfs(i, visited);
        }
        System.out.println();
    }

    private void dfs(int index, boolean[] visited) {
        visited[index] = true;
        System.out.println("visited:" + Vnodes[index].data);
        Edge edge = Vnodes[index].firstEdge;
        while (edge != null) {
//            快速迭代完成
            if (!visited[edge.index]) {
                dfs(edge.index, visited);
            }
            edge = edge.next;
        }
    }

    public void print() {
        for (int i = 0; i < Vnodes.length; i++) {
            System.out.printf("%s",Vnodes[i].data);
            Edge edge = Vnodes[i].firstEdge;
            while(edge != null){
                System.out.println("next:"+Vnodes[edge.index].data+"  ");
                edge = edge.next;
            }
        }
    }

    public static void main(String[] args){
//        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
//        EData[] edges = {
//                // 起点 终点 权
//                new EData('A', 'B', 12),
//                new EData('A', 'F', 16),
//                new EData('A', 'G', 14),
//                new EData('B', 'C', 10),
//                new EData('B', 'F',  7),
//                new EData('C', 'D',  3),
//                new EData('C', 'E',  5),
//                new EData('C', 'F',  6),
//                new EData('D', 'E',  4),
//                new EData('E', 'F',  2),
//                new EData('E', 'G',  8),
//                new EData('F', 'G',  9),
//        };
//
//        ListUdg listUdg = new ListUdg(vexs,edges);
//        listUdg.print();
//        listUdg.dfs();
//        listUdg.bfs();

//        int[] prev = new int[vexs.length];
//        int[] dist = new int[vexs.length];
//        listUdg.dijkstra(0,prev,dist);

//        listUdg.kruskal();
//        listUdg.prim(0);


        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EData[] edges = {
                // 起点 终点 权
                new EData('A', 'G', 12),
                new EData('B', 'A', 10),
                new EData('B', 'D',  7),
                new EData('C', 'G',  3),
                new EData('C', 'F',  5),
                new EData('D', 'E',  4),
                new EData('D', 'F',  4),
        };
        ListUdg listUdg = new ListUdg(vexs,edges);
        listUdg.topologicalSort();
    }




//    dijkstra

    /**
     *
     * @param vtex 起始点
     * @param prev 前缀数组
     * @param dist 距离
     */
    public void dijkstra(int vtex,int[] prev,int[] dist){
        int length = dist.length;
        boolean[] visited = new boolean[length];
//        initial the values
        for (int i = 0; i < length; i++) {
            visited[i] = false;
            prev[i] = 0;
            dist[i] = getWeight(vtex,i);
        }
        visited[vtex] = true;
        dist[vtex] = 0;
//        每次取出新的节点
        int k = 0;
        for (int i = 0; i < length - 1; i++) {
//            取出最小距离的点
            int min = INF;
            for (int j = 0; j < length; j++) {
                if(!visited[j] && dist[j] < min){
                    min = dist[j];
                    k = j;
                }
            }
            visited[k] = true;

//            对新加入的点进行距离更新
            for (int j = 0; j < length; j++) {
                int tmp = getWeight(k,j);
                tmp = (tmp == INF)?INF:(min+tmp);
                if(!visited[j] && tmp < dist[j]){
                    prev[j] = k;
                    dist[j] = tmp;
                }
            }
        }
        System.out.println("dist:");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+"  ");
        }
        System.out.println();
        System.out.println("prev:");
        for (int i = 0; i < prev.length; i++) {
            System.out.print(prev[i]+"  ");
        }
        System.out.println();
        for (int i = 0; i < length ; i++) {
            if(i != vtex){
                System.out.printf("%s -> %s distance:%d\n\t",Vnodes[vtex].data,Vnodes[i].data,dist[i]);
//                output the path from the right --> left
                System.out.print(Vnodes[i].data+"-->");
                int pre = prev[i];
                while(pre != vtex){
                    System.out.printf("%s-->",Vnodes[pre].data);
                    pre =  prev[pre];
                }
                System.out.printf("%s\n",Vnodes[vtex].data);
            }
        }
    }

    private int getWeight(int start,int end){
        Edge edge = Vnodes[start].firstEdge;
        while(edge != null){
            if(edge.index == end){
                return edge.weight;
            }
            edge = edge.next;
        }
        return INF;
    }
    private final int INF = Integer.MAX_VALUE;


//    prim
    public void prim(int start){
        int length = Vnodes.length;
        boolean[] visited = new boolean[length];
        EData[] eData = new EData[length];
        for (int i = 0; i < length; i++) {
            int tmp = getWeight(start,i);
            eData[i] = new EData(Vnodes[start].data,Vnodes[i].data,tmp);
        }
        visited[start] = true;
        int u = getMin(visited,eData);
        int sum = 0;
        while(u != -1){
            visited[u] = true;
            sum += eData[u].weight;
//            adjust the elems
            for (int i = 0; i < length; i++) {
                int tmp = getWeight(u,i);
                if(!visited[i] && tmp < eData[i].weight){
                    eData[i].weight = tmp;
                    eData[i].start = Vnodes[u].data;
                    eData[i].end = Vnodes[i].data;
                }
            }
            u = getMin(visited,eData);
        }
        System.out.println("prim distance:");
        for (int i = 0; i < length; i++) {
            if(i != start){
                System.out.printf("%s-->%s %d\n",eData[i].start,eData[i].end,eData[i].weight);
            }
        }
        System.out.println("total :"+sum);
    }

    private int getMin(boolean[] visited,EData[] eData){
        int index = -1;
        int min = INF;
        for (int i = 0; i < eData.length; i++) {
            if(!visited[i] && eData[i].weight < min){
                min = eData[i].weight;
                index = i;
            }
        }
        return index;
    }

//    kruskal
    public void kruskal(){
        EData[] edata = getEdata();
        sortEdges(edata);
        int[] ends = new int[edgeNumL];
        EData[] ret = new EData[edgeNumL];
        int index = 0;

        for (int i = 0; i < edgeNumL; i++) {
            EData tmp = edata[i];
            int start = map.get(tmp.start);
            int end = map.get(tmp.end);

            int m = getEnd(ends,start);
            int n = getEnd(ends,end);
            if(m!=n){
                ends[m] = n;
                ret[index++] = tmp;
            }
        }
        int sum = 0;
        System.out.println("krusal distance:");
        for (int i = 0; i < index; i++) {
            System.out.printf("%s -> %s:%d\n",ret[i].start,ret[i].end,ret[i].weight);
            sum+= ret[i].weight;
        }
        System.out.println("total :"+sum);
    }

    private EData[] getEdata(){
        EData[] edata = new EData[edgeNumL];
        int index = 0;
        for (int i = 0; i < Vnodes.length; i++) {
            Edge edge = Vnodes[i].firstEdge;
            while(edge!=null){
                if(edge.index > i){
                    System.out.println("index:"+index);
                    edata[index++]= new EData(Vnodes[i].data,Vnodes[edge.index].data,edge.weight);
                }
                edge = edge.next;
            }
        }
        return edata;
    }

    private void sortEdges(EData[] eData){
        for (int i = 0; i < edgeNumL; i++) {
            for (int j = i+1; j < edgeNumL; j++) {
                if(eData[i].weight > eData[j].weight){
                    EData tmp = eData[i];
                    eData[i] = eData[j];
                    eData[j] = tmp;
                }
            }
        }
    }

    private int getEnd(int[] ends,int index){
        while(ends[index] != 0){
            index = ends[index];
        }
        return index;
    }

    public void topologicalSort(){
//        初始化结构
        int length = Vnodes.length;
        char[] nodes = new char[length];
        Queue<Integer> queue = new LinkedList<>();
//        出入度统计
        int[] ins = new int[length];
        for (int i = 0; i < length; i++) {
            Edge edge = Vnodes[i].firstEdge;
            while(edge != null){
                ins[edge.index]++;
                edge = edge.next;
            }
        }
//      如果是前驱节点，添加进queue中
        for (int i = 0; i < length; i++) {
            if(ins[i] == 0){
                queue.add(i);
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.toArray());
        }
        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.poll().intValue();
            nodes[index++] = Vnodes[node].data;

//            对相连的边度数减一
            Edge edge = Vnodes[node].firstEdge;
            while(edge != null){
                ins[edge.index]--;
                edge = edge.next;
            }
            for (int i = 0; i < length; i++) {
                if(ins[i] == 0){
                    queue.add(i);
                }
            }
        }
        if(index != length){
            System.out.println("the graph has an cycle");
            return ;
        }
        System.out.println("topological searchSort:");
        for (int i = 0; i < length; i++) {
            System.out.print(nodes[i]+" ");
        }
    }
}


















