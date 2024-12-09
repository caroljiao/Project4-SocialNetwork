import ADTPackage.LinkedQueue;
import ADTPackage.LinkedStack;
import ADTPackage.StackInterface;
import ADTPackage.QueueInterface;
import GraphPackage.UndirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the UndirectedGraph class, which represents an undirected graph and provides graph-related operations.
 */
class UndirectedGraphTest {

    private UndirectedGraph<String> graph;

    /**
     * Sets up a new undirected graph instance before each test case.
     * This method is annotated with @BeforeEach to ensure it runs before each individual test.
     */
    @BeforeEach
    void setUp() {
        graph = new UndirectedGraph<>();
    }

    /**
     * Tests the addEdge method of the UndirectedGraph class with custom weights.
     * Ensures that edges can be added in both directions and with a specified weight.
     */
    @Test
    void addEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B", 10.0));  // Should add the edge in both directions
        assertTrue(graph.addEdge("B", "A", 10.0));  // Undirected, so adding reverse should also work
    }

    /**
     * Tests the addEdge method of the UndirectedGraph class with default weights (0).
     * Ensures that edges can be added in both directions with the default weight.
     */
    @Test
    void testAddEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B"));  // Should add the edge with default weight (0)
        assertTrue(graph.addEdge("B", "A"));  // Reverse direction should also be handled
    }

    /**
     * Tests the removeVertex method of the UndirectedGraph class.
     * Ensures that a vertex can be removed from the graph and that its edges are also removed.
     */
    @Test
    void removeVertex() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 10.0);
        assertTrue(graph.removeVertex("A"));  // Should return true when removing vertex A
        assertFalse(graph.hasEdge("A", "B"));  // Should no longer have edge after removing vertex A
    }

    /**
     * Tests the getShortestPath method of the UndirectedGraph class.
     * Ensures that the shortest path between two vertices is calculated correctly.
     */
    @Test
    void getShortestPath() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 1.0);
        graph.addEdge("B", "C", 1.0);

        StackInterface<String> path = new LinkedStack<>();
        int pathLength = graph.getShortestPath("A", "C", path);
        assertEquals(1, pathLength);  // Path length should be 1 (A -> B -> C)
    }

    /**
     * Tests the getBreadthFirstTraversal method of the UndirectedGraph class.
     * Ensures that a breadth-first traversal returns the correct order of vertices.
     */
    @Test
    void getBreadthFirstTraversal() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 10.0);
        graph.addEdge("B", "C", 5.0);

        QueueInterface<String> traversal = graph.getBreadthFirstTraversal("A");
        assertEquals(3, traversal.getSize());
        assertEquals("A", traversal.dequeue());
        assertEquals("B", traversal.dequeue());
        assertEquals("C", traversal.dequeue());
    }

    /**
     * Tests the getDepthFirstTraversal method of the UndirectedGraph class.
     * Ensures that a depth-first traversal returns the correct order of vertices.
     */
    @Test
    void getDepthFirstTraversal() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 10.0);
        graph.addEdge("B", "C", 5.0);

        QueueInterface<String> traversal = graph.getDepthFirstTraversal("A");
        assertEquals(3, traversal.getSize());
        assertEquals("A", traversal.dequeue());
        assertEquals("B", traversal.dequeue());
        assertEquals("C", traversal.dequeue());
    }

    /**
     * Tests the getNumberOfEdges method of the UndirectedGraph class.
     * Ensures that the correct number of edges is counted, considering the undirected nature of the graph.
     */
    @Test
    void getNumberOfEdges() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 1.0);
        graph.addEdge("B", "C", 2.0);

        assertEquals(2, graph.getNumberOfEdges());  // Two edges, but undirected, so this should be divided by 2
    }

    /**
     * Tests the getTopologicalOrder method of the UndirectedGraph class.
     * Ensures that an exception is thrown, as undirected graphs do not support topological sorting.
     */
    @Test
    void getTopologicalOrder() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            graph.getTopologicalOrder();  // Should throw exception since undirected graphs don't support topological sort
        });
        assertEquals("Topological sort is not allowed in an undirected graph.", exception.getMessage());
    }
}
