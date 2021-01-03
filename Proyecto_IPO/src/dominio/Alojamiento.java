package dominio;

public class Alojamiento {
	public Alojamiento(String nombreAlojamiento, String tipoAlojamiento, String precioPorNoche, String tamaño,
			String descripcion, String capacidadMaxima) {
		super();
		this.tipoAlojamiento = tipoAlojamiento;
		this.nombreAlojamiento = nombreAlojamiento;
		this.precioPorNoche = precioPorNoche;
		this.tamaño = tamaño;
		this.descripcion = descripcion;
		this.capacidadMaxima = capacidadMaxima;
	}
	protected String nombreAlojamiento;
	protected String tipoAlojamiento; 
	protected String precioPorNoche;
	protected String tamaño;
	protected String descripcion;
	protected String capacidadMaxima;
	
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
		return "<html><body> &nbsp;"+tipoAlojamiento + "<br> &nbsp;Nombre " + nombreAlojamiento +"<br>  &nbsp;Precio por noche: "+precioPorNoche+ "<br>  &nbsp;Tamaño: " + tamaño + "<br>  &nbsp;Descripcion: " + descripcion+ "<br> &nbsp;Capacidad máxima: "+capacidadMaxima+"</body></html>";
	}

}
