package presentacion;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class RenderizadoRuta extends DefaultListCellRenderer {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	public RenderizadoRuta() {
		
	}
	
	public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value, int index, boolean isSelected, boolean hasFocus){
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		renderer.setIcon(new ImageIcon(RenderizadoRuta.class.getResource("/Iconos/mapaIcono.png")));
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
