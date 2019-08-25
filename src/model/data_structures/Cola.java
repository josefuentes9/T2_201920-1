package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class Cola <T> implements ICola <T>{
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int size;
	/**
	 * Cabeza de la lista encadenada
	 */
	private Node<T> primero;

	/**
	 * �ltimo elemento de la lista encadenada
	 */
	private Node<T> ultimo;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public Cola(  )
	{
		primero=null;
		ultimo=null;
	}

	public void agregarUltimo( T o )
	{
		Node<T> nodo = new Node<T>( o );
		if( primero == null )
		{
			primero = nodo;
			ultimo = nodo;
		}
		else
		{
			ultimo.insertarDespues( nodo );
			ultimo = nodo;
		}
		size++;
	}

	public int size() 
	{
		return size;
	}

	public T darElemento(int pos) 
	{
		Node<T> aux = primero;

		for( int cont = 0; cont < pos; cont++ )
		{
			aux = aux.darSiguiente( );
		}

		return aux.darElemento( );
	}

	/**
     * Elimina el �ltimo nodo y devuelve el elemento que conten�a. <br>
     * <b>post: </b> Se elimin� el �ltimo nodo de la lista. Se retorn� el elemento contenido en el nodo eliminado. La cantidad de elementos se reduce en uno. Si la lista no
     * tiene nodos se retorna null.
     * @return Elemento del nodo eliminado
     */
    public T eliminarPrimero( )
    {//
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
    
    /**
     * Elimina el elemento especificado de la lista encadenada. <br>
     * <b>post: </b> Se elimin� el elemento especificado de la lista. La cantidad de elementos se reduce en uno<br>
     * @param elemento Elemento a eliminar<br>
     * @return Elemento eliminado<br>
     * @throws NoExisteException Excepci�n que es lanzada si el elemento especificado no existe<br>
     */
    public T eliminar( T elemento ) throws Exception
    {
        T valor = null;
        if( primero == null )
        {
            throw new Exception( "Elemento no existe" );
        }
        else if( primero.darElemento( ).equals( elemento ) )
        {
            if( primero.equals( ultimo ) )
            {
                ultimo = null;
            }
            valor = primero.darElemento( );
            primero = primero.desconectarPrimero( );
            size--;
            return valor;
        }
        else
        {
            for( Node<T> p = primero.darSiguiente( ); p != null; p = p.darSiguiente( ) )
            {
                if( p.darElemento( ).equals( elemento ) )
                {
                    if( p.equals( ultimo ) )
                    {
                        ultimo = p.darAnterior( );
                    }
                    valor = p.darElemento( );
                    p.desconectarNodo( );
                    size--;
                    return valor;
                }
            }
            throw new Exception( "Elemento no existe" );
        }
    }

    @Override
	public boolean isEmpty() 
	{
		primero = null;
        ultimo = null;
        size = 0;
        return true;
	}

    @Override
	public Iterator<T> iterator() 
	{			
		return new ColaIterator();
	}
    
    private class ColaIterator implements Iterator<T>{

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
