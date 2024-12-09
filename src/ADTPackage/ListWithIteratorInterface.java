package ADTPackage;

import java.util.Iterator;

/**
 * An interface for a list that has an iterator.
 *
 * @param <T> The type of elements in the list.
 */
public interface ListWithIteratorInterface<T> extends Iterable<T> {
    /**
     * Adds a new entry to the end of the list.
     *
     * @param newEntry The object to be added.
     */
    void add(T newEntry);

    /**
     * Adds a new entry at a specific position in the list.
     *
     * @param newPosition The position where the new entry will be added.
     * @param newEntry    The object to be added.
     */
    void add(int newPosition, T newEntry);

    /**
     * Removes an entry from the list at a specific position.
     *
     * @param givenPosition The position of the entry to remove.
     * @return The removed entry.
     */
    T remove(int givenPosition);

    /**
     * Removes all entries from the list.
     */
    void clear();

    /**
     * Replaces an entry at a specific position in the list.
     *
     * @param givenPosition The position of the entry to replace.
     * @param newEntry      The new entry to set.
     * @return The original entry that was replaced.
     */
    T replace(int givenPosition, T newEntry);

    /**
     * Retrieves an entry from a specific position in the list.
     *
     * @param givenPosition The position of the entry to retrieve.
     * @return The entry at the given position.
     */
    T getEntry(int givenPosition);

    /**
     * Retrieves all entries in the list as an array.
     *
     * @return An array containing all entries.
     */
    T[] toArray();

    /**
     * Checks whether the list contains a specific entry.
     *
     * @param anEntry The object to search for.
     * @return True if the list contains the entry, false otherwise.
     */
    boolean contains(T anEntry);

    /**
     * Retrieves the number of entries in the list.
     *
     * @return The number of entries.
     */
    int getLength();

    /**
     * Checks whether the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Creates an iterator for the list.
     *
     * @return An iterator that provides sequential access to the list's elements.
     */
    Iterator<T> getIterator();
}
