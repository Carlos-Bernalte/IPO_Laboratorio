package presentacion;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import dominio.Alojamiento;
import dominio.GenericDAO;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class ConsultarInformacion extends JPanel {
	private JTabbedPane tabbedPaneConsultarInformacion;
	private JPanel tabParcelas;
	private JPanel tabBungalows;
	private JPanel tabRutas;
	private JPanel tabActividades;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JList listParcelas;

	/**
	 * Create the panel.
	 */
	public ConsultarInformacion(GenericDAO gdao) {
		setBackground(Paleta.azul_oscuro);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		tabbedPaneConsultarInformacion = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPaneConsultarInformacion.setForeground(Color.WHITE);
		tabbedPaneConsultarInformacion.setBackground(Paleta.azul_turquesa);
		add(tabbedPaneConsultarInformacion);
		
		tabParcelas = new JPanel();
		tabParcelas.setBackground(Paleta.azul_turquesa);
		tabbedPaneConsultarInformacion.addTab("Parcelas", null, tabParcelas, null);
		GridBagLayout gbl_tabParcelas = new GridBagLayout();
		gbl_tabParcelas.columnWidths = new int[]{367, 66, 161, 0};
		gbl_tabParcelas.rowHeights = new int[]{1, 0};
		gbl_tabParcelas.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_tabParcelas.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		tabParcelas.setLayout(gbl_tabParcelas);
		
		listParcelas = new JList();
		listParcelas.setBackground(Paleta.azul_turquesa2);
		GridBagConstraints gbc_listParcelas = new GridBagConstraints();
		gbc_listParcelas.insets = new Insets(0, 0, 0, 5);
		gbc_listParcelas.fill = GridBagConstraints.BOTH;
		gbc_listParcelas.gridx = 0;
		gbc_listParcelas.gridy = 0;
		tabParcelas.add(listParcelas, gbc_listParcelas);
		refresh(gdao);
		listParcelas.setCellRenderer(new RenderizadoAlojamiento());
		
		
		tabBungalows = new JPanel();
		tabBungalows.setBackground(Paleta.azul_turquesa);
		tabbedPaneConsultarInformacion.addTab("Bungalows", null, tabBungalows, null);
		
		scrollPane_1 = new JScrollPane();
		tabBungalows.add(scrollPane_1);
		
		tabRutas = new JPanel();
		tabRutas.setBackground(Paleta.azul_turquesa);
		tabbedPaneConsultarInformacion.addTab("Rutas", null, tabRutas, null);
		
		scrollPane_2 = new JScrollPane();
		tabRutas.add(scrollPane_2);
		
		tabActividades = new JPanel();
		tabActividades.setBackground(Paleta.azul_turquesa);
		tabbedPaneConsultarInformacion.addTab("Actividades", null, tabActividades, null);
		
		scrollPane_3 = new JScrollPane();
		tabActividades.add(scrollPane_3);

	}
	public void refresh(GenericDAO gdao) {
		DefaultListModel<Alojamiento> modeloLista = new DefaultListModel<Alojamiento>();
		listParcelas.setModel(modeloLista);
		Vector<Alojamiento> lAlojamiento=gdao.getListaAlojamientos();
		for(int i=0; i<lAlojamiento.size(); i++) {
			if(lAlojamiento.elementAt(i).getClass().toString().equals("class dominio.Parcela")) {
				modeloLista.addElement(lAlojamiento.get(i));
			}
		}
		
	}
}
