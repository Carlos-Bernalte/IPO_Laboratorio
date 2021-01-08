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
	public int borrarActividad(Actividad a) throws IOException {
		int valor=0;
		File inFile = new File("src/ficheros/Actividades.txt");
		BufferedReader br = new BufferedReader(new FileReader("src/ficheros/Actividades.txt"));
		PrintWriter pw= new PrintWriter(new FileWriter(inFile));
		String line= null;
		while ((line = br.readLine()) != null) {
			if(!line.equals(a.toString3())){
				System.out.println("Makina");
				pw.println(line);
				pw.flush();
			}
		}
		pw.close();
		br.close();
		return valor;
	}
}
