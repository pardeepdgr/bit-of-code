package graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Non-numeric sort which is only applicable for Directed Acyclic Graph
 * Application: Build System
 */
public class TopologicalSort {

	private Vertex[] adjList;

	public void sort(Graph graph) {
		adjList = graph.getAdjacencyList();
		Deque<Vertex> stack = new ArrayDeque<Vertex>();
		boolean[] visited = new boolean[adjList.length];

		for (int v = 0; v < visited.length; v++) {
			if (!visited[v])
				sort(v, stack, visited);
		}
		while (stack.peekFirst() != null) {
			System.out.println(stack.pollFirst().getName());
		}
	}

	private void sort(int v, Deque<Vertex> stack, boolean[] visited) {
		visited[v] = true;
		for (Neighbor nbr = adjList[v].getNeighbor(); nbr != null; nbr = nbr.getNext()) {
			if (!visited[nbr.getVertexNumber()])
				sort(nbr.getVertexNumber(), stack, visited);
		}
		stack.offerFirst(adjList[v]);
	}
}
