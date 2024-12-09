package GraphPackage;

import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;

/**
 * Interface for basic graph operations.
 *
 * @param <T> The type of vertex labels (must be unique).
 */
public interface BasicGraphInterface<T> {

    /** Adds a given vertex to this graph. */
    boolean addVertex(T vertexLabel);

    /** Adds a weighted edge between two vertices. */
    boolean addEdge(T begin, T end, double edgeWeight);

    /** Adds an unweighted edge between two vertices. */
    boolean addEdge(T begin, T end);

    /** Sees whether an edge exists between two vertices. */
    boolean hasEdge(T begin, T end);

    /** Sees whether this graph is empty. */
    boolean isEmpty();

    /** Gets the number of vertices in this graph. */
    int getNumberOfVertices();

    /** Gets the number of edges in this graph. */
    int getNumberOfEdges();

    /** Removes all vertices and edges from this graph. */
    void clear();

    /** Performs a breadth-first traversal of this graph. */
    QueueInterface<T> getBreadthFirstTraversal(T origin);

    /** Performs a depth-first traversal of this graph. */
    QueueInterface<T> getDepthFirstTraversal(T origin);

    /** Finds the shortest path between two vertices. */
    int getShortestPath(T begin, T end, StackInterface<T> path);
}
