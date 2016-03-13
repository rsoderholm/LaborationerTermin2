package laboration1;

public interface Queue<T> {

	/**
	 * L�gger till ett element sist i k�n Kastar ArrayQueueException om k�n �r
	 * full
	 */
	public void add(T elem);

	/**
	 * 
	 * @return
	 */

	public T remove();

	/**
	 * 
	 * @return
	 */

	public T element();

	/**
	 * 
	 * @return
	 */

	public boolean isEmpty();

	/**
	 *
	 * 
	 * @return
	 */
	public int size();

}
