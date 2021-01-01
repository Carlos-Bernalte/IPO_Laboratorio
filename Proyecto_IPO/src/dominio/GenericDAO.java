package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class GenericDAO {
	private Vector<Usuario> listaUsuarios;
	private Vector<Empleado> listaEmpleados;
	private Vector<Actividad> listaActividad;
	private Vector<Ruta> listaRutas;
	private Vector<Alojamiento> listaAlojamientos;
	private Vector<Reserva> listaReservas;
	
	public GenericDAO() {
		this.listaUsuarios = leerUsuarios("src/Ficheros/Usuarios.txt");
		this.listaEmpleados = leerEmpleados("src/Ficheros/Empleados.txt");
//		this.listaActividad = leerActividades("src/Ficheros/");
//		this.listaRutas = leerRutas("src/Ficheros/");
//		this.listaAlojamientos = leerAlojamientos("src/Ficheros/");
//		this.listaReservas = leerReservas("src/Ficheros/");
	}
	
	public Vector<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(Vector<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Vector<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(Vector<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Vector<Actividad> getListaActividad() {
		return listaActividad;
	}

	public void setListaActividad(Vector<Actividad> listaActividad) {
		this.listaActividad = listaActividad;
	}

	public Vector<Ruta> getListaRutas() {
		return listaRutas;
	}

	public void setListaRutas(Vector<Ruta> listaRutas) {
		this.listaRutas = listaRutas;
	}

	public Vector<Alojamiento> getListaAlojamientos() {
		return listaAlojamientos;
	}

	public void setListaAlojamientos(Vector<Alojamiento> listaAlojamientos) {
		this.listaAlojamientos = listaAlojamientos;
	}

	public Vector<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(Vector<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	public Vector<Usuario> leerUsuarios(String ruta){
		Vector<Usuario> resultado = new Vector<Usuario>();
		Scanner lector = null;
		try {
			lector = new Scanner(new FileReader(new File(ruta)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		while(lector.hasNext()) {
			StringTokenizer datos = new StringTokenizer(lector.nextLine(),";");
			Usuario u = new Usuario(datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken());
			resultado.add(u);
		}
		return resultado;
	}
	public Vector<Empleado> leerEmpleados(String ruta){
		
		Vector<Empleado> resultado = new Vector<Empleado>();
		Scanner lector = null;
		try {
			lector = new Scanner(new FileReader(new File(ruta)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		while(lector.hasNext()) {
			StringTokenizer datos = new StringTokenizer(lector.nextLine(),";");
			Empleado e = new Empleado(datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken());
			resultado.add(e);
		}
		return resultado;
	}

	public Vector<Actividad> leerActividades(String ruta){
		
		return null;
	}

	public Vector<Ruta> leerRutas(String ruta){
		
		return null;
	}
	
	public Vector<Alojamiento> leerAlojamientos(String ruta){
		
		return null;
	}
	
	public Vector<Reserva> leerReservas(String ruta){
		
		return null;
	}
	
	

}
