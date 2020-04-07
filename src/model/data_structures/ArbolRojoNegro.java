
package model.data_structures;

import java.io.Serializable;


import java.util.LinkedList;
import java.util.List;

import model.data_structures.ElementoExisteException;
import model.data_structures.ElementoNoExisteException;
import model.data_structures.IArbolOrdenado;
import model.logic.Comparendo;





public class ArbolRojoNegro<T extends Comparable<? super T>> implements Serializable, IArbolOrdenado<T>
{
	

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Raiz del árbol.
	 */
	private NodoRojoNegro<T> raiz;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------    

	/**
	 * Constructor por defecto.
	 * </p>
	 * Construye un árbol vacio.
	 */
	public ArbolRojoNegro( )
	{
		raiz = null;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------      


	public void insertar( Comparendo c ) throws ElementoExisteException
	{

		NodoRojoNegro<T> nodo = new NodoRojoNegro<T>( c );

		NodoRojoNegro<T> r2 = null;

		if( raiz == null )
		{
			raiz = nodo;
			raiz.cambiarColor( NodoRojoNegro.NEGRO );
		}
		else
		{
			r2 = raiz.insertar( nodo );
		}

		raiz = r2 != null && r2.darPadre( ) == null ? r2 : raiz;
	}


	public void eliminar( T elem ) throws ElementoNoExisteException
	{
		
	}

	
	public List<T> darPreorden( )
	{
		List<T> preorden = new LinkedList<T>( );
		if( raiz != null )
			raiz.darPreorden( preorden );
		return preorden;
	}

	/**
	 * Verifica si un elemento existe en el arbol.
	 * 
	 * @param elem Elemento a buscar en el arbol.
	 * @return <code>true</code> si el elemento es encontrado en el arbol o <code>false</code> en caso contrario.
	 */
	public boolean existe( Comparendo elem )
	{
		return raiz != null ? raiz.existe( elem ) : false;
	}


	public Comparendo buscar( Comparendo modelo )
	{
		try
		{   
			if (raiz.darNodo(modelo)== null)
				return null; 
			return raiz != null ? raiz.darNodo( modelo ) : null;
		}
		catch( ElementoNoExisteException e )
		{
			return null;
		}
	}

	
	public NodoRojoNegro<T> darRaiz( )
	{
		return raiz;
	}



	public int darPeso( )
	{
		if (raiz== null) {
			return 0;
		}
		
		return raiz.darPeso();
	}


	public int darAltura( )
	{
		return raiz == null ? 0 : raiz.darAltura( );
	}

	/**
	 * Retorna el menor  del arbol.
	 * 
	 * @return El menor  del arbol , null si vaesta vacio
	 */
	public Comparendo darMinimo( )
	{
		return raiz == null ? null : raiz.darMenor( );
	}

	/**
	 * Retorna el mayor  del arbol.
	 * 
	 * @return El mayor  del arbol , null si esta vacio
	 */
	public Comparendo darMayor( )
	{
		return raiz == null ? null : raiz.darMayor( );
	}

}