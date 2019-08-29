package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class Queue<T> {

	Nodo<T> primero;
	
	Nodo<T> ultimo;
	
	int size;
	
	public Queue(){
	    ultimo = null;
	    size = 0;

	}
	
	public void enqueue(T o){
	Nodo<T> auxiliar= new Nodo(o);
	if (primero==null){
		primero=auxiliar;
		ultimo=auxiliar;
		
	}
	else{
		ultimo.setSigNode(auxiliar);
		ultimo=auxiliar;
		
	}
	
	size++;
	}
	
	public T dequeue(){
		T auxiliar=primero.getElemento();
		primero=primero.getSigNode();
		size--;
		return auxiliar;
	}
	
	public boolean isEmpty(){
		if (size==0){
			return true;
		}
		return false;
	}
	
	public int size(){
		
		return size;
	}
	//___________________________________________________________________________________________________________________________________________________
	//ITERADORES
	//___________________________________________________________________________________________________________________________________________________
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new PilaIterator();
	}
	
	private class PilaIterator implements Iterator<T>{

		Nodo<T> a =null;
		
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
				a=a.getSigNode();
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
				return a.getElemento();
			}
			else
			{
				throw new NoSuchElementException();
			}

		}
	}
	
	
}
