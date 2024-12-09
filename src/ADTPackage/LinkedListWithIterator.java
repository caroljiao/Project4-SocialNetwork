package ADTPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements a linked list with an iterator.
 *
 * @param <T> The type of elements in the linked list.
 */
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    /**
     * Creates an empty linked list.
     */
    public LinkedListWithIterator() {
        initializeDataFields();
    }

    /**
     * Initializes the data fields of the linked list.
     */
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to the end of the list.
     *
     * @param newEntry The entry to be added.
     */
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.next = newNode;
        }
        numberOfEntries++;
    }

    /**
     * Adds a new entry at a specified position in the list.
     *
     * @param newPosition The position at which to add the new entry.
     * @param newEntry The entry to be added.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    @Override
    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);

            if (newPosition == 1) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }

            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    /**
     * Returns an iterator to iterate over the linked list.
     *
     * @return an iterator for the linked list.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Alias for the iterator method.
     *
     * @return an iterator for the linked list.
     */
    @Override
    public Iterator<T> getIterator() {
        return iterator();
    }

    /**
     * Removes an entry from the list at a given position.
     *
     * @param givenPosition The position of the entry to remove.
     * @return The entry that was removed.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.next;
                result = nodeToRemove.data;
                nodeBefore.next = nodeToRemove.next;
            }

            numberOfEntries--;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }

        return result;
    }

    /**
     * Clears the list, removing all entries.
     */
    @Override
    public void clear() {
        initializeDataFields();
    }

    /**
     * Replaces an entry at a given position with a new entry.
     *
     * @param givenPosition The position of the entry to replace.
     * @param newEntry The new entry to replace the old one.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.data;
            desiredNode.data = newEntry;
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }

    /**
     * Retrieves the entry at a given position.
     *
     * @param givenPosition The position of the entry to retrieve.
     * @return The entry at the given position.
     * @throws IndexOutOfBoundsException if the position is invalid.
     */
    @Override
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getNodeAt(givenPosition).data;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    /**
     * Converts the linked list to an array of elements.
     *
     * @return An array containing all the elements of the list.
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }

        return result;
    }

    /**
     * Checks if the list contains a specific entry.
     *
     * @param anEntry The entry to check for.
     * @return true if the entry is found, false otherwise.
     */
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return found;
    }

    /**
     * Gets the length of the list.
     *
     * @return The number of entries in the list.
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Retrieves the node at a specific position in the list.
     *
     * @param givenPosition The position of the node to retrieve.
     * @return The node at the given position.
     */
    private Node getNodeAt(int givenPosition) {
        Node currentNode = firstNode;

        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    /**
     * An iterator for the linked list.
     */
    private class LinkedListIterator implements Iterator<T> {
        private Node currentNode;

        /**
         * Initializes the iterator with the first node of the list.
         */
        private LinkedListIterator() {
            currentNode = firstNode;
        }

        /**
         * Checks if there are more elements to iterate over.
         *
         * @return true if there are more elements, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Retrieves the next element in the list.
         *
         * @return The next element in the list.
         * @throws NoSuchElementException if there are no more elements.
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements.");
            }

            T data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }

    /**
     * A node in the linked list, holding data and a reference to the next node.
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * Creates a new node with the specified data.
         *
         * @param data The data for the new node.
         */
        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
