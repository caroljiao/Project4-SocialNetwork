package ADTPackage;

import java.util.PriorityQueue;

/**
 * A priority queue implementation using Java's built-in {@link PriorityQueue}.
 *
 * This implementation uses a min-heap by default because Java's PriorityQueue is a min-heap.
 * It supports basic operations such as adding, removing, and peeking at the highest-priority element.
 *
 * @param <T> The type of elements stored in the priority queue, which must implement {@link Comparable}.
 */
public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
    private final PriorityQueue<T> priorityQueue;

    /**
     * Default constructor initializes an empty priority queue.
     */
    public HeapPriorityQueue() {
        priorityQueue = new PriorityQueue<>();
    }

    /**
     * Adds a new entry to the priority queue.
     *
     * @param newEntry The entry to add.
     */
    @Override
    public void add(T newEntry) {
        priorityQueue.add(newEntry);
    }

    /**
     * Removes and returns the element with the highest priority from the queue.
     *
     * @return The element with the highest priority, or {@code null} if the queue is empty.
     */
    @Override
    public T remove() {
        return priorityQueue.poll();
    }

    /**
     * Retrieves, but does not remove, the element with the highest priority.
     *
     * @return The element with the highest priority, or {@code null} if the queue is empty.
     */
    @Override
    public T peek() {
        return priorityQueue.peek();
    }

    /**
     * Checks whether the priority queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    /**
     * Gets the size of the priority queue.
     *
     * @return The number of elements in the queue.
     */
    @Override
    public int getSize() {
        return priorityQueue.size();
    }

    /**
     * Clears the priority queue by removing all elements.
     */
    @Override
    public void clear() {
        priorityQueue.clear();
    }
}
