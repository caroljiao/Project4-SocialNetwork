package ADTPackage;

/**
 * An interface for the ADT max heap.
 *
 * @param <T> The type of elements stored in the max heap (must be comparable).
 */
public interface MaxHeapInterface<T extends Comparable<? super T>> {

    /**
     * Adds a new entry to this max heap.
     *
     * @param newEntry The entry to add.
     */
    void add(T newEntry);

    /**
     * Removes and returns the maximum element from the max heap.
     *
     * @return The maximum element, or {@code null} if the heap is empty.
     */
    T removeMax();

    /**
     * Retrieves the maximum element without removing it.
     *
     * @return The maximum element, or {@code null} if the heap is empty.
     */
    T getMax();

    /**
     * Checks if the max heap is empty.
     *
     * @return {@code true} if the heap is empty, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the current size of the max heap.
     *
     * @return The number of elements in the heap.
     */
    int getSize();

    /**
     * Removes all elements from the max heap.
     */
    void clear();
}
