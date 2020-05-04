package data_structure.arraylist;

import java.util.Arrays;

public class ArrayList<E> {

	private final int DEFAULT_INITIAL_CAPACITY = 5;
	private Object[] EMPTY_ARRAY = {};
	private Object[] backedArray;
	private int size;

	public ArrayList() {
		backedArray = EMPTY_ARRAY;
	}

	public ArrayList(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Intial capacity can't be negative");
		backedArray = new Object[size];
	}

	public boolean add(E element) {
		ensureCapacity(size + 1);
		backedArray[size++] = element;
		return true;
	}

	private void ensureCapacity(int capacity) {
		if(backedArray == EMPTY_ARRAY)
			capacity = Math.max(capacity, DEFAULT_INITIAL_CAPACITY);
		if(capacity > backedArray.length){
			increaseCapacity(capacity);
		}
	}

	private void increaseCapacity(int capacity) {
		int oldCapacity = backedArray.length;
		int newCapacity = oldCapacity + (oldCapacity/2);
		if(newCapacity < capacity)
			newCapacity = capacity;
		backedArray = Arrays.copyOf(backedArray, newCapacity);
	}
	
	public E remove(int index){
		E valueToRemove = (E)backedArray[index];
		int noOfLeftElement = size - index - 1;
		if(noOfLeftElement > 0)
			System.arraycopy(backedArray, index+1, backedArray, index, noOfLeftElement);
		backedArray[--size] = null;
		return valueToRemove;
	}

	public E get(int index){
		if(index < 0)
			throw new IllegalArgumentException("Index value can't be negative");
		return (E) backedArray[index];
	}

	public int size() {
		return size;
	}
}
