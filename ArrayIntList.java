/**
 * @author tainglyda 
 * CSC 143
 * April 24, 2018
 * 
 * Class to contain an integer List.
 *
 */
public class ArrayIntList {
	private int[] elementData;
	private int size;
	public static final int DEFAULT_CAPACITY = 100;

	// post: Create an integer list with default capacity.
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}

	// pre: capacity >0 (throw IllegalArgumentExpection if not)
	// post: Create an integer list with given capacity.
	public ArrayIntList(int capacity) {
		if (capacity<=0) {
			throw new IllegalArgumentException();
		}
		elementData = new int[capacity];
		size = 0;
	}

	// pre: size < capacity (throws IllegalStateException if not).
	// post: Add value to the end of the list.
	public void add(int value) {
		checkCapacity(size+1);
		elementData[size] = value;
		size++;
	}

	// post: Returns string version using bracketed list with
	// 	     comma-separated elements.
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		String result = "[" + elementData[0];
		for (int i = 1; i < size; i++) {
			result = result + ", " + elementData[i];
		}
		return result + "]";
	}

	// post: returns the size of the list.
	public int size() {
		return size;
	}

	// pre: 0 <= index < size (throws IndexOutOFBoundsException if not).
	// post: returns the value at the given index.
	public int get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	// post: returns the index of the first occurrence of the given value
	// 		 in the list (-1 if value is not in the list).
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (elementData[i] == value) {
				return i;
			}
		}
		return -1;
	}

	// pre: 0 <= index < size. (throws IndexOutOFBoundsException if not).
	// post: removes value of the given index and
	// 		 shifts the remaining value left.
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
	}

	// pre: 0 <= index <= size (throws IdexOutofBoundException if not).
	// 		and size < capacity (throws IllegalstateException if not).
	// post: adds value at the given index to the list.
	// 		 and shift subsequent elements to the right.
	public void add(int index, int value) {
		if(index<0 || index>size) {
			throw new IndexOutOfBoundsException();
		}
		checkCapacity(size);
		for (int i = size; i >= index; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}
	
	// post: throw IllegalStateException if over capacity.
	private void checkCapacity(int capacity) {
		if (capacity > elementData.length) {
			throw new IllegalStateException("Exceed the capactiy.");
		}	
	}
	
	// post: throws IndexOutOfBound if index is greater than size.
	private void checkIndex(int index) {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
	// post: return true if value is in the list.
	public boolean contains(int value) {	
		return (indexOf(value)>=0);
	}
	
	// post: return true if list is empty.
	public boolean isEmpty() {
		return (size==0);	
	}
	
	// pre: 0<= index < size (throws IndexOutOfBoundsExpception if not).
	// post: put given value in list at given index.
	public void set(int index, int value) {
		checkIndex(index);
		elementData[index]= value;
	}
	
	// post: empty the list (set size = 0).
	public void clear() {
		size = 0;
	}
	
	// pre: size + other.size < capacity (throw IllegalExcpetion if not).
	// post: add the element of other ArrayIntList to the end of the list.
	public void addAll(ArrayIntList other) {
		checkCapacity(size+ other.size());
		for (int i = 0; i<other.size(); i++) {
			add(other.get(i));
		}
	}

}
