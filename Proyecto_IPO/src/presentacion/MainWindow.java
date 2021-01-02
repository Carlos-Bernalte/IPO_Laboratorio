package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import dominio.GenericDAO;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Enumeration;

import javax.swing.JPopupMenu;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentral;
	private JLabel lblFeedback;
	private JMenuBar barraOpciones;
	private JMenu mnIdioma;
	private JPanel panelSuperior;
	private JPanel bannerUsuario;
	private JLabel banner;
	private JMenuBar barraUsuario;
	private JMenu mnUsuario;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmEspañol;
	private JMenuItem mntmIngles;
	private JPanel pnlOpciones;
	private JToolBar tbAcciones;
	private JButton btnConsultarInformacion;
	private JButton btnRealizarReserva;
	private JButton btnPersonal;
	private JButton btnDibujarRuta;
	private JMenu mnAjustes;
	private JMenu mnFuente;
	private JMenu mnTamañoFuente;
	private JMenuItem fuenteArial;
	private JMenuItem mnTFuente12;
	private JMenuItem mnTFuente16;
	private JMenuItem mnTFuente20;
	private JMenuItem fuenteAvenir;
	private JMenuItem fuenteFranklin;
	private Font fuenteDefault;
	private final ButtonGroup btnGroupFuente = new ButtonGroup();
	private JButton btnSalir;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public MainWindow() throws ParseException {
		setBackground(Paleta.azul_turquesa2);
		setUndecorated(true);
		
		GenericDAO gdao = new GenericDAO();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Iconos/003-tent.png")));
		setTitle("Gestor Camping");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1536, 793);
		contentPane = new JPanel();
		contentPane.setBackground(Paleta.azul_oscuro);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelCentral = new JPanel();
		panelCentral.setBackground(Paleta.azul_turquesa);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new CardLayout(0, 0));
		
		//Inicializar los paneles y añadirlos al panel central
		ConsultarInformacion consultar_informacion= new ConsultarInformacion();
		panelCentral.add(consultar_informacion, "Consultar Información");
		
		RealizarReserva realizar_reserva= new RealizarReserva();
		panelCentral.add(realizar_reserva, "Realizar Reserva");
		
		Personal personal = new Personal(gdao);
		panelCentral.add(personal, "Personal");
		
		DibujarRuta dibujar_ruta =new DibujarRuta();
		panelCentral.add(dibujar_ruta, "Dibujar Ruta");
		
		lblFeedback = new JLabel("Bienvenido");
		lblFeedback.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblFeedback.setForeground(Color.WHITE);
		contentPane.add(lblFeedback, BorderLayout.SOUTH);
		
		panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		bannerUsuario = new JPanel();
		bannerUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		bannerUsuario.setBackground(Paleta.azul_turquesa2);
		panelSuperior.add(bannerUsuario, BorderLayout.CENTER);
		GridBagLayout gbl_bannerUsuario = new GridBagLayout();
		gbl_bannerUsuario.columnWidths = new int[]{685, 66, 0};
		gbl_bannerUsuario.rowHeights = new int[]{89, 0};
		gbl_bannerUsuario.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_bannerUsuario.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bannerUsuario.setLayout(gbl_bannerUsuario);
		
		banner = new JLabel("");
		banner.setHorizontalAlignment(SwingConstants.CENTER);
		banner.setBackground(Paleta.azul_turquesa2);
		banner.setIgnoreRepaint(true);
		banner.setIconTextGap(7);
		banner.setSize(new Dimension(3, 3));
		banner.setAlignmentX(Component.CENTER_ALIGNMENT);
		banner.setIcon(null);
		GridBagConstraints gbc_banner = new GridBagConstraints();
		gbc_banner.fill = GridBagConstraints.HORIZONTAL;
		gbc_banner.insets = new Insets(0, 0, 0, 5);
		gbc_banner.gridx = 0;
		gbc_banner.gridy = 0;
		bannerUsuario.add(banner, gbc_banner);
		
		barraUsuario = new JMenuBar();
		barraUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		barraUsuario.setBackground(Paleta.azul_turquesa2);
		barraUsuario.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_barraUsuario = new GridBagConstraints();
		gbc_barraUsuario.fill = GridBagConstraints.BOTH;
		gbc_barraUsuario.gridx = 1;
		gbc_barraUsuario.gridy = 0;
		bannerUsuario.add(barraUsuario, gbc_barraUsuario);
		
		mnUsuario = new JMenu("");
		mnUsuario.setBackground(Paleta.azul_turquesa2);
		mnUsuario.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/usuario.png")));
		barraUsuario.add(mnUsuario);
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginWindow window = new LoginWindow();
				window.frmGestorDeCamping.setVisible(true);
				dispose();
			}
		});;
		mntmCerrarSesion.setForeground(Color.WHITE);
		mntmCerrarSesion.setBackground(Color.GRAY);
		this.mntmCerrarSesion.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/006-logout.png")));
		mnUsuario.add(mntmCerrarSesion);
		
		barraOpciones = new JMenuBar();
		barraOpciones.setBackground(Paleta.azul_oscuro);
		barraOpciones.setBorderPainted(false);
		panelSuperior.add(barraOpciones, BorderLayout.NORTH);
		
		mnIdioma = new JMenu("Idioma");
		mnIdioma.setForeground(Color.WHITE);
		this.mnIdioma.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/007-language.png")));
		barraOpciones.add(mnIdioma);
		
		mntmEspañol = new JMenuItem("Español");
		this.mntmEspañol.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/001-spain.png")));
		mnIdioma.add(mntmEspañol);
		
		mntmIngles = new JMenuItem("Inglés");
		this.mntmIngles.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/002-united-kingdom.png")));
		mnIdioma.add(mntmIngles);
		
		mnAjustes = new JMenu("Ajustes");
		mnAjustes.setForeground(Color.WHITE);
		mnAjustes.setIcon(new ImageIcon(LoginWindow.class.getResource("/Iconos/004-settings.png")));
		barraOpciones.add(mnAjustes);
		
		mnFuente = new JMenu("Fuente");
		mnAjustes.add(mnFuente);
		
		fuenteArial = new JMenuItem("Arial");
		fuenteArial.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteArial);
		mnFuente.add(fuenteArial);
		
		fuenteAvenir = new JMenuItem("Avenir Next LT Pro");
		fuenteAvenir.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteAvenir);
		mnFuente.add(fuenteAvenir);
		
		fuenteFranklin = new JMenuItem("Franklin Gothic Book");
		fuenteFranklin.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteFranklin);
		mnFuente.add(fuenteFranklin);
		
		mnTamañoFuente = new JMenu("Tamaño de Fuente");
		mnAjustes.add(mnTamañoFuente);
		
		mnTFuente12 = new JMenuItem("12"); 
		mnTFuente12.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente12);
		
		mnTFuente16 = new JMenuItem("16");
		mnTFuente16.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente16);
		
		mnTFuente20 = new JMenuItem("20");
		mnTFuente20.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente20);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setForeground(Color.WHITE);
		barraOpciones.add(horizontalGlue);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnSalir.setBackground(new Color(0,0,0,0));
		btnSalir.setOpaque(false);
		btnSalir.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/006-logout.png")));
		barraOpciones.add(btnSalir);
		
		
		pnlOpciones = new JPanel();
		panelSuperior.add(pnlOpciones, BorderLayout.SOUTH);
		pnlOpciones.setLayout(new BorderLayout(0, 0));
		
		tbAcciones = new JToolBar();
		tbAcciones.setBorder(null);
		tbAcciones.setBackground(Paleta.azul_turquesa2);
		tbAcciones.setFloatable(false);
		pnlOpciones.add(tbAcciones);
		
		btnConsultarInformacion = new JButton("Consultar Información");
		btnConsultarInformacion.setVerifyInputWhenFocusTarget(false);
		btnConsultarInformacion.setIgnoreRepaint(true);
		btnConsultarInformacion.setFocusable(false);
		btnConsultarInformacion.setFocusTraversalKeysEnabled(false);
		btnConsultarInformacion.setFocusPainted(false);
		btnConsultarInformacion.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnConsultarInformacion.setBackground(Paleta.azul_oscuro);
		btnConsultarInformacion.setForeground(Color.WHITE);
		btnConsultarInformacion.addActionListener(new btnComunAcciones());
		tbAcciones.add(btnConsultarInformacion);
		
		btnRealizarReserva = new JButton("Realizar Reserva");
		btnRealizarReserva.setFocusable(false);
		btnRealizarReserva.setFocusTraversalKeysEnabled(false);
		btnRealizarReserva.setFocusPainted(false);
		btnRealizarReserva.setVerifyInputWhenFocusTarget(false);
		btnRealizarReserva.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnRealizarReserva.setBackground(Paleta.azul_turquesa2);
		btnRealizarReserva.setForeground(Color.WHITE);
		btnRealizarReserva.addActionListener(new btnComunAcciones());
		tbAcciones.add(btnRealizarReserva);
		
		btnPersonal = new JButton("Personal");
		btnPersonal.setFocusable(false);
		btnPersonal.setFocusTraversalKeysEnabled(false);
		btnPersonal.setFocusPainted(false);
		btnPersonal.setVerifyInputWhenFocusTarget(false);
		btnPersonal.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnPersonal.setBackground(Paleta.azul_turquesa2);
		btnPersonal.setForeground(Color.WHITE);
		btnPersonal.addActionListener(new btnComunAcciones());
		tbAcciones.add(btnPersonal);
		
		btnDibujarRuta = new JButton("Dibujar Ruta");
		btnDibujarRuta.setFocusPainted(false);
		btnDibujarRuta.setFocusTraversalKeysEnabled(false);
		btnDibujarRuta.setFocusable(false);
		btnDibujarRuta.setVerifyInputWhenFocusTarget(false);
		btnDibujarRuta.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnDibujarRuta.setBackground(Paleta.azul_turquesa2);
		btnDibujarRuta.setForeground(Color.WHITE);
		btnDibujarRuta.addActionListener(new btnComunAcciones());
		tbAcciones.add(btnDibujarRuta);
	}
	private class btnComunAcciones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout panelSeleccionado = (CardLayout) panelCentral.getLayout();
			if(e.getActionCommand()=="Consultar Información") {
				resetearColor();				
				btnConsultarInformacion.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, "Consultar Información");
			}
			if(e.getActionCommand()=="Realizar Reserva") {
				resetearColor();				
				btnRealizarReserva.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, "Realizar Reserva");
			}
			if(e.getActionCommand()=="Personal") {
				resetearColor();				
				btnPersonal.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, "Personal");
			}
			if(e.getActionCommand()=="Dibujar Ruta") {
				resetearColor();				
				btnDibujarRuta.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, "Dibujar Ruta");
			}

		}

	}
	private void resetearColor() {
		btnConsultarInformacion.setBackground(Paleta.azul_turquesa2);
		btnRealizarReserva.setBackground(Paleta.azul_turquesa2);
		btnPersonal.setBackground(Paleta.azul_turquesa2);
		btnDibujarRuta.setBackground(Paleta.azul_turquesa2);
	}
	private class fuenteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "12":
				fuenteDefault = new Font(fuenteDefault.getFontName(), Font.PLAIN, 12);
				break;
			case "16":
				fuenteDefault = new Font(fuenteDefault.getFontName(), Font.PLAIN, 16);
				break;
			case "20":
				fuenteDefault = new Font(fuenteDefault.getFontName(), Font.PLAIN, 20);
				break;
			case "Arial":
				fuenteDefault = new Font("Arial", Font.PLAIN, fuenteDefault.getSize());
				break;
				
			case "Verdana":
				fuenteDefault = new Font("Avenir Next LT Pro", Font.PLAIN, fuenteDefault.getSize());
				break;
				
			case "Franklin Gothic Book":
				fuenteDefault = new Font("Franklin Gothic Book", Font.PLAIN, fuenteDefault.getSize());
				break;

			}
			nuevaFuente(new FontUIResource(fuenteDefault));
		}
	}
	public static void nuevaFuente(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }

}
