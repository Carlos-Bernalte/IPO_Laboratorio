package dominio;

import java.util.Vector;

public class Empleado {
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String email;
	private String foto;
	private String empleo;
	

	public Empleado(String nombre, String apellido, String dni, String telefono, String email, String foto, String empleo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.foto = foto;
		this.empleo = empleo;
	}

	public Empleado() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getEmpleo() {
		return empleo;
	}

	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}

	@Override
	public String toString() {
		return "<html><body> &nbsp;"+nombre + " " + apellido +"<br>  &nbsp;"+empleo+ "<br>  &nbsp;Telefono: " + telefono + "<br>  &nbsp;Email: " + email+"</body></html>";
	}
	public Vector<Empleado> leerMonitores() {
		Vector<Empleado> e = new Vector<Empleado>();
		Vector<Empleado> e1 = new Vector<Empleado>();
		GenericDAO gdao = new GenericDAO();
		e1=gdao.getListaEmpleados();
		for(int i=0;i<e1.size();i++) {
			if (e1.elementAt(i).getEmpleo().equals("Monitor")) {
				e.add(e1.elementAt(i));
			}
		}
		return e;
	}

}
