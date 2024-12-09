package GraphPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class that implements a vertex in a graph.
 *
 * @param <T> The type of the vertex label (must be unique).
 */
public class Vertex<T> implements VertexInterface<T> {
    private final T label;
    private final List<Edge> edgeList;
    private boolean visited;
    private VertexInterface<T> previousVertex;
    private double cost;

    /**
     * Constructs a new vertex with the specified label.
     *
     * @param label The label of the vertex.
     */
    public Vertex(T label) {
        this.label = label;
        this.edgeList = new ArrayList<>();
        this.visited = false;
        this.previousVertex = null;
        this.cost = 0;
    }

    /**
     * Returns the label of this vertex.
     *
     * @return The label of the vertex.
     */
    @Override
    public T getLabel() {
        return label;
    }

    /**
     * Marks this vertex as visited.
     */
    @Override
    public void visit() {
        visited = true;
    }

    /**
     * Marks this vertex as unvisited.
     */
    @Override
    public void unvisit() {
        visited = false;
    }

    /**
     * Checks if this vertex has been visited.
     *
     * @return {@code true} if the vertex has been visited, {@code false} otherwise.
     */
    @Override
    public boolean isVisited() {
        return visited;
    }

    /**
     * Connects this vertex to another vertex with a specified edge weight.
     *
     * @param endVertex   The vertex to connect to.
     * @param edgeWeight  The weight of the edge.
     * @return {@code true} if the edge was successfully added, {@code false} if the edge already exists.
     */
    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
        if (hasEdge(endVertex)) {
            return false;  // Edge already exists
        }
        edgeList.add(new Edge(endVertex, edgeWeight));
        return true;
    }

    /**
     * Connects this vertex to another vertex with a default edge weight of 0.
     *
     * @param endVertex The vertex to connect to.
     * @return {@code true} if the edge was successfully added.
     */
    @Override
    public boolean connect(VertexInterface<T> endVertex) {
        return connect(endVertex, 0);
    }

    /**
     * Checks if this vertex is already connected to the specified vertex.
     *
     * @param endVertex The vertex to check for an edge.
     * @return {@code true} if there is an edge from this vertex to the specified vertex, {@code false} otherwise.
     */
    @Override
    public boolean hasEdge(VertexInterface<T> endVertex) {
        for (Edge edge : edgeList) {
            if (edge.getEndVertex().equals(endVertex)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Disconnects this vertex from the specified vertex by removing the edge.
     *
     * @param endVertex The target vertex to disconnect.
     * @return {@code true} if the edge was removed, {@code false} if no such edge existed.
     */
    @Override
    public boolean disconnect(VertexInterface<T> endVertex) {
        Iterator<Edge> edgeIterator = edgeList.iterator();
        while (edgeIterator.hasNext()) {
            Edge edge = edgeIterator.next();
            if (edge.getEndVertex().equals(endVertex)) {
                edgeIterator.remove();
                return true;  // Edge successfully removed
            }
        }
        return false;  // Edge not found
    }

    /**
     * Returns the number of neighbors (edges) connected to this vertex.
     *
     * @return The number of neighbors.
     */
    @Override
    public int getNeighborCount() {
        return edgeList.size();
    }

    /**
     * Returns an iterator over the neighbors of this vertex.
     *
     * @return An iterator for the neighbors of this vertex.
     */
    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return new NeighborIterator();
    }

    /**
     * Returns an iterator over the weights of edges connected to this vertex.
     *
     * @return An iterator for the edge weights.
     */
    @Override
    public Iterator<Double> getWeightIterator() {
        return new WeightIterator();
    }

    /**
     * Checks if this vertex has any neighbors (edges).
     *
     * @return {@code true} if the vertex has neighbors, {@code false} otherwise.
     */
    @Override
    public boolean hasNeighbor() {
        return !edgeList.isEmpty();
    }

    /**
     * Returns an unvisited neighbor of this vertex, or {@code null} if none exists.
     *
     * @return An unvisited neighbor, or {@code null} if no unvisited neighbors are found.
     */
    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
        while (neighbors.hasNext()) {
            VertexInterface<T> neighbor = neighbors.next();
            if (!neighbor.isVisited()) {
                return neighbor;
            }
        }
        return null;
    }

    /**
     * Sets the predecessor of this vertex.
     *
     * @param predecessor The vertex that precedes this one in a path.
     */
    @Override
    public void setPredecessor(VertexInterface<T> predecessor) {
        this.previousVertex = predecessor;
    }

    /**
     * Returns the predecessor of this vertex.
     *
     * @return The predecessor vertex, or {@code null} if none exists.
     */
    @Override
    public VertexInterface<T> getPredecessor() {
        return previousVertex;
    }

    /**
     * Checks if this vertex has a predecessor.
     *
     * @return {@code true} if the vertex has a predecessor, {@code false} otherwise.
     */
    @Override
    public boolean hasPredecessor() {
        return previousVertex != null;
    }

    /**
     * Sets the cost for this vertex, used in algorithms like Dijkstra's.
     *
     * @param cost The cost value to set.
     */
    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the cost associated with this vertex.
     *
     * @return The cost value.
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     * Iterator for neighbors of this vertex.
     */
    private class NeighborIterator implements Iterator<VertexInterface<T>> {
        private final Iterator<Edge> edges = edgeList.iterator();

        @Override
        public boolean hasNext() {
            return edges.hasNext();
        }

        @Override
        public VertexInterface<T> next() {
            return edges.next().getEndVertex();
        }
    }

    /**
     * Iterator for weights of edges connected to this vertex.
     */
    private class WeightIterator implements Iterator<Double> {
        private final Iterator<Edge> edges = edgeList.iterator();

        @Override
        public boolean hasNext() {
            return edges.hasNext();
        }

        @Override
        public Double next() {
            return edges.next().getWeight();
        }
    }

    /**
     * Represents an edge in the graph, connecting two vertices.
     */
    private class Edge {
        private final VertexInterface<T> vertex;
        private final double weight;

        private Edge(VertexInterface<T> vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        private VertexInterface<T> getEndVertex() {
            return vertex;
        }

        private double getWeight() {
            return weight;
        }
    }
}
