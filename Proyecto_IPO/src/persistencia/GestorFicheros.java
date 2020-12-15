package persistencia;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import dominio.Usuario;
public class GestorFicheros {
	private Usuario [] usuarios;

	public GestorFicheros() {
		this.usuarios=leerUsuarios();
	}
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario[] leerUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Scanner scUsuarios = null;
		try {
			scUsuarios = new Scanner(new FileReader(new File("src/ficheros/Usuarios.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String nuevoUsuario;

		while (scUsuarios.hasNext()) {
			nuevoUsuario = scUsuarios.nextLine();
			StringTokenizer st = new StringTokenizer(nuevoUsuario, "/");
			Usuario usuario = new Usuario(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(), st.nextToken());
			usuarios.add(usuario);
		}

		scUsuarios.close();
		return usuarios.toArray(new Usuario[usuarios.size()]);
	}
}
