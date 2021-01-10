package dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		this.listaActividad = leerActividades("src/Ficheros/Actividades.txt");
//		this.listaRutas = leerRutas("src/Ficheros/");
		this.listaAlojamientos = leerAlojamientos("src/Ficheros/Alojamientos.txt");
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
		return leerActividades("src/Ficheros/Actividades.txt");
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
	
	public int editarUsuario(Usuario actualizada, Usuario antigua) throws IOException {
		Scanner lector = null;
		try{
			lector= new Scanner(new FileReader(new File("src/ficheros/Usuarios.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		String archivo="";
		while (lector.hasNext()) {
			String line =lector.nextLine();
			if(!line.equals(antigua.toString2())) {
				archivo+=line+"\n";
			}else {
				archivo+=actualizada.toString2()+"\n";
			}
		}
		lector.close();
		FileWriter fw = new FileWriter("src/ficheros/Usuarios.txt", false);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write(archivo.substring(0,archivo.length()-1));
		bw.close();
		return 1;
		
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
		Vector<Actividad> resultado = new Vector<Actividad>();
		Scanner lector = null;
		try{
			lector= new Scanner(new FileReader(new File(ruta)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		while (lector.hasNext()) {
			StringTokenizer datos = new StringTokenizer(lector.nextLine(),";");
			Actividad a = new Actividad(datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken());
			resultado.add(a);
		}
		return resultado;
	}

	public Vector<Ruta> leerRutas(String ruta){
		
		return null;
	}
	
	public Vector<Alojamiento> leerAlojamientos(String ruta){
		Vector<Alojamiento> resultado= new Vector<Alojamiento>();
		Scanner lector= null;
		String tipo;
		try {
			lector= new Scanner(new FileReader(new File(ruta)));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		while(lector.hasNext()) {
			StringTokenizer datos = new StringTokenizer(lector.nextLine(),";");
			if (datos.nextToken().equals("Parcela")) {
				tipo= "Parcela";
				Alojamiento a = new Parcela(tipo,datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken());
				resultado.add(a);
			} else {
				tipo= "Bungalow";
				Alojamiento a = new Bungalow(tipo,datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken(),datos.nextToken());
				resultado.add(a);
			}
			
			
		}
		return resultado;
	}
	
	public Vector<Reserva> leerReservas(String ruta){
		
		return null;
	}
	
	public int reservar(Reserva r) throws IOException {
		int valor=0;
		FileWriter fw = new FileWriter("src/ficheros/Reservas.txt", true);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write(r.toString());
		bw.close();
		return valor;
	}
	public int guardarActividad(Actividad a) throws IOException {
		int valor=0;
		FileWriter fw = new FileWriter("src/ficheros/Actividades.txt", true);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write(a.toString2());
		bw.close();
		return valor;
		}
	@SuppressWarnings("unlikely-arg-type")
	public int borrarActividad(Actividad a) throws IOException {
		
		Scanner lector = null;
		try{
			lector= new Scanner(new FileReader(new File("src/ficheros/Actividades.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		String antiguo="";
		while (lector.hasNext()) {
			String line =lector.nextLine();
			if(!line.equals(a.toString3())) {
				antiguo+=line+"\n";
			}
		}
		lector.close();
		FileWriter fw = new FileWriter("src/ficheros/Actividades.txt", false);
		BufferedWriter bw= new BufferedWriter(fw);
		if(antiguo.length()>1) {
			bw.write(antiguo.substring(0,antiguo.length()-1));
		}else {
			bw.write("");
		}
		bw.close();
		return 1;
	}
	public int editarActividad(Actividad actualizada, Actividad antigua) throws IOException {
		Scanner lector = null;
		try{
			lector= new Scanner(new FileReader(new File("src/ficheros/Actividades.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		String archivo="";
		while (lector.hasNext()) {
			String line =lector.nextLine();
			if(!line.equals(antigua.toString3())) {
				archivo+=line+"\n";
			}else {
				archivo+=actualizada.toString3()+"\n";
			}
		}
		lector.close();
		FileWriter fw = new FileWriter("src/ficheros/Actividades.txt", false);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write(archivo.substring(0,archivo.length()-1));
		bw.close();
		return 1;
		
	}
}
