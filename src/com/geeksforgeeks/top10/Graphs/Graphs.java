package com.geeksforgeeks.top10.Graphs;

import java.util.LinkedList;

public class Graphs {

    private int numberOfNodes;
    private LinkedList<Integer>[] adjacency;

    public Graphs(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        adjacency = new LinkedList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adjacency[i] = new LinkedList<>();
        }
    }

    public void addEdge(int fromNode, int toNode) {
        adjacency[fromNode].add(toNode);
    }

    public LinkedList<Integer> getAdjacencyAtIndex(int index) {
        return adjacency[index];
    }
}
