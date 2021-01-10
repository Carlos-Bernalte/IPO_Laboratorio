package presentacion;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.*;

@SuppressWarnings("serial")
public class RenderizadoAlojamiento extends DefaultListCellRenderer{
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	private int escenario;
	
	public RenderizadoAlojamiento(int escenario) {
		this.escenario=escenario;
	}
	
	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus){
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		if (value.getClass().toString().equals("class dominio.Parcela")) {
			renderer.setIcon(new ImageIcon(RenderizadoPersonal.class.getResource("/imagenes/parcela.png")));
		} else {
			renderer.setIcon(new ImageIcon(RenderizadoPersonal.class.getResource("/imagenes/bungalow.png")));
		}
		renderer.setBackground(Paleta.azul_turquesa2);
		renderer.setForeground(Color.WHITE);
		if(this.escenario==1) {
			renderer.setBorder(new CompoundBorder(new LineBorder(Paleta.blanco_gris, 8), new EmptyBorder(5, 5, 5, 5)));
			if (isSelected) {
				renderer.setBackground(Paleta.azul_turquesa);
				renderer.setBorder(new LineBorder(Paleta.blanco_gris, 3));
			}
		}else {
			renderer.setBorder(new CompoundBorder(new LineBorder(Paleta.azul_oscuro, 8), new EmptyBorder(5, 5, 5, 5)));
			if (isSelected) {
				renderer.setBackground(Paleta.azul_turquesa);
				renderer.setBorder(new LineBorder(Paleta.azul_oscuro, 3));
			}
		}
			
		return renderer;
	}
}