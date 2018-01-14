package com.julyerr.algo.graph;

public class Edge {
    public int index;
    public int weight;
    public Edge next;

    public Edge(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
