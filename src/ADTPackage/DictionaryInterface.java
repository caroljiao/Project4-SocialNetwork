package ADTPackage;

import java.util.Iterator;

/**
 * An interface for a dictionary with distinct search keys.
 *
 * @param <K> The type of keys maintained by this dictionary
 * @param <V> The type of values mapped to keys
 */
public interface DictionaryInterface<K, V> {

    /**
     * Adds a new entry to this dictionary. If the given search key already exists
     * in the dictionary, it replaces the corresponding value.
     *
     * @param key   An object search key of the new entry.
     * @param value An object associated with the search key.
     * @return Either null if the new entry was added to the dictionary, or the
     *         value that was associated with the key if it was replaced.
     */
    V add(K key, V value);

    /**
     * Removes a specific entry from this dictionary.
     *
     * @param key An object search key of the entry to be removed.
     * @return Either the value that was associated with the search key or null if
     *         no such object exists.
     */
    V remove(K key);

    /**
     * Retrieves the value associated with a given search key.
     *
     * @param key An object search key of the entry to be retrieved.
     * @return Either the value associated with the search key, or null if no such
     *         object exists.
     */
    V getValue(K key);

    /**
     * Checks whether a specific entry is in this dictionary.
     *
     * @param key An object search key of the desired entry.
     * @return True if the key is associated with an entry in the dictionary.
     */
    boolean contains(K key);

    /**
     * Creates an iterator that traverses all search keys in this dictionary.
     *
     * @return An iterator that provides sequential access to the search keys in
     *         the dictionary.
     */
    Iterator<K> getKeyIterator();

    /**
     * Creates an iterator that traverses all values in this dictionary.
     *
     * @return An iterator that provides sequential access to the values in this
     *         dictionary.
     */
    Iterator<V> getValueIterator();

    /**
     * Checks whether this dictionary is empty.
     *
     * @return True if the dictionary is empty.
     */
    boolean isEmpty();

    /**
     * Gets the size of this dictionary.
     *
     * @return The number of entries (key-value pairs) currently in the dictionary.
     */
    int getSize();

    /**
     * Removes all entries from this dictionary.
     */
    void clear();
}
