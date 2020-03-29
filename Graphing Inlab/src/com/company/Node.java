package com.company;

import java.util.ArrayList;

public class Node {

    int data;
    boolean visited;
    ArrayList<Integer> edges;
    public Node(int d){
        this.data = d;
        this.visited = false;
        edges = new ArrayList<Integer>();
    }

    public void addEdge(int x){
        edges.add(x);
    }
    public ArrayList<Integer> getEdges(){
        return edges;
    }
    public String toString(){
        return String.valueOf(this.data);
    }
}
