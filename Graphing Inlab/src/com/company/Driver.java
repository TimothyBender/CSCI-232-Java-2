package com.company;

import java.io.File;
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
		for (int x = 0; x < size; x++){
			graph.addNode(x);
			for (int y = 0; y < size; y++){
				storage = sc.nextInt();
				if (storage == 1){
					graph.addEdge(x,y);
				}
			}
		}

// Step 2: Print the graph
		graph.printGraph();
		graph.findEdges(0);
		graph.findEdges(1);
		graph.findEdges(2);
		graph.findEdges(3);
		graph.findEdges(4);
		graph.findEdges(5);

// Step 4: Breadth-First Search (slide 22, GraphsIntro)
		graph.bfs(2);
		graph.bfs(5);

// Step 5: Depth-First Search   (slide 27, GraphsIntro)
// Obviously, the result is the same as with BFS, but the implementation is different.
// DFS is simpler but slower.
		graph.dfs(2);
		graph.dfs(5);
/*
/* Email said no warshalls
		graph.warshall(2);
		graph.warshall(5);
		System.out.println("\n");

 */
		fl = new FileReader("src/intputw.txt");
		sc = new Scanner(fl);
// I included one number in the first row of the file so you know a priori
// the number of elements of the graph. You can remove it if you don't need it.
		size = sc.nextInt();
		GraphAdjacent graph2 = new GraphAdjacent(elements);

// Step 7: Print the new graph
		for (int i = 0; i < elements; i++) {
			graph2.addNode(i);
			for (int j = 0; j < elements ; j++) {
				digit = fin.nextInt();
				if (digit > 0) graph2.addEdge(i, j, digit);
			}
		}
		graph2.printGraph();

// Step 8: Dijkstra's algorithm for shortest path
// The slides 22 and 27 were useful to me for the two first algorithms (actually, it's pretty straightforward);
// however, the slide 32 looks very confusing, so I'd recommend you to check this lecture:
// https://www.coursera.org/learn/algorithms-part2/lecture/2e9Ic/dijkstras-algorithm
// and this post https://java2blog.com/dijkstra-java/
		graph2.dijkstra(2);

// Step 9: Prim's algorithm for Minimum Spanning Tree
// Prim is somehow similar to Dijkstra, so if you solved the previous one, then you solved Prim.
		graph2.prim(2);

// Floyd-Warshall's algorithm for shortest path is not applicable for this case
// so, even when it's easy to implement, I've decided to not take it into account
// in order to avoid confusions

 */
    }


}
