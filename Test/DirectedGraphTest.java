import ADTPackage.LinkedQueue;
import ADTPackage.LinkedStack;
import ADTPackage.StackInterface;
import ADTPackage.QueueInterface;
import GraphPackage.DirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the DirectedGraph class, which tests basic graph operations.
 */
class DirectedGraphTest {

    private DirectedGraph<String> graph;

    /**
     * Sets up the graph before each test case.
     * This method is annotated with @BeforeEach to ensure it's called before each test.
     */
    @BeforeEach
    void setUp() {
        graph = new DirectedGraph<>();
    }

    /**
     * Tests adding a vertex to the graph.
     * It ensures that a vertex can be added only once.
     */
    @Test
    void addVertex() {
        assertTrue(graph.addVertex("A"));
        assertFalse(graph.addVertex("A"));  // Should fail if trying to add the same vertex
    }

    /**
     * Tests adding an edge between two vertices.
     * Ensures that an edge can be added only once.
     */
    @Test
    void addEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B", 10.0));  // Should add the edge successfully
        assertFalse(graph.addEdge("A", "B", 10.0));  // Should fail if the edge already exists
    }

    /**
     * Tests adding an edge with the default weight.
     * Ensures that an edge can be added with a default weight of 0.
     */
    @Test
    void testAddEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B"));  // Should add the edge with default weight
    }

    /**
     * Tests checking if an edge exists between two vertices.
     * Ensures the method properly checks for the presence of edges in the graph.
     */
    @Test
    void hasEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 10.0);
        assertTrue(graph.hasEdge("A", "B"));  // Edge should exist
        assertFalse(graph.hasEdge("B", "A"));  // Reverse edge should not exist
    }

    /**
     * Tests removing a vertex from the graph.
     * Ensures that removing a vertex also removes its associated edges.
     */
    @Test
    void removeVertex() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 10.0);
        assertTrue(graph.removeVertex("A"));  // Should return true if vertex A is removed
        assertFalse(graph.hasEdge("A", "B"));  // Edge should be removed
    }

    /**
     * Tests checking if the graph is empty.
     * Ensures that the graph is initially empty and becomes non-empty after adding a vertex.
     */
    @Test
    void isEmpty() {
        assertTrue(graph.isEmpty());  // Should be empty initially
        graph.addVertex("A");
        assertFalse(graph.isEmpty());  // Should not be empty after adding a vertex
    }

    /**
     * Tests getting the number of vertices in the graph.
     * Ensures that the number of vertices is correctly updated after adding or removing vertices.
     */
    @Test
    void getNumberOfVertices() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertEquals(2, graph.getNumberOfVertices());
        graph.removeVertex("A");
        assertEquals(1, graph.getNumberOfVertices());
    }

    /**
     * Tests getting the number of edges in the graph.
     * Ensures that the number of edges is correctly updated after adding or removing edges.
     */
    @Test
    void getNumberOfEdges() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 10.0);
        assertEquals(1, graph.getNumberOfEdges());
        graph.removeVertex("A");
        assertEquals(0, graph.getNumberOfEdges());
    }

    /**
     * Tests clearing the graph.
     * Ensures that the graph is empty after the clear operation.
     */
    @Test
    void clear() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.clear();
        assertTrue(graph.isEmpty());  // Should be empty after clear
    }

    /**
     * Tests the breadth-first traversal of the graph.
     * Ensures that the traversal returns the vertices in the correct order.
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
     * Tests the depth-first traversal of the graph.
     * Ensures that the traversal returns the vertices in the correct order.
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
     * Tests getting the shortest path between two vertices.
     * Ensures that the correct path length is returned for the shortest path.
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
     * Tests getting the cheapest path between two vertices.
     * Ensures that the correct cost is returned for the cheapest path.
     */
    @Test
    void getCheapestPath() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 1.0);
        graph.addEdge("B", "C", 2.0);

        StackInterface<String> path = new LinkedStack<>();
        double cost = graph.getCheapestPath("A", "C", path);
        assertEquals(3.0, cost);  // The cheapest path cost should be 3.0 (A -> B -> C)
    }

    /**
     * Tests the traversal size.
     * Ensures that the size of the traversal is correctly calculated.
     */
    @Test
    void testTraversalSize() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        QueueInterface<String> traversal = graph.getBreadthFirstTraversal("A");
        assertEquals(2, traversal.getSize());  // Example: expecting size 2
    }
}
