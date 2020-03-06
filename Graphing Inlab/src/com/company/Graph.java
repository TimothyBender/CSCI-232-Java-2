package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    int size = -1;
    int[][] graph;
    Node[][] nodes;

    public void buildAdjGraph(){

        if(nodes == null){
            nodes = new Node[size][size];
        }
        //construct the initial graph
        for(int x = 0; x < graph.length;x++){
            for(int y = 0; y < graph.length;y++){
                nodes[x][y] = new Node(graph[x][y]);
            }
        }

        //fill in the adjacency's arraylist
        for(int x = 0; x < graph.length; x++){
            for(int y = 0; y < graph.length; y++){
                int x1,x2,y1,y2;
                x1 = x-1;
                if(x1 >= 0){
                    nodes[x][y].addEdge(nodes[x1][y]);
                }
                x2 = x+1;
                if(x2 < nodes.length){
                    nodes[x][y].addEdge(nodes[x2][y]);
                }
                y1 = y-1;
                if(y1 >= 0){
                    nodes[x][y].addEdge((nodes[x][y1]));
                }
                y2 = y+1;
                if(y2 < nodes.length){
                    nodes[x][y].addEdge(nodes[x][y2]);
                }
            }
        }
    }
    public void readFile(String fname){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            System.out.println("FIle not found");
            e.printStackTrace();
        }
        int counter = 0;
        do {
            assert sc != null;
            String storage = sc.nextLine();
            if(this.size == -1) {
                this.size = storage.length();
                this.graph = new int[size][size];
            }
            for(int x = 0; x < size; x++){
                this.graph[counter][x] = Integer.parseInt(String.valueOf(storage.charAt(x)));
            }
            counter++;
        }while(sc.hasNext());
    }

    public void breathFirstSearch(Node start){
        ArrayList<Node> que = new ArrayList<Node>();
        que.add(start);
        Node u;
        //perform the search
        while(!que.isEmpty()){
            u = que.get(0);
            que.remove(u);
            System.out.println(u);
            for(Node x : u.getEdges()){
                if(x.visited == false){
                    x.visited = true;
                    que.add(x);
                }
            }
        }
        //reset the booleans
        for(Node[] x : nodes){
            for(Node y : x){
                y.visited = false;
            }
        }

    }
    
    public void printGraph(){
        for(int x = 0;x < size; x++){
            for(int y = 0; y < size; y++){
                System.out.print(graph[x][y]);
            }
            System.out.println();
        }
    }
}
