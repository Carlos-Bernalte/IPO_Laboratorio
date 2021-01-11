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
import dominio.GenericDAO;
import dominio.Ruta;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ConsultarInformacion extends JPanel {
	private JTabbedPane tabbedPaneConsultarInformacion;
	private JPanel tabParcelas;
	private JPanel tabBungalows;
	private JPanel tabRutas;
	private JPanel tabActividades;
	private JScrollPane scrollPaneActividades;
	private JLabel lblImagen;
	private JLabel lblImagen1;
	private JScrollPane scrollPaneParcelas;
	private JList<Alojamiento> listaParcelas;
	private JScrollPane scrollPaneBungalows;
	private JList<Alojamiento> listaBungalows;
	private JList<Actividad> listActividades;
	private JPanel informacionActividad;
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
	private JLabel lblMaterialNecesario;
	private JTextField textFieldMaterial;
	private JButton btnEditarActividad;
	private JButton btnCrearActividad;
	private JButton btnElegirIcono;
	private JTextField textFieldPathIcono;
	private JLabel lblDestinatarios;
	private JTextField textFieldDestinatario;
	private JButton btnNewButton;
	private JTextArea textFieldDescripcion;
	private JScrollPane scrollPaneRutas;
	private JList<Ruta> listRutas;
	private JLabel imagenRuta;

	/**
	 * Create the panel.
	 */
	public ConsultarInformacion(GenericDAO gdao) {
		UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0)); //$NON-NLS-1$
		UIManager.put("TabbedPane.selected", Paleta.blanco_gris); //$NON-NLS-1$
		
		setBackground(Paleta.azul_oscuro);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		tabbedPaneConsultarInformacion = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPaneConsultarInformacion.setVerifyInputWhenFocusTarget(false);
		tabbedPaneConsultarInformacion.setIgnoreRepaint(true);
		tabbedPaneConsultarInformacion.setFocusTraversalKeysEnabled(false);
		tabbedPaneConsultarInformacion.setFocusable(false);
		tabbedPaneConsultarInformacion.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneConsultarInformacion.setBorder(null);
		tabbedPaneConsultarInformacion.setForeground(Color.BLACK);
		tabbedPaneConsultarInformacion.setBackground(Paleta.azul_turquesa2);
		add(tabbedPaneConsultarInformacion);
		
		tabParcelas = new JPanel();
		tabParcelas.setBorder(null);
		tabParcelas.setBackground(Paleta.blanco_gris);
		tabbedPaneConsultarInformacion.addTab(Messages.getString("ConsultarInformacion.2"), null, tabParcelas, null); //$NON-NLS-1$
		GridBagLayout gbl_tabParcelas = new GridBagLayout();
		gbl_tabParcelas.columnWidths = new int[]{900, 10, 160, 0};
		gbl_tabParcelas.rowHeights = new int[]{126, 1, 0};
		gbl_tabParcelas.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_tabParcelas.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		tabParcelas.setLayout(gbl_tabParcelas);
		
		scrollPaneParcelas = new JScrollPane();
		scrollPaneParcelas.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPaneParcelas.setBackground(Paleta.blanco_gris);
		GridBagConstraints gbc_scrollPaneParcelas = new GridBagConstraints();
		gbc_scrollPaneParcelas.gridheight = 2;
		gbc_scrollPaneParcelas.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneParcelas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneParcelas.gridx = 0;
		gbc_scrollPaneParcelas.gridy = 0;
		tabParcelas.add(scrollPaneParcelas, gbc_scrollPaneParcelas);
		
		listaParcelas = new JList<Alojamiento>();
		listaParcelas.setBorder(null);
		listaParcelas.setBackground(Paleta.blanco_gris);
		listaParcelas.addListSelectionListener(new ListaParcelasListSelectionListener());
		scrollPaneParcelas.setViewportView(listaParcelas);
		GridBagConstraints gbc_listParcelas = new GridBagConstraints();
		gbc_listParcelas.gridheight = 2;
		gbc_listParcelas.insets = new Insets(0, 0, 0, 5);
		gbc_listParcelas.fill = GridBagConstraints.BOTH;
		gbc_listParcelas.gridx = 0;
		gbc_listParcelas.gridy = 0;
		listaParcelas.setCellRenderer(new RenderizadoAlojamiento(1));
		
		lblImagen = new JLabel(""); //$NON-NLS-1$
		lblImagen.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 5), "Image", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK)); //$NON-NLS-1$
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.anchor = GridBagConstraints.NORTH;
		gbc_lblImagen.gridx = 2;
		gbc_lblImagen.gridy = 1;
		tabParcelas.add(lblImagen, gbc_lblImagen);
		
		
		tabBungalows = new JPanel();
		tabBungalows.setBorder(null);
		tabBungalows.setBackground(Paleta.blanco_gris);
		tabbedPaneConsultarInformacion.addTab(Messages.getString("ConsultarInformacion.5"), null, tabBungalows, null); //$NON-NLS-1$
		GridBagLayout gbl_tabBungalows = new GridBagLayout();
		gbl_tabBungalows.columnWidths = new int[]{900, 10, 89, 0};
		gbl_tabBungalows.rowHeights = new int[]{126, 138, 0};
		gbl_tabBungalows.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_tabBungalows.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		tabBungalows.setLayout(gbl_tabBungalows);
		
		scrollPaneBungalows = new JScrollPane();
		scrollPaneBungalows.setBackground(Paleta.blanco_gris);
		scrollPaneBungalows.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_scrollPaneBungalows = new GridBagConstraints();
		gbc_scrollPaneBungalows.gridheight = 2;
		gbc_scrollPaneBungalows.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneBungalows.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneBungalows.gridx = 0;
		gbc_scrollPaneBungalows.gridy = 0;
		tabBungalows.add(scrollPaneBungalows, gbc_scrollPaneBungalows);
		
		listaBungalows = new JList<Alojamiento>();
		listaBungalows.addListSelectionListener(new ListaBungalowsListSelectionListener());
		listaBungalows.setSelectedIndex(0);
		listaBungalows.setBackground(Paleta.blanco_gris);
		scrollPaneBungalows.setViewportView(listaBungalows);
		listaBungalows.setCellRenderer(new RenderizadoAlojamiento(1));
		
		lblImagen1 = new JLabel(""); //$NON-NLS-1$
		lblImagen1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 5), "Image", TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_lblImagen1 = new GridBagConstraints();
		gbc_lblImagen1.anchor = GridBagConstraints.NORTH;
		gbc_lblImagen1.gridx = 2;
		gbc_lblImagen1.gridy = 1;
		tabBungalows.add(lblImagen1, gbc_lblImagen1);
		
		tabRutas = new JPanel();
		tabRutas.setBorder(null);
		tabRutas.setBackground(Paleta.blanco_gris);
		tabbedPaneConsultarInformacion.addTab(Messages.getString("ConsultarInformacion.8"), null, tabRutas, null); //$NON-NLS-1$
		refreshAlojamiento(gdao);
		GridBagLayout gbl_tabRutas = new GridBagLayout();
		gbl_tabRutas.columnWidths = new int[]{729, 10, 0, 0};
		gbl_tabRutas.rowHeights = new int[]{10, 155, 0};
		gbl_tabRutas.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_tabRutas.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		tabRutas.setLayout(gbl_tabRutas);
		
		scrollPaneRutas = new JScrollPane();
		scrollPaneRutas.setBackground(Paleta.blanco_gris);
		scrollPaneRutas.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_scrollPaneRutas = new GridBagConstraints();
		gbc_scrollPaneRutas.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneRutas.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneRutas.gridx = 0;
		gbc_scrollPaneRutas.gridy = 1;
		tabRutas.add(scrollPaneRutas, gbc_scrollPaneRutas);
		
		listRutas = new JList<Ruta>();
		listRutas.addListSelectionListener(new ListaRutasListSelectionListener());
		listRutas.setSelectedIndex(0);
		listRutas.setBackground(Paleta.blanco_gris);
		scrollPaneRutas.setViewportView(listRutas);
		listRutas.setCellRenderer(new RenderizadoRuta());
		
		refreshRutas(gdao);
		
		imagenRuta = new JLabel(""); //$NON-NLS-1$
		GridBagConstraints gbc_imagenRuta = new GridBagConstraints();
		gbc_imagenRuta.gridx = 2;
		gbc_imagenRuta.gridy = 1;
		tabRutas.add(imagenRuta, gbc_imagenRuta);
		
		tabActividades = new JPanel();
		tabActividades.setBorder(null);
		tabActividades.setBackground(Paleta.blanco_gris);
		tabbedPaneConsultarInformacion.addTab(Messages.getString("ConsultarInformacion.10"), null, tabActividades, null); //$NON-NLS-1$
		GridBagLayout gbl_tabActividades = new GridBagLayout();
		gbl_tabActividades.columnWidths = new int[]{800, 194, 10, 0};
		gbl_tabActividades.rowHeights = new int[]{10, 222, 10, 0};
		gbl_tabActividades.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_tabActividades.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		tabActividades.setLayout(gbl_tabActividades);
		
		scrollPaneActividades = new JScrollPane();
		scrollPaneActividades.setBackground(Paleta.blanco_gris);
		scrollPaneActividades.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_scrollPaneActividades = new GridBagConstraints();
		gbc_scrollPaneActividades.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneActividades.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneActividades.gridx = 0;
		gbc_scrollPaneActividades.gridy = 1;
		tabActividades.add(scrollPaneActividades, gbc_scrollPaneActividades);
		
		listActividades = new JList<Actividad>();
		listActividades.setBorder(new EmptyBorder(0, 0, 0, 0));
		listActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Actividad a = (Actividad) listActividades.getSelectedValue();
				textFieldNombre.setText(a.getNombre());
				textFieldDescripcion.setText(a.getDescripcion());
				textFieldMonitor.setText(a.getMonitor());
				textFieldHorario.setText(a.getHorario());
				spinnerCupoMinimo.setValue(Integer.parseInt(a.getCupoMínimo()));
				spinnerCupoMaximo.setValue(Integer.parseInt(a.getCupoMaximo()));
				textFieldPathIcono.setText(a.getFoto());
				textFieldPrecio.setText(a.getPrecioPorHora());
				textFieldDestinatario.setText(a.getDestinatarios());
				textFieldMaterial.setText(a.getMaterialNecesario());
			}
		});

		listActividades.setBackground(Paleta.blanco_gris);
		GridBagConstraints gbc_listActividades = new GridBagConstraints();
		gbc_listActividades.insets = new Insets(0, 0, 5, 0);
		gbc_listActividades.fill = GridBagConstraints.BOTH;
		gbc_listActividades.gridx = 1;
		gbc_listActividades.gridy = 0;
		scrollPaneActividades.setViewportView(listActividades);
		listActividades.setCellRenderer(new RenderizadoActividades());
		
		informacionActividad = new JPanel();
		informacionActividad.setBorder(null);
		informacionActividad.setBackground(Paleta.azul_turquesa2);
		GridBagConstraints gbc_informacionActividad = new GridBagConstraints();
		gbc_informacionActividad.insets = new Insets(0, 0, 0, 5);
		gbc_informacionActividad.fill = GridBagConstraints.BOTH;
		gbc_informacionActividad.gridx = 1;
		gbc_informacionActividad.gridy = 1;
		tabActividades.add(informacionActividad, gbc_informacionActividad);
		GridBagLayout gbl_informacionActividad = new GridBagLayout();
		gbl_informacionActividad.columnWidths = new int[]{51, 85, 64, 50, 62, 0, 85, 60, 124, 0};
		gbl_informacionActividad.rowHeights = new int[]{93, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 40, 21, 0};
		gbl_informacionActividad.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_informacionActividad.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		informacionActividad.setLayout(gbl_informacionActividad);
		
		textFieldHorario = new JTextField();
		textFieldHorario.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldHorario.addKeyListener(new TextFieldHorarioKeyListener());
		
		textFieldMonitor = new JTextField();
		textFieldMonitor.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldMonitor.addKeyListener(new TextFieldMonitorKeyListener());
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldNombre.addKeyListener(new TextFieldNombreKeyListener());
		
		lblDescripcion = new JLabel(Messages.getString("ConsultarInformacion.11")); //$NON-NLS-1$
		lblDescripcion.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.SOUTH;
		gbc_lblDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 6;
		gbc_lblDescripcion.gridy = 0;
		informacionActividad.add(lblDescripcion, gbc_lblDescripcion);
		
		lblNombreActividad = new JLabel(Messages.getString("ConsultarInformacion.12")); //$NON-NLS-1$
		lblNombreActividad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreActividad.setFont(new Font("Tahoma", Font.PLAIN, 10)); //$NON-NLS-1$
		lblNombreActividad.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNombreActividad = new GridBagConstraints();
		gbc_lblNombreActividad.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNombreActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreActividad.gridx = 1;
		gbc_lblNombreActividad.gridy = 1;
		informacionActividad.add(lblNombreActividad, gbc_lblNombreActividad);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.anchor = GridBagConstraints.NORTH;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 1;
		informacionActividad.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDescripcion = new JTextArea();
		textFieldDescripcion.setLineWrap(true);
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.gridwidth = 2;
		gbc_textFieldDescripcion.gridheight = 3;
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textFieldDescripcion.gridx = 6;
		gbc_textFieldDescripcion.gridy = 1;
		informacionActividad.add(textFieldDescripcion, gbc_textFieldDescripcion);
		
		lblMonitor = new JLabel(Messages.getString("ConsultarInformacion.14")); //$NON-NLS-1$
		lblMonitor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonitor.setFont(new Font("Tahoma", Font.PLAIN, 10)); //$NON-NLS-1$
		lblMonitor.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMonitor = new GridBagConstraints();
		gbc_lblMonitor.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitor.gridx = 1;
		gbc_lblMonitor.gridy = 2;
		informacionActividad.add(lblMonitor, gbc_lblMonitor);
		GridBagConstraints gbc_textFieldMonitor = new GridBagConstraints();
		gbc_textFieldMonitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMonitor.anchor = GridBagConstraints.SOUTH;
		gbc_textFieldMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMonitor.gridwidth = 2;
		gbc_textFieldMonitor.gridx = 2;
		gbc_textFieldMonitor.gridy = 2;
		informacionActividad.add(textFieldMonitor, gbc_textFieldMonitor);
		textFieldMonitor.setColumns(10);
		
		lblHorario = new JLabel(Messages.getString("ConsultarInformacion.16")); //$NON-NLS-1$
		lblHorario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 10)); //$NON-NLS-1$
		lblHorario.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 4;
		informacionActividad.add(lblHorario, gbc_lblHorario);
		GridBagConstraints gbc_textFieldHorario = new GridBagConstraints();
		gbc_textFieldHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHorario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHorario.gridwidth = 2;
		gbc_textFieldHorario.gridx = 2;
		gbc_textFieldHorario.gridy = 4;
		informacionActividad.add(textFieldHorario, gbc_textFieldHorario);
		textFieldHorario.setColumns(10);
		
		lblCupoMinimo = new JLabel(Messages.getString("ConsultarInformacion.18")); //$NON-NLS-1$
		lblCupoMinimo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCupoMinimo.setFont(new Font("Tahoma", Font.PLAIN, 10)); //$NON-NLS-1$
		lblCupoMinimo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCupoMinimo = new GridBagConstraints();
		gbc_lblCupoMinimo.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMinimo.gridx = 1;
		gbc_lblCupoMinimo.gridy = 5;
		informacionActividad.add(lblCupoMinimo, gbc_lblCupoMinimo);
		
		spinnerCupoMinimo = new JSpinner();
		spinnerCupoMinimo.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_spinnerCupoMinimo = new GridBagConstraints();
		gbc_spinnerCupoMinimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerCupoMinimo.anchor = GridBagConstraints.NORTH;
		gbc_spinnerCupoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerCupoMinimo.gridx = 2;
		gbc_spinnerCupoMinimo.gridy = 5;
		informacionActividad.add(spinnerCupoMinimo, gbc_spinnerCupoMinimo);
		
		btnElegirIcono = new JButton(Messages.getString("ConsultarInformacion.20")); //$NON-NLS-1$
		btnElegirIcono.addActionListener(new BtnElegirIconoActionListener());
		GridBagConstraints gbc_btnElegirIcono = new GridBagConstraints();
		gbc_btnElegirIcono.anchor = GridBagConstraints.NORTH;
		gbc_btnElegirIcono.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnElegirIcono.insets = new Insets(0, 0, 5, 5);
		gbc_btnElegirIcono.gridwidth = 2;
		gbc_btnElegirIcono.gridx = 6;
		gbc_btnElegirIcono.gridy = 5;
		informacionActividad.add(btnElegirIcono, gbc_btnElegirIcono);
		
		lblCupoMaximo = new JLabel(Messages.getString("ConsultarInformacion.21")); //$NON-NLS-1$
		lblCupoMaximo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCupoMaximo.setFont(new Font("Tahoma", Font.PLAIN, 10)); //$NON-NLS-1$
		lblCupoMaximo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCupoMaximo = new GridBagConstraints();
		gbc_lblCupoMaximo.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMaximo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMaximo.gridx = 1;
		gbc_lblCupoMaximo.gridy = 6;
		informacionActividad.add(lblCupoMaximo, gbc_lblCupoMaximo);
		
		spinnerCupoMaximo = new JSpinner();
		GridBagConstraints gbc_spinnerCupoMaximo = new GridBagConstraints();
		gbc_spinnerCupoMaximo.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerCupoMaximo.anchor = GridBagConstraints.NORTH;
		gbc_spinnerCupoMaximo.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerCupoMaximo.gridx = 2;
		gbc_spinnerCupoMaximo.gridy = 6;
		informacionActividad.add(spinnerCupoMaximo, gbc_spinnerCupoMaximo);
		
		textFieldPathIcono = new JTextField();
		textFieldPathIcono.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldPathIcono.addKeyListener(new TextFieldPathIconoKeyListener());
		GridBagConstraints gbc_textFieldPathIcono = new GridBagConstraints();
		gbc_textFieldPathIcono.gridwidth = 2;
		gbc_textFieldPathIcono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPathIcono.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPathIcono.gridx = 6;
		gbc_textFieldPathIcono.gridy = 6;
		informacionActividad.add(textFieldPathIcono, gbc_textFieldPathIcono);
		textFieldPathIcono.setColumns(10);
		
		lblPrecioPorHora = new JLabel(Messages.getString("ConsultarInformacion.23")); //$NON-NLS-1$
		lblPrecioPorHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioPorHora.setFont(new Font("Tahoma", Font.PLAIN, 10)); //$NON-NLS-1$
		lblPrecioPorHora.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPrecioPorHora = new GridBagConstraints();
		gbc_lblPrecioPorHora.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPrecioPorHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioPorHora.gridx = 1;
		gbc_lblPrecioPorHora.gridy = 7;
		informacionActividad.add(lblPrecioPorHora, gbc_lblPrecioPorHora);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldPrecio.addKeyListener(new TextFieldPrecioKeyListener());
		GridBagConstraints gbc_textFieldPrecio = new GridBagConstraints();
		gbc_textFieldPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrecio.anchor = GridBagConstraints.NORTH;
		gbc_textFieldPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrecio.gridwidth = 2;
		gbc_textFieldPrecio.gridx = 2;
		gbc_textFieldPrecio.gridy = 7;
		informacionActividad.add(textFieldPrecio, gbc_textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		lblDestinatarios = new JLabel(Messages.getString("ConsultarInformacion.25")); //$NON-NLS-1$
		lblDestinatarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestinatarios.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDestinatarios = new GridBagConstraints();
		gbc_lblDestinatarios.anchor = GridBagConstraints.EAST;
		gbc_lblDestinatarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatarios.gridx = 1;
		gbc_lblDestinatarios.gridy = 8;
		informacionActividad.add(lblDestinatarios, gbc_lblDestinatarios);
		
		textFieldDestinatario = new JTextField();
		textFieldDestinatario.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldDestinatario.addKeyListener(new TextFieldDestinatarioKeyListener());
		GridBagConstraints gbc_textFieldDestinatario = new GridBagConstraints();
		gbc_textFieldDestinatario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDestinatario.anchor = GridBagConstraints.NORTH;
		gbc_textFieldDestinatario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDestinatario.gridwidth = 2;
		gbc_textFieldDestinatario.gridx = 2;
		gbc_textFieldDestinatario.gridy = 8;
		informacionActividad.add(textFieldDestinatario, gbc_textFieldDestinatario);
		textFieldDestinatario.setColumns(10);
		
		lblMaterialNecesario = new JLabel(Messages.getString("ConsultarInformacion.26")); //$NON-NLS-1$
		lblMaterialNecesario.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMaterialNecesario = new GridBagConstraints();
		gbc_lblMaterialNecesario.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMaterialNecesario.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterialNecesario.gridwidth = 2;
		gbc_lblMaterialNecesario.gridx = 6;
		gbc_lblMaterialNecesario.gridy = 8;
		informacionActividad.add(lblMaterialNecesario, gbc_lblMaterialNecesario);
		
		textFieldMaterial = new JTextField();
		textFieldMaterial.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldMaterial.addKeyListener(new TextFieldMaterialKeyListener());
		GridBagConstraints gbc_textFieldMaterial = new GridBagConstraints();
		gbc_textFieldMaterial.gridheight = 2;
		gbc_textFieldMaterial.fill = GridBagConstraints.BOTH;
		gbc_textFieldMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMaterial.gridwidth = 2;
		gbc_textFieldMaterial.gridx = 6;
		gbc_textFieldMaterial.gridy = 9;
		informacionActividad.add(textFieldMaterial, gbc_textFieldMaterial);
		textFieldMaterial.setColumns(10);
		
		btnEditarActividad = new JButton(Messages.getString("ConsultarInformacion.27")); //$NON-NLS-1$
		btnEditarActividad.setForeground(Color.WHITE);
		btnEditarActividad.setFocusTraversalKeysEnabled(false);
		btnEditarActividad.setFocusPainted(false);
		btnEditarActividad.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEditarActividad.setBackground(Paleta.azul_turquesa);
		btnEditarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actividad antigua = (Actividad) listActividades.getSelectedValue();
				Actividad actualizada = new Actividad(textFieldNombre.getText(),textFieldMonitor.getText(),textFieldHorario.getText(),spinnerCupoMinimo.getValue().toString(),spinnerCupoMaximo.getValue().toString(),textFieldDestinatario.getText(), textFieldPrecio.getText(), textFieldDescripcion.getText(),textFieldMaterial.getText(),textFieldPathIcono.getText());
				try {
					gdao.editarActividad(actualizada, antigua);
					refreshActividades(gdao);
				} catch (IOException e1) {
					System.out.println(e1.toString());
				}
			}
		});
		GridBagConstraints gbc_btnEditarActividad = new GridBagConstraints();
		gbc_btnEditarActividad.fill = GridBagConstraints.BOTH;
		gbc_btnEditarActividad.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditarActividad.gridwidth = 2;
		gbc_btnEditarActividad.gridx = 1;
		gbc_btnEditarActividad.gridy = 12;
		informacionActividad.add(btnEditarActividad, gbc_btnEditarActividad);
		
		btnCrearActividad = new JButton(Messages.getString("ConsultarInformacion.28")); //$NON-NLS-1$
		btnCrearActividad.setFocusTraversalKeysEnabled(false);
		btnCrearActividad.setFocusPainted(false);
		btnCrearActividad.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCrearActividad.setBackground(Color.GREEN);
		btnCrearActividad.setEnabled(false);
		btnCrearActividad.addActionListener(new BtnCrearActividadActionListener());
		
		btnNewButton = new JButton(Messages.getString("ConsultarInformacion.29")); //$NON-NLS-1$
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actividad a = (Actividad) listActividades.getSelectedValue();
				try {
					gdao.borrarActividad(a);
					refreshActividades(gdao);					
				} catch (IOException e1) {
					System.out.println(e1.toString());
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 12;
		informacionActividad.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnCrearActividad = new GridBagConstraints();
		gbc_btnCrearActividad.fill = GridBagConstraints.BOTH;
		gbc_btnCrearActividad.gridx = 7;
		gbc_btnCrearActividad.gridy = 12;
		informacionActividad.add(btnCrearActividad, gbc_btnCrearActividad);
		
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
			if(lAlojamiento.elementAt(i).getClass().toString().equals("class dominio.Parcela")) { //$NON-NLS-1$
				modeloLista.addElement(lAlojamiento.get(i));
			}else if (lAlojamiento.elementAt(i).getClass().toString().equals("class dominio.Bungalow")){ //$NON-NLS-1$
				modeloLista2.addElement(lAlojamiento.get(i));
			}
		}
	}
	public void refreshRutas(GenericDAO gdao) {
		DefaultListModel<Ruta> modeloLista = new DefaultListModel<Ruta>();
		listRutas.setModel(modeloLista);
		Vector<Ruta> lRutas=gdao.getListaRutas();
		for(int i=0; i<lRutas.size(); i++) {
			modeloLista.addElement(lRutas.elementAt(i));
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
	private class ListaRutasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			Ruta r = (Ruta) listRutas.getSelectedValue();
			imagenRuta.setIcon(new ImageIcon(MainWindow.class.getResource(r.getFotoRuta())));
		}
	}
	
	private class BtnCrearActividadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Actividad a = new Actividad(textFieldNombre.getText(),textFieldMonitor.getText(),textFieldHorario.getText(),spinnerCupoMinimo.getValue().toString(),spinnerCupoMaximo.getValue().toString(),textFieldDestinatario.getText(), textFieldPrecio.getText(), textFieldDescripcion.getText(),textFieldMaterial.getText(),textFieldPathIcono.getText());
				a.guardarActividad(a);
				GenericDAO gdao= new GenericDAO();
				refreshActividades(gdao);
			} catch (NoSuchElementException e1) {
				System.out.println(Messages.getString("ConsultarInformacion.32")); //$NON-NLS-1$
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class BtnElegirIconoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			 fileChooser.setFileFilter(filtroImagen);
			try {
				fileChooser.showOpenDialog(fileChooser);
		      textFieldPathIcono.setText(fileChooser.getSelectedFile().getAbsolutePath());
			} catch (NullPointerException ex) {
			}
		}
	}
	private class TextFieldNombreKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				btnCrearActividad.setEnabled(true);
			} else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldMonitorKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
			}
	}
	private class TextFieldHorarioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldPrecioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldDestinatarioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
	}
	private class TextFieldMaterialKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				btnCrearActividad.setEnabled(true);
			}else {
				btnCrearActividad.setEnabled(false);
			}
		}
		
	}
	private class TextFieldPathIconoKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!textFieldNombre.getText().equals("") && !textFieldMaterial.getText().equals("") && !textFieldNombre.getText().equals("") && !textFieldMonitor.getText().equals("") && !textFieldHorario.getText().equals("") && !textFieldDestinatario.getText().equals("") && !textFieldDescripcion.getText().equals("") && !textFieldPathIcono.getText().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				btnCrearActividad.setEnabled(true);
		}else {
			btnCrearActividad.setEnabled(false);
		}
	}
}
}