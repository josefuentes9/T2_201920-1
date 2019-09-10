package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
	
	private Nodo<T> ultimo;
	
	private int size;
	
	public Stack() {
		
		ultimo = null;
		size = 0;
	}
	
	public void push(T o){
		Nodo<T> auxiliar=new Nodo(o);
		
		if(ultimo==null){
			
			ultimo=auxiliar;
		}
		
		else{
			
			auxiliar.setSigNode(ultimo);
			ultimo=auxiliar;			
		}
		size++;
	}
	
	public T pop(){
		
		T auxiliar=ultimo.getElemento();
		ultimo=ultimo.getSigNode();
		size--;
		return auxiliar;
	}
	
	public boolean isEmpty(){
		if(size==0){
			
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
				a=ultimo;
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
