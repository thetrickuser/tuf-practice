package graph;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * Question - Find number of connected components in a graph
     * @param V     Total number of vertices
     * @param edges Adjacency matrix
     * @return      Number of connected components in the given graph
     */
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        UndirectedGraph graph = new UndirectedGraph();

        List<Integer>[] adjacencyList = getAdjacencyListFromMatrix(V, edges);
        boolean[] visited = new boolean[V];
        int componentCount = 0;

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                componentCount++;
                graph.bfs(i, adjacencyList, visited);
            }
        }

        return componentCount;
    }

    /**
     * Converts adjacency matrix to adjacency list
     * @param V     Total number of vertices
     * @param edges Adjacency matrix
     * @return      Resulting adjacency matrix
     */
    private static List<Integer>[] getAdjacencyListFromMatrix(int V, List<List<Integer>> edges) {
        int e = edges.size();
        List<Integer>[] adjacencyList = new ArrayList[V];

        for (int i = 0; i< V; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i=0; i<e; i++) {
            adjacencyList[edges.get(i).get(0)].add(edges.get(i).get(1));
            adjacencyList[edges.get(i).get(1)].add(edges.get(i).get(0));
        }

        return adjacencyList;
    }
}
