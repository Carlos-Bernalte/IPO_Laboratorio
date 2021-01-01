package presentacion;

import javax.swing.*;
import java.awt.*;

public class RenderizadoPersonal extends DefaultListCellRenderer{
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	public RenderizadoPersonal() {
		
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus){
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		renderer.setIcon(new ImageIcon(RenderizadoPersonal.class.getResource("/imagenes/usuario.png")));
		return renderer;
	}
}
