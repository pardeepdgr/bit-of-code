package graph;

public class Neighbor {

	private int vertexNumber;
	private Neighbor next;

	public Neighbor(int vertexNumber, Neighbor next) {
		this.vertexNumber = vertexNumber;
		this.next = next;
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public Neighbor getNext() {
		return next;
	}

}
