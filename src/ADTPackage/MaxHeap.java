package ADTPackage;

import java.util.Arrays;

/**
 * A class that implements the max heap using an array.
 *
 * @param <T> The type of elements stored in the heap.
 */
public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
    private T[] heap; // Array representing the heap
    private int lastIndex; // Last used index
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Default constructor initializes the heap with default capacity.
     */
    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor with a custom initial capacity.
     *
     * @param initialCapacity The initial capacity of the heap.
     */
    public MaxHeap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        }
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1]; // Index 0 is not used
        heap = tempHeap;
        lastIndex = 0;
    }

    @Override
    public void add(T newEntry) {
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;

        while (parentIndex > 0 && newEntry.compareTo(heap[parentIndex]) > 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }

        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    @Override
    public T removeMax() {
        T root = null;

        if (!isEmpty()) {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }

        return root;
    }

    @Override
    public T getMax() {
        return isEmpty() ? null : heap[1];
    }

    @Override
    public boolean isEmpty() {
        return lastIndex < 1;
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void clear() {
        for (int i = 1; i <= lastIndex; i++) {
            heap[i] = null;
        }
        lastIndex = 0;
    }

    /**
     * Restores the heap property.
     */
    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done && leftChildIndex <= lastIndex) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if (rightChildIndex <= lastIndex && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            } else {
                done = true;
            }
        }

        heap[rootIndex] = orphan;
    }

    /**
     * Ensures the heap has enough capacity to store new elements.
     */
    private void ensureCapacity() {
        if (lastIndex >= heap.length - 1) {
            int newCapacity = 2 * (heap.length - 1);
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity + 1);
        }
    }

    /**
     * Checks if the requested capacity is valid.
     */
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Maximum heap capacity exceeded.");
        }
    }
}
