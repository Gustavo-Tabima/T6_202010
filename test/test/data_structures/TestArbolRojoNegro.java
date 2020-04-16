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

	private Comparendo co5;
	
	@Before
	public void setUp1() throws ElementoExisteException {
		Comparendo co1= new Comparendo(1, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		Comparendo co2= new Comparendo(2, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		Comparendo co3= new Comparendo(3, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		Comparendo co4= new Comparendo(4, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		 co5= new Comparendo(5, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);

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
	public void testDarTamano() throws ElementoExisteException {
		// TODO
		setUp1();
		assertEquals(5, pre.darPeso());
	}

	@Test
	public void testPut() throws ElementoExisteException {
		// TODO Completar la prueba
		setUp1();
		Comparendo co6= new Comparendo(6, x, "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", "sasa", 1212, 12);
		assertEquals(6, pre.darPeso());


	}

	@Test
	public void testMin() throws ElementoExisteException {
		// TODO Completar la prueba
		setUp1();

		Comparendo u = (Comparendo) pre.darMinimo();
		assertEquals(1, u.dartId());
	}

	@Test
	public void testMax() throws Exception {
		// TODO Completar la prueba
		setUp1();

		Comparendo u = (Comparendo) pre.darMayor();
		assertEquals(5, u.dartId());
	}@Test
	public void testExiste() {
		// TODO Completar la prueba
		assertEquals(false, pre.existe(7));
		
	}
	@Test
	public void testVacio() {
		// TODO Completar la prueba
		boolean bruh=false;
		
		if (pre.darRaiz()==null) {
			bruh= true;
		}
		assertEquals(false, bruh);
	}
}
