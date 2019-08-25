package model.data_structures;

import java.util.Iterator;

public interface ICola <T> extends Iterable<T>{

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return
	 */
	int size( );
	
	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	public T darElemento (int pos);

	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */
	public void agregarUltimo( T dato );
	
	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param dato Objeto de eliminacion en el arreglo
	 * @return dato eliminado
	 */
	public T eliminarPrimero ();
	
	public boolean isEmpty();
	Iterator<T> iterator();

}
