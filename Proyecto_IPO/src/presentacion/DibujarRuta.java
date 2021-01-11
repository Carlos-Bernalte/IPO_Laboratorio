package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

import editorGrafico.AreaDibujo;
import editorGrafico.ImagenGrafico;
import editorGrafico.lineaGrafico;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;

import dominio.Empleado;
import dominio.GenericDAO;
import dominio.Ruta;

import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;


@SuppressWarnings("serial")
public class DibujarRuta extends JPanel {
	private JFileChooser fileChooser;
	private JPanel panelDibujo;
	private JPanel informacionRuta;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private AreaDibujo areaDibujo;
	private ImageIcon imagen;
	private JButton cargarMapa;
	private JLabel lblNewLabel;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxMonitores;
	private JButton btnLimpiar;
	private JTextField txtHoraInicio;
	private JTextField txtHoraFin;
	private JButton btnGuardarRuta;
	private JMenuItem mntmFuente;
	private JMenuItem mntmInicio;
	private JMenuItem mntmLlegada;
	private JMenuItem mntmMerendero;
	private JMenuItem mntmPuntoInteres;
	private Toolkit toolkit;
	private Image imagenInicio;
	private Image imagenFuente;
	private Image imagenMerendero;
	private Image imagenMeta;
	private Image puntoInteres;
	private Image imagenRuta;
	private Image imagenBorrador;
	private Image imagenFacil;
	private Image imagenMediana;
	private Image imagenDificil;
	private Cursor cursorInicio;
	private Cursor cursorFuente;
	private Cursor cursorMerendero;
	private Cursor cursorMeta;
	private Cursor cursorInteres;
	private Cursor cursorRuta;
	private Cursor cursorBorrador;
	private Cursor cursorFacil;
	private Cursor cursorMediana;
	private Cursor cursorDificil;
	int modo= -1;
	private final int INICIO =1;
	private final int LLEGADA =2;
	private final int FUENTE = 3;
	private final int MERENDERO =4;
	private final int INTERES=5;
	private final int ROJO=6;
	private final int BORRADOR=7;
	private final int VERDE=8;
	private final int NARANJA=9;
	private int x, y, x1, y1;
	private Vector<Empleado> empleados;
	private JLabel lblDescripcionRuta;
	private JTextArea textArea;
	private JMenuItem mntmBorrador;
	private File file;
	private JMenu mnNewMenu;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem_1;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DibujarRuta(GenericDAO gdao, JLabel lblFeedback) throws ParseException {
		
		toolkit = Toolkit.getDefaultToolkit();
		imagenInicio =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/chinchetaInicio.png")); //$NON-NLS-1$
		imagenFuente =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/fuente.png")); //$NON-NLS-1$
		imagenMerendero =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/merendero.png")); //$NON-NLS-1$
		imagenMeta = toolkit.getImage(getClass().getClassLoader().getResource("Iconos/meta.png")); //$NON-NLS-1$
		puntoInteres = toolkit.getImage(getClass().getClassLoader().getResource("Iconos/puntoInteres.png")); //$NON-NLS-1$
		imagenBorrador=toolkit.getImage(getClass().getClassLoader().getResource("Iconos/borrador.png")); //$NON-NLS-1$
		imagenFacil=toolkit.getImage(getClass().getClassLoader().getResource("Iconos/highlighter.png"));
		imagenMediana=toolkit.getImage(getClass().getClassLoader().getResource("Iconos/lapiz.png"));
		imagenDificil=toolkit.getImage(getClass().getClassLoader().getResource("Iconos/lineaRuta.png"));
		cursorInicio = toolkit.createCustomCursor(imagenInicio, new Point(0,0), "CURSOR_INICIO"); //$NON-NLS-1$
		cursorFuente = toolkit.createCustomCursor(imagenFuente, new Point(0,0), "CURSOR_FUENTE"); //$NON-NLS-1$
		cursorMerendero = toolkit.createCustomCursor(imagenMerendero, new Point(0,0), "CURSOR_MERENDERO"); //$NON-NLS-1$
		cursorMeta = toolkit.createCustomCursor(imagenMeta, new Point(0,0), "CURSOR_META"); //$NON-NLS-1$
		cursorInteres = toolkit.createCustomCursor(puntoInteres, new Point(0,0), "CURSOR_INTERES"); //$NON-NLS-1$
		cursorBorrador= toolkit.createCustomCursor(imagenBorrador, new Point(0,0), "CURSOR_BORRADOR"); //$NON-NLS-1$
		cursorFacil= toolkit.createCustomCursor(imagenFacil, new Point(0,0), "CURSOR_FACIL"); //$NON-NLS-1$
		cursorMediana= toolkit.createCustomCursor(imagenMediana, new Point(0,0), "CURSOR_MEDIANA"); //$NON-NLS-1$
		cursorDificil= toolkit.createCustomCursor(imagenDificil, new Point(0,0), "CURSOR_DIFICIL"); //$NON-NLS-1$
		
		setBackground(Paleta.azul_oscuro);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{438, 10, 327, 10, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panelDibujo = new JPanel();
		panelDibujo.setOpaque(false);
		GridBagConstraints gbc_panelDibujo = new GridBagConstraints();
		gbc_panelDibujo.insets = new Insets(0, 0, 0, 5);
		gbc_panelDibujo.fill = GridBagConstraints.BOTH;
		gbc_panelDibujo.gridx = 0;
		gbc_panelDibujo.gridy = 1;
		add(panelDibujo, gbc_panelDibujo);
		panelDibujo.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panelDibujo.add(scrollPane, BorderLayout.CENTER);
		
		
		areaDibujo=new AreaDibujo();
		areaDibujo.setHorizontalAlignment(SwingConstants.CENTER);
		areaDibujo.addMouseMotionListener(new AreaDibujoMouseMotionListener());
		areaDibujo.addMouseListener(new AreaDibujoMouseListener());
		areaDibujo.setIcon(null);
		scrollPane.setViewportView(areaDibujo);
		
		menuBar = new JMenuBar();
		panelDibujo.add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu(Messages.getString("DibujarRuta.mnNewMenu.text")); //$NON-NLS-1$
		mnNewMenu.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/lapiz.png")));
		menuBar.add(mnNewMenu);
		
		rdbtnmntmNewRadioItem = new JRadioButtonMenuItem(Messages.getString("DibujarRuta.rdbtnmntmNewRadioItem.text")); //$NON-NLS-1$
		rdbtnmntmNewRadioItem.addActionListener(new RdbtnmntmNewRadioItemActionListener());
		buttonGroup.add(rdbtnmntmNewRadioItem);
		rdbtnmntmNewRadioItem.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/highlighter.png")));
		mnNewMenu.add(rdbtnmntmNewRadioItem);
		
		rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem(Messages.getString("DibujarRuta.rdbtnmntmNewRadioItem_1.text")); //$NON-NLS-1$
		rdbtnmntmNewRadioItem_1.addActionListener(new RdbtnmntmNewRadioItem_1ActionListener());
		buttonGroup.add(rdbtnmntmNewRadioItem_1);
		rdbtnmntmNewRadioItem_1.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/marker.png")));
		mnNewMenu.add(rdbtnmntmNewRadioItem_1);
		
		rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem(Messages.getString("DibujarRuta.rdbtnmntmNewRadioItem_2.text")); //$NON-NLS-1$
		rdbtnmntmNewRadioItem_2.addActionListener(new RdbtnmntmNewRadioItem_2ActionListener());
		buttonGroup.add(rdbtnmntmNewRadioItem_2);
		rdbtnmntmNewRadioItem_2.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/lineaRuta.png")));
		mnNewMenu.add(rdbtnmntmNewRadioItem_2);
		
		mntmBorrador = new JMenuItem(Messages.getString("DibujarRuta.16")); //$NON-NLS-1$
		mntmBorrador.setToolTipText(Messages.getString("DibujarRuta.mntmBorrador.toolTipText")); //$NON-NLS-1$
		menuBar.add(mntmBorrador);
		mntmBorrador.addActionListener(new MntmBorradorActionListener());
		mntmBorrador.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/borrador.png"))); //$NON-NLS-1$
		
		mntmLlegada = new JMenuItem(Messages.getString("DibujarRuta.18")); //$NON-NLS-1$
		mntmLlegada.setToolTipText(Messages.getString("DibujarRuta.mntmLlegada.toolTipText")); //$NON-NLS-1$
		menuBar.add(mntmLlegada);
		mntmLlegada.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/meta.png"))); //$NON-NLS-1$
		mntmLlegada.addActionListener(new MntmLlegadaActionListener());
		
		mntmInicio = new JMenuItem(Messages.getString("DibujarRuta.20")); //$NON-NLS-1$
		mntmInicio.setToolTipText(Messages.getString("DibujarRuta.mntmInicio.toolTipText")); //$NON-NLS-1$
		menuBar.add(mntmInicio);
		mntmInicio.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/chinchetaInicio.png"))); //$NON-NLS-1$
		mntmInicio.addActionListener(new MntmInicioActionListener());
		mntmInicio.setSelectedIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/bandera_inicio.png"))); //$NON-NLS-1$
		
		mntmMerendero = new JMenuItem(Messages.getString("DibujarRuta.23")); //$NON-NLS-1$
		mntmMerendero.setToolTipText(Messages.getString("DibujarRuta.mntmMerendero.toolTipText")); //$NON-NLS-1$
		menuBar.add(mntmMerendero);
		mntmMerendero.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/merendero.png"))); //$NON-NLS-1$
		mntmMerendero.addActionListener(new MntmMerenderoActionListener());
		
		mntmFuente = new JMenuItem(Messages.getString("DibujarRuta.25")); //$NON-NLS-1$
		mntmFuente.setToolTipText(Messages.getString("DibujarRuta.mntmFuente.toolTipText")); //$NON-NLS-1$
		menuBar.add(mntmFuente);
		mntmFuente.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/fuente.png"))); //$NON-NLS-1$
		mntmFuente.addActionListener(new MntmFuenteActionListener());
		
		mntmPuntoInteres = new JMenuItem(Messages.getString("DibujarRuta.27")); //$NON-NLS-1$
		mntmPuntoInteres.setToolTipText(Messages.getString("DibujarRuta.mntmPuntoInteres.toolTipText")); //$NON-NLS-1$
		menuBar.add(mntmPuntoInteres);
		mntmPuntoInteres.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/puntoInteres.png"))); //$NON-NLS-1$
		mntmPuntoInteres.addActionListener(new MntmPuntoInteresActionListener());
		
		informacionRuta = new JPanel();
		informacionRuta.setBackground(Paleta.azul_turquesa2);
		GridBagConstraints gbc_informacionRuta = new GridBagConstraints();
		gbc_informacionRuta.insets = new Insets(0, 0, 0, 5);
		gbc_informacionRuta.fill = GridBagConstraints.BOTH;
		gbc_informacionRuta.gridx = 2;
		gbc_informacionRuta.gridy = 1;
		add(informacionRuta, gbc_informacionRuta);
		GridBagLayout gbl_informacionRuta = new GridBagLayout();
		gbl_informacionRuta.columnWidths = new int[]{10, 0, 50, 50, 10, 0};
		gbl_informacionRuta.rowHeights = new int[]{50, 0, 10, 0, 0, 0, 0, 0, 80, 40, 0, 0, 0, 0};
		gbl_informacionRuta.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_informacionRuta.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		informacionRuta.setLayout(gbl_informacionRuta);
		
		cargarMapa = new JButton(Messages.getString("DibujarRuta.40")); //$NON-NLS-1$
		cargarMapa.setBackground(Paleta.azul_turquesa);
		cargarMapa.setForeground(Color.WHITE);
		cargarMapa.setToolTipText(Messages.getString("DibujarRuta.cargarMapa.toolTipText")); //$NON-NLS-1$
		cargarMapa.setFocusTraversalKeysEnabled(false);
		cargarMapa.setFocusable(false);
		cargarMapa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagConstraints gbc_cargarMapa = new GridBagConstraints();
		gbc_cargarMapa.gridwidth = 2;
		gbc_cargarMapa.fill = GridBagConstraints.BOTH;
		gbc_cargarMapa.insets = new Insets(0, 0, 5, 5);
		gbc_cargarMapa.gridx = 2;
		gbc_cargarMapa.gridy = 1;
		informacionRuta.add(cargarMapa, gbc_cargarMapa);
		cargarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser(Messages.getString("DibujarRuta.41")); //$NON-NLS-1$
				FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				fileChooser.setFileFilter(filtroImagen);
				int valorDevuelto = fileChooser.showOpenDialog(new Frame());
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					areaDibujo.setIcon(null);
					areaDibujo.removeAllObjetoGrafico();
					imagen = new ImageIcon(file.getAbsolutePath());
					areaDibujo.setIcon(imagen);
					btnGuardarRuta.setEnabled(true);
					btnLimpiar.setEnabled(true);
				}
			}
		});
		
		lblNewLabel = new JLabel(Messages.getString("DibujarRuta.29")); //$NON-NLS-1$
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		informacionRuta.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBoxMonitores = new JComboBox();
		comboBoxMonitores.setToolTipText(Messages.getString("DibujarRuta.comboBoxMonitores.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_comboBoxMonitores = new GridBagConstraints();
		gbc_comboBoxMonitores.gridwidth = 2;
		gbc_comboBoxMonitores.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMonitores.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMonitores.gridx = 2;
		gbc_comboBoxMonitores.gridy = 3;
		informacionRuta.add(comboBoxMonitores, gbc_comboBoxMonitores);
		
		Empleado e = new Empleado();
		empleados=e.leerMonitores();
		DefaultComboBoxModel<String> modeloCombo= new DefaultComboBoxModel<String>();
		comboBoxMonitores.setModel(modeloCombo);
		for(int i=0; i<empleados.size();i++) {
			modeloCombo.addElement(empleados.elementAt(i).getNombre()+ " "+ empleados.elementAt(i).getApellido()); //$NON-NLS-1$
		}
		
		lblHoraInicio = new JLabel(Messages.getString("DibujarRuta.31")); //$NON-NLS-1$
		lblHoraInicio.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHoraInicio = new GridBagConstraints();
		gbc_lblHoraInicio.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraInicio.gridx = 1;
		gbc_lblHoraInicio.gridy = 5;
		informacionRuta.add(lblHoraInicio, gbc_lblHoraInicio);
		
		MaskFormatter mascara = new MaskFormatter("##:##"); //$NON-NLS-1$
		txtHoraInicio = new JFormattedTextField(mascara);
		txtHoraInicio.setToolTipText(Messages.getString("DibujarRuta.txtHoraInicio.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_txtHoraInicio = new GridBagConstraints();
		gbc_txtHoraInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraInicio.anchor = GridBagConstraints.NORTH;
		gbc_txtHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraInicio.gridx = 2;
		gbc_txtHoraInicio.gridy = 5;
		informacionRuta.add(txtHoraInicio, gbc_txtHoraInicio);
		txtHoraInicio.setColumns(10);
		
		lblHoraFin = new JLabel(Messages.getString("DibujarRuta.33")); //$NON-NLS-1$
		lblHoraFin.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHoraFin = new GridBagConstraints();
		gbc_lblHoraFin.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraFin.anchor = GridBagConstraints.EAST;
		gbc_lblHoraFin.gridx = 1;
		gbc_lblHoraFin.gridy = 6;
		informacionRuta.add(lblHoraFin, gbc_lblHoraFin);
		
		txtHoraFin = new JFormattedTextField(mascara);
		txtHoraFin.setToolTipText(Messages.getString("DibujarRuta.txtHoraFin.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_txtHoraFin = new GridBagConstraints();
		gbc_txtHoraFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraFin.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraFin.gridx = 2;
		gbc_txtHoraFin.gridy = 6;
		informacionRuta.add(txtHoraFin, gbc_txtHoraFin);
		txtHoraFin.setColumns(10);
		
		lblDescripcionRuta = new JLabel(Messages.getString("DibujarRuta.34")); //$NON-NLS-1$
		lblDescripcionRuta.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcionRuta.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDescripcionRuta = new GridBagConstraints();
		gbc_lblDescripcionRuta.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcionRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionRuta.gridx = 1;
		gbc_lblDescripcionRuta.gridy = 8;
		informacionRuta.add(lblDescripcionRuta, gbc_lblDescripcionRuta);
		
		textArea = new JTextArea();
		textArea.setToolTipText(Messages.getString("DibujarRuta.textArea.toolTipText")); //$NON-NLS-1$
		textArea.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 8;
		informacionRuta.add(textArea, gbc_textArea);
		
		btnGuardarRuta = new JButton(Messages.getString("DibujarRuta.39")); //$NON-NLS-1$
		btnGuardarRuta.setForeground(Color.BLACK);
		btnGuardarRuta.setBackground(Color.GREEN);
		btnGuardarRuta.setToolTipText(Messages.getString("DibujarRuta.btnGuardarRuta.toolTipText")); //$NON-NLS-1$
		btnGuardarRuta.setEnabled(false);
		btnGuardarRuta.setFocusTraversalKeysEnabled(false);
		btnGuardarRuta.setFocusable(false);
		btnGuardarRuta.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnGuardarRuta.addActionListener(new BtnNewButton_1ActionListener());
		
		btnLimpiar = new JButton(Messages.getString("DibujarRuta.35")); //$NON-NLS-1$
		btnLimpiar.setForeground(Color.BLACK);
		btnLimpiar.setBackground(Color.RED);
		btnLimpiar.setToolTipText(Messages.getString("DibujarRuta.btnLimpiar.toolTipText")); //$NON-NLS-1$
		btnLimpiar.setEnabled(false);
		btnLimpiar.setFocusTraversalKeysEnabled(false);
		btnLimpiar.setFocusable(false);
		btnLimpiar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxMonitores.setSelectedIndex(-1);
				txtHoraInicio.setText(""); //$NON-NLS-1$
				txtHoraFin.setText(""); //$NON-NLS-1$
				areaDibujo.removeAllObjetoGrafico();
				areaDibujo.repaint();
				textArea.setText(""); //$NON-NLS-1$

			}
		});
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 2;
		gbc_btnLimpiar.gridy = 10;
		informacionRuta.add(btnLimpiar, gbc_btnLimpiar);
		GridBagConstraints gbc_btnGuardarRuta = new GridBagConstraints();
		gbc_btnGuardarRuta.fill = GridBagConstraints.BOTH;
		gbc_btnGuardarRuta.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarRuta.gridx = 3;
		gbc_btnGuardarRuta.gridy = 10;
		informacionRuta.add(btnGuardarRuta, gbc_btnGuardarRuta);
		
		
	}

	private class MntmInicioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = INICIO;
			panelDibujo.setCursor(cursorInicio);
		}
	}
	private class MntmLlegadaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = LLEGADA;
			panelDibujo.setCursor(cursorMeta);
		}
	}
	private class MntmFuenteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = FUENTE;
			panelDibujo.setCursor(cursorFuente);
		}
	}
	
	private class MntmMerenderoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = MERENDERO;
			panelDibujo.setCursor(cursorMerendero);
		}
	}
	private class MntmPuntoInteresActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = INTERES;
			panelDibujo.setCursor(cursorInteres);
		}
	}
	private class MntmBorradorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = BORRADOR;
			panelDibujo.setCursor(cursorBorrador);
		}
	}
	private class AreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				if (imagen != null){
					switch (modo){
					case INICIO:
						areaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagenInicio));
						areaDibujo.repaint();
						break;
					case FUENTE:
						areaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagenFuente));
						areaDibujo.repaint();
						break;
					case LLEGADA:
						areaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagenMeta));
						areaDibujo.repaint();
						break;
					case INTERES:
						areaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,puntoInteres));
						areaDibujo.repaint();
						break;
					case MERENDERO:
						areaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagenMerendero));
						areaDibujo.repaint();
						break;
					case ROJO:
						areaDibujo.addObjetoGrafico(new lineaGrafico(x,y,x1,y1,Color.RED));
						areaDibujo.repaint();
						break;
					case VERDE:
						areaDibujo.addObjetoGrafico(new lineaGrafico(x,y,x1,y1,Color.GREEN));
						areaDibujo.repaint();
						break;
					case NARANJA:
						areaDibujo.addObjetoGrafico(new lineaGrafico(x,y,x1,y1,Color.ORANGE));
						areaDibujo.repaint();
						break;
					case BORRADOR:
						try {
							areaDibujo.removeObjetoGrafico(x, y,80);
						} catch (NullPointerException e2) {
						} catch (IndexOutOfBoundsException e3) {
						}
						areaDibujo.repaint();
			}
			}

		}
	}
	
	
	private class AreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
	
			if((modo == ROJO || modo == VERDE || modo == NARANJA) && imagen!=null) {
				((lineaGrafico)areaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((lineaGrafico)areaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				areaDibujo.repaint();
			}
		}
	}
	
	private class BtnNewButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GenericDAO gdao = new GenericDAO();
			int valorDevuelto = fileChooser.showSaveDialog(new Frame());
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				Image salida =areaDibujo.createImage(areaDibujo.getSize().width, areaDibujo.getSize().height);
				File file = fileChooser.getSelectedFile();
				try {
					ImageIO.write((BufferedImage) salida, "jpg", file); //$NON-NLS-1$
					Ruta r = new Ruta("Ruta",comboBoxMonitores.getSelectedItem().toString(),txtHoraInicio.getText(),txtHoraInicio.getText(),textArea.getText(),file.getAbsolutePath());
					gdao.guardarRuta(r);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	private class RdbtnmntmNewRadioItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo=VERDE;
			panelDibujo.setCursor(cursorFacil);
		}
	}
	private class RdbtnmntmNewRadioItem_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo=NARANJA;
			panelDibujo.setCursor(cursorMediana);
		}
	}
	private class RdbtnmntmNewRadioItem_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo=ROJO;
			panelDibujo.setCursor(cursorDificil);
		}
	}
	
	
}
