package presentacion;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dominio.Actividad;

import java.awt.*;

@SuppressWarnings("serial")
public class RenderizadoActividades extends DefaultListCellRenderer{
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	public RenderizadoActividades() {
	}
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus){
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		Actividad a= (Actividad) value;
		renderer.setIcon(new ImageIcon(RenderizadoPersonal.class.getResource("/imagenes/walking.png")));
		renderer.setBorder(new CompoundBorder(new LineBorder(Paleta.blanco_gris, 8), new EmptyBorder(5, 5, 5, 5)));
		renderer.setBackground(Paleta.azul_turquesa2);
		renderer.setForeground(Color.WHITE);
		if (isSelected) {
			renderer.setBackground(Paleta.azul_turquesa);
			renderer.setBorder(new LineBorder(Paleta.blanco_gris, 3));
		}
		return renderer;
	}
}