import GraphPackage.UndirectedGraph;
import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;
import ADTPackage.LinkedStack;

/**
 * Driver2: Tests graph functionalities including vertex addition, edge creation,
 * breadth-first traversal, depth-first traversal, and shortest path calculations.
 */
public class Driver2 {
    public static void main(String[] args) {
        System.out.println("==== Graph Functionality Testing ====");

        // Create an undirected graph
        UndirectedGraph<String> graph = new UndirectedGraph<>();

        // Test adding vertices
        System.out.println("\nAdding vertices...");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        System.out.println("Vertices added: " + graph.getNumberOfVertices());

        // Test adding edges
        System.out.println("\nAdding edges...");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        System.out.println("Edges added: " + graph.getNumberOfEdges());

        // Test Breadth-First Traversal
        System.out.println("\nBreadth-First Traversal (starting from A):");
        QueueInterface<String> bfsTraversal = graph.getBreadthFirstTraversal("A");
        displayTraversal(bfsTraversal);

        // Test Depth-First Traversal
        System.out.println("\nDepth-First Traversal (starting from A):");
        QueueInterface<String> dfsTraversal = graph.getDepthFirstTraversal("A");
        displayTraversal(dfsTraversal);

        // Test Shortest Path
        System.out.println("\nFinding shortest path from A to E:");
        StackInterface<String> path = new LinkedStack<>();
        int pathLength = graph.getShortestPath("A", "E", path);

        if (pathLength != -1) {
            System.out.println("Shortest path length: " + pathLength);
            displayPath(path);
        } else {
            System.out.println("No path found.");
        }
    }

    private static void displayTraversal(QueueInterface<String> traversal) {
        while (!traversal.isEmpty()) {
            System.out.print(traversal.dequeue() + " ");
        }
        System.out.println();
    }

    private static void displayPath(StackInterface<String> path) {
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
        System.out.println();
    }
}
