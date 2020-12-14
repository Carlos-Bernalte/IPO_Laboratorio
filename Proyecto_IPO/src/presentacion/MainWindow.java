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

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentral;
	private JLabel lblFeedback;
	private JMenuBar barraOpciones;
	private JMenu mnIdioma;
	private JPanel panelSuperior;
	private JMenuBar MenuOpciones;
	private JMenu mnConsultarInformacion;
	private JMenu mnRealizarReserva;
	private JMenu mnPersonal;
	private JMenu mnDibujarRuta;
	private JPanel bannerUsuario;
	private JLabel banner;
	private JMenuBar barraUsuario;
	private JMenu mnUsuario;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmEspañol;
	private JMenuItem mntmIngles;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 494);
		
		barraOpciones = new JMenuBar();
		setJMenuBar(barraOpciones);
		
		mnIdioma = new JMenu("Idioma");
		barraOpciones.add(mnIdioma);
		
		mntmEspañol = new JMenuItem("Español");
		mnIdioma.add(mntmEspañol);
		
		mntmIngles = new JMenuItem("Ingles");
		mnIdioma.add(mntmIngles);
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
		
		MenuOpciones = new JMenuBar();
		panelSuperior.add(MenuOpciones, BorderLayout.CENTER);
		
		mnConsultarInformacion = new JMenu("Consultar Información");
		mnConsultarInformacion.setHideActionText(true);
		mnConsultarInformacion.setSelected(true);
		MenuOpciones.add(mnConsultarInformacion);
		
		mnRealizarReserva = new JMenu("Realizar Reserva");
		mnRealizarReserva.setHideActionText(true);
		MenuOpciones.add(mnRealizarReserva);
		
		mnPersonal = new JMenu("Personal");
		mnPersonal.setHideActionText(true);
		MenuOpciones.add(mnPersonal);
		
		mnDibujarRuta = new JMenu("Dibujar Ruta");
		mnDibujarRuta.setHideActionText(true);
		MenuOpciones.add(mnDibujarRuta);
		
		bannerUsuario = new JPanel();
		bannerUsuario.setBackground(Color.DARK_GRAY);
		panelSuperior.add(bannerUsuario, BorderLayout.NORTH);
		GridBagLayout gbl_bannerUsuario = new GridBagLayout();
		gbl_bannerUsuario.columnWidths = new int[]{685, 66, 0};
		gbl_bannerUsuario.rowHeights = new int[]{89, 0};
		gbl_bannerUsuario.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_bannerUsuario.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bannerUsuario.setLayout(gbl_bannerUsuario);
		
		banner = new JLabel("BANNER");
		banner.setBackground(Color.GRAY);
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
		
		mnUsuario = new JMenu("");
		mnUsuario.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/usuario.png")));
		barraUsuario.add(mnUsuario);
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mnUsuario.add(mntmCerrarSesion);
	}

}
