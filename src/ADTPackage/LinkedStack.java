package ADTPackage;

import java.util.EmptyStackException;

/**
 * A class that implements a stack using a linked list.
 *
 * @param <T> The type of elements stored in the stack.
 */
public final class LinkedStack<T> implements StackInterface<T> {
    private Node topNode; // Reference to the first node in the chain
    private int size;     // Tracks the number of entries

    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry The object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
        size++;
    }

    /**
     * Removes and returns this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException If the stack is empty.
     */
    @Override
    public T pop() {
        T top = peek();  // Might throw EmptyStackException
        topNode = topNode.getNextNode();
        size--;
        return top;
    }

    /**
     * Retrieves this stack's top entry without removing it.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException If the stack is empty.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    /**
     * Checks whether this stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }

    /**
     * Returns the number of entries currently in the stack.
     *
     * @return The size of the stack.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * A private inner class that represents a node in the linked list.
     */
    private class Node {
        private T data;    // Entry in the stack
        private Node next; // Link to the next node

        /**
         * Initializes a node with data and a link to the next node.
         *
         * @param dataPortion The data to be stored in this node.
         * @param nextNode    The next node in the chain.
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * Gets the data stored in this node.
         *
         * @return The data stored in this node.
         */
        private T getData() {
            return data;
        }

        /**
         * Gets the next node in the chain.
         *
         * @return The next node.
         */
        private Node getNextNode() {
            return next;
        }
    }
}
