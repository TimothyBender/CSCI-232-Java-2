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

// Step 2: Print the graph
		graph.printGraph();
		graph.findNeighbors();

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
		*/

//Read in the new file and make a new graph
		System.out.println();
		fl = new FileReader("src/inputw.txt");
		sc = new Scanner(fl);
		size = sc.nextInt();
		GraphAdjacent graph2 = new GraphAdjacent(size);

// Step 7: Print the new graph
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

// Step 8: Dijkstra's algorithm for shortest path
// The slides 22 and 27 were useful to me for the two first algorithms (actually, it's pretty straightforward);
// however, the slide 32 looks very confusing, so I'd recommend you to check this lecture:
// https://www.coursera.org/learn/algorithms-part2/lecture/2e9Ic/dijkstras-algorithm
// and this post https://java2blog.com/dijkstra-java/
		graph2.dijkstra(2);
		System.out.println(graph2.getDistance(2));
		//graph2.closestPath(3);
/*
// Step 9: Prim's algorithm for Minimum Spanning Tree
// Prim is somehow similar to Dijkstra, so if you solved the previous one, then you solved Prim.
		graph2.prim(2);

// Floyd-Warshall's algorithm for shortest path is not applicable for this case
// so, even when it's easy to implement, I've decided to not take it into account
// in order to avoid confusions

 */
    }


}
