package dominio;

import java.io.IOException;

public class Ruta {

	private String monitor;
	private String horaInicio;
	private String horaFinal;
	private String descripcion;
	private String fotoRuta;
	
	public Ruta(String monitor, String horaInicio, String horaFinal, String descripcion, String fotoRuta) {
		super();
		this.monitor = monitor;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.descripcion = descripcion;
		this.fotoRuta = fotoRuta;
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
	@Override
	public String toString() {
		return monitor+";"+horaInicio+";"+horaFinal+";"+descripcion+";"+fotoRuta+"\n";
	}
	public int guardarRuta(Ruta r) throws IOException {
		int valor=0;
		GenericDAO gdao = new GenericDAO();
		valor=gdao.guardarRuta(r);
		return valor;
		
	}
	
}
