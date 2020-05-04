package data_structure.graph.vertex;

/**
 * Degree of a vertex is the number of edges incident on it.
 * Max. number of edges could be n*(n-1) in directed and (n*(n-1))/2 in undirected graphs.
 */
public class Vertex {

	private String name;
	private Neighbor neighbor;

	public Vertex(String name, Neighbor neighbor) {
		this.name = name;
		this.neighbor = neighbor;
	}

	public String getName() {
		return name;
	}

	public Neighbor getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(Neighbor neighbor) {
		this.neighbor = neighbor;
	}

}
