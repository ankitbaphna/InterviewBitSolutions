package com.geeksforgeeks.top10.Graphs;

import java.util.Iterator;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Graphs g = new Graphs(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        boolean[] visited = new boolean[4]; //4 is number of nodes
        DFS(g, 2, 4, visited);
    }

    private static void DFS(Graphs g, int staringNode, int numberOfNodes, boolean[] visited) {

        visited[staringNode] = true;
        System.out.println("thisNode = " + staringNode);

        Iterator<Integer> iterator = g.getAdjacencyAtIndex(staringNode).listIterator();

        while (iterator.hasNext()) {
            int thisNode = iterator.next();
            if (!visited[thisNode]) {
                DFS(g, thisNode, numberOfNodes, visited);
            }
        }
    }
}
