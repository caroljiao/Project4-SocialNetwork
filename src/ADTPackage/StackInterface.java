package ADTPackage;

/**
 * An interface for a stack data structure.
 *
 * @param <T> The type of elements stored in the stack.
 */
public interface StackInterface<T> {

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry The object to be added to the stack.
     */
    void push(T newEntry);

    /**
     * Removes and returns this stack's top entry.
     *
     * @return The object at the top of the stack, or throws an exception if the stack is empty.
     */
    T pop();

    /**
     * Retrieves this stack's top entry without removing it.
     *
     * @return The object at the top of the stack, or throws an exception if the stack is empty.
     */
    T peek();

    /**
     * Checks whether this stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Removes all entries from this stack.
     */
    void clear();

    /**
     * Returns the number of entries currently in the stack.
     *
     * @return The size of the stack.
     */
    int getSize();
}
