package com.company;

import javafx.util.Pair;

import java.util.*;

public class GraphAdjacent {
    int[][] graph;
    Node[] matrix;
    int[] distances;
    ArrayList<Integer> reached;
    int[] unreached;
    int size;
    int start;
    int verticies;

    GraphAdjacent(int size){
        matrix = new Node[size];
        graph = new int[size][size];
        this.size = size;
        distances = new int[size];
        for(int x = 0; x < size; x++){
            distances[x] = Integer.MAX_VALUE;
        }
        unreached = new int[size];
        reached = new ArrayList<Integer>();
        verticies = 0;
    }

    public void dijkstra(int s){
        this.start = s;
        resetVisits();
        resetDistances();
        distances[s] = 0;
        ArrayList<Integer> que = new ArrayList<Integer>();
        que.add(start);
        matrix[start].visited = true;
        while(!que.isEmpty()){
            int currentNode = que.remove(0);
            matrix[currentNode].visited = true;
            for(Edge e : matrix[currentNode].getEdges()) {
                if (matrix[e.finish.data].visited == false) {
                    if (distances[e.finish.data] > distances[currentNode] + e.weight){
                        distances[e.finish.data] = distances[currentNode] + e.weight;
            }
        }
            }
            int nextNode = closestNode(currentNode);
            if(nextNode != -1) {
                que.add(nextNode);
            }
        }
    }

    public int closestNode(int currentNode){
        int distance = Integer.MAX_VALUE;
        int closestNode = -1;
        for(Edge e : matrix[currentNode].getEdges()){
            if(matrix[e.finish.data].visited == false){
                if(e.weight < distance){
                    distance = e.weight;
                    closestNode = e.finish.data;
                }
            }
        }
        if(closestNode == -1){
            return -1;
        }
        return closestNode;
    }


    public void closestPath(int d){
        String path = "";
        boolean toContinue = true;
        int distance = distances[d];
        for(Edge e : matrix[d].getEdges()){
            if(e.finish.data == start){
                toContinue = false;
                System.out.println("Using Dijkstra, the shortest path from node #" + start +
                        " to node #" + d + " has a weight of " + distance + " with path: " + start + d);
                return;
            }
        }
        if (distances[d] != Integer.MAX_VALUE) {
            int currentNode = d;
            int tempdistance = Integer.MAX_VALUE;
            while (currentNode != start) {
                for (Edge e : matrix[currentNode].getEdges()) {
                    if (distances[e.finish.data] < tempdistance) {
                        path += currentNode;
                        tempdistance = distances[e.finish.data];
                        currentNode = e.finish.data;

                    }
                }
            }
            path += currentNode;
            String finalPath = "";
            for (int i = path.length() - 1; i >= 0; i--) {
                finalPath += path.charAt(i);
            }
            System.out.println("Using Dijkstra, the shortest path from node #" + start +
                    " to node #" + d + " has a weight of " + distance + " with path: " + finalPath);
        } else {
            System.out.println("Using Dijkstra, the shortest path from node #" + start +
                    " to node #" + d + " No Path found");
        }
    }


    public void prim(int s){
        System.out.println("Using Prim, the MST starting from node #" + s + "is:");
        resetParents();
        resetVisits();
        resetDistances();
        for(int i = 0; i < size; i++){
            unreached[i] = 1;
        }
        int start = s;
        reached.add(start);
        unreached[s] = 0;
        distances[start] = 0;
        //System.out.println("Starting at vertex " + start);
        while(!checkIfEmpty(unreached)){
            int minimumNode = Integer.MAX_VALUE;
            int minimumdistance = Integer.MAX_VALUE;
            int xtrack = Integer.MAX_VALUE;
            //System.out.println("Contents of reached " + reached);
            for(int x : reached){
                for(Edge e : matrix[x].getEdges()){
                    if(!reached.contains(e.finish.data)){
                        //System.out.println("Checking edge " + x + " to " + e.finish.data);
                        if(e.weight < minimumdistance){
                            minimumdistance = e.weight;
                            minimumNode = e.finish.data;
                            xtrack = x;
                        }
                    }
                }
            }
            if(minimumdistance == Integer.MAX_VALUE){
                break;
            }
            if(minimumNode < Integer.MAX_VALUE) {
                System.out.println("From " + xtrack + " to " + minimumNode
                        + " Weight: " + minimumdistance);
                reached.add(minimumNode);
                unreached[minimumNode] = 0;
                distances[minimumNode] = minimumdistance;
                //System.out.println("Edge from " + xtrack + " to minimum node" + minimumNode);
                //System.out.println("Weight: " + minimumdistance);
            }
        }

    }

    public boolean checkIfEmpty(int[] unreached){
        boolean toReturn = true;
        for(int x : unreached){
            if (x==1){
                toReturn = false;
            }
        }
        return toReturn;
    }

    public void addNode(int i){
        matrix[i] = new Node(i);
    }

    public void addEdge(int i, int j, int weight){
        matrix[i].addEdge(new Node(j),weight);
        graph[i][j] = weight;
    }

    public void findNeighbors(){
        String connections;
        int counter = 0;
        for(Node x : matrix){
            connections = "";
            for(Edge t : x.getEdges()){
                connections += t.finish.data + " ";
            }
            System.out.println("Node " + counter + " is connected to " + connections);
            counter ++;
        }
    }

    public void printGraph(){
        for(int[] x : graph){
            for(int y : x){
                System.out.print(y);
            }
            System.out.println();
        }
    }
    public void resetVisits(){
        for(Node x : matrix){
            x.visited = false;
        }
    }

    public void resetDistances(){
        for(int x : distances){
            x = Integer.MAX_VALUE;
        }
    }

    public void resetParents(){
        for(Node x : matrix){
            x.parent = null;
        }
    }

    public void getDistances(){
        System.out.println("Distances are : ");
        for(int i = 0; i < distances.length; i++){
            System.out.println("Node " +  i + " distance: " + distances[i]);
        }
    }

}
