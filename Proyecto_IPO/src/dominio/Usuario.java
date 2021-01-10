package dominio;

public class Usuario implements Cloneable{
	private String nombre;
	private String apellidos;
	private String nick;
	private String contraseña;
	private String ultVezConectado;
	
	public Usuario(String nombre, String apellidos, String nick, String contraseña, String ultVezConectado) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.contraseña = contraseña;
		this.ultVezConectado = ultVezConectado;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getUltVezConectado() {
		return ultVezConectado;
	}
	public void setUltVezConectado(String ultVezConectado) {
		this.ultVezConectado = ultVezConectado;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", nick=" + nick + ", contraseña="
				+ contraseña + ", ultVezConectado=" + ultVezConectado + "]";
	}

	public String toString2() {
		return nombre + ";" + apellidos + ";" + nick + ";"+ contraseña + ";" + ultVezConectado;
	}

}
