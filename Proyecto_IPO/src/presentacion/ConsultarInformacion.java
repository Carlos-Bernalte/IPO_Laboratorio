package presentacion;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
import dominio.Empleado;
import dominio.GenericDAO;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarInformacion extends JPanel {
	private JTabbedPane tabbedPaneConsultarInformacion;
	private JPanel tabParcelas;
	private JPanel tabBungalows;
	private JPanel tabRutas;
	private JPanel tabActividades;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JLabel lblLabelLocalizacion;
	private JLabel lblImagen;
	private JLabel lblLabelLocalizacion1;
	private JLabel lblImagen1;
	private JScrollPane scrollPaneParcelas;
	private JList listaParcelas;
	private JScrollPane scrollPane;
	private JList listaBungalows;

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
		gbl_tabParcelas.columnWidths = new int[]{900, 10, 160, 0};
		gbl_tabParcelas.rowHeights = new int[]{126, 1, 0};
		gbl_tabParcelas.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_tabParcelas.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		tabParcelas.setLayout(gbl_tabParcelas);
		
		scrollPaneParcelas = new JScrollPane();
		scrollPaneParcelas.setBackground(Paleta.azul_turquesa2);
		GridBagConstraints gbc_scrollPaneParcelas = new GridBagConstraints();
		gbc_scrollPaneParcelas.gridheight = 2;
		gbc_scrollPaneParcelas.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneParcelas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneParcelas.gridx = 0;
		gbc_scrollPaneParcelas.gridy = 0;
		tabParcelas.add(scrollPaneParcelas, gbc_scrollPaneParcelas);
		
		listaParcelas = new JList();
		listaParcelas.setBackground(Paleta.azul_turquesa2);
		listaParcelas.addListSelectionListener(new ListaParcelasListSelectionListener());
		scrollPaneParcelas.setViewportView(listaParcelas);
		GridBagConstraints gbc_listParcelas = new GridBagConstraints();
		gbc_listParcelas.gridheight = 2;
		gbc_listParcelas.insets = new Insets(0, 0, 0, 5);
		gbc_listParcelas.fill = GridBagConstraints.BOTH;
		gbc_listParcelas.gridx = 0;
		gbc_listParcelas.gridy = 0;
		listaParcelas.setCellRenderer(new RenderizadoAlojamiento());
		
		
		lblLabelLocalizacion = new JLabel("Localizacion");
		lblLabelLocalizacion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblLabelLocalizacion = new GridBagConstraints();
		gbc_lblLabelLocalizacion.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblLabelLocalizacion.insets = new Insets(0, 0, 5, 0);
		gbc_lblLabelLocalizacion.gridx = 2;
		gbc_lblLabelLocalizacion.gridy = 0;
		tabParcelas.add(lblLabelLocalizacion, gbc_lblLabelLocalizacion);
		
		lblImagen = new JLabel("");
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.gridx = 2;
		gbc_lblImagen.gridy = 1;
		tabParcelas.add(lblImagen, gbc_lblImagen);
		
		
		tabBungalows = new JPanel();
		tabBungalows.setBackground(Paleta.azul_turquesa);
		tabbedPaneConsultarInformacion.addTab("Bungalows", null, tabBungalows, null);
		GridBagLayout gbl_tabBungalows = new GridBagLayout();
		gbl_tabBungalows.columnWidths = new int[]{900, 10, 89, 0};
		gbl_tabBungalows.rowHeights = new int[]{126, 138, 0};
		gbl_tabBungalows.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_tabBungalows.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		tabBungalows.setLayout(gbl_tabBungalows);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		tabBungalows.add(scrollPane, gbc_scrollPane);
		
		listaBungalows = new JList();
		listaBungalows.addListSelectionListener(new ListaBungalowsListSelectionListener());
		listaBungalows.setSelectedIndex(0);
		listaBungalows.setBackground(new Color(0, 88, 122));
		scrollPane.setViewportView(listaBungalows);
		refresh(gdao);
		listaBungalows.setCellRenderer(new RenderizadoAlojamiento());
		
		lblLabelLocalizacion1 = new JLabel("Localizacion");
		lblLabelLocalizacion1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblLabelLocalizacion1 = new GridBagConstraints();
		gbc_lblLabelLocalizacion1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblLabelLocalizacion1.insets = new Insets(0, 0, 5, 0);
		gbc_lblLabelLocalizacion1.gridx = 2;
		gbc_lblLabelLocalizacion1.gridy = 0;
		tabBungalows.add(lblLabelLocalizacion1, gbc_lblLabelLocalizacion1);
		
		lblImagen1 = new JLabel("");
		GridBagConstraints gbc_lblImagen1 = new GridBagConstraints();
		gbc_lblImagen1.gridx = 2;
		gbc_lblImagen1.gridy = 1;
		tabBungalows.add(lblImagen1, gbc_lblImagen1);
		
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
		
		listaParcelas.setSelectedIndex(0);
		listaBungalows.setSelectedIndex(0);
	}
	public void refresh(GenericDAO gdao) {
		DefaultListModel<Alojamiento> modeloLista = new DefaultListModel<Alojamiento>();
		listaParcelas.setModel(modeloLista);
		DefaultListModel<Alojamiento> modeloLista2 = new DefaultListModel<Alojamiento>();
		listaBungalows.setModel(modeloLista2);
		Vector<Alojamiento> lAlojamiento=gdao.getListaAlojamientos();
		for(int i=0; i<lAlojamiento.size(); i++) {
			if(lAlojamiento.elementAt(i).getClass().toString().equals("class dominio.Parcela")) {
				modeloLista.addElement(lAlojamiento.get(i));
			}else if (lAlojamiento.elementAt(i).getClass().toString().equals("class dominio.Bungalow")){
				modeloLista2.addElement(lAlojamiento.get(i));
			}
		}
	}
	private class ListaParcelasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			Alojamiento a = (Alojamiento) listaParcelas.getSelectedValue();
			lblImagen.setIcon(new ImageIcon(MainWindow.class.getResource(a.getFoto())));
		}
	}
	private class ListaBungalowsListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			Alojamiento a = (Alojamiento) listaBungalows.getSelectedValue();
			lblImagen1.setIcon(new ImageIcon(MainWindow.class.getResource(a.getFoto())));
		}
	}
}
