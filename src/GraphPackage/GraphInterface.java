package GraphPackage;

import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;

/**
 * Interface for a graph structure that supports directed and undirected graphs.
 *
 * @param <T> The type of vertex labels (must be unique).
 */
public interface GraphInterface<T> {

    /**
     * Adds a given vertex to this graph.
     *
     * @param vertexLabel The label of the vertex to be added.
     * @return True if the vertex was successfully added, false otherwise.
     */
    boolean addVertex(T vertexLabel);

    /**
     * Adds a weighted edge between two given vertices.
     *
     * @param begin      The starting vertex.
     * @param end        The ending vertex.
     * @param edgeWeight The weight of the edge.
     * @return True if the edge was successfully added, false otherwise.
     */
    boolean addEdge(T begin, T end, double edgeWeight);

    /**
     * Adds an unweighted edge between two given vertices.
     *
     * @param begin The starting vertex.
     * @param end   The ending vertex.
     * @return True if the edge was successfully added, false otherwise.
     */
    boolean addEdge(T begin, T end);

    /**
     * Sees whether an edge exists between two given vertices.
     *
     * @param begin The starting vertex.
     * @param end   The ending vertex.
     * @return True if the edge exists, false otherwise.
     */
    boolean hasEdge(T begin, T end);

    /**
     * Removes a given vertex and all edges associated with it.
     *
     * @param vertexLabel The label of the vertex to remove.
     * @return True if the vertex was successfully removed, false otherwise.
     */
    boolean removeVertex(T vertexLabel);

    /**
     * Checks whether this graph is empty.
     *
     * @return True if the graph is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the number of vertices in this graph.
     *
     * @return The number of vertices in the graph.
     */
    int getNumberOfVertices();

    /**
     * Gets the number of edges in this graph.
     *
     * @return The number of edges in the graph.
     */
    int getNumberOfEdges();

    /**
     * Removes all vertices and edges from this graph.
     */
    void clear();

    /**
     * Performs a breadth-first traversal of this graph starting from the given vertex.
     *
     * @param origin The starting vertex label.
     * @return A queue containing the vertices in traversal order.
     */
    QueueInterface<T> getBreadthFirstTraversal(T origin);

    /**
     * Performs a depth-first traversal of this graph starting from the given vertex.
     *
     * @param origin The starting vertex label.
     * @return A queue containing the vertices in traversal order.
     */
    QueueInterface<T> getDepthFirstTraversal(T origin);

    /**
     * Finds the shortest path between two vertices using BFS.
     *
     * @param begin The starting vertex.
     * @param end   The ending vertex.
     * @param path  A stack to store the path from start to end.
     * @return The length of the shortest path or -1 if no path exists.
     */
    int getShortestPath(T begin, T end, StackInterface<T> path);

    /**
     * Finds the least-cost path between two vertices using Dijkstra's algorithm.
     *
     * @param begin The starting vertex.
     * @param end   The ending vertex.
     * @param path  A stack to store the least-cost path.
     * @return The cost of the cheapest path or -1 if no path exists.
     */
    double getCheapestPath(T begin, T end, StackInterface<T> path);
}
