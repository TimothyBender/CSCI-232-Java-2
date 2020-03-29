package com.company;

import java.util.ArrayList;

public class Node {

    int data;
    boolean visited;
    ArrayList<Integer> edges;
    ArrayList<Integer> weight;

    public Node(int d){
        this.data = d;
        this.visited = false;
        edges = new ArrayList<Integer>();
        weight = new ArrayList<Integer>();
    }

    public void addEdge(int x){
        edges.add(x);
    }
    public void addEdge(int j, int weight){
        this.edges.add(j);
        this.weight.add(weight);
    }
    public ArrayList<Integer> getEdges(){
        return edges;
    }
    public int getWeight(int x){
        return weight.get(x);
    }
    public String toString(){
        return String.valueOf(this.data);
    }
}
