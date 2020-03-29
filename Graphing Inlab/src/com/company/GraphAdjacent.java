package com.company;

public class GraphAdjacent {

    int[][] graph;
    Node[] vertex;

    GraphAdjacent(int size){
        graph = new int[size][size];
        vertex = new Node[size];
    }

    public void addNode(int x){
        vertex[x] = new Node(x);
    }

    public void addEdge(int i, int j, int weight){
        graph[i][j] = weight;
        vertex[i].addEdge(j,weight);
    }
    public void printGraph(){
        for(int[] x : graph){
            for(int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
    public void findNeighbors(){
        String connections;
        int counter = 0;
        for(Node w : vertex) {
            connections = "";
            for(Integer x : w.getEdges()){
                connections += x + " ";
            }
            System.out.println("Node " + counter + " is connected to: " + connections);
            counter ++;
        }
    }

}
