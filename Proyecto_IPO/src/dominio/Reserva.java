package dominio;

import java.io.IOException;
import java.util.Date;

public class Reserva {
	
	private String nombreAlojamiento;
	private String nombre;
	private String telefono;
	private String email;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String solicitudes;
	
	public Reserva(String nombreAlojamiento,String nombre, String telefono, String email, Date fechaEntrada, Date fechaSalida,
			String solicitudes) {
		this.nombreAlojamiento= nombreAlojamiento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.solicitudes = solicitudes;
	}
	
	public String getNombreAlojamiento() {
		return nombreAlojamiento;
	}


	public void setNombreAlojamiento(String nombreAlojamiento) {
		this.nombreAlojamiento = nombreAlojamiento;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(String solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public int guardarReserva(Reserva r) throws IOException {
		int guardado=0;
		GenericDAO gdao= new GenericDAO();
		guardado=gdao.reservar(r);
		return guardado;
	}
	
	public String toString() {
		return ""+nombreAlojamiento+";"+nombre+";"+telefono+";"+email+";"+fechaEntrada+";"+fechaSalida+";"+solicitudes+";\n";
	}
}
