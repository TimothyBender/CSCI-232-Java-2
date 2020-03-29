package com.company;

import java.util.ArrayList;

public class Graph {

    int size = -1;
    int[][] graph;
    Node[] vertex;
    ArrayList<Integer> discoveryOrder;
    int[] visited;
    Graph(int size){
        this.size = size;
        graph = new int[size][size];
        vertex = new Node[size];
        discoveryOrder = new ArrayList<Integer>();
        visited = new int[size];
    }

    public void addNode(int i) {
        vertex[i] = new Node(i);
    }
    public void addEdge(int i, int j) {
        graph[i][j] = 1;
        vertex[i].addEdge(j);
    }
    public void addEdge(int i, int j, int digit){
        graph[i][j] = digit;
        vertex[i].addEdge(j);
    }


   public void bfs(int i){
        ArrayList<Node> que = new ArrayList<Node>();
        String visitedNodes = "\n";
        que.add(vertex[i]);
        vertex[i].visited = true;
        while(!que.isEmpty()){
            Node u = que.remove(0);
            for(Integer v : u.getEdges()){
                if(!vertex[v].visited){
                    vertex[v].visited = true;
                    visitedNodes += v + " ";
                    que.add(vertex[v]);
                }
            }
            u.visited = true;
        }
        for(Node u : vertex){
            u.visited = false;
        }
        System.out.println("Using BFS starting from index " + i + " we can reach indexes ="
        + visitedNodes);
    }

    public void dfs(int start){
        discoveryOrder.clear();
        depthFirstSearch(start);
        String visited = "";
        for(Integer x : discoveryOrder){
            visited += Integer.toString(x) + " ";
        }
        for(Node u : vertex){
            u.visited = false;
        }
        System.out.println("Using DFS starting from index " + start +" we can reach " +
                "indexes = \n" + visited);
    }
    public void depthFirstSearch(int start){
        Node u = vertex[start];
        u.visited = true;
        for(Integer v : u.getEdges()){
            if(vertex[v].visited == false){
                discoveryOrder.add(v);
                depthFirstSearch(v);
            }
        }
    }

    /*public void warshall(int start){   //cancelled - Not assigned via email
        for k from 1 to |V|
        for i from 1 to |V|
        for j from 1 to |V|
        if dist[i][j] > dist[i][k] + dist[k][j]
        dist[i][j] ← dist[i][k] + dist[k][j]
    }
     */
    
    public void printGraph(){
        System.out.println("Adjacency Matrix");
        for(int x = 0;x < size; x++){
            for(int y = 0; y < size; y++){
                System.out.print(graph[x][y]);
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
                connections += x;
            }
            System.out.println("Node " + counter + " is connected to: " + connections);
            counter ++;
        }
    }
}
