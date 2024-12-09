import GraphPackage.Vertex;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Vertex class, which represents a vertex in a graph.
 * This class contains methods to test the basic functionality of the Vertex class, including
 * connectivity, visiting, and setting properties like cost and predecessor.
 */
class VertexTest {

    /**
     * Sets up a new instance of the Vertex class before each test case.
     * This method is annotated with @BeforeEach to ensure it runs before each individual test.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Initialization can be done here if required for each test.
    }

    /**
     * Tests the getLabel method of the Vertex class.
     * Ensures that the label of the vertex is returned correctly.
     */
    @org.junit.jupiter.api.Test
    void getLabel() {
        Vertex<String> vertex = new Vertex<>("A");
        assertEquals("A", vertex.getLabel());
    }

    /**
     * Tests the visit method of the Vertex class.
     * Ensures that after visiting the vertex, the isVisited method returns true.
     */
    @org.junit.jupiter.api.Test
    void visit() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.visit();
        assertTrue(vertex.isVisited());
    }

    /**
     * Tests the unvisit method of the Vertex class.
     * Ensures that after unvisiting the vertex, the isVisited method returns false.
     */
    @org.junit.jupiter.api.Test
    void unvisit() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.visit();
        vertex.unvisit();
        assertFalse(vertex.isVisited());
    }

    /**
     * Tests the connect method of the Vertex class.
     * Ensures that two vertices can be connected and that the connection is established.
     */
    @org.junit.jupiter.api.Test
    void connect() {
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        assertTrue(vertex1.connect(vertex2, 10));  // Test the connection with weight
        assertTrue(vertex1.hasEdge(vertex2));     // Verify that the edge exists
    }

    /**
     * Tests the disconnect method of the Vertex class.
     * Ensures that the connection between two vertices can be removed.
     */
    @org.junit.jupiter.api.Test
    void disconnect() {
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        vertex1.connect(vertex2, 10);
        vertex1.disconnect(vertex2);
        assertFalse(vertex1.hasEdge(vertex2));  // Verify that the edge is removed
    }

    /**
     * Tests the getNeighborCount method of the Vertex class.
     * Ensures that the number of neighbors connected to a vertex is returned correctly.
     */
    @org.junit.jupiter.api.Test
    void getNeighborCount() {
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        vertex1.connect(vertex2, 10);
        assertEquals(1, vertex1.getNeighborCount());  // Should have one neighbor
    }

    /**
     * Tests the getUnvisitedNeighbor method of the Vertex class.
     * Ensures that the correct unvisited neighbor is returned.
     */
    @org.junit.jupiter.api.Test
    void getUnvisitedNeighbor() {
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        Vertex<String> vertex3 = new Vertex<>("C");
        vertex1.connect(vertex2);
        vertex1.connect(vertex3);
        vertex2.visit();  // Mark vertex2 as visited
        assertEquals(vertex3, vertex1.getUnvisitedNeighbor());  // Should return the unvisited neighbor (vertex3)
    }

    /**
     * Tests the setPredecessor method of the Vertex class.
     * Ensures that the predecessor of a vertex is correctly set.
     */
    @org.junit.jupiter.api.Test
    void setPredecessor() {
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        vertex2.setPredecessor(vertex1);
        assertEquals(vertex1, vertex2.getPredecessor());  // Should return vertex1 as predecessor
    }

    /**
     * Tests the setCost method of the Vertex class.
     * Ensures that the cost of a vertex can be set and retrieved correctly.
     */
    @org.junit.jupiter.api.Test
    void setCost() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.setCost(10.5);
        assertEquals(10.5, vertex.getCost());  // Should return the correct cost
    }
}
