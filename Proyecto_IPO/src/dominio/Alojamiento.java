package dominio;


public class Alojamiento {
	public Alojamiento(String nombreAlojamiento, String tipoAlojamiento, String precioPorNoche, String tamaño,
			String descripcion, String capacidadMaxima, String foto) {
		super();
		this.tipoAlojamiento = tipoAlojamiento;
		this.nombreAlojamiento = nombreAlojamiento;
		this.precioPorNoche = precioPorNoche;
		this.tamaño = tamaño;
		this.descripcion = descripcion;
		this.capacidadMaxima = capacidadMaxima;
		this.foto= foto;
	}
	protected String nombreAlojamiento;
	protected String tipoAlojamiento; 
	protected String precioPorNoche;
	protected String tamaño;
	protected String descripcion;
	protected String capacidadMaxima;
	protected String foto;
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNombreAlojamiento() {
		return nombreAlojamiento;
	}
	public void setNombreAlojamiento(String nombreAlojamiento) {
		this.nombreAlojamiento = nombreAlojamiento;
	}
	public String getTipoAlojamiento() {
		return tipoAlojamiento;
	}
	public void setTipoAlojamiento(String tipoAlojamiento) {
		this.tipoAlojamiento = tipoAlojamiento;
	}
	public String getPrecioPorNoche() {
		return precioPorNoche;
	}
	public void setPrecioPorNoche(String precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	public String getTamaño() {
		return tamaño;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(String capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	@Override
	public String toString() {
		return "<html><body> &nbsp;"+tipoAlojamiento + " <br> &nbsp;Nombre: " + nombreAlojamiento +" <br>  &nbsp;Precio por noche: "+precioPorNoche+ "<br>  &nbsp;Tamaño: " + tamaño + "<br>  &nbsp;Descripcion: " + descripcion+ "<br> &nbsp;Capacidad máxima: "+capacidadMaxima+"</body></html>";
	}
	public String toStringNombreAlojamiento(String cadena) {
		String subString= cadena.substring(cadena.indexOf("Nombre:")+8,cadena.indexOf("Precio")-13);
		return subString;
	}
}
