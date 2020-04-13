

package model.data_structures;

import java.util.List;

import  model.data_structures.NodoRojoNegro;
import model.data_structures.ElementoExisteException;

import model.data_structures.ElementoNoExisteException;
import model.logic.Comparendo;



public class NodoRojoNegro<T> 
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------




	/**
	 * Constante que representa el color negro de los nodos
	 */
	public static final int NEGRO = 1;

	/**
	 * Constante que representa el color rojo de los nodos
	 */
	public static final int ROJO = 0;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	public int llave;
	
	/**
	 * Hijo derecho del nodo
	 */
	private NodoRojoNegro<T> hijoDerecho;
	

	/**
	 * Hijo izquierdo del nodo
	 */
	private NodoRojoNegro<T> hijoIzquierdo;

	/**
	 * Información del comparendo  en el nodo
	 */
	private T comparendo;

	/**
	 * Color del nodo
	 */
	private int color;

	/**
	 * Padre del nodo
	 */
	private NodoRojoNegro<T> padre;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Constructor del nodo.
	 * </p>
	 * Cronstruye un nodo no-hoja de color rojo sin padre y con hijos hojas.
	 * 
	 * @param c
	 */
	public NodoRojoNegro( T c, int Pllave )
	{
		comparendo =  (T) c;
		llave=Pllave;
		color = ROJO;
		cambiarHijoDerecho( new NodoRojoNegro<T>( ) );
		cambiarHijoIzquierdo( new NodoRojoNegro<T>( ) );
		padre = null;
	}

	/**
	 * Construye un nodo hoja (nodo negro sin información).
	 */
	private NodoRojoNegro( )
	{
		this.comparendo = null;
		color = NEGRO;
		padre = null;
	}

	// -----------------------------------------------------------------
	// Métodos  básicos
	// -----------------------------------------------------------------

	/**
	 * Retorna el padre del nodo.
	 * 
	 * @return el padre del nodo.
	 */
	public NodoRojoNegro<T> darPadre( )
	{
		return padre;
	}

	/**
	 * Retorna el hermano del padre
	 * 
	 * @return El hermano del padre del nodo
	 */
	public NodoRojoNegro<T> darTio( )
	{
		if( padre == null || padre.padre == null )
		{
			return null;
		}
		else
		{
			if( padre.padre.esHijoDerecho( padre ) )
				return padre.padre.hijoIzquierdo;
			else
				return padre.padre.hijoDerecho;
		}

	}

	/**
	 * Retorna el color del nodo.
	 * 
	 * @return El color del nodo.
	 */
	public int darColor( )
	{
		return color;
	}

	/**
	 * Retorna el hijo derecho del nodo.
	 * 
	 * @return Hijo derecho del nodo, o <code>null</code> en caso de que el nodo sea hoja.
	 */
	public NodoRojoNegro<T> darHijoDerecho( )
	{
		return hijoDerecho;
	}

	/**
	 * Verifica si el nodo ingresado por parametro es hijo derecho de <code>this</code>
	 * 
	 * @param nodo Nodo a comparar.
	 * @return si el nodo ingresado como parametro es hijo derecho del nodo parametro es true, sino false
	 */
	public boolean esHijoDerecho( NodoRojoNegro<T> nodo ){
		boolean es=false;

		if (hijoDerecho==nodo) {
			es=true;
		}


		return es;
	}

	/**
	 * Retorna el hijo izquierdo del nodo.

	 */
	public NodoRojoNegro<T> darHijoIzquierdo( )
	{

		return hijoIzquierdo;
	}

	/**
	 * Mismo metodo que el anterior , pero para el hijo izquierdo   
	 */
	public boolean esHijoIzquierdo( NodoRojoNegro<T> nodo )
	{
		boolean es=false;

		if (hijoIzquierdo==nodo) {
			es=true;
		}


		return es;
	}

	/**
	 * Verifica si el hijo derecho del nodo es una hoja.
	 * 
	 */
	public boolean hijoDerechoHoja( )
	{
		return hijoDerecho.comparendo == null;
	}

	/**
	 * Verifica si el hijo izquierdo del nodo es una hoja.
	 * 
	 */
	public boolean hijoIzquierdoHoja( )
	{
		return hijoIzquierdo.comparendo == null;
	}

	/**
	 * Retorna el mayor de los descendientes del nodo.
	 * 
	 * @return El mayor de los descendientes del nodo.
	 */
	public T darMayor( )
	{
		return hijoDerechoHoja( ) ? (T) comparendo : hijoDerecho.darMayor( );
	}

	/**
	 * Retorna el menor de los descendientes del nodo.
	 * 
	 * @return El menor de los descendientes del nodo.
	 */
	public T darMenor( )
	{
		return hijoIzquierdoHoja( ) ?  comparendo : hijoIzquierdo.darMenor( );
	}

	/**
	 * Construye una lista con los elementos descendientes del nodo en preorden
	 * 
	 * @param preorden La lista en donde se agregarán los descendientes del nodo en preorden.
	 */
	public void darPreorden( List<T> preorden )
	{
		preorden.add( (T) comparendo );
		if( !hijoIzquierdoHoja( ) )
			hijoIzquierdo.darPreorden( preorden );
		if( !hijoDerechoHoja( ) )
			hijoDerecho.darPreorden( preorden );
	}

	/**
	 * Verifica si el nodo es una hoja.
	 * es decir si es de los que son null :v
	 * 
	 */
	public boolean esHoja( )
	{ boolean es=false;

	if (comparendo==null) {
		es=true;
	}


	return es;
	}

	/**
	 * Retorna  cantidad de descendientes del nodo
	 * 
	 * @return cantidad  de descendientes del nodo
	 */
	public int darPeso( )
	{
		return esHoja( ) ? 0 : 1 + hijoDerecho.darPeso( ) + hijoIzquierdo.darPeso( );
	}

	/**
	 * Construye una lista con los descendientes hoja del nodo.
	 * 
	 * @param hojas La lista en donde se agregarán los descendientes hoja del nodo.
	 */
	public void darHojas( List<NodoRojoNegro<T>> hojas )
	{
		if( esHoja( ) )
			hojas.add( this );
		else
		{
			if( !hijoDerechoHoja( ) )
				hijoDerecho.darHojas( hojas );
			if( !hijoIzquierdoHoja( ) )
				hijoIzquierdo.darHojas( hojas );
		}
	}

	/**
	 * Retorna la altura del nodo.
	 * 
	 * @return La altura del nodo.
	 */
	public int darAltura( )
	{
		if( esHoja( ) )
			return 0;
		int a1 = hijoIzquierdo.darAltura( );
		int a2 = hijoDerecho.darAltura( );
		return ( a1 >= a2 ) ? a1 + 1 : a2 + 1;
	}

	/**
	 * Verifica si el nodo tiene un descendiente con el comparendo  por parametro.
	 * 
	 * @param e Información a buscar.
	 * @return <code>true</code> si existe un descendiente del nodo con la información ingresada por parametro o <code>false</code> en caso contrario.
	 */
	public boolean existe( int Pllave )
	{
		try
		{
			darNodo( Pllave );
			return true;
		}
		catch( ElementoNoExisteException e )
		{
			return false;
		}

	}

	/**
	 * Busca el nodo que contiene llave como parametro.
	 * 
	 * @param comaparendo buscado en el nodo.
	 * @return El nodo que contiene comparendo por parametro.
	 * @throws NoExisteException En caso de no encontrar la información buscada.
	 */
	public T darNodo( int Pllave ) throws ElementoNoExisteException
	{
		int comp = Pllave-this.darLlaveNodo();
		if( comp == 0 )
			return (T) comparendo;
		else if( comp < 0 )
		{
			if( !hijoIzquierdoHoja( ) )
				return hijoIzquierdo.darNodo( Pllave );
			else{
				throw new ElementoNoExisteException( "El elemento con llave parametro buscado no existe" );

			}
		}
		else
		{
			if( !hijoDerechoHoja( ) )
				return hijoDerecho.darNodo( Pllave );
			else{
				throw new ElementoNoExisteException( "El elemento con llave parametro buscado no existe" );

			}

		}

	}

	/**
	 * Retorna la información del nodo.
	 * 
	 * @return La información guardada en el nodo.
	 */
	public Comparendo darInfoNodo( )
	{
		return  (Comparendo) comparendo;
	}

	/**
	 * El arbol ya estar ordenado segun el id de los comparendos
	 * 
	 * @return La información guardada en el nodo.
	 */
	public int darLlaveNodo( )
	{
		return  llave;
	}

	/**
	 * 
	 * 
	 * Verifica si el hijo derecho del nodo es negro.
	 * 
	 * @return <code>true</code> si el hijo derecho es negro o <code>false</code> en caso contrario.
	 */
	public boolean hijoDerechoNegro( )
	{
		if ( hijoDerecho.color == NEGRO) {
			return true;
		}else {
			return false ;

		}
	}

	/**
	 * Verifica si el hijo izquierdo del nodo es negro.
	 * 
	 * @return si en negro true, sino false
	 */
	public boolean hijoIzquierdoNegro( )
	{
		if ( hijoIzquierdo.color == NEGRO) {
			return true;
		}else {
			return false ;

		}
	}

	/**
	 * Verifica si los hijos del nodo son negro.
	 * 
	 * @return <code>true</code> si los hijos son negros o <code>false</code> en caso contrario.
	 */
	public boolean hijosNegros( )
	{
		return hijoDerechoNegro( ) && hijoIzquierdoNegro( );
	}

	/**
	 * Retorna el hermano del nodo.
	 * 
	 * @return El hermano del nodo o <code>null</code> en caso de no tener hermano.
	 */
	public NodoRojoNegro<T> darHermano( )
	{
		if( padre == null )
			return null;
		else
			return padre.esHijoDerecho( this ) ? padre.hijoIzquierdo : padre.hijoDerecho;
	}

	// -----------------------------------------------------------------
	// Modificadores básicos
	// -----------------------------------------------------------------

	/**
	 * Modifica el padre del nodo
	 * </p>
	 * Este método NO mantiene encadenamientos del nuevo padre al nodo.
	 * 
	 * @param padre Nuevo padre del nodo
	 */
	public void cambiarPadre( NodoRojoNegro<T> padre )
	{
		this.padre = padre;
	}

	/**
	 * Cambia el color del nodo.
	 * 0 es rojo y uno es negro
	 * @param color Nuevo color del nodo.
	 */
	protected void cambiarColor( int color )
	{
		this.color = color;
	}

	/**
	 * Modifica el hijo derecho del nodo.
	 * </p>
	 * Este mÃ©todo mantiene el encadenamiento de los nodos en ambos sentidos.
	 * 
	 * @param hijo Nuevo hijo derecho del nodo.
	 */
	public void cambiarHijoDerecho( NodoRojoNegro<T> hijo )
	{
		if( hijo != null )
			hijo.cambiarPadre( this );
		hijoDerecho = hijo;
	}

	/**
	 * Modifica el hijo izquierdo del nodo.
	 * </p>
	 * Este método mantiene el encadenamiento de los nodos en ambos sentidos.
	 * 
	 * @param hijo Nuevo hijo izquierdo del nodo.
	 */
	public void cambiarHijoIzquierdo( NodoRojoNegro<T> hijo )
	{
		if( hijo != null )
			hijo.cambiarPadre( this );
		hijoIzquierdo = hijo;
	}

	/**
	 * Intercambia la información de dos nodos. Este metodo no implica cambios de encadenamientos.
	 * 
	 * @param nodo Nodo con el que se quiere intercambiar la información.
	 */
	public void cambiarComparendo( NodoRojoNegro<T> nodo )
	{
		if( nodo.comparendo != null )
		{
			Comparendo aux =  (Comparendo) comparendo;
			comparendo = nodo.comparendo;
			nodo.comparendo =  (T) aux;
		}
		else
		{
			comparendo = null;
			color = NEGRO;
			hijoDerecho = hijoIzquierdo = null;
		}
	}

	/**
	 * Rota a la derecha el nodo.
	 * 
	 * @return El nodo rotado a la derecha.
	 */
	public NodoRojoNegro<T> rotarIzquierda( )
	{
		if( hijoDerechoHoja( ) )
			return this;
		else
		{
			NodoRojoNegro<T> hijoDerechoAux = hijoDerecho;
			cambiarHijoDerecho( hijoDerechoAux.darHijoIzquierdo( ) );
			hijoDerechoAux.cambiarPadre( padre );
			hijoDerechoAux.cambiarHijoIzquierdo( this );
			return hijoDerechoAux;
		}
	}

	/**
	 * Rota a la izquierda el nodo.
	 * 
	 * @return El nodo rotado a la izquierda.
	 */
	public NodoRojoNegro<T> rotarDerecha( )
	{
		if( hijoIzquierdoHoja( ) )
			return this;
		else
		{
			NodoRojoNegro<T> hijoIzquierdoAux = hijoIzquierdo;
			cambiarHijoIzquierdo( hijoIzquierdoAux.darHijoDerecho( ) );
			hijoIzquierdoAux.cambiarPadre( padre );
			hijoIzquierdoAux.cambiarHijoDerecho( this );
			return hijoIzquierdoAux;
		}
	}
	// -----------------------------------------------------------------
	// Métodos de inserción
	// -----------------------------------------------------------------

	// se tomo como ejemplo y guia la informacion de https://www.infor.uva.es/~cvaca/asigs/doceda/rojonegro.pdf
	/**
	 * Inserta un nodo en la raiz de un árbol rojo negro.
	 * 
	 * @param nodo Nodo a ingresar.
	 * @return La nueva raiz del árbol o <code>null</code> si no hubo cambio de raiz.
	 * @throws ExisteException Si el no ya existe en el árbol.
	 */
	protected NodoRojoNegro<T> insertar( NodoRojoNegro<T> nodo ) throws ElementoExisteException
	{
		insertarNormal( nodo );
		Rewind r = new Rewind( null );
		nodo.balanceoCaso1( r );
		return r.respuesta;
	}

	/**
	 * Inserta un nuevo nodo a partir de <code>this</code> como si el árbol fuera un árbol binario ordenado. El utilizar unicamente este método NO conserva las propiedades
	 * del árbol rojo-negro.
	 * 
	 * @param nodo Nuevo nodo a insertar.
	 * @throws ExisteException Si ya existe un nodo con la misma información del nuevo nodo.
	 * @see NodoRojoNegro#balanceoCaso1()
	 */
	private void insertarNormal( NodoRojoNegro<T> nodo ) throws ElementoExisteException
	{
		if( llave==nodo.darLlaveNodo())
		{
			Comparendo x = nodo.darInfoNodo();
			
		 darInfoNodo().cambioDeTodo(x.darFecha(), x.darMedioDete(), x.darClaseVehi(), x.darTipoServi(), x.darCodInfrac(), x.darDesInfrac(), x.darLocalidad(), x.darMuni(), x.getLongitud(), x.darLatitud());	
		}
		else if(llave<nodo.darLlaveNodo())
		{
			if( hijoDerechoHoja( ) )
			{
				hijoDerecho = nodo;
				nodo.cambiarPadre( this );
			}
			else
			{
				hijoDerecho.insertarNormal( nodo );
			}
		}
		else
		{
			if( hijoIzquierdoHoja( ) )
			{
				hijoIzquierdo = nodo;
				nodo.cambiarPadre( this );
			}
			else
			{
				hijoIzquierdo.insertarNormal( nodo );
			}
		}
	}

	/**
	 *  caso 1 para insertar, este metodo va a hacer uso de los otros si no se cumple, es decir va a revisar si es caso1 , si no es pasa a caso y asi hasta caso 5
	 *  
	 * Consiste en agregar un nodo en un árbol de peso 1.
	 */
	private NodoRojoNegro<T> balanceoCaso1( Rewind r )
	{
		if( padre == null )
		{
			color = NEGRO;
			r.respuesta = this;
		}
		else
		{
			balanceoCaso2( r );
		}
		return r.respuesta;
	}

	/**
	 * Segundo caso de balanceo en inserción.
	 * 
	 * Si el padre del nodo agregado es negro no se debe hacer nada ya que reemplazar una hoja con un nodo rojo no afecta las propiedades del árbol.
	 */
	private void balanceoCaso2( Rewind r )
	{
		if( padre.darColor( ) == ROJO )
			balanceoCaso3( r );
		else
			r.respuesta = null;

	}

	/**
	 *  caso 3 para insertar
	 * 
	 * El nodo agregado tiene un padre y un tio rojos.
	 */
	private void balanceoCaso3( Rewind r )
	{
		NodoRojoNegro<T> tio = darTio( );
		NodoRojoNegro<T> abuelo = padre.darPadre( );
		r.respuesta = null;

		if( !tio.esHoja( ) && tio.darColor( ) == ROJO )
		{
			darPadre( ).cambiarColor( NEGRO );
			tio.cambiarColor( NEGRO );
			abuelo.cambiarColor( ROJO );
			abuelo.balanceoCaso1( r );
		}
		else
		{
			balanceCaso4( r );
		}
	}

	/**
	 *  caso 4 para insertar
	 * 
	 * El nodo ingresado es hijo derecho, su padre es hijo izquierdo y ambos son rojos. El caso reflejado también se cubre.
	 * 
	 */
	private void balanceCaso4( Rewind r )
	{
		NodoRojoNegro<T> abuelo = padre.darPadre( );
		r.respuesta = null;

		if( padre.esHijoDerecho( this ) && abuelo.esHijoIzquierdo( padre ) )
		{
			abuelo.cambiarHijoIzquierdo( padre.rotarIzquierda( ) );
			hijoIzquierdo.balanceoCaso5( r );
		}
		else if( padre.esHijoIzquierdo( this ) && abuelo.esHijoDerecho( padre ) )
		{
			abuelo.cambiarHijoDerecho( padre.rotarDerecha( ) );
			hijoDerecho.balanceoCaso5( r );
		}
		else
		{
			balanceoCaso5( r );
		}
	}

	/**
	 *  caso 5 para insertar
	 * </p>
	 * El nodo y su padre son hijos izquierdos, son rojos y el tio es negro. El caso reflejado también se cubre.
	 * osea padre e hijo son rojos y en la esquina lateral de el arbol y tio en negro.
	 */
	private void balanceoCaso5( Rewind r )
	{
		NodoRojoNegro<T> abuelo = padre.darPadre( );

		padre.cambiarColor( NEGRO );
		abuelo.cambiarColor( ROJO );

		if( padre.esHijoIzquierdo( this ) && abuelo.esHijoIzquierdo( padre ) )
		{
			if( abuelo.darPadre( ) == null )
				abuelo.rotarDerecha( );
			else if( abuelo.darPadre( ).esHijoDerecho( abuelo ) ){

				abuelo.darPadre( ).cambiarHijoDerecho( abuelo.rotarDerecha( ) );
			}

			else{

				abuelo.darPadre( ).cambiarHijoIzquierdo( abuelo.rotarDerecha( ) );
			}

		}
		else
		{
			if( abuelo.darPadre( ) == null )
				abuelo.rotarIzquierda( );
			else if( abuelo.darPadre( ).esHijoDerecho( abuelo ) )
				abuelo.darPadre( ).cambiarHijoDerecho( abuelo.rotarIzquierda( ) );
			else
				abuelo.darPadre( ).cambiarHijoIzquierdo( abuelo.rotarIzquierda( ) );
		}
		r.respuesta = padre;
	}


	public NodoRojoNegro<T> eliminar( NodoRojoNegro<T> nodo ) throws ElementoNoExisteException{
		return nodo;

	}





	public String toString( )
	{
		return ( comparendo != null ? comparendo.toString( ) : "null" ) + ( color == ROJO ? " red" : " black" );
	}


	/**
	 * Estructura para retornar la raíz del árbol rojo-negro resultado de un proceso de modificación.
	 */
	//its rewind time :V
	private class Rewind
	{
		// -----------------------------------------------------------------
		// Atributos
		// -----------------------------------------------------------------

		/**
		 * Raíz del árbol de respuesta
		 */
		private NodoRojoNegro<T> respuesta;

		// -----------------------------------------------------------------
		// Constructores
		// -----------------------------------------------------------------



		private Rewind( NodoRojoNegro<T> pRespuesta )
		{
			respuesta = pRespuesta;
		}
	}

}
