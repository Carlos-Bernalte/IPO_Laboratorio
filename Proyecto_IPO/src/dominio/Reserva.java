package dominio;

import java.util.Date;

public class Reserva {
	
	
	private String nombre;
	private long telefono;
	private String email;
	private int numeroOcupantes;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String solicitudes;
	
	public Reserva(String nombre, long telefono, String email, int numeroOcupantes, Date fechaEntrada, Date fechaSalida,
			String solicitudes) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.numeroOcupantes = numeroOcupantes;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.solicitudes = solicitudes;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumeroOcupantes() {
		return numeroOcupantes;
	}
	public void setNumeroOcupantes(int numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
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
	
}
