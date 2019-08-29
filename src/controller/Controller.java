package controller;

import java.util.Scanner;

import model.data_structures.Queue;
import model.logic.MVCModelo;
import model.logic.Viaje;
import view.MVCView;

public class Controller {
	/* Instancia del Modelo*/
	private static MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \n Cargando Viajes ");
				modelo = new MVCModelo();
				try
				{
					modelo.crearLista(0);
					modelo.crearLista(1);
				}
				catch(Exception e)
				{
					view.printMessage("error al crear la lista");
				}
				view.printMessage("Lista creada");
				view.printMessage("El total de viajes (líneas) leídos para el primer trimestre del año es "+modelo.darTamano(0));
				//view.printMessage("Informacion primer viaje: "+ modelo.buscar(0, 0).getSourceid()+", "+modelo.buscar(0, 0).getDstid()+", "+modelo.buscar(0, 0).getHod()+", "+modelo.buscar(0, 0).getMean_travel_time());
				//view.printMessage("Informacion primer viaje: "+ modelo.buscar(modelo.darTamano(1), 1).getSourceid()+", "+modelo.buscar(modelo.darTamano(1), 1).getDstid()+", "+modelo.buscar(modelo.darTamano(1), 1).getHod()+", "+modelo.buscar(modelo.darTamano(1), 1).getMean_travel_time());
				break;

			case 2:
				view.printMessage("--------- \n Escriba la hora: ");
				int hora = lector.nextInt();
				Queue <Viaje> cola=(Queue<Viaje>) modelo.grupoGrandeHora(hora);
				view.printMessage("El numero de viajes del grupo mas grande por la hora de parametro es "+cola.size());
				while(cola.size()!=0)
				{
					Viaje v=cola.dequeue();
					view.printMessage("Informacion viaje "+ v.getHod()+ ", "+ v.getSourceid()+", "+ v.getDstid()+", "+v.getMean_travel_time());
				}
				break;

			case 3:
				view.printMessage("--------- \\n Escriba la hora:");
				int h = lector.nextInt();
				view.printMessage("--------- \\n Escriba el numero de viajes:");
				int n = lector.nextInt();
				Queue <Viaje> c=modelo.nViajesHora(h,n);
				
				while(c.size()!=0){
					
					Viaje v=c.dequeue();
					view.printMessage("Informacion viaje "+ v.getHod()+ ", "+ v.getSourceid()+", "+ v.getDstid()+", "+v.getMean_travel_time());
				}
				break;

			
			case 6: 
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}

		}	

	}
}
