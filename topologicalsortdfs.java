import java.util.*;

public class topologicalsortdfs {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdges(5, 2);
        graph.addEdges(5, 0);
        graph.addEdges(4, 0);
        graph.addEdges(4, 1);
        graph.addEdges(2, 3);
        graph.addEdges(3, 1);

        System.out.println("Topological sort:");
        graph.topologicalSort();
    }

    static class Graph{
        int vertices;
        List<List<Integer>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();
            for (int i = 0; i< vertices;i++) {
                adjList.add(new ArrayList<>());
            }
        }
        void addEdges(int u, int v) {
            adjList.get(u).add(v);
        }
        void topologicalSort() {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    dfs(i, visited, stack);
                }
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
        void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {
            visited[vertex] = true;
            for (int neighbor : adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited, stack);
                }
            }
            stack.push(vertex);
        }

    }
}
