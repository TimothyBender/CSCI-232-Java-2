package com.company;

public class Driver {

    public static void main(String[] args) {
	Graph g = new Graph();
	g.readFile("D:\\Onedrive\\CSCI 232 Java 2\\Graphing Inlab\\src\\data.txt");
	g.printGraph();
	g.buildAdjGraph();
	g.breathFirstSearch(g.nodes[0][0]);
    }


}
