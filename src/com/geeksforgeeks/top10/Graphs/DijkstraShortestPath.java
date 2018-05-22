package com.geeksforgeeks.top10.Graphs;


/*Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph.

http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
https://www.youtube.com/watch?v=lAXZGERcDf4*/

public class DijkstraShortestPath {

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4,  0, 0,  0,  0,  0, 8,  0},
                                    {4, 0,  8, 0,  0,  0,  0, 11, 0},
                                    {0, 8,  0, 7,  0,  4,  0, 0,  2},
                                    {0, 0,  7, 0,  9,  14, 0, 0,  0},
                                    {0, 0,  0, 9,  0,  10, 0, 0,  0},
                                    {0, 0,  4, 14, 10, 0,  2, 0,  0},
                                    {0, 0,  0, 0,  0,  2,  0, 1,  6},
                                    {8, 11, 0, 0,  0,  0,  1, 0,  7},
                                    {0, 0,  2, 0,  0,  0,  6, 7,  0}
        };



    }
}
