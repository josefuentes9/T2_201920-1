package model.data_structures;

public interface IStack<T> extends Iterable<T> {
	
	/**
	 * add the item "o" to the stack.
	 * @param o
	 */
	public void push(T o);
	
	/**
	 * remove the most recently added item
	 * @return
	 */
	
	public T pop();
	
	/**
	 * is the queue empty
	 * @return true or false depending its empty or not
	 */
	
	public boolean isEmpty();
	
	/**
	 * number of items in the stack
	 * @return
	 */
	
	public int size();
	
}
