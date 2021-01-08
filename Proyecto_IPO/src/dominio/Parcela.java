package dominio;

public class Parcela extends Alojamiento{

	public Parcela(String tipoAlojamiento,String nombreAlojamiento, String precioPorNoche, String tamaño,
			String descripcion, String capacidadMaxima, String foto) {
		super(nombreAlojamiento, tipoAlojamiento, precioPorNoche, tamaño, descripcion, capacidadMaxima, foto);
	}

}
