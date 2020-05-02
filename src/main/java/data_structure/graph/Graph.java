package data_structure.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
	Scanner scan;
	Vertex[] adjList;
	Boolean isDirected;

	public Graph(String filename) {
		try {
			scan = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Input file not found.");
		}
		createGraph();
	}

	private void createGraph() {
		isDirected = "directed".equals(scan.next());
		adjList = new Vertex[scan.nextInt()];
		readVertices();
		readEdges();
	}

	private void readVertices() {
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new Vertex(scan.next(), null);
		}
	}

	private void readEdges() {
		while (scan.hasNext()) {
			int v1 = indexForName(scan.next());
			int v2 = indexForName(scan.next());

			adjList[v1].setNeighbor(new Neighbor(v2, adjList[v1].getNeighbor()));
			if (!isDirected)
				adjList[v2].setNeighbor(new Neighbor(v1, adjList[v2].getNeighbor()));
		}
	}

	private int indexForName(String name) {
		for (int i = 0; i < adjList.length; i++)
			if (adjList[i].getName().equals(name))
				return i;
		return -1;
	}

	public void print() {
		for (int i = 0; i < adjList.length; i++) {
			System.out.print(adjList[i].getName());
			for (Neighbor nbr = adjList[i].getNeighbor(); nbr != null; nbr = nbr.getNext()) {
				System.out.print(" --> " + adjList[nbr.getVertexNumber()].getName());
			}
			System.out.println();
		}
	}

	/*
	 *  Runtime complexity: 
	 *  O(V + E), when adjacency list is used to represent graph
	 *  O(V * V), when adjacency matrix is used to represent graph
	 *  
	 *  DFS has less memory requirement than BFS 
	 *  as it's not required to store all the child pointers at each level
	 *  
	 *  Application:
	 *  Topological sorting, solving maze problems and search at max. depth
	 */
	public void dfs() {
		boolean[] visited = new boolean[adjList.length];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				dfs(i, visited);
		}
	}

	private void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println(adjList[v].getName());

		for (Neighbor nbr = adjList[v].getNeighbor(); nbr != null; nbr = nbr.getNext()) {
			if (!visited[nbr.getVertexNumber()])
				dfs(nbr.getVertexNumber(), visited);
		}
	}

	/*
	 *  Runtime complexity: 
	 *  O(V + E), when adjacency list is used to represent graph
	 *  O(V * V), when adjacency matrix is used to represent graph
	 *  
	 *  Application:
	 *  Finding shortest path and search at low depth
	 */
	public void bfs() {
		boolean[] visited = new boolean[adjList.length];
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				bfs(i, visited, queue);
		}
	}

	private void bfs(int v, boolean[] visited, Queue<Integer> queue) {
		visited[v] = true;
		queue.offer(v);
		System.out.println(adjList[v].getName());

		while (!queue.isEmpty()) {
			int element = queue.poll();
			for (Neighbor nbr = adjList[element].getNeighbor(); nbr != null; nbr = nbr.getNext()) {
				int vertexNumber = nbr.getVertexNumber();
				if (!visited[vertexNumber]) {
					System.out.println(adjList[vertexNumber].getName());
					visited[vertexNumber] = true;
					queue.offer(vertexNumber);
				}
			}
		}
	}

}
