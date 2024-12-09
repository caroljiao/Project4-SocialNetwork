package ADTPackage;

/**
 * An interface for the ADT priority queue.
 */
public interface PriorityQueueInterface<T extends Comparable<? super T>> {
    void add(T newEntry);
    T remove();
    T peek();
    boolean isEmpty();
    int getSize();
    void clear();
}
