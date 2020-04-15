package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArbolRojoNegro;
import model.data_structures.ElementoExisteException;
import model.logic.Comparendo;
import sun.nio.ch.DatagramSocketAdaptor;

public class TestArbolRojoNegro {
	
	public ArbolRojoNegro pre= new ArbolRojoNegro();
	
	Date x= new Date();
	
	@Before
	public void setUp1() throws ElementoExisteException {
		Comparendo co1= new Comparendo(1, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		Comparendo co2= new Comparendo(2, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		Comparendo co3= new Comparendo(3, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		Comparendo co4= new Comparendo(4, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		Comparendo co5= new Comparendo(4, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);

		pre.put(co1, 1);
		pre.put(co2, 2);
		pre.put(co3, 3);
		pre.put(co4, 4);
		pre.put(co5, 4);


		
	}

	

	@Test
	public void testArbol() {
		
	}

	@Test
	public void testDarTamano() {
		// TODO
		assertEquals(4, pre.darPeso());
	}

	@Test
	public void testPut() throws ElementoExisteException {
		// TODO Completar la prueba


	}

	@Test
	public void testBuscar() {
		// TODO Completar la prueba
	}

	
}
