package dominio;

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String nick;
	private String contraseña;
	private String ult_vez_conectado;
	
	public Usuario(String nick, String contraseña, String nombre, String apellidos, String ult_vez_conectado) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.contraseña=contraseña;
		this.ult_vez_conectado = ult_vez_conectado;
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
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", nick=" + nick + ", contraseña="
				+ contraseña + ", ult_vez_conectado=" + ult_vez_conectado + "]";
	}


	public String getUlt_vez_conectado() {
		return ult_vez_conectado;
	}
	public void setUlt_vez_conectado(String ult_vez_conectado) {
		this.ult_vez_conectado = ult_vez_conectado;
	}	
	

}
