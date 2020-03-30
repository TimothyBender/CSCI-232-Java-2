package com.company;

public class Edge implements Comparable<Edge> {
    Node finish;
    int weight;

    Edge(Node f, int w){
        this.finish = f;
        this.weight = w;
    }

    Edge(Node f){
        this.finish = f;
        this.weight = 0;
    }

    public int compareTo(Edge toCompare){
        if(toCompare.weight < this.weight){
            return 1;
        }
        else{
            return -1;
        }
    }

    public String toString(){
        return Integer.toString(finish.data);
    }
}
