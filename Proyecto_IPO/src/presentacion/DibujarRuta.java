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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
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
	private Cursor cursorInicio;
	private Cursor cursorFuente;
	private Cursor cursorMerendero;
	private Cursor cursorMeta;
	private Cursor cursorInteres;
	private Cursor cursorRuta;
	private Cursor cursorBorrador;
	int modo= -1;
	private final int INICIO =1;
	private final int LLEGADA =2;
	private final int FUENTE = 3;
	private final int MERENDERO =4;
	private final int INTERES=5;
	private final int RUTA=6;
	private final int BORRADOR=7;
	private int x, y, x1, y1;
	private JMenuItem mntmLineaRuta;
	private Vector<Empleado> empleados;
	private JLabel lblDescripcionRuta;
	private JTextArea textArea;
	private JMenuItem mntmBorrador;
	private File file;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DibujarRuta(GenericDAO gdao, JLabel lblFeedback) throws ParseException {
		
		toolkit = Toolkit.getDefaultToolkit();
		imagenInicio =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/chinchetaInicio.png"));
		imagenFuente =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/fuente.png"));
		imagenMerendero =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/merendero.png"));
		imagenMeta = toolkit.getImage(getClass().getClassLoader().getResource("Iconos/meta.png"));
		puntoInteres = toolkit.getImage(getClass().getClassLoader().getResource("Iconos/puntoInteres.png"));
		imagenRuta= toolkit.getImage(getClass().getClassLoader().getResource("Iconos/lineaRuta.png"));
		imagenBorrador=toolkit.getImage(getClass().getClassLoader().getResource("Iconos/borrador.png"));
		cursorInicio = toolkit.createCustomCursor(imagenInicio, new Point(0,0), "CURSOR_INICIO");
		cursorFuente = toolkit.createCustomCursor(imagenFuente, new Point(0,0), "CURSOR_FUENTE");
		cursorMerendero = toolkit.createCustomCursor(imagenMerendero, new Point(0,0), "CURSOR_MERENDERO");
		cursorMeta = toolkit.createCustomCursor(imagenMeta, new Point(0,0), "CURSOR_META");
		cursorInteres = toolkit.createCustomCursor(puntoInteres, new Point(0,0), "CURSOR_INTERES");
		cursorRuta= toolkit.createCustomCursor(imagenRuta, new Point(0,0),"CURSOR_RUTA");
		cursorBorrador= toolkit.createCustomCursor(imagenBorrador, new Point(0,0), "CURSOR_BORRADOR");
		
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
		
		mntmLineaRuta = new JMenuItem("Linea de ruta");
		menuBar.add(mntmLineaRuta);
		mntmLineaRuta.addActionListener(new MntmLineaRutaActionListener());
		mntmLineaRuta.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/lineaRuta.png")));
		
		mntmBorrador = new JMenuItem("Borrador");
		menuBar.add(mntmBorrador);
		mntmBorrador.addActionListener(new MntmBorradorActionListener());
		mntmBorrador.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/borrador.png")));
		
		mntmLlegada = new JMenuItem("Llegada");
		menuBar.add(mntmLlegada);
		mntmLlegada.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/meta.png")));
		mntmLlegada.addActionListener(new MntmLlegadaActionListener());
		
		mntmInicio = new JMenuItem("Inicio");
		menuBar.add(mntmInicio);
		mntmInicio.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/chinchetaInicio.png")));
		mntmInicio.addActionListener(new MntmInicioActionListener());
		mntmInicio.setSelectedIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/bandera_inicio.png")));
		
		mntmMerendero = new JMenuItem("Merenderos");
		menuBar.add(mntmMerendero);
		mntmMerendero.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/merendero.png")));
		mntmMerendero.addActionListener(new MntmMerenderoActionListener());
		
		mntmFuente = new JMenuItem("Fuentes de Agua");
		menuBar.add(mntmFuente);
		mntmFuente.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/fuente.png")));
		mntmFuente.addActionListener(new MntmFuenteActionListener());
		
		mntmPuntoInteres = new JMenuItem("Punto de Interes");
		menuBar.add(mntmPuntoInteres);
		mntmPuntoInteres.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/puntoInteres.png")));
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
		gbl_informacionRuta.columnWidths = new int[]{10, 0, 100, 51, 10, 0};
		gbl_informacionRuta.rowHeights = new int[]{50, 0, 0, 0, 0, 0, 80, 40, 0, 0, 0, 0};
		gbl_informacionRuta.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_informacionRuta.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		informacionRuta.setLayout(gbl_informacionRuta);
		
		lblNewLabel = new JLabel("Monitor:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		informacionRuta.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBoxMonitores = new JComboBox();
		GridBagConstraints gbc_comboBoxMonitores = new GridBagConstraints();
		gbc_comboBoxMonitores.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMonitores.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMonitores.gridx = 2;
		gbc_comboBoxMonitores.gridy = 1;
		informacionRuta.add(comboBoxMonitores, gbc_comboBoxMonitores);
		
		Empleado e = new Empleado();
		empleados=e.leerMonitores();
		DefaultComboBoxModel<String> modeloCombo= new DefaultComboBoxModel<String>();
		comboBoxMonitores.setModel(modeloCombo);
		for(int i=0; i<empleados.size();i++) {
			modeloCombo.addElement(empleados.elementAt(i).getNombre()+ " "+ empleados.elementAt(i).getApellido());
		}
		
		lblNewLabel_1 = new JLabel("Hora de Inicio:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		informacionRuta.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		MaskFormatter mascara = new MaskFormatter("##:##");
		txtHoraInicio = new JFormattedTextField(mascara);
		GridBagConstraints gbc_txtHoraInicio = new GridBagConstraints();
		gbc_txtHoraInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraInicio.anchor = GridBagConstraints.NORTH;
		gbc_txtHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraInicio.gridx = 2;
		gbc_txtHoraInicio.gridy = 3;
		informacionRuta.add(txtHoraInicio, gbc_txtHoraInicio);
		txtHoraInicio.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Hora de Fin");
		lblNewLabel_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		informacionRuta.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtHoraFin = new JFormattedTextField(mascara);
		GridBagConstraints gbc_txtHoraFin = new GridBagConstraints();
		gbc_txtHoraFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraFin.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraFin.gridx = 2;
		gbc_txtHoraFin.gridy = 4;
		informacionRuta.add(txtHoraFin, gbc_txtHoraFin);
		txtHoraFin.setColumns(10);
		
		lblDescripcionRuta = new JLabel("Descripcion:");
		lblDescripcionRuta.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcionRuta.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDescripcionRuta = new GridBagConstraints();
		gbc_lblDescripcionRuta.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcionRuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionRuta.gridx = 1;
		gbc_lblDescripcionRuta.gridy = 6;
		informacionRuta.add(lblDescripcionRuta, gbc_lblDescripcionRuta);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 6;
		informacionRuta.add(textArea, gbc_textArea);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setEnabled(false);
		btnLimpiar.setFocusTraversalKeysEnabled(false);
		btnLimpiar.setFocusable(false);
		btnLimpiar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxMonitores.setSelectedIndex(-1);
				txtHoraInicio.setText("");
				txtHoraFin.setText("");
				areaDibujo.removeAllObjetoGrafico();
				areaDibujo.repaint();
				textArea.setText("");

			}
		});
		
		btnGuardarRuta = new JButton("Guardar Ruta");
		btnGuardarRuta.setEnabled(false);
		btnGuardarRuta.setFocusTraversalKeysEnabled(false);
		btnGuardarRuta.setFocusable(false);
		btnGuardarRuta.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardarRuta.addActionListener(new BtnNewButton_1ActionListener());
		
		cargarMapa = new JButton("Cargar Mapa");
		cargarMapa.setFocusTraversalKeysEnabled(false);
		cargarMapa.setFocusable(false);
		cargarMapa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagConstraints gbc_cargarMapa = new GridBagConstraints();
		gbc_cargarMapa.fill = GridBagConstraints.BOTH;
		gbc_cargarMapa.insets = new Insets(0, 0, 5, 5);
		gbc_cargarMapa.gridx = 2;
		gbc_cargarMapa.gridy = 8;
		informacionRuta.add(cargarMapa, gbc_cargarMapa);
		cargarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser("rutas");
				FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
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
		GridBagConstraints gbc_btnGuardarRuta = new GridBagConstraints();
		gbc_btnGuardarRuta.fill = GridBagConstraints.BOTH;
		gbc_btnGuardarRuta.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarRuta.gridx = 2;
		gbc_btnGuardarRuta.gridy = 9;
		informacionRuta.add(btnGuardarRuta, gbc_btnGuardarRuta);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar.gridx = 2;
		gbc_btnLimpiar.gridy = 10;
		informacionRuta.add(btnLimpiar, gbc_btnLimpiar);
		
		
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
	private class MntmLineaRutaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RUTA;
			panelDibujo.setCursor(cursorRuta);
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
					case RUTA:
						areaDibujo.addObjetoGrafico(new lineaGrafico(x,y,x1,y1,Color.RED));
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
	
			if(modo == RUTA && imagen!=null) {
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
					ImageIO.write((BufferedImage) salida, "jpg", file);
					Ruta r = new Ruta(comboBoxMonitores.getSelectedItem().toString(),txtHoraInicio.getText(),txtHoraInicio.getText(),textArea.getText(),file.getAbsolutePath());
					gdao.guardarRuta(r);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
}
