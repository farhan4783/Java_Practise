import java.util.*;  





public class graphList {
    private Map<Integer, List<Integer>> adjacencyList;
    
    public graphList() {
        adjacencyList = new HashMap<>();
    }
    
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }
    
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
    }
    
    public void addUndirectedEdge(int vertex1, int vertex2) {
        addVertex(vertex1);
        addVertex(vertex2);
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }
    
    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }
    
    public void displayGraph() {
        for (int vertex : adjacencyList.keySet()) {
            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }
    
    public void bfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new java.util.LinkedList<>();
        
        queue.add(startVertex);
        visited.add(startVertex);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    
    public void dfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(startVertex, visited);
        System.out.println();
    }
    
    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        graphList graph = new graphList();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 4);

        System.out.println("Graph:");
        graph.displayGraph();

        System.out.println("\nBFS from 1:");
        graph.bfs(1);

        System.out.println("\nDFS from 1:");
        graph.dfs(1);
    }
}
