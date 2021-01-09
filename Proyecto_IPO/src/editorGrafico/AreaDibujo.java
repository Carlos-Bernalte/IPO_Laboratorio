package editorGrafico;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

public class AreaDibujo extends JLabel{
	
	private ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();
	
	public AreaDibujo(){}
	public void addObjetoGrafico(ObjetoGrafico objg) {
		objetosGraficos.add(objg);
	}
	public ObjetoGrafico getUltimoObjetoGrafico(){
		return objetosGraficos.get(objetosGraficos.size()-1);
	}
	public void paint(Graphics g){
	super.paint(g);
	
	for (int i = 0; i < objetosGraficos.size(); i++) {
		ObjetoGrafico objg = objetosGraficos.get(i);
		if (objg instanceof ImagenGrafico){
			g.drawImage(((ImagenGrafico)objg).getImagen(), objg.getX(),
					objg.getY(), null);
		}else if (objg instanceof lineaGrafico){
			g.setColor(((lineaGrafico)objg).getColor());
			int w = ((lineaGrafico)objg).getX1();
			int h = ((lineaGrafico)objg).getY1();
			g.drawLine(objg.getX(),objg.getY(),w,h);
		} 
	}	
	}
}

