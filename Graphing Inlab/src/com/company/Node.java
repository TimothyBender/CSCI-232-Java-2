package com.company;

import java.util.ArrayList;

public class Node {

    int data;
    boolean visited = false;
    ArrayList<Node> adj = new ArrayList<Node>();

    public Node(int d){
        this.data = d;
    }

    public void addEdge(Node n){
        adj.add(n);
    }

    public ArrayList<Node> getEdges(){
        return adj;
    }

    public int getData(){
        return this.data;
    }

    public void printEdges(){
        for(Node x: adj){
            System.out.println(x);
        }
    }

    public String toString(){
        return String.valueOf(this.data);
    }
}
