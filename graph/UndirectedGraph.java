package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class provides algorithms to solve question based on UndirectedGraphs
 */
public class UndirectedGraph {

    /**
     * Breadth First Search algorithm for traversing an undirected graph
     * @param startNode     Node to start BFS from
     * @param adjacencyList Graph represented in form of adjacencyList
     * @param visited       Boolean array visited to keep track of already visited nodes
     */
    public void bfs(int startNode, List<Integer>[] adjacencyList, boolean[] visited) {
        visited[startNode] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbour: adjacencyList[currentNode]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    /**
     * Depth First Search algorithm for traversing an undirected graph
     * @param startNode     Node to start BFS from
     * @param adjacencyList Graph represented in form of adjacencyList
     * @param visited       Boolean array visited to keep track of already visited nodes
     */
    public void dfs(int startNode, List<Integer>[] adjacencyList, boolean[] visited) {
        visited[startNode] = true;

        for (int neighbour: adjacencyList[startNode]) {
            if (!visited[neighbour]) {
                dfs(neighbour, adjacencyList, visited);
            }
        }
    }
}
