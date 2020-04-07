package model.data_structures;

import model.data_structures.ElementoExisteException;
import model.data_structures.ElementoNoExisteException;
import model.logic.Comparendo;

public interface IArbolOrdenado<T> {




	public int darAltura();


	public int darPeso();


	public Comparendo buscar(Comparendo modelo);



	public void insertar( Comparendo elem ) throws ElementoExisteException;


	public void eliminar( T elem ) throws ElementoNoExisteException;


}
