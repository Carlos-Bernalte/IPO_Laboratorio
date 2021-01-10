package presentacion;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import java.awt.*;

@SuppressWarnings("serial")
public class RenderizadoPersonal extends DefaultListCellRenderer{
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	public RenderizadoPersonal() {
		
	}
	
	public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value, int index, boolean isSelected, boolean hasFocus){
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		renderer.setIcon(new ImageIcon(RenderizadoPersonal.class.getResource("/imagenes/usuario.png")));
		renderer.setBorder(new CompoundBorder(new LineBorder(Paleta.azul_oscuro, 8), new EmptyBorder(5, 5, 5, 5)));
		renderer.setBackground(Paleta.azul_turquesa2);
		renderer.setForeground(Color.WHITE);
		if (isSelected) {
			renderer.setBackground(Paleta.azul_turquesa);
			renderer.setBorder(new LineBorder(Paleta.azul_oscuro, 3));
		}
		return renderer;
	}
}
