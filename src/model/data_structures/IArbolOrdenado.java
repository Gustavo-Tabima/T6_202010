package model.data_structures;

import model.data_structures.ElementoExisteException;
import model.data_structures.ElementoNoExisteException;
import model.logic.Comparendo;

public interface IArbolOrdenado<T> {




	public int darAltura();


	public int darPeso();


	public Object buscar(int llave);



	public void put( T elem, int Pllave ) throws ElementoExisteException;


	public void eliminar( T elem ) throws ElementoNoExisteException;


}
