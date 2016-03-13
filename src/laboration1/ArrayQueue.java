package laboration1;

public class ArrayQueue<T> implements Queue<T> {
	private T[] elements;
	private int size = 0;

	public ArrayQueue(int capacity) {
		elements = (T[]) new Object[capacity];
	}

	public void add(T elem) {
		if (size < elements.length) {
			throw new ArrayQueueException("enqueue: Queue is full");
		}
		elements[size++] = elem;
	}

	public T remove() {
		if (size == 0) {
			throw new ArrayQueueException("dequeue: Queue is empty");
		}

		T value = elements[0];
		size--;

		for (int i = 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[size] = null;

		return value;
	}

	public T element() {

		if (size == 0) {
			throw new ArrayQueueException("peek: Queue is empty");
		}
		return elements[0];

	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {

		return size;
	}

}