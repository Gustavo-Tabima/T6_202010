package controller;

import java.util.Scanner;

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
					view.printMessage("--------- \n cargar datos: ");
					modelo.cargarDatos();
				    view.printMessage("arbol creado");
				    view.printMessage("Numero actual de elementos " + modelo.darTamano() );
				    view.printMessage(modelo.darMayorId()+ "\n---------");
					break;
				case 2:
					view.printMessage("--------- \n altura prom del arbol: ");
				    view.printMessage("altura actula " + modelo.darAlturaP() );
					break;
			

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
