package dominio;

import java.io.IOException;

public class Ruta {
	
	private String nombre;
	private String monitor;
	private String horaInicio;
	private String horaFinal;
	private String descripcion;
	private String fotoRuta;
	
	public Ruta(String nombre,String monitor, String horaInicio, String horaFinal, String descripcion, String fotoRuta) {
		super();
		this.nombre=nombre;
		this.monitor = monitor;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.descripcion = descripcion;
		this.fotoRuta = fotoRuta;
	}
	
	public String getNombre() {
		return monitor;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFotoRuta() {
		return fotoRuta;
	}
	public void setFotoRuta(String fotoRuta) {
		this.fotoRuta = fotoRuta;
	}
	public String toString() {
		return "<html><body> &nbsp;"+nombre + " <br> &nbsp;Monitor: " + monitor +" <br>  &nbsp;Hora de inicio: "+horaInicio+ "<br>  &nbsp;Hora de llegada: " + horaFinal + "<br>  &nbsp;Descripción: " + descripcion;
	}
	public String toString2() {
		return monitor+";"+horaInicio+";"+horaFinal+";"+descripcion+";"+fotoRuta;
	}
	public int guardarRuta(Ruta r) throws IOException {
		int valor=0;
		GenericDAO gdao = new GenericDAO();
		valor=gdao.guardarRuta(r);
		return valor;
		
	}
	
}
