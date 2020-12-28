package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JPopupMenu;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Iconos/003-tent.png")));
		setTitle("Gestor Camping");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
		lblFeedback = new JLabel("Bienvenido");
		contentPane.add(lblFeedback, BorderLayout.SOUTH);
		
		panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		bannerUsuario = new JPanel();
		bannerUsuario.setBackground(Color.LIGHT_GRAY);
		panelSuperior.add(bannerUsuario, BorderLayout.CENTER);
		GridBagLayout gbl_bannerUsuario = new GridBagLayout();
		gbl_bannerUsuario.columnWidths = new int[]{685, 66, 0};
		gbl_bannerUsuario.rowHeights = new int[]{89, 0};
		gbl_bannerUsuario.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_bannerUsuario.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bannerUsuario.setLayout(gbl_bannerUsuario);
		
		banner = new JLabel("");
		banner.setHorizontalAlignment(SwingConstants.CENTER);
		banner.setBackground(Color.WHITE);
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
		barraUsuario.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_barraUsuario = new GridBagConstraints();
		gbc_barraUsuario.fill = GridBagConstraints.BOTH;
		gbc_barraUsuario.gridx = 1;
		gbc_barraUsuario.gridy = 0;
		bannerUsuario.add(barraUsuario, gbc_barraUsuario);
		
		//Inicializacion de los paneles
		RealizarReserva rr= new RealizarReserva();
		
		mnUsuario = new JMenu("");
		mnUsuario.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/usuario.png")));
		barraUsuario.add(mnUsuario);
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		this.mntmCerrarSesion.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/006-logout.png")));
		mnUsuario.add(mntmCerrarSesion);
		
		barraOpciones = new JMenuBar();
		panelSuperior.add(barraOpciones, BorderLayout.NORTH);
		
		mnIdioma = new JMenu("Idioma");
		this.mnIdioma.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/007-language.png")));
		barraOpciones.add(mnIdioma);
		
		mntmEspañol = new JMenuItem("Español");
		this.mntmEspañol.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/001-spain.png")));
		mnIdioma.add(mntmEspañol);
		
		mntmIngles = new JMenuItem("Inglés");
		this.mntmIngles.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/002-united-kingdom.png")));
		mnIdioma.add(mntmIngles);
		
		pnlOpciones = new JPanel();
		panelSuperior.add(pnlOpciones, BorderLayout.SOUTH);
		pnlOpciones.setLayout(new BorderLayout(0, 0));
		
		tbAcciones = new JToolBar();
		pnlOpciones.add(tbAcciones);
		
		btnConsultarInformacion = new JButton("Consultar Información");
		tbAcciones.add(btnConsultarInformacion);
		
		btnRealizarReserva = new JButton("Realizar Reserva");
		tbAcciones.add(btnRealizarReserva);
		
		btnPersonal = new JButton("Personal");
		tbAcciones.add(btnPersonal);
		
		btnDibujarRuta = new JButton("Dibujar Ruta");
		tbAcciones.add(btnDibujarRuta);
	}

}
