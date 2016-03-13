package laboration1;

public interface Queue<T> {

	/**
	 * Lägger till ett element sist i kön Kastar ArrayQueueException om kön är
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
