package dominio;

import java.io.IOException;

public class Actividad {
		
		private String nombre;
		private String monitor;
		private String horario;
		private String cupoMínimo;
		private String cupoMaximo;
		private String destinatarios;
		private String precioPorHora;
		private String descripcion;
		private String materialNecesario;
		private String foto;
		
		public Actividad(String nombre, String monitor, String horario, String cupoMínimo, String cupoMaximo, String destinatarios,
				String precioPorHora, String descripcion, String materialNecesario, String foto) {
			super();
			this.nombre = nombre;
			this.monitor = monitor;
			this.horario = horario;
			this.cupoMínimo = cupoMínimo;
			this.cupoMaximo = cupoMaximo;
			this.destinatarios = destinatarios;
			this.precioPorHora = precioPorHora;
			this.descripcion = descripcion;
			this.materialNecesario = materialNecesario;
			this.foto= foto;
		}
		
		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getMonitor() {
			return monitor;
		}
		public void setMonitor(String monitor) {
			this.monitor = monitor;
		}
		public String getHorario() {
			return horario;
		}
		public void setHorario(String horario) {
			this.horario = horario;
		}
		public String getCupoMínimo() {
			return cupoMínimo;
		}
		public void setCupoMínimo(String cupoMínimo) {
			this.cupoMínimo = cupoMínimo;
		}
		public String getCupoMaximo() {
			return cupoMaximo;
		}
		public void setCupoMaximo(String cupoMaximo) {
			this.cupoMaximo = cupoMaximo;
		}
		public String getDestinatarios() {
			return destinatarios;
		}
		public void setDestinatarios(String destinatarios) {
			this.destinatarios = destinatarios;
		}
		public String getPrecioPorHora() {
			return precioPorHora;
		}
		public void setPrecioPorHora(String precioPorHora) {
			this.precioPorHora = precioPorHora;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getMaterialNecesario() {
			return materialNecesario;
		}
		public void setMaterialNecesario(String materialNecesario) {
			this.materialNecesario = materialNecesario;
		}
		public String toString() {
			return "<html><body> &nbsp;"+nombre + " <br> &nbsp;Monitor: " + monitor +" <br>  &nbsp;Horario "+horario+ "<br>  &nbsp;Cupo minimo: " + cupoMínimo + "<br>  &nbsp;Cupo Máximo: " + cupoMaximo+ 
					"<br> &nbsp;Publico: "+destinatarios+  " <br> &nbsp;Precio: " + precioPorHora +  " <br> &nbsp;Descripcion " + descripcion +  " <br> &nbsp;Material: " + materialNecesario + "</body></html>" + "/n";
		}
		public int guardarActividad(Actividad a) throws IOException {
			int guardado=0;
			GenericDAO gdao= new GenericDAO();
			guardado=gdao.guardarActividad(a);
			return guardado;
		}
		public String toString2() {
			return nombre+";"+monitor+";"+horario+";"+cupoMínimo+";"+cupoMaximo+";"+destinatarios+";"+precioPorHora+";"+descripcion+";"+materialNecesario+";"+foto+"\n";
		}
		public int borrarActividad(Actividad a) throws IOException {
			int borrado=0;
			GenericDAO gdao= new GenericDAO();
			borrado=gdao.borrarActividad(a);
			return borrado;
		}
		public String toString3() {
			return nombre+";"+monitor+";"+horario+";"+cupoMínimo+";"+cupoMaximo+";"+destinatarios+";"+precioPorHora+";"+descripcion+";"+materialNecesario+";"+foto;
		}
}
