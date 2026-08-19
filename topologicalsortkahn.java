public class topologicalsortkahn {
	public static int[] topologicalSort(int vertices, int[][] edges) {
		java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();
		int[] indegree = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			graph.add(new java.util.ArrayList<>());
		}

		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			graph.get(from).add(to);
			indegree[to]++;
		}

		java.util.Queue<Integer> queue = new java.util.ArrayDeque<>();
		for (int i = 0; i < vertices; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
        

		int[] order = new int[vertices];
		int count = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			order[count++] = current;

			for (int neighbor : graph.get(current)) {
				if (--indegree[neighbor] == 0) {
					queue.offer(neighbor);
				}
			}
		}

		if (count != vertices) {
			throw new IllegalArgumentException("The graph contains a cycle");
		}
		return order;
	}
}
