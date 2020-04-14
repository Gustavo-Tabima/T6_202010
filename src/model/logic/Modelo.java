package model.logic;


import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.ArbolRojoNegro;
import model.data_structures.ElementoNoExisteException;
import model.data_structures.NodoRojoNegro;



/**
 * Definicion del modelo del mundo
 * @param <T>
 */
public class Modelo<T> {

	//public static String PATH = "./data/Comparendos_DEI_2018_Bogota_D.C.geojson";
	public static String PATH = "./data/Comparendos_DEI_2018_Bogota_D.C_small.geojson";

	public  ArbolRojoNegro datos; 
	public Modelo(){
		datos= new ArbolRojoNegro();
	}

	public void cargarDatos() {


		JsonReader reader;

		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();

			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

			for (JsonElement e : e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
				Date FECHA_HORA = parser.parse(s);

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				String MUNICIPIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("MUNICIPIO").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();


				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, MUNICIPIO, longitud, latitud);
				datos.insertar(c,OBJECTID);
			}

		}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public int darTamano() {
		return datos.darPeso();

	}

	public T darMayorId(){
		Comparendo x = (Comparendo) datos.darMayor();

		return (T) x;

	}

	public T darMenorId(){
		Comparendo x = (Comparendo) datos.darMinimo();

		return (T) x;

	}

	public int darAltura(){
		int x = datos.darAltura();
		return x;

	}
	public double darAlturaP(){
		int x = datos.darAlturaP();
		return x/darTamano();

	}

	public String req2(int llave) throws ElementoNoExisteException{
		return	 datos.buscar(llave)+"";




	}
	public String req3(int datoInt){
		return "";
	}
	public void req4(){

	}
	public void req5(){


	}
	public void req6(){

	}

}

