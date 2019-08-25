package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pila<T> implements IPila<T> 
{
	/**
	 * Cabeza de la lista encadenada
	 */
	private Node<T> primero;

	/**
	 * �ltimo elemento de la lista encadenada
	 */
	private Node<T> ultimo;

	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int size;

	public Pila()
	{
		primero=null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public void agregarPrimero(T o) {
		Node<T> nodo = new Node<T>( o );
		if( primero == null )
		{
			primero = nodo;
		}
		else
		{
			primero.insertarAntes( nodo );
			primero = nodo;
		}
		size++;
	}
	@Override
	public T eliminarPrimero() 
	{
		//
		// Si no tiene
		if( primero == null )
		{
			return null;
		}
		else
		{
			//
			// Elimina el primer elemento
			try
			{
				return eliminar( primero.darElemento( ) );
			}
			catch( Exception e )
			{
				//
				// Esto nunca deber�a pasar
				return null;
			}
		}
	}

	public T eliminar( T elemento ) throws Exception
	{
		T valor = null;
		valor = primero.darElemento( );
		primero = primero.desconectarPrimero( );
		size--;
		return valor;

	}
	@Override
	public T get(int pos) {
		 Node<T> aux = primero;

         for( int cont = 0; cont < pos; cont++ )
         {
             aux = aux.darSiguiente( );
         }

         return aux.darElemento( );
	}
	@Override
	public boolean isEmpty() {
		primero = null;
        ultimo = null;
        size = 0;
        return true;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new PilaIterator();
	}
	
	private class PilaIterator implements Iterator<T>{

		Node<T> a =null;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			boolean bool;
			if(a==null)
			{
				a=primero;
			}
			else 
			{
				a=a.darSiguiente();
			}
			if(a==null)
			{
				bool=false;
			}
			else
			{
				bool=true;
			}
			return bool;
		}
		
		@Override
		public T next() {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			if(a!=null)
			{
				return a.darObjeto();
			}
			else
			{
				throw new NoSuchElementException();
			}

		}
	}

}
