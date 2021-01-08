package presentacion;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import dominio.Actividad;
import dominio.Alojamiento;
import dominio.Empleado;
import dominio.GenericDAO;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultarInformacion extends JPanel {
	private JTabbedPane tabbedPaneConsultarInformacion;
	private JPanel tabParcelas;
	private JPanel tabBungalows;
	private JPanel tabRutas;
	private JPanel tabActividades;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPaneActividades;
	private JLabel lblLabelLocalizacion;
	private JLabel lblImagen;
	private JLabel lblLabelLocalizacion1;
	private JLabel lblImagen1;
	private JScrollPane scrollPaneParcelas;
	private JList listaParcelas;
	private JScrollPane scrollPane;
	private JList listaBungalows;
	private JList list;
	private JList listActividades;
	private JPanel panel;
	private JLabel lblNombreActividad;
	private JLabel lblMonitor;
	private JLabel lblHorario;
	private JLabel lblCupoMinimo;
	private JLabel lblCupoMaximo;
	private JLabel lblPrecioPorHora;
	private JTextField textFieldNombre;
	private JTextField textFieldMonitor;
	private JTextField textFieldHorario;
	private JTextField textFieldPrecio;
	private JSpinner spinnerCupoMinimo;
	private JSpinner spinnerCupoMaximo;
	private JLabel lblDescripcion;
	private JTextField textFieldDescripcion;
	private JLabel lblMaterialNecesario;
	private JTextField textFieldMaterial;
	private JButton btnEditarActividad;
	private JButton btnBorrarActividad;
	private JButton btnCrearActividad;
	private JButton btnElegirIcono;
	private JTextField textFieldPathIcono;
	private JLabel lblDestinatarios;
	private JTextField textFieldDestinatario;

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
		refreshAlojamiento(gdao);
		scrollPane_2 = new JScrollPane();
		tabRutas.add(scrollPane_2);
		
		tabActividades = new JPanel();
		tabActividades.setBackground(Paleta.azul_turquesa);
		tabbedPaneConsultarInformacion.addTab("Actividades", null, tabActividades, null);
		GridBagLayout gbl_tabActividades = new GridBagLayout();
		gbl_tabActividades.columnWidths = new int[]{800, 194, 0};
		gbl_tabActividades.rowHeights = new int[]{222, 252, 0};
		gbl_tabActividades.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_tabActividades.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		tabActividades.setLayout(gbl_tabActividades);
		
		scrollPaneActividades = new JScrollPane();
		GridBagConstraints gbc_scrollPaneActividades = new GridBagConstraints();
		gbc_scrollPaneActividades.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneActividades.gridheight = 2;
		gbc_scrollPaneActividades.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneActividades.gridx = 0;
		gbc_scrollPaneActividades.gridy = 0;
		tabActividades.add(scrollPaneActividades, gbc_scrollPaneActividades);
		
		listActividades = new JList();
		listActividades.setBackground(Paleta.azul_turquesa);
		GridBagConstraints gbc_listActividades = new GridBagConstraints();
		gbc_listActividades.insets = new Insets(0, 0, 5, 0);
		gbc_listActividades.fill = GridBagConstraints.BOTH;
		gbc_listActividades.gridx = 1;
		gbc_listActividades.gridy = 0;
		scrollPaneActividades.setViewportView(listActividades);
		listActividades.setCellRenderer(new RenderizadoActividades());
		
		panel = new JPanel();
		panel.setBackground(Paleta.azul_turquesa2);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		tabActividades.add(panel, gbc_panel);
		
		lblNombreActividad = new JLabel("Nombre:");
		lblNombreActividad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreActividad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNombreActividad.setForeground(Color.WHITE);
		lblNombreActividad.setBounds(91, 95, 45, 13);
		panel.add(lblNombreActividad);
		
		lblMonitor = new JLabel("Monitor:");
		lblMonitor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonitor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMonitor.setForeground(Color.WHITE);
		lblMonitor.setBounds(91, 164, 45, 13);
		panel.add(lblMonitor);
		
		lblHorario = new JLabel("Horario:");
		lblHorario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setBounds(91, 225, 45, 13);
		panel.add(lblHorario);
		
		lblCupoMinimo = new JLabel("Cupo mínimo:");
		lblCupoMinimo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCupoMinimo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCupoMinimo.setForeground(Color.WHITE);
		lblCupoMinimo.setBounds(61, 308, 75, 13);
		panel.add(lblCupoMinimo);
		
		lblCupoMaximo = new JLabel("Cupo máximo:");
		lblCupoMaximo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCupoMaximo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCupoMaximo.setForeground(Color.WHITE);
		lblCupoMaximo.setBounds(61, 364, 75, 13);
		panel.add(lblCupoMaximo);
		
		lblPrecioPorHora = new JLabel("Precio/Hora:");
		lblPrecioPorHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioPorHora.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPrecioPorHora.setForeground(Color.WHITE);
		lblPrecioPorHora.setBounds(61, 435, 75, 13);
		panel.add(lblPrecioPorHora);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new TextFieldNombreKeyListener());
		textFieldNombre.setBounds(146, 92, 96, 19);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldMonitor = new JTextField();
		textFieldMonitor.addKeyListener(new TextFieldMonitorKeyListener());
		textFieldMonitor.setBounds(146, 161, 96, 19);
		panel.add(textFieldMonitor);
		textFieldMonitor.setColumns(10);
		
		textFieldHorario = new JTextField();
		textFieldHorario.addKeyListener(new TextFieldHorarioKeyListener());
		textFieldHorario.setBounds(146, 222, 96, 19);
		panel.add(textFieldHorario);
		textFieldHorario.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.addKeyListener(new TextFieldPrecioKeyListener());
		textFieldPrecio.setBounds(146, 432, 96, 19);
		panel.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		spinnerCupoMinimo = new JSpinner();
		spinnerCupoMinimo.setBounds(180, 305, 30, 20);
		panel.add(spinnerCupoMinimo);
		
		spinnerCupoMaximo = new JSpinner();
		spinnerCupoMaximo.setBounds(180, 361, 30, 20);
		panel.add(spinnerCupoMaximo);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(304, 95, 85, 13);
		panel.add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.addKeyListener(new TextFieldDescripcionKeyListener());
		textFieldDescripcion.setBounds(304, 118, 155, 160);
		panel.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblMaterialNecesario = new JLabel("Material necesario:");
		lblMaterialNecesario.setForeground(Color.WHITE);
		lblMaterialNecesario.setBounds(304, 405, 117, 13);
		panel.add(lblMaterialNecesario);
		
		textFieldMaterial = new JTextField();
		textFieldMaterial.addKeyListener(new TextFieldMaterialKeyListener());
		textFieldMaterial.setBounds(304, 428, 155, 50);
		panel.add(textFieldMaterial);
		textFieldMaterial.setColumns(10);
		
		btnEditarActividad = new JButton("Editar Actividad");
		btnEditarActividad.setBounds(51, 582, 135, 21);
		panel.add(btnEditarActividad);
		
		btnBorrarActividad = new JButton("Borrar Actividad");
		btnBorrarActividad.setBounds(223, 582, 135, 21);
		panel.add(btnBorrarActividad);
		
		btnCrearActividad = new JButton("Añadir Actividad");
		btnCrearActividad.setEnabled(false);
		btnCrearActividad.addActionListener(new BtnCrearActividadActionListener());
		btnCrearActividad.setBounds(399, 582, 135, 21);
		panel.add(btnCrearActividad);
		
		btnElegirIcono = new JButton("Seleccionar Icono");
		btnElegirIcono.addActionListener(new BtnElegirIconoActionListener());
		btnElegirIcono.setBounds(304, 332, 141, 21);
		panel.add(btnElegirIcono);
		
		textFieldPathIcono = new JTextField();
		textFieldPathIcono.addKeyListener(new TextFieldPathIconoKeyListener());
		textFieldPathIcono.setBounds(466, 333, 124, 19);
		panel.add(textFieldPathIcono);
		textFieldPathIcono.setColumns(10);
		
		lblDestinatarios = new JLabel("Destinatario:");
		lblDestinatarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestinatarios.setForeground(Color.WHITE);
		lblDestinatarios.setBounds(70, 511, 66, 13);
		panel.add(lblDestinatarios);
		
		textFieldDestinatario = new JTextField();
		textFieldDestinatario.addKeyListener(new TextFieldDestinatarioKeyListener());
		textFieldDestinatario.setBounds(146, 508, 96, 19);
		panel.add(textFieldDestinatario);
		textFieldDestinatario.setColumns(10);
		
		refreshActividades(gdao);
		listaParcelas.setSelectedIndex(0);
		listaBungalows.setSelectedIndex(0);
	}
	public void refreshAlojamiento(GenericDAO gdao) {
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
	public void refreshActividades(GenericDAO gdao) {
		DefaultListModel<Actividad> modeloLista3 = new DefaultListModel<Actividad>();
		listActividades.setModel(modeloLista3);
		Vector<Actividad> lActividades=gdao.getListaActividad();
		for(int i=0; i<lActividades.size(); i++) {
			modeloLista3.addElement(lActividades.elementAt(i));
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
	private class BtnCrearActividadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int valor=0;
			try {
				Actividad a = new Actividad(textFieldNombre.getText(),textFieldMonitor.getText(),textFieldHorario.getText(),spinnerCupoMinimo.getValue().toString(),spinnerCupoMaximo.getValue().toString(),textFieldDestinatario.getText(), textFieldPrecio.getText(), textFieldDescripcion.getText(),textFieldMaterial.getText(),textFieldPathIcono.getText());
				valor=a.guardarActividad(a);
				GenericDAO gdao= new GenericDAO();
				refreshActividades(gdao);
			} catch (NoSuchElementException e1) {
				System.out.println("Hay algun dato vacio, por favor rellenalo");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class BtnElegirIconoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			 FileFilter filtro = new FileNameExtensionFilter("Imagenes (png)", ".png");
			 fileChooser.setFileFilter(filtro);
			try {
				fileChooser.showOpenDialog(fileChooser);
		      textFieldPathIcono.setText(fileChooser.getSelectedFile().getAbsolutePath());
			} catch (NullPointerException ex) {
				System.out.println("Elige un archivo");
			}
	        
		}
	}
	private class TextFieldNombreKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
			} else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldMonitorKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
			}
	}
	private class TextFieldHorarioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldPrecioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldDestinatarioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldDescripcionKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldMaterialKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
		
	}
	private class TextFieldPathIconoKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) {
				btnCrearActividad.setEnabled(true);
		}else {
			btnCrearActividad.setEnabled(false);
		}
	}
}
}
	
	
