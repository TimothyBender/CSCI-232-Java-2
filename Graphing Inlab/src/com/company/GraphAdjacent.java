package com.company;

import java.util.*;

public class GraphAdjacent {
    int[][] graph;
    Node[] matrix;
    int size;
    int start;

    GraphAdjacent(int size){
        matrix = new Node[size];
        graph = new int[size][size];
        this.size = size;
    }

    public void dijkstra(int s){
        this.start = s;
        resetVisits();
        System.out.println("Starting at node " + s);
        matrix[s].distance = 0;
        System.out.println("Matrix start distance " + matrix[s].distance);
        ArrayList<Integer> que = new ArrayList<Integer>();
        que.add(start);
        matrix[start].visited = true;

        while(!que.isEmpty()){
            int currentNode = que.remove(0);
            System.out.println("Visiting Node " + currentNode);
            matrix[currentNode].visited = true;

            
            int nextNode = closestNode(currentNode);
            if(nextNode != -1) {
                que.add(nextNode);
            }
            else{
                break;
            }
        }
    }

    public int closestNode(int currentNode){
        int distance = Integer.MAX_VALUE;
        int closestNode = -1;
        //System.out.println("Edges of " + currentNode.data + " are " + currentNode.getEdges());
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
        int temp = d;
        int distance = Integer.MAX_VALUE;
        while(d != this.start){
            path += temp;
            System.out.println("Visiting Node for closest Path : " + temp);
            System.out.println("Edges for Closest Path: " + matrix[temp].getEdges());
            for(Edge e : matrix[temp].getEdges()){
                System.out.println(e.finish.distance);
                if(e.finish.distance < distance){
                    distance = e.finish.distance;
                    temp = e.finish.data;
                }
            }
        }
        System.out.println(path);

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

    public int getDistance(int x){
        return matrix[x].distance;
    }

}
