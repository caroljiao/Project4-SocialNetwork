package GraphPackage;

import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;

/**
 * A class that implements an undirected graph by extending DirectedGraph.
 *
 * @param <T> The type of vertex labels (must be unique).
 */
public class UndirectedGraph<T> extends DirectedGraph<T> {

    /**
     * Default constructor for an undirected graph.
     */
    public UndirectedGraph() {
        super();
    }

    /**
     * Adds a weighted edge between two vertices in both directions.
     */
    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean addedFirst = super.addEdge(begin, end, edgeWeight);
        boolean addedSecond = super.addEdge(end, begin, edgeWeight);
        return addedFirst && addedSecond;
    }

    /**
     * Adds an unweighted edge between two vertices in both directions.
     */
    @Override
    public boolean addEdge(T begin, T end) {
        return this.addEdge(begin, end, 0);  // Default weight is 0
    }

    /**
     * Removes a vertex from the graph and all its connecting edges.
     */
    @Override
    public boolean removeVertex(T vertexLabel) {
        return super.removeVertex(vertexLabel);
    }

    /**
     * Finds the shortest path between two vertices using BFS.
     */
    @Override
    public int getShortestPath(T begin, T end, StackInterface<T> path) {
        return super.getShortestPath(begin, end, path);
    }

    /**
     * Performs a breadth-first traversal starting from the given vertex label.
     */
    @Override
    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        return super.getBreadthFirstTraversal(origin);
    }

    /**
     * Performs a depth-first traversal starting from the given vertex label.
     */
    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        return super.getDepthFirstTraversal(origin);
    }

    /**
     * Corrects the edge count for an undirected graph by dividing by 2.
     */
    @Override
    public int getNumberOfEdges() {
        return super.getNumberOfEdges() / 2;
    }

    /**
     * Throws an exception because topological sorting is not supported.
     */
    //@Override
    public StackInterface<T> getTopologicalOrder() {
        throw new UnsupportedOperationException("Topological sort is not allowed in an undirected graph.");
    }
}
