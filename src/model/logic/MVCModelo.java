package model.logic;

import java.util.ArrayList;

import model.data_structures.Cola;
import model.data_structures.ICola;
import model.data_structures.Pila;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArrayList<Cola<Viaje>> datosCola;
	private ArrayList<Pila<Viaje>> datosPila;

	private int tamano;
	private Viaje viaje;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datosCola = new ArrayList< Cola<Viaje>>();
		datosCola.add(new Cola<Viaje>());
		datosCola.add(new Cola<Viaje>());

		datosPila = new ArrayList< Pila<Viaje>>();
		datosPila.add(new Pila<Viaje>());
		datosPila.add(new Pila<Viaje>());
	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano(int lista)
	{
		return datosCola.get(lista).size();
	}
	public void crearLista(int lista) throws Exception
	{
		CSVReader reader=null;
		reader = new CSVReader(new FileReader(".bogota-cadastral-2018-1-All-HourlyAggregate.csv"));
		String [] nextLine=reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line

			datosCola.get(lista).agregarUltimo(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
			datosPila.get(lista).agregarPrimero(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
			
		}
		reader.close();
	}

	public int darViajesMes(double mes)
	{
		int c=0;
		if(mes<=3)
		{
			for(Viaje viaje: datos.get(0))
			{
				if(viaje.getMonth()==mes)
				{
					c++;
				}
			}
		}
		else if(mes>3)
		{
			for(Viaje viaje: datos.get(0))
			{
				if(viaje.getMonth()==mes)
				{
					c++;
				}
			}
		}
		return c;
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Viaje v, int lista)
	{	
		datos.get(lista).agregar(v);
	}

	/**
	 * Requerimiento buscar dato
	 * @param <T>
	 * @param dato Dato a buscar
	 * @return 
	 * @return dato encontrado
	 */
	public Viaje buscar(int pos, int lista)
	{
		return datosCola.get(lista).darElemento(pos);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public void eliminar(int pos, int lista)
	{
		datos.get(lista).remove(pos);
	}

	public ArregloDinamico<Viaje> nuevosServicios(int mes, int zona)
	{

		ArregloDinamico<Viaje> pedidos= new ArregloDinamico<Viaje>();
		if(mes<=3)
		{
			for(Viaje i: datos.get(0))
			{
				if(i.getSourceid()==zona)
				{
					pedidos.agregar(i);
				}
			}
		}
		else
		{
			for(Viaje i: datos.get(1))
			{
				if(i.getSourceid()==zona)
				{
					pedidos.agregar(i);
				}
			}
		}

		return pedidos;

	}

}
