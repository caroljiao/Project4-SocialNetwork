package ADTPackage;

import java.util.Iterator;

/**
 * Interface for a queue data structure.
 *
 * @param <T> The type of elements in the queue.
 */
public interface QueueInterface<T> extends Iterable<T> {

    /**
     * Adds a new entry to the back of the queue.
     *
     * @param newEntry The element to be added to the queue.
     */
    void enqueue(T newEntry);

    /**
     * Removes and returns the front entry from the queue.
     *
     * @return The front element in the queue.
     */
    T dequeue();

    /**
     * Retrieves the front entry without removing it.
     *
     * @return The front element in the queue.
     */
    T getFront();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, otherwise false.
     */
    boolean isEmpty();

    /**
     * Clears the queue, removing all elements.
     */
    void clear();

    /**
     * Returns an iterator for traversing the queue.
     *
     * @return An iterator for the queue.
     */
    Iterator<T> getIterator();

    /**
     * Returns the size of the queue.
     *
     * @return The number of elements in the queue.
     */
    int getSize();  // Added this method to return the size of the queue
}
