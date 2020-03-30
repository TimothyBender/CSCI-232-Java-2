package com.company;

import java.util.ArrayList;

public class Node {
    int data;
    boolean visited;
    ArrayList<Edge> edges;
    Node parent;

    int length = Integer.MAX_VALUE;
    int status = 1;
    //1 is temporary, 2 is permanent

    public Node(int d){
        this.data = d;
        this.visited = false;
        edges = new ArrayList<Edge>();
        parent = null;
    }

    public void addEdge(Node x){
        edges.add(new Edge(x));
    }
    public void addEdge(Node j, int weight){
        this.edges.add(new Edge(j,weight));
    }
    public ArrayList<Edge> getEdges(){
        return edges;
    }
    public String toString(){
        return String.valueOf(this.data);
    }
}
