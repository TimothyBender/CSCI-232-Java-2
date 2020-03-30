package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {
    	//read in file, store in a 2d matrix, and then add nodes and edges
		FileReader fl = new FileReader("src/input.txt");
		Scanner sc = new Scanner(fl);
		int storage;
		String sizeS = sc.next();
		int size = Integer.parseInt(sizeS);
		Graph graph = new Graph(size);
		sc.nextLine();
		for(int x = 0; x < size; x++) {
			graph.addNode(x);
		}
		for(int t = 0; t < size; t ++){
			for (int y = 0; y < size; y++){
				storage = sc.nextInt();
				if (storage == 1){
					graph.addEdge(t,y);
				}
				}
		}

		graph.printGraph();
		graph.findNeighbors();
		graph.bfs(2);
		graph.bfs(5);


		graph.dfs(2);
		graph.dfs(5);
/*
/* Email said no warshalls
		graph.warshall(2);
		graph.warshall(5);
		*/

//Read in the new file and make a new graph
		System.out.println();
		fl = new FileReader("src/inputw.txt");
		sc = new Scanner(fl);
		size = sc.nextInt();
		GraphAdjacent graph2 = new GraphAdjacent(size);

		for (int i = 0; i < size; i++) {
			graph2.addNode(i);
			for (int j = 0; j < size ; j++) {
				storage = sc.nextInt();
				if (storage > 0) graph2.addEdge(i, j, storage);
			}
		}
		System.out.println("Graph: Adjacency Matrix");
		graph2.printGraph();
		graph2.findNeighbors();


		graph2.dijkstra(2);
		for(int x = 0; x <= 6; x++) {
			graph2.closestPath(x);
		}


// Step 9: Prim's algorithm for Minimum Spanning Tree
// Prim is somehow similar to Dijkstra, so if you solved the previous one, then you solved Prim.
		System.out.println();
		graph2.prim(2); //should follow the path 2-0,0-4,4-1,1-3. Giving a total edgeweight of 16

    }


}
