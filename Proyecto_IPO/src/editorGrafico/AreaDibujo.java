package editorGrafico;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

@SuppressWarnings("serial")
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
		public void removeObjetoGrafico(int x, int y, int tamano) {
			for (int i = 0; i < objetosGraficos.size(); i++) {
				if (Math.abs(objetosGraficos.get(i).getX() - x) <= tamano
						&& Math.abs(objetosGraficos.get(i).getY() - y) <= tamano) {
					objetosGraficos.remove(i);
				}
			}
		}
		public void removeAllObjetoGrafico() {
			for (int i = 0; i < objetosGraficos.size(); i++) {
					objetosGraficos.remove(i);
				}
			}
		}
		
	


