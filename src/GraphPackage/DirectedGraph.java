package GraphPackage;

import ADTPackage.LinkedQueue;
import ADTPackage.LinkedStack;
import ADTPackage.PriorityQueueInterface;
import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;
import ADTPackage.UnsortedLinkedDictionary;
import ADTPackage.HeapPriorityQueue;

import java.util.Iterator;

/**
 * A class that implements a directed graph using vertices and edges.
 *
 * @param <T> The type of vertex labels (must be unique).
 */
public class DirectedGraph<T> implements GraphInterface<T> {
    private final UnsortedLinkedDictionary<T, VertexInterface<T>> vertices;
    private int edgeCount;

    /**
     * Constructs an empty directed graph.
     */
    public DirectedGraph() {
        vertices = new UnsortedLinkedDictionary<>();
        edgeCount = 0;
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertexLabel The label of the vertex to add.
     * @return {@code true} if the vertex was successfully added, {@code false} otherwise.
     */
    @Override
    public boolean addVertex(T vertexLabel) {
        VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }

    /**
     * Adds an edge from the {@code begin} vertex to the {@code end} vertex with the given weight.
     *
     * @param begin      The label of the starting vertex.
     * @param end        The label of the ending vertex.
     * @param edgeWeight The weight of the edge.
     * @return {@code true} if the edge was successfully added, {@code false} otherwise.
     */
    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);

        if (beginVertex != null && endVertex != null && !beginVertex.hasEdge(endVertex)) {
            boolean result = beginVertex.connect(endVertex, edgeWeight);
            if (result) edgeCount++;
            return result;
        }
        return false;
    }

    /**
     * Adds an edge from the {@code begin} vertex to the {@code end} vertex with a default weight of 0.
     *
     * @param begin The label of the starting vertex.
     * @param end   The label of the ending vertex.
     * @return {@code true} if the edge was successfully added, {@code false} otherwise.
     */
    @Override
    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }

    /**
     * Checks if there is an edge from the {@code begin} vertex to the {@code end} vertex.
     *
     * @param begin The label of the starting vertex.
     * @param end   The label of the ending vertex.
     * @return {@code true} if the edge exists, {@code false} otherwise.
     */
    @Override
    public boolean hasEdge(T begin, T end) {
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);

        if (beginVertex != null && endVertex != null) {
            return beginVertex.hasEdge(endVertex);
        }
        return false;
    }

    /**
     * Removes a vertex from the graph and all edges connected to it.
     *
     * @param vertexLabel The label of the vertex to remove.
     * @return {@code true} if the vertex was successfully removed, {@code false} otherwise.
     */
    @Override
    public boolean removeVertex(T vertexLabel) {
        VertexInterface<T> vertexToRemove = vertices.getValue(vertexLabel);
        if (vertexToRemove == null) {
            return false;
        }

        vertices.remove(vertexLabel);
        edgeCount -= vertexToRemove.getNeighborCount();

        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext()) {
            VertexInterface<T> currentVertex = vertexIterator.next();
            if (currentVertex.disconnect(vertexToRemove)) {
                edgeCount--;
            }
        }
        return true;
    }

    /**
     * Checks if the graph is empty (i.e., it has no vertices).
     *
     * @return {@code true} if the graph is empty, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return The number of vertices in the graph.
     */
    @Override
    public int getNumberOfVertices() {
        return vertices.getSize();
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return The number of edges in the graph.
     */
    @Override
    public int getNumberOfEdges() {
        return edgeCount;
    }

    /**
     * Clears the graph, removing all vertices and edges.
     */
    @Override
    public void clear() {
        vertices.clear();
        edgeCount = 0;
    }

    /**
     * Returns a breadth-first traversal of the graph starting from the specified vertex.
     *
     * @param origin The label of the vertex to start the traversal.
     * @return A queue containing the labels of the vertices in breadth-first order.
     */
    @Override
    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        if (originVertex != null) {
            originVertex.visit();
            traversalOrder.enqueue(origin);
            vertexQueue.enqueue(originVertex);

            while (!vertexQueue.isEmpty()) {
                VertexInterface<T> frontVertex = vertexQueue.dequeue();
                Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

                while (neighbors.hasNext()) {
                    VertexInterface<T> nextNeighbor = neighbors.next();
                    if (!nextNeighbor.isVisited()) {
                        nextNeighbor.visit();
                        traversalOrder.enqueue(nextNeighbor.getLabel());
                        vertexQueue.enqueue(nextNeighbor);
                    }
                }
            }
        }
        return traversalOrder;
    }

    /**
     * Returns a depth-first traversal of the graph starting from the specified vertex.
     *
     * @param origin The label of the vertex to start the traversal.
     * @return A queue containing the labels of the vertices in depth-first order.
     */
    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        if (originVertex != null) {
            originVertex.visit();
            traversalOrder.enqueue(origin);
            vertexStack.push(originVertex);

            while (!vertexStack.isEmpty()) {
                VertexInterface<T> topVertex = vertexStack.peek();
                VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();

                if (nextNeighbor != null) {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexStack.push(nextNeighbor);
                } else {
                    vertexStack.pop();
                }
            }
        }
        return traversalOrder;
    }

    /**
     * Finds the shortest path from the {@code begin} vertex to the {@code end} vertex using breadth-first search.
     *
     * @param begin The label of the starting vertex.
     * @param end   The label of the ending vertex.
     * @param path  A stack to hold the labels of the vertices in the shortest path.
     * @return The number of edges in the shortest path, or {@code -1} if no path exists.
     */
    @Override
    public int getShortestPath(T begin, T end, StackInterface<T> path) {
        resetVertices();
        boolean done = false;

        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
        VertexInterface<T> originVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);

        if (originVertex == null || endVertex == null) {
            return -1;
        }

        originVertex.visit();
        vertexQueue.enqueue(originVertex);

        while (!done && !vertexQueue.isEmpty()) {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

            while (!done && neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited()) {
                    nextNeighbor.visit();
                    nextNeighbor.setPredecessor(frontVertex);
                    vertexQueue.enqueue(nextNeighbor);

                    if (nextNeighbor.equals(endVertex)) {
                        done = true;
                    }
                }
            }
        }

        if (done) {
            int pathLength = 0;
            VertexInterface<T> vertex = endVertex;

            while (vertex != null) {
                path.push(vertex.getLabel());
                vertex = vertex.getPredecessor();
                pathLength++;
            }
            return pathLength - 1;
        }
        return -1;
    }

    /**
     * Finds the cheapest path from the {@code begin} vertex to the {@code end} vertex using Dijkstra's algorithm.
     *
     * @param begin The label of the starting vertex.
     * @param end   The label of the ending vertex.
     * @param path  A stack to hold the labels of the vertices in the cheapest path.
     * @return The total cost of the cheapest path, or {@code -1} if no path exists.
     */
    @Override
    public double getCheapestPath(T begin, T end, StackInterface<T> path) {
        resetVertices();
        boolean done = false;

        PriorityQueueInterface<EntryPQ> priorityQueue = new HeapPriorityQueue<>();
        VertexInterface<T> originVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);

        if (originVertex == null || endVertex == null) {
            return -1;
        }

        priorityQueue.add(new EntryPQ(originVertex, 0, null));

        while (!done && !priorityQueue.isEmpty()) {
            EntryPQ frontEntry = priorityQueue.remove();
            VertexInterface<T> frontVertex = frontEntry.getVertex();

            if (!frontVertex.isVisited()) {
                frontVertex.visit();
                frontVertex.setCost(frontEntry.getCost());
                frontVertex.setPredecessor(frontEntry.getPredecessor());

                if (frontVertex.equals(endVertex)) {
                    done = true;
                } else {
                    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                    Iterator<Double> edgeWeights = frontVertex.getWeightIterator();

                    while (neighbors.hasNext()) {
                        VertexInterface<T> nextNeighbor = neighbors.next();
                        double weight = edgeWeights.next();

                        if (!nextNeighbor.isVisited()) {
                            double nextCost = frontVertex.getCost() + weight;
                            priorityQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
                        }
                    }
                }
            }
        }

        if (done) {
            double pathCost = endVertex.getCost();
            VertexInterface<T> vertex = endVertex;

            while (vertex != null) {
                path.push(vertex.getLabel());
                vertex = vertex.getPredecessor();
            }
            return pathCost;
        }
        return -1;
    }

    /**
     * Resets all vertices to their initial state (unvisited, with no predecessors).
     */
    private void resetVertices() {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext()) {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }

    /**
     * A helper class used for the priority queue in the cheapest path algorithm.
     */
    private class EntryPQ implements Comparable<EntryPQ> {
        private final VertexInterface<T> vertex;
        private final VertexInterface<T> predecessor;
        private final double cost;

        public EntryPQ(VertexInterface<T> vertex, double cost, VertexInterface<T> predecessor) {
            this.vertex = vertex;
            this.predecessor = predecessor;
            this.cost = cost;
        }

        public VertexInterface<T> getVertex() {
            return vertex;
        }

        public double getCost() {
            return cost;
        }

        public VertexInterface<T> getPredecessor() {
            return predecessor;
        }

        @Override
        public int compareTo(EntryPQ otherEntry) {
            return Double.compare(this.cost, otherEntry.cost);
        }
    }
}
