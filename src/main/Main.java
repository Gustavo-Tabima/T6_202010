package main;
import controller.Controller;
import model.data_structures.ElementoNoExisteException;

public class Main {
	
	public static void main(String[] args) throws ElementoNoExisteException 
	{
		Controller controler = new Controller();
		controler.run();
	}
}
