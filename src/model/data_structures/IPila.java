package model.data_structures;

import java.util.Iterator;

public interface IPila <T> extends Iterable<T>
{
	int size();
	public void agregarPrimero( T dato );
	public T eliminarPrimero();
	public T get (int pos);
	public boolean isEmpty();
	Iterator<T> iterator();
}
