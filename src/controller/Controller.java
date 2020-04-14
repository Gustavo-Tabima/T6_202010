package controller;

import java.util.Scanner;

import model.data_structures.ElementoNoExisteException;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() throws ElementoNoExisteException 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		int datoInt = 0;
		int datoSig = 0;
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage(" cargar datos: ");
					modelo.cargarDatos();
				    view.printMessage("arbol creado");
				    view.printMessage("Numero actual de elementos " + modelo.darTamano() );
				    view.printMessage("Comparendo con mayor id"+modelo.darMayorId()+ "\n---------");
				    view.printMessage("Comparendo con menor id"+modelo.darMenorId()+ "\n---------");

					break;
				case 2:
					view.printMessage(" altura  del arbol: ");
				    view.printMessage("altura actual " + modelo.darAltura() );
					break;
			
				case 3:
					view.printMessage(" bucar comparendo por la id: ");
					datoInt= lector.nextInt();
				    view.printMessage(modelo.req2(datoInt) );
					break;
				case 4:
					view.printMessage(" bucar comparendos por el rango de ids: ejm: "
							+ "inferior - superior ");
					
					datoInt= lector.nextInt();
					datoSig= lector.nextInt();
				    view.printMessage(modelo.req3(datoInt,datoSig) );
					break;
					
					
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
