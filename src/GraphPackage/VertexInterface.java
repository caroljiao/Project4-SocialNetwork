package GraphPackage;

import java.util.Iterator;

/**
 * Interface for a vertex in a graph.
 *
 * @param <T> The type of the vertex label (must be unique).
 */
public interface VertexInterface<T> {

    /**
     * Returns the label of this vertex.
     *
     * @return The label of the vertex.
     */
    T getLabel();

    /**
     * Marks this vertex as visited.
     */
    void visit();

    /**
     * Marks this vertex as unvisited.
     */
    void unvisit();

    /**
     * Checks if this vertex has been visited.
     *
     * @return {@code true} if the vertex has been visited, {@code false} otherwise.
     */
    boolean isVisited();

    /**
     * Connects this vertex to another vertex with a specified edge weight.
     *
     * @param endVertex   The vertex to connect to.
     * @param edgeWeight  The weight of the edge.
     * @return {@code true} if the edge was successfully added, {@code false} if the edge already exists.
     */
    boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    /**
     * Connects this vertex to another vertex with a default edge weight of 0.
     *
     * @param endVertex The vertex to connect to.
     * @return {@code true} if the edge was successfully added.
     */
    boolean connect(VertexInterface<T> endVertex);

    /**
     * Disconnects this vertex from the specified vertex by removing the edge.
     *
     * @param endVertex The target vertex to disconnect.
     * @return {@code true} if the edge was removed, {@code false} if no such edge existed.
     */
    boolean disconnect(VertexInterface<T> endVertex);

    /**
     * Returns an iterator over the neighbors of this vertex.
     *
     * @return An iterator for the neighbors of this vertex.
     */
    Iterator<VertexInterface<T>> getNeighborIterator();

    /**
     * Returns an iterator over the weights of edges connected to this vertex.
     *
     * @return An iterator for the edge weights.
     */
    Iterator<Double> getWeightIterator();

    /**
     * Checks if this vertex has any neighbors (edges).
     *
     * @return {@code true} if the vertex has neighbors, {@code false} otherwise.
     */
    boolean hasNeighbor();

    /**
     * Returns an unvisited neighbor of this vertex, or {@code null} if none exists.
     *
     * @return An unvisited neighbor, or {@code null} if no unvisited neighbors are found.
     */
    VertexInterface<T> getUnvisitedNeighbor();

    /**
     * Sets the predecessor of this vertex.
     *
     * @param predecessor The vertex that precedes this one in a path.
     */
    void setPredecessor(VertexInterface<T> predecessor);

    /**
     * Returns the predecessor of this vertex.
     *
     * @return The predecessor vertex, or {@code null} if none exists.
     */
    VertexInterface<T> getPredecessor();

    /**
     * Checks if this vertex has a predecessor.
     *
     * @return {@code true} if the vertex has a predecessor, {@code false} otherwise.
     */
    boolean hasPredecessor();

    /**
     * Sets the cost for this vertex, used in algorithms like Dijkstra's.
     *
     * @param newCost The cost value to set.
     */
    void setCost(double newCost);

    /**
     * Returns the cost associated with this vertex.
     *
     * @return The cost value.
     */
    double getCost();

    /**
     * Checks if there is an edge from this vertex to the specified vertex.
     *
     * @param endVertex The vertex to check for an edge.
     * @return {@code true} if an edge exists, {@code false} otherwise.
     */
    boolean hasEdge(VertexInterface<T> endVertex);

    /**
     * Returns the number of neighbors (edges) connected to this vertex.
     *
     * @return The number of neighbors.
     */
    int getNeighborCount();
}
