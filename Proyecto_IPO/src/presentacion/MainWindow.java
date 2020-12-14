package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.EtchedBorder;
import java.awt.ComponentOrientation;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JButton btnConsultarInformacion;
	private JButton btnRealizarReserva;
	private JButton btnPersonal;
	private JButton btnDibujarRuta;
	private JMenu mnIdioma;
	private JPanel panelUsuario;
	private JMenuBar menuUsuario;
	private JMenu mnNewMenu;
	private JMenuItem mntmCerrarSesion;
	private JPanel panelVariable;
	private JLabel lblFeedback;
	private JPanel panel;

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 742);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnIdioma = new JMenu("Idioma");
		menuBar.add(mnIdioma);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 13, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelUsuario = new GridBagConstraints();
		gbc_panelUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_panelUsuario.fill = GridBagConstraints.BOTH;
		gbc_panelUsuario.gridx = 3;
		gbc_panelUsuario.gridy = 0;
		contentPane.add(panelUsuario, gbc_panelUsuario);
		
		menuUsuario = new JMenuBar();
		panelUsuario.add(menuUsuario);
		
		mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/usuario.png")));
		menuUsuario.add(mnNewMenu);
		
		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(mntmCerrarSesion);
		
		btnConsultarInformacion = new JButton("Consultar Información");
		btnConsultarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarInformacion.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
				btnRealizarReserva.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnPersonal.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnDibujarRuta.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			}
		});
		btnConsultarInformacion.setBackground(Color.WHITE);
		btnConsultarInformacion.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		btnConsultarInformacion.setMargin(new Insets(10, 30, 0, 30));
		GridBagConstraints gbc_btnConsultarInformacion = new GridBagConstraints();
		gbc_btnConsultarInformacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConsultarInformacion.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarInformacion.gridx = 0;
		gbc_btnConsultarInformacion.gridy = 1;
		contentPane.add(btnConsultarInformacion, gbc_btnConsultarInformacion);
		
		btnRealizarReserva = new JButton("Realizar Reserva");
		btnRealizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarInformacion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnRealizarReserva.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
				btnPersonal.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnDibujarRuta.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			}
		});
		btnRealizarReserva.setBackground(Color.WHITE);
		btnRealizarReserva.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnRealizarReserva.setMargin(new Insets(10, 30, 0, 30));
		GridBagConstraints gbc_btnRealizarReserva = new GridBagConstraints();
		gbc_btnRealizarReserva.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRealizarReserva.insets = new Insets(0, 0, 5, 5);
		gbc_btnRealizarReserva.gridx = 1;
		gbc_btnRealizarReserva.gridy = 1;
		contentPane.add(btnRealizarReserva, gbc_btnRealizarReserva);
		
		btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarInformacion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnRealizarReserva.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnPersonal.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
				btnDibujarRuta.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
			}
		});
		btnPersonal.setBackground(Color.WHITE);
		btnPersonal.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnPersonal.setMargin(new Insets(10, 30, 0, 30));
		GridBagConstraints gbc_btnPersonal = new GridBagConstraints();
		gbc_btnPersonal.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPersonal.insets = new Insets(0, 0, 5, 5);
		gbc_btnPersonal.gridx = 2;
		gbc_btnPersonal.gridy = 1;
		contentPane.add(btnPersonal, gbc_btnPersonal);
		
		btnDibujarRuta = new JButton("Dibujar Ruta");
		btnDibujarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarInformacion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnRealizarReserva.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnPersonal.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				btnDibujarRuta.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
			}
		});
		btnDibujarRuta.setBackground(Color.WHITE);
		btnDibujarRuta.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnDibujarRuta.setMargin(new Insets(10, 30, 0, 30));
		GridBagConstraints gbc_btnDibujarRuta = new GridBagConstraints();
		gbc_btnDibujarRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDibujarRuta.insets = new Insets(0, 0, 5, 0);
		gbc_btnDibujarRuta.gridx = 3;
		gbc_btnDibujarRuta.gridy = 1;
		contentPane.add(btnDibujarRuta, gbc_btnDibujarRuta);
		
		panelVariable = new JPanel();
		panelVariable.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelVariable = new GridBagConstraints();
		gbc_panelVariable.gridwidth = 4;
		gbc_panelVariable.insets = new Insets(0, 0, 5, 0);
		gbc_panelVariable.fill = GridBagConstraints.BOTH;
		gbc_panelVariable.gridx = 0;
		gbc_panelVariable.gridy = 2;
		contentPane.add(panelVariable, gbc_panelVariable);
		panelVariable.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panelVariable.add(panel, BorderLayout.NORTH);
		
		lblFeedback = new JLabel("Bienvenido");
		lblFeedback.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblFeedback = new GridBagConstraints();
		gbc_lblFeedback.anchor = GridBagConstraints.WEST;
		gbc_lblFeedback.gridwidth = 4;
		gbc_lblFeedback.insets = new Insets(0, 0, 0, 5);
		gbc_lblFeedback.gridx = 0;
		gbc_lblFeedback.gridy = 3;
		contentPane.add(lblFeedback, gbc_lblFeedback);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
