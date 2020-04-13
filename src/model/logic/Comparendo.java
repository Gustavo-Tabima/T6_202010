package model.logic;
import java.util.Date;

public class Comparendo {
	private int id;
	private Date fecha;
	private String medioDete;
	private String claseVehi;
	private String tipoServi;
	private String codInfrac;
	private String descrepInfrac;
	private String municipio;
	private String localidad;
	private double longitud;
	private double latitud;

	public Comparendo(int id, Date fecha, String medioDete, String claseDeVehiculo, String tipoDeServicio, String codigoInfraccion,String descripcionInfraccion, String localidad, String municipio, double longitud, double latitud) {

		this.id = id;

		this.fecha = fecha;

		this.medioDete = medioDete;

		this.claseVehi = claseDeVehiculo;

		this.tipoServi = tipoDeServicio;

		this.codInfrac = codigoInfraccion;

		this.descrepInfrac = descripcionInfraccion;


		this.localidad = localidad;

		this.longitud = longitud;
		this.municipio=municipio;

		this.latitud = latitud;
	}

	public int dartId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public Date darFecha() {

		return fecha;
	}


	public void setFecha(Date fecha) {


		this.fecha = fecha;
	}

	public String darClaseVehi() {

		return claseVehi;
	}
	
	public String darMuni(){
		return municipio;
	}

	public void setClaseVehi(String claseDeVehi) {

		this.claseVehi = claseDeVehi;

	}

	public String darTipoServi() {
		return tipoServi;

	}

	public void setTipoServi(String PtipoServi) {
		tipoServi = PtipoServi;

	}

	public String darCodInfrac() {

		return codInfrac;

	}
	public void setCodInfrac(String codInfrac) {

		this.codInfrac = codInfrac;

	}
	public String darDesInfrac() {

		return descrepInfrac;

	}
	public void setDescrpInfraccion(String descripcion) {

		this.descrepInfrac = descripcion;

	}
	public String darLocalidad() {

		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String darMedioDete() {
		return medioDete;
	}

	public void setMedioDete(String medioDete) {
		this.medioDete = medioDete;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double darLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	// este metodo es para cuando el nodo que se quiera meter tiene una llave que ya existe
	//, lo que se hace es que cambia toda la info por la del nodo parametro
	public void cambioDeTodo( Date fecha, String medioDete, String claseDeVehiculo, String tipoDeServicio, String codigoInfraccion,String descripcionInfraccion, String localidad, String municipio, double longitud, double latitud) 
{

		this.fecha = fecha;

		this.medioDete = medioDete;

		this.claseVehi = claseDeVehiculo;

		this.tipoServi = tipoDeServicio;

		this.codInfrac = codigoInfraccion;

		this.descrepInfrac = descripcionInfraccion;


		this.localidad = localidad;

		this.longitud = longitud;
		this.municipio=municipio;

		this.latitud = latitud;
		
	}

	public String toString() {
		return "Comparendo [OBJECTID=" + id + ", FECHA_HORA=" + fecha + ", DES_INFRAC=" + descrepInfrac
				+ ", MEDIO_DETE=" + medioDete + ", CLASE_VEHI=" + claseVehi + ", TIPO_SERVI=" + tipoServi
				+ ", INFRACCION=" + codInfrac + ", LOCALIDAD=" + localidad + ", latitud=" + latitud + ", longitud="
				+ longitud +
				"Municipio="+municipio+"]";
	}
}
