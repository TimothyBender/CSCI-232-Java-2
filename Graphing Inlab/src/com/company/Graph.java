package com.company;

import java.util.ArrayList;

public class Graph {

    int size = -1;
    int[][] graph;
    Node[] vertex;
    ArrayList<Node> discoveryOrder;
    int[] visited;

    Graph(int size){
        this.size = size;
        graph = new int[size][size];
        vertex = new Node[size];
        discoveryOrder = new ArrayList<Node>();
        visited = new int[size];
    }

    public void addNode(int i) {
        vertex[i] = new Node(i);
    }
    public void addEdge(int i, int j) {
        graph[i][j] = 1;
        vertex[i].addEdge(vertex[j]);
    }

   public void bfs(int i){
        ArrayList<Node> que = new ArrayList<Node>();
        String visitedNodes = "\n";
        que.add(vertex[i]);
        vertex[i].visited = true;
        while(!que.isEmpty()){
            Node u = que.remove(0);
            for(Edge v : u.getEdges()){
                if(!v.finish.visited){
                    v.finish.visited = true;
                    visitedNodes += v.finish.data + " ";
                    que.add(v.finish);
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
        depthFirstSearch(vertex[start]);
        String visited = "";
        for(Node x : discoveryOrder){
            visited += Integer.toString(x.data) + " ";
        }
        for(Node u : vertex){
            u.visited = false;
        }
        System.out.println("Using DFS starting from index " + start +" we can reach " +
                "indexes = \n" + visited);
    }
    public void depthFirstSearch(Node start){
        Node u = start;
        u.visited = true;
        for(Edge v : u.getEdges()){
            if(v.finish.visited == false){
                discoveryOrder.add(v.finish);
                depthFirstSearch(v.finish);
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
        for(Node x : vertex){
            connections = "";
            for(Edge t : x.getEdges()){
                connections += t.finish.data + " ";
            }
            System.out.println("Node " + counter + " is connected to " + connections);
            counter ++;
        }
        }
}
