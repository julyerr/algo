package com.julyerr.algo.graph;

import java.util.HashMap;
import java.util.Map;

import static com.julyerr.algo.graph.Utils.INF;
import static com.julyerr.algo.graph.Utils.bubbleSort;

public class ListUdg {
    //    内部成员
    //存储整个图的所有成员变量
    private Vnode[] vnodes;
    //    线性查找字母对应的下表
    private Map<Character, Integer> map;
    //   图中所有的边的数量
    private int edgeNum;

    public ListUdg(char[] nodes, EData[] eData) {
//        初始化图中的结构
        int num = nodes.length;
        int length = eData.length;
        edgeNum = eData.length;
        map = new HashMap<>();
        vnodes = new Vnode[num];
        for (int i = 0; i < num; i++) {
            map.put(nodes[i], i);
            vnodes[i] = new Vnode(nodes[i]);
        }

        for (int i = 0; i < length; i++) {
            EData eData1 = eData[i];
//            无向图中所有的边都出现两次
            int index1 = map.get(eData1.start);
            int index2 = map.get(eData1.end);
            Edge edge1 = new Edge(index2, eData1.weight);
            Edge edge2 = new Edge(index1, eData1.weight);

            if (vnodes[index1].firstEdge == null) {
                vnodes[index1].firstEdge = edge1;
            } else {
//                将新的边附加到next表中
                Utils.linkEdge(vnodes[index1].firstEdge, edge1);
            }

            if (vnodes[index2].firstEdge == null) {
                vnodes[index2].firstEdge = edge2;
            } else {
                Utils.linkEdge(vnodes[index2].firstEdge, edge2);
            }
        }
    }

    //    邻接表中打印信息
    public void print() {
        System.out.println("邻接表存储的图如下：");
        for (int i = 0; i < vnodes.length; i++) {
            System.out.printf("%c:\n\t", vnodes[i].data);
            Edge edge = vnodes[i].firstEdge;
            while (edge != null) {
                System.out.printf("%c ", vnodes[edge.index].data);
                edge = edge.next;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EData[] edges = {
                // 起点 终点 权
                new EData('A', 'B', 12),
                new EData('A', 'F', 16),
                new EData('A', 'G', 14),
                new EData('B', 'C', 10),
                new EData('B', 'F', 7),
                new EData('C', 'D', 3),
                new EData('C', 'E', 5),
                new EData('C', 'F', 6),
                new EData('D', 'E', 4),
                new EData('E', 'F', 2),
                new EData('E', 'G', 8),
                new EData('F', 'G', 9),
        };
        ListUdg listUdg = new ListUdg(vexs, edges);
//        listUdg.print();
//        listUdg.dfs();
//        listUdg.bfs();

//        listUdg.dijkstra(0);

//        listUdg.prim(0);

        listUdg.kruskal();
    }


//    图的遍历
//    dfs

    /**
     * 使用递归方式进行访问，设置visited数组并且出入进行判断
     */
    public void dfs() {
//        设置访问数组
        int num = vnodes.length;
        boolean[] visited = new boolean[num];
        for (int i = 0; i < num; i++) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
    }

    private void dfs(int index, boolean[] visited) {
//        传进来的索引没有访问过
        visited[index] = true;
        System.out.println("visited:" + vnodes[index].data);
//        依次遍历next链表的中的元素
        Edge edge = vnodes[index].firstEdge;
        while (edge != null) {
            if (!visited[edge.index]) {
                dfs(edge.index, visited);
            }
            edge = edge.next;
        }
    }

//    bfs

    /**
     * 使用队列
     * 首先依次访问所有的next中的元素
     * 同时将已经访问过的元素添加到队列中
     * 使用数组，设置head,rear两个游标模拟队列的进出
     */
    public void bfs() {
        int num = vnodes.length;
        int[] queue = new int[num];
        int head, rear;
        head = rear = 0;
        boolean[] visited = new boolean[num];

//        遍历所有的端点
        for (int i = 0; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue[rear++] = i;
                System.out.println("visited:" + vnodes[i].data);
            }
//            访问next链表中的其他元素
            while (head != rear) {
                Edge edge = vnodes[queue[head++]].firstEdge;
                while (edge != null) {
                    if (!visited[edge.index]) {
                        visited[edge.index] = true;
//                        已经访问完成的元素需要同时添加到队列中
                        queue[rear++] = edge.index;
                        System.out.println("visited:" + vnodes[edge.index].data);
                    }
                    edge = edge.next;
                }
            }
        }
    }

    //    得到距离函数
    private int getPosition(int start, int end) {
        Vnode vnode = vnodes[start];
        Edge edge = vnode.firstEdge;
        while (edge != null) {
            if (edge.index == end) {
                return edge.weight;
            }
            edge = edge.next;
        }
        return INF;
    }
//    dijkstra算法

    /**
     * 设置两个集合，S集合中存储已经访问的元素（初始化的时候只有起始点），U集合中存储还没有被访问的节点
     * 取出S集合到U集合中最短的边，将边的一段添加到U集合中，更新s到U集合的距离
     * 两种情况，不可达->可达，距离变短（s,v)<(s,k)+(k,v)
     * <p>
     * 为了显示路径，设置prev保留父节点的信息
     */
    public void dijkstra(int start) {
        int num = vnodes.length;
        boolean[] visited = new boolean[num];
//        父节点信息
        int[] prev = new int[num];
//        距离数组
        int[] weight = new int[num];

//        初始化集合S
        for (int i = 0; i < num; i++) {
            weight[i] = getPosition(start, i);
        }
        weight[start] = 0;
        visited[start] = true;

        int k = 0;
        for (int i = 0; i < num; i++) {
            int min = INF;
            for (int j = 0; j < num; j++) {
                if (!visited[j] && weight[j] < min) {
                    min = weight[j];
                    k = j;
                }
            }
//            将最短边中U集合中的点添加到已经访问过的数组中
            visited[k] = true;
//            更新起始点到集合U中其他的点距离
            for (int j = 0; j < num; j++) {
                int tmp = getPosition(k, j);
//                处理溢出的情况
                tmp = (tmp == INF) ? INF : (min + tmp);
                if (!visited[j] && tmp < weight[j]) {
                    weight[j] = tmp;
                    prev[j] = k;
                }
            }
        }

//        打印访问过过的路径
        for (int i = 0; i < num; i++) {
//            exclude start point
            char startPoint = vnodes[start].data;
            if (i != start) {
                System.out.printf("%s --> %s,distance:%d\n\t", startPoint, vnodes[i].data, weight[i]);
                int pre = i;
                do {
                    System.out.print(vnodes[pre].data + "-->");
                    pre = prev[pre];
                } while (pre != start);
                System.out.printf("%s\n", startPoint);
            }
        }
    }

//    prim算法

    /**
     * 设置两个集合，U集合表示已经在最小生成树中的点集合，集合T表示最小生成树中的边集合
     * 从所有uЄU，vЄ(V-U)(V-U表示去除U的所有顶点)的边中选取权值最小的边(u,v)，v加入U中，边（u,v)加入T中并进行更新
     * 直到U=V
     * <p>
     * 为了打印边方便，集合T用EData结构表示
     */


    //uЄU，vЄ(V-U)(V-U表示去除U的所有顶点)的边中选取权值最小的边(u,v)，获取v
    private int getMin(EData[] eData, boolean[] visited) {
        int index = -1;
        int min = INF;
        for (int i = 0; i < eData.length; i++) {
            if (!visited[i] && eData[i].weight < min) {
                index = i;
                min = eData[i].weight;
            }
        }
        return index;
    }


    //    start设置与否关系不大，只是初始化的点的选择
    public void prim(int start) {
        int num = vnodes.length;
        boolean[] visited = new boolean[num];
        EData[] edata = new EData[num];

//        初始化集合U和T
        for (int i = 0; i < num; i++) {
            int tmp = getPosition(start, i);
            edata[i] = new EData(vnodes[start].data, vnodes[i].data, tmp);
        }
        visited[start] = true;

        int u = getMin(edata, visited);
        while (u != -1) {
//            添加到集合U中
            visited[u] = true;
            Edge edge = vnodes[u].firstEdge;
            while (edge != null) {
                if (!visited[edge.index] && edge.weight < edata[edge.index].weight) {
                    edata[edge.index].start = vnodes[u].data;
                    edata[edge.index].end = vnodes[edge.index].data;
                    edata[edge.index].weight = edge.weight;
                }
                edge = edge.next;
            }
            u = getMin(edata, visited);
        }
//        打印输出路径
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if (i != start) {
                System.out.println(edata[i].start + "-->" + edata[i].end + ",distance:" + edata[i].weight);
                sum += edata[i].weight;
            }
        }
        System.out.println("total distance:" + sum);
    }


//    kruskal算法

    /**
     * 获取图中所有的边集合，按照边的距离大小进行排序，n个点中保证n-1条边中不出现回路
     * <p>
     * 算法的关键之处在于，是否有回路的判定：类似union-find的思路，对所有已经连接起来的边parent一致
     */
    public void kruskal() {
        EData[] eData = getEdate();
        bubbleSort(eData);

//        parent数组
        int num = vnodes.length;
        int[] parent = new int[num];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        //        保存最短路径

//      每次添加一条新边，循环n-1次就行
        EData[] eData1 = new EData[num - 1];
        int index = 0;

        for (int i = 0; i < edgeNum; i++) {
            EData eData2 = eData[i];
            int m = getParent(parent, map.get(eData2.start));
            int n = getParent(parent, map.get(eData2.end));

            //如果不存在回路添加
            if (m != n) {
                eData1[index++] = eData2;
//                设置parent
                parent[m] = n;
            }
            if (index == num - 1) {
                break;
            }
        }
//        打印输出路径
        int sum = 0;
        for (int i = 0; i < num - 1; i++) {
            System.out.println(eData1[i].start + "-->" + eData1[i].end + ",distance:" + eData1[i].weight);
            sum += eData1[i].weight;
        }
        System.out.println("total distance:" + sum);
    }

    //获取所有的边，无向图中只需要使用到有向图中的边数即可
    private EData[] getEdate() {
        EData[] eData = new EData[edgeNum];
        int index = 0;
        int num = vnodes.length;
        for (int i = 0; i < num; i++) {

            Edge edge = vnodes[i].firstEdge;
//            使用单向的边进行排序
            while (edge != null) {
                if (edge.index > i)
                    eData[index++] = new EData(vnodes[i].data, vnodes[edge.index].data, edge.weight);
                edge = edge.next;
            }
        }
        return eData;
    }

    //    获取parent
    private int getParent(int[] parent, int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}
