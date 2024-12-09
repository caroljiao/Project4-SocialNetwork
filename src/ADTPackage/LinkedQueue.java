package ADTPackage;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A linked list-based implementation of a queue.
 * This queue supports common operations such as enqueue, dequeue, and checking if the queue is empty.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class LinkedQueue<T> implements QueueInterface<T> {
    private final LinkedList<T> queue;  // Linked list to hold the elements in the queue

    /**
     * Constructs an empty LinkedQueue.
     */
    public LinkedQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Adds a new entry to the back of the queue.
     *
     * @param newEntry The element to be added to the queue.
     */
    @Override
    public void enqueue(T newEntry) {
        queue.addLast(newEntry);
    }

    /**
     * Removes and returns the front entry of the queue.
     *
     * @return The front entry of the queue, or null if the queue is empty.
     */
    @Override
    public T dequeue() {
        return queue.isEmpty() ? null : queue.removeFirst();
    }

    /**
     * Retrieves the front entry without removing it.
     *
     * @return The front entry of the queue, or null if the queue is empty.
     */
    @Override
    public T getFront() {
        return queue.peekFirst();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Clears all entries from the queue.
     */
    @Override
    public void clear() {
        queue.clear();
    }

    /**
     * Returns an iterator for traversing the queue.
     *
     * @return An iterator for the queue.
     */
    @Override
    public Iterator<T> getIterator() {
        return queue.iterator();
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return The size of the queue.
     */
    @Override
    public int getSize() {
        return queue.size();
    }

    /**
     * Returns an iterator for the queue, equivalent to {@link #getIterator()}.
     *
     * @return An iterator for the queue.
     */
    @Override
    public Iterator<T> iterator() {
        return getIterator();  // Use the custom iterator method
    }
}
