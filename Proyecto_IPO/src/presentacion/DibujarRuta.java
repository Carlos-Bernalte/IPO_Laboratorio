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
import java.text.ParseException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import dominio.Empleado;

import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultComboBoxModel;


public class DibujarRuta extends JPanel {
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
	private JComboBox comboBoxMonitores;
	private JButton btnNewButton;
	private JTextField txtHoraInicio;
	private JTextField txtHoraFin;
	private JButton btnNewButton_1;
	private JMenu mnNewMenu;
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
	private Cursor cursorInicio;
	private Cursor cursorFuente;
	private Cursor cursorMerendero;
	private Cursor cursorMeta;
	private Cursor cursorInteres;
	private Cursor cursorRuta;
	int modo= -1;
	private final int INICIO =1;
	private final int LLEGADA =2;
	private final int FUENTE = 3;
	private final int MERENDERO =4;
	private final int INTERES=5;
	private final int RUTA=6;
	private int x, y, x1, y1;
	private JMenuItem mntmLineaRuta;
	private Vector<Empleado> empleados;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public DibujarRuta() throws ParseException {
		
		toolkit = Toolkit.getDefaultToolkit();
		imagenInicio =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/chinchetaInicio.png"));
		imagenFuente =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/fuente.png"));
		imagenMerendero =toolkit.getImage(getClass().getClassLoader().getResource("Iconos/merendero.png"));
		imagenMeta = toolkit.getImage(getClass().getClassLoader().getResource("Iconos/meta.png"));
		puntoInteres = toolkit.getImage(getClass().getClassLoader().getResource("Iconos/puntoInteres.png"));
		imagenRuta= toolkit.getImage(getClass().getClassLoader().getResource("Iconos/lineaRuta.png"));
		cursorInicio = toolkit.createCustomCursor(imagenInicio, new Point(0,0), "CURSOR_INICIO");
		cursorFuente = toolkit.createCustomCursor(imagenFuente, new Point(0,0), "CURSOR_FUENTE");
		cursorMerendero = toolkit.createCustomCursor(imagenMerendero, new Point(0,0), "CURSOR_MERENDERO");
		cursorMeta = toolkit.createCustomCursor(imagenMeta, new Point(0,0), "CURSOR_META");
		cursorInteres = toolkit.createCustomCursor(puntoInteres, new Point(0,0), "CURSOR_INTERES");
		cursorRuta= toolkit.createCustomCursor(imagenRuta, new Point(0,0),"CURSOR_RUTA");
		setBackground(Paleta.azul_oscuro);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 10, 505, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
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
		panelDibujo.add(scrollPane, BorderLayout.CENTER);
		
		
		areaDibujo=new AreaDibujo();
		areaDibujo.addMouseMotionListener(new AreaDibujoMouseMotionListener());
		areaDibujo.addMouseListener(new AreaDibujoMouseListener());
		areaDibujo.setIcon(null);
		scrollPane.setViewportView(areaDibujo);
		
		menuBar = new JMenuBar();
		panelDibujo.add(menuBar, BorderLayout.NORTH);
		
		cargarMapa = new JButton("Nueva Ruta");
		cargarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fcAbrir = new JFileChooser("E:\\GithubDesktop\\Proyecto_IPO\\Proyecto_IPO\\src\\imagenes");
				FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
				fcAbrir.setFileFilter(filtroImagen);
				int valorDevuelto = fcAbrir.showOpenDialog(new Frame());
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					File file = fcAbrir.getSelectedFile();
					imagen = new ImageIcon(file.getAbsolutePath());
					areaDibujo.setIcon(imagen);
				}
			}
		});
		menuBar.add(cargarMapa);
		
		mnNewMenu = new JMenu("Puntos");
		menuBar.add(mnNewMenu);
		
		mntmInicio = new JMenuItem("Inicio");
		mntmInicio.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/chinchetaInicio.png")));
		mntmInicio.addActionListener(new MntmInicioActionListener());
		mntmInicio.setSelectedIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/bandera_inicio.png")));
		mnNewMenu.add(mntmInicio);
		
		mntmLlegada = new JMenuItem("Llegada");
		mntmLlegada.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/meta.png")));
		mntmLlegada.addActionListener(new MntmLlegadaActionListener());
		mnNewMenu.add(mntmLlegada);
		
		mntmFuente = new JMenuItem("Fuentes de Agua");
		mntmFuente.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/fuente.png")));
		mntmFuente.addActionListener(new MntmFuenteActionListener());
		mnNewMenu.add(mntmFuente);
		
		mntmMerendero = new JMenuItem("Merenderos");
		mntmMerendero.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/merendero.png")));
		mntmMerendero.addActionListener(new MntmMerenderoActionListener());
		mnNewMenu.add(mntmMerendero);
		
		mntmPuntoInteres = new JMenuItem("Punto de Interes");
		mntmPuntoInteres.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/puntoInteres.png")));
		mntmPuntoInteres.addActionListener(new MntmPuntoInteresActionListener());
		mnNewMenu.add(mntmPuntoInteres);
		
		mntmLineaRuta = new JMenuItem("Linea de ruta");
		mntmLineaRuta.addActionListener(new MntmLineaRutaActionListener());
		mntmLineaRuta.setIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/lineaRuta.png")));
		mnNewMenu.add(mntmLineaRuta);
		
		informacionRuta = new JPanel();
		informacionRuta.setBackground(Paleta.azul_turquesa2);
		GridBagConstraints gbc_informacionRuta = new GridBagConstraints();
		gbc_informacionRuta.fill = GridBagConstraints.BOTH;
		gbc_informacionRuta.gridx = 2;
		gbc_informacionRuta.gridy = 1;
		add(informacionRuta, gbc_informacionRuta);
		GridBagLayout gbl_informacionRuta = new GridBagLayout();
		gbl_informacionRuta.columnWidths = new int[]{10, 154, 100, 50, 10, 0};
		gbl_informacionRuta.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_informacionRuta.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_informacionRuta.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		informacionRuta.setLayout(gbl_informacionRuta);
		
		lblNewLabel = new JLabel("Monitor:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		informacionRuta.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBoxMonitores = new JComboBox();
		GridBagConstraints gbc_comboBoxMonitores = new GridBagConstraints();
		gbc_comboBoxMonitores.gridwidth = 2;
		gbc_comboBoxMonitores.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMonitores.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMonitores.gridx = 2;
		gbc_comboBoxMonitores.gridy = 2;
		informacionRuta.add(comboBoxMonitores, gbc_comboBoxMonitores);
		Empleado e = new Empleado();
		empleados=e.leerMonitores();
		DefaultComboBoxModel<Empleado> modeloCombo= new DefaultComboBoxModel<Empleado>();
		comboBoxMonitores.setModel(modeloCombo);
		for(int i=0; i<empleados.size();i++) {
			modeloCombo.addElement(empleados.elementAt(i));
		}
		
		lblNewLabel_1 = new JLabel("Hora de Inicio:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		informacionRuta.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		MaskFormatter mascara = new MaskFormatter("##:##");
		txtHoraInicio = new JFormattedTextField(mascara);
		GridBagConstraints gbc_txtHoraInicio = new GridBagConstraints();
		gbc_txtHoraInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraInicio.gridx = 2;
		gbc_txtHoraInicio.gridy = 4;
		informacionRuta.add(txtHoraInicio, gbc_txtHoraInicio);
		txtHoraInicio.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Hora de Fin");
		lblNewLabel_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		informacionRuta.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtHoraFin = new JFormattedTextField(mascara);
		GridBagConstraints gbc_txtHoraFin = new GridBagConstraints();
		gbc_txtHoraFin.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraFin.gridx = 2;
		gbc_txtHoraFin.gridy = 5;
		informacionRuta.add(txtHoraFin, gbc_txtHoraFin);
		txtHoraFin.setColumns(10);
		
		btnNewButton = new JButton("Limpiar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		informacionRuta.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Guardar Ruta");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		informacionRuta.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
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
	
}
