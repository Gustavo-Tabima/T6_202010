
package model.data_structures;

import java.io.Serializable;


import java.util.LinkedList;
import java.util.List;

import model.data_structures.ElementoExisteException;
import model.data_structures.ElementoNoExisteException;
import model.data_structures.IArbolOrdenado;
import model.logic.Comparendo;





public class ArbolRojoNegro<T> implements  IArbolOrdenado<T>
{
	

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Raiz del árbol.
	 */
	private NodoRojoNegro raiz;

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


	public void put( T c, int Pllave) throws ElementoExisteException
	{

		NodoRojoNegro nodo = new NodoRojoNegro(   c, Pllave );

		NodoRojoNegro r2 = null;

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
	public boolean existe( int Pllave )
	{
		return raiz != null ? raiz.existe( Pllave ) : false;
	}


	public Object buscar( int Pllave )
	{
		try
		{   
			if (raiz.darNodo(Pllave)== null)
				return null; 
			return raiz != null ? raiz.darNodo( Pllave ) : null;
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
	
	public int darAlturaP( )
	{
		return raiz == null ? 0 : raiz.darAlturaP( );
	}

	/**
	 * Retorna el menor  del arbol.
	 * 
	 * @return El menor  del arbol , null si vaesta vacio
	 */
	public Object darMinimo( )
	{
		return raiz == null ? null : raiz.darMenor( );
	}

	/**
	 * Retorna el mayor  del arbol.
	 * 
	 * @return El mayor  del arbol , null si esta vacio
	 */
	public Object darMayor( )
	{
		return raiz == null ? null : raiz.darMayor( );
	}
	public void req3( )
	{
	}
	
	
}