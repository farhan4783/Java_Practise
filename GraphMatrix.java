

public class GraphMatrix {
	private final int[][] matrix;
	private final int vertices;

	public GraphMatrix(int vertices) {
		if (vertices < 0) {
			throw new IllegalArgumentException("Number of vertices cannot be negative");
		}
		this.vertices = vertices;
		this.matrix = new int[vertices][vertices];
	}

	public void addEdge(int source, int destination) {
		validateVertex(source);
		validateVertex(destination);
		matrix[source][destination] = 1;
		matrix[destination][source] = 1;
	}

	public void removeEdge(int source, int destination) {
		validateVertex(source);
		validateVertex(destination);
		matrix[source][destination] = 0;
		matrix[destination][source] = 0;
	}

	public boolean hasEdge(int source, int destination) {
		validateVertex(source);
		validateVertex(destination);
		return matrix[source][destination] == 1;
	}

	public void printMatrix() {
		for (int[] row : matrix) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	private void validateVertex(int vertex) {
		if (vertex < 0 || vertex >= vertices) {
			throw new IndexOutOfBoundsException("Invalid vertex: " + vertex);
		}
	}
}
