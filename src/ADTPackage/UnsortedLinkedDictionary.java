package ADTPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An unsorted linked list implementation of the DictionaryInterface.
 * It stores key-value pairs and allows for basic dictionary operations.
 *
 * @param <K> The type of keys in the dictionary.
 * @param <V> The type of values in the dictionary.
 */
public class UnsortedLinkedDictionary<K, V> implements DictionaryInterface<K, V> {
    private Node firstNode;   // Reference to first node of chain
    private int numberOfEntries;

    /**
     * Creates an empty dictionary.
     */
    public UnsortedLinkedDictionary() {
        initializeDataFields();
    }

    /**
     * Initializes the data fields of the dictionary.
     */
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new key-value pair to the dictionary or updates the value for an existing key.
     *
     * @param key   The key to add or update.
     * @param value The value associated with the key.
     * @return The old value associated with the key, or null if the key was not previously in the dictionary.
     * @throws IllegalArgumentException if either the key or the value is null.
     */
    @Override
    public V add(K key, V value) {
        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        }

        V result = null;
        Node currentNode = firstNode;

        // Search for existing node with the same key
        while (currentNode != null && !key.equals(currentNode.key)) {
            currentNode = currentNode.next;
        }

        // If key doesn't exist, add a new node to the list
        if (currentNode == null) {
            Node newNode = new Node(key, value);
            newNode.next = firstNode;
            firstNode = newNode;
            numberOfEntries++;
        } else {
            // If key exists, update the value
            result = currentNode.value;
            currentNode.value = value;
        }

        return result;
    }

    /**
     * Removes a specific entry from the dictionary by its key.
     *
     * @param key The key of the entry to remove.
     * @return The value associated with the removed key, or null if the key was not found.
     * @throws IllegalArgumentException if the key is null.
     */
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Cannot remove null key from the dictionary.");
        }

        Node currentNode = firstNode;
        Node previousNode = null;

        // Search for the node with the given key
        while (currentNode != null && !key.equals(currentNode.key)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // If the node was not found, return null
        if (currentNode == null) {
            return null; // Return null when key is not found
        }

        V removedValue = currentNode.value;  // Save the value to return it

        // If the node to be removed is the first node
        if (previousNode == null) {
            firstNode = currentNode.next;  // Move firstNode to the next node
        } else {
            previousNode.next = currentNode.next;  // Bypass the current node
        }

        numberOfEntries--;  // Decrease the count of entries
        return removedValue;  // Return the removed value
    }

    /**
     * Retrieves the value associated with a specific key.
     *
     * @param key The key whose value is to be retrieved.
     * @return The value associated with the key, or null if the key is not found.
     */
    @Override
    public V getValue(K key) {
        Node currentNode = firstNode;

        while (currentNode != null && !key.equals(currentNode.key)) {
            currentNode = currentNode.next;
        }

        return (currentNode != null) ? currentNode.value : null;
    }

    /**
     * Checks if the dictionary contains a specific key.
     *
     * @param key The key to check for existence in the dictionary.
     * @return true if the dictionary contains the key, false otherwise.
     */
    @Override
    public boolean contains(K key) {
        return getValue(key) != null;
    }

    /**
     * Checks if the dictionary is empty.
     *
     * @return true if the dictionary is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Returns the number of key-value pairs in the dictionary.
     *
     * @return The size of the dictionary.
     */
    @Override
    public int getSize() {
        return numberOfEntries;
    }

    /**
     * Clears the dictionary, removing all key-value pairs.
     */
    @Override
    public void clear() {
        initializeDataFields();
    }

    /**
     * Returns an iterator for the keys in the dictionary.
     *
     * @return An iterator for the keys in the dictionary.
     */
    @Override
    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    }

    /**
     * Returns an iterator for the values in the dictionary.
     *
     * @return An iterator for the values in the dictionary.
     */
    @Override
    public Iterator<V> getValueIterator() {
        return new ValueIterator();
    }

    /**
     * Inner Node class for holding key-value pairs.
     */
    private class Node {
        private K key;
        private V value;
        private Node next;

        /**
         * Creates a new node to store a key-value pair.
         *
         * @param key   The key associated with the value.
         * @param value The value associated with the key.
         */
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Key iterator for traversing keys in the dictionary.
     */
    private class KeyIterator implements Iterator<K> {
        private Node currentNode = firstNode;

        /**
         * Checks if there are more keys to iterate over.
         *
         * @return true if there are more keys, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Returns the next key in the iteration.
         *
         * @return The next key in the iteration.
         * @throws NoSuchElementException if no more keys are available.
         */
        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            K key = currentNode.key;
            currentNode = currentNode.next;
            return key;
        }
    }

    /**
     * Value iterator for traversing values in the dictionary.
     */
    private class ValueIterator implements Iterator<V> {
        private Node currentNode = firstNode;

        /**
         * Checks if there are more values to iterate over.
         *
         * @return true if there are more values, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Returns the next value in the iteration.
         *
         * @return The next value in the iteration.
         * @throws NoSuchElementException if no more values are available.
         */
        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            V value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }
}
