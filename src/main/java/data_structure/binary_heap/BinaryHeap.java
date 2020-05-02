package data_structure.binary_heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {

	private static final int NUMBER_OF_DESCENDANT = 2;

	private int[] heap;
	private int heapSize;
	private HeapType heapType;

	public BinaryHeap(int capacity, HeapType heapType) {
		heapSize = 0;
		this.heapType = heapType;
		heap = new int[capacity];
		Arrays.fill(heap, -1);
	}

	public int getParentIndex(int childIndex) {
		if (childIndex < 0 || childIndex > heapSize)
			return -1;
		return (childIndex - 1) / NUMBER_OF_DESCENDANT;
	}

	public int getLeftChildIndex(int parentIndex) {
		if (parentIndex < 0 || parentIndex > heapSize)
			return -1;
		return (NUMBER_OF_DESCENDANT * parentIndex) + 1;
	}

	public int getRightChildIndex(int parentIndex) {
		if (parentIndex < 0 || parentIndex > heapSize)
			return -1;
		return (NUMBER_OF_DESCENDANT * parentIndex) + 2;
	}

	public int getMin() {
		if (heapType == HeapType.MAX_HEAP)
			throw new UnsupportedOperationException(
					"Cannot find Min in MaxHeap");
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return heap[0];
	}

	public int getMax() {
		if (heapType == HeapType.MIN_HEAP)
			throw new UnsupportedOperationException(
					"Cannot find Max in MinHeap");
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return heap[0];
	}

	public boolean isEmpty() {
		return heapSize == 0;
	}

	public boolean isFull() {
		return heapSize == heap.length;
	}

	public int percolateDown(int index) {
		while (index > -1 && getLeftChildIndex(index) < heapSize) {
			int leftChildIndex = getLeftChildIndex(index);
			int rightChildIndex = getRightChildIndex(index);

			if (heapType == HeapType.MAX_HEAP)
				index = percolateDownForMaxHeap(index, leftChildIndex,
						rightChildIndex);
			else
				index = percolateDownForMinHeap(index, leftChildIndex,
						rightChildIndex);
		}
		return index;
	}

	private int percolateDownForMaxHeap(int index, int leftChildIndex,
			int rightChildIndex) {
		if (heap[index] > heap[leftChildIndex]) {
			swap(index, leftChildIndex);
			index = leftChildIndex;
		} else
			index = percolateUpForMinHeap(index, rightChildIndex);
		return index;
	}

	private int percolateDownForMinHeap(int index, int leftChildIndex,
			int rightChildIndex) {
		if (heap[index] < heap[leftChildIndex]) {
			swap(index, leftChildIndex);
			index = leftChildIndex;
		} else
			index = percolateUpForMaxHeap(index, rightChildIndex);
		return index;
	}

	private void swap(int firstIndex, int secondIndex) {
		heap[firstIndex] = heap[firstIndex] + heap[secondIndex];
		heap[secondIndex] = heap[firstIndex] - heap[secondIndex];
		heap[firstIndex] = heap[firstIndex] - heap[secondIndex];
	}

	public int percolateUp(int index) {
		while (getParentIndex(index) > -1 && index < heapSize) {
			int parentIndex = getParentIndex(index);

			if (heapType == HeapType.MAX_HEAP)
				index = percolateUpForMaxHeap(index, parentIndex);
			else
				index = percolateUpForMinHeap(index, parentIndex);

		}
		return index;
	}

	private int percolateUpForMaxHeap(int index, int parentIndex) {
		if (heap[index] < heap[parentIndex]) {
			swap(index, parentIndex);
			index = parentIndex;
		}
		return index;
	}

	private int percolateUpForMinHeap(int index, int parentIndex) {
		if (heap[index] > heap[parentIndex]) {
			swap(index, parentIndex);
			index = parentIndex;
		}
		return index;
	}

	public void add(int element) {
		if (isFull())
			throw new NoSuchElementException("Overflow Exception");
		heap[heapSize++] = element;
		percolateUp(heapSize - 1);
	}

	public int delete(int index) {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");

		int element = heap[index];
		heap[index] = heap[heapSize - 1];
		heapSize--;
		percolateDown(index);
		return element;
	}

	public int deleteMin() {
		if (heapType == HeapType.MAX_HEAP)
			throw new UnsupportedOperationException(
					"Cannot find Min in MaxHeap");
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");

		int element = heap[0];
		delete(0);
		return element;
	}

	public int deleteMax() {
		if (heapType == HeapType.MIN_HEAP)
			throw new UnsupportedOperationException(
					"Cannot find Max in MinHeap");
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");

		int element = heap[0];
		delete(0);
		return element;
	}

	public void printHeap() {
		System.out.print("Heap: ");
		for (int i = 0; i < heapSize; i++)
			System.out.println(heap[i] + " ");
		System.out.println();
	}

}
