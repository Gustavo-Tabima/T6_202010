package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. cargar json");
			System.out.println("2. dar altura del arbol");
			System.out.println("3. Buscar comparendo segun llave (requerimiento 2)");
			System.out.println("4. Buscar comparendo segun  rango de llaves (requerimiento 3)");

		
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
