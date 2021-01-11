package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import dominio.GenericDAO;
import dominio.Usuario;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
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

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentral;
	private JLabel lblFeedback;
	private JMenuBar barraOpciones;
	private JMenu mnIdioma;
	private JPanel panelSuperior;
	private JRadioButtonMenuItem mntmEspañol;
	private JRadioButtonMenuItem mntmIngles;
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
	private JMenu mnUser;
	private JPanel panel;
	private JLabel lblUltVezConect;
	private JLabel fotoUsuario;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private Usuario usuario;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public MainWindow(Usuario u,String idioma) throws ParseException {
		this.usuario = u;
		setUndecorated(true);
		GenericDAO gdao = new GenericDAO();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Iconos/003-tent.png"))); //$NON-NLS-1$
		setTitle(Messages.getString("MainWindow.1")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 734);
		contentPane = new JPanel();
		contentPane.setBackground(Paleta.azul_oscuro);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblFeedback = new JLabel(Messages.getString("MainWindow.2")); //$NON-NLS-1$
		lblFeedback.setToolTipText(Messages.getString("MainWindow.3")); //$NON-NLS-1$
		lblFeedback.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblFeedback.setForeground(Color.WHITE);
		contentPane.add(lblFeedback, BorderLayout.SOUTH);
		
		panelCentral = new JPanel();
		panelCentral.setBackground(Paleta.azul_turquesa);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new CardLayout(0, 0));
		
		//Inicializar los paneles y añadirlos al panel central
		ConsultarInformacion consultar_informacion= new ConsultarInformacion(gdao);
		panelCentral.add(consultar_informacion, Messages.getString("MainWindow.4")); //$NON-NLS-1$
		
		RealizarReserva realizar_reserva= new RealizarReserva(gdao,lblFeedback);
		panelCentral.add(realizar_reserva, Messages.getString("MainWindow.5")); //$NON-NLS-1$
		
		Personal personal = new Personal(gdao,lblFeedback);
		panelCentral.add(personal, Messages.getString("MainWindow.6")); //$NON-NLS-1$
		
		DibujarRuta dibujar_ruta =new DibujarRuta(gdao,lblFeedback);
		panelCentral.add(dibujar_ruta, Messages.getString("MainWindow.7")); //$NON-NLS-1$
		

		
		panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));;
		
		barraOpciones = new JMenuBar();
		barraOpciones.setBackground(Paleta.azul_oscuro);
		barraOpciones.setBorderPainted(false);
		panelSuperior.add(barraOpciones, BorderLayout.NORTH);
		
		mnIdioma = new JMenu(Messages.getString("MainWindow.8")); //$NON-NLS-1$
		mnIdioma.setToolTipText(Messages.getString("MainWindow.9")); //$NON-NLS-1$
		mnIdioma.setForeground(Color.WHITE);
		this.mnIdioma.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/007-language.png"))); //$NON-NLS-1$
		barraOpciones.add(mnIdioma);
		
		mntmEspañol = new JRadioButtonMenuItem(Messages.getString("MainWindow.11")); //$NON-NLS-1$
		mntmEspañol.setToolTipText(Messages.getString("MainWindow.12")); //$NON-NLS-1$
		buttonGroup.add(mntmEspañol);
		mntmEspañol.addActionListener(new MnIdiomaActionListener());
		this.mntmEspañol.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/001-spain.png"))); //$NON-NLS-1$
		mnIdioma.add(mntmEspañol);
		
		mntmIngles = new JRadioButtonMenuItem(Messages.getString("MainWindow.14")); //$NON-NLS-1$
		mntmIngles.setToolTipText(Messages.getString("MainWindow.15")); //$NON-NLS-1$
		buttonGroup.add(mntmIngles);
		mntmIngles.addActionListener(new MnIdiomaActionListener());
		this.mntmIngles.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/002-united-kingdom.png"))); //$NON-NLS-1$
		mnIdioma.add(mntmIngles);
		
		mnAjustes = new JMenu(Messages.getString("MainWindow.17")); //$NON-NLS-1$
		mnAjustes.setToolTipText(Messages.getString("MainWindow.18")); //$NON-NLS-1$
		mnAjustes.setForeground(Color.WHITE);
		mnAjustes.setIcon(new ImageIcon(LoginWindow.class.getResource("/Iconos/004-settings.png"))); //$NON-NLS-1$
		barraOpciones.add(mnAjustes);
		
		mnFuente = new JMenu(Messages.getString("MainWindow.20")); //$NON-NLS-1$
		mnAjustes.add(mnFuente);
		
		fuenteArial = new JMenuItem("Arial"); //$NON-NLS-1$
		fuenteArial.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteArial);
		mnFuente.add(fuenteArial);
		
		fuenteAvenir = new JMenuItem("Avenir Next LT Pro"); //$NON-NLS-1$
		fuenteAvenir.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteAvenir);
		mnFuente.add(fuenteAvenir);
		
		fuenteFranklin = new JMenuItem("Franklin Gothic Book"); //$NON-NLS-1$
		fuenteFranklin.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteFranklin);
		mnFuente.add(fuenteFranklin);
		
		mnTamañoFuente = new JMenu(Messages.getString("MainWindow.24")); //$NON-NLS-1$
		mnAjustes.add(mnTamañoFuente);
		
		mnTFuente12 = new JMenuItem("12");  //$NON-NLS-1$
		mnTFuente12.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente12);
		
		mnTFuente16 = new JMenuItem("16"); //$NON-NLS-1$
		mnTFuente16.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente16);
		
		mnTFuente20 = new JMenuItem("20"); //$NON-NLS-1$
		mnTFuente20.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente20);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setForeground(Color.WHITE);
		barraOpciones.add(horizontalGlue);
		
		switch(idioma) {
		case "castellano":  //$NON-NLS-1$
			mntmEspañol.setSelected(true);
			break;
		case "ingles": //$NON-NLS-1$
			mntmIngles.setSelected(true);
			break;
		default:
			break;
		}
		
		btnSalir = new JButton(Messages.getString("MainWindow.30")); //$NON-NLS-1$
		btnSalir.setToolTipText(Messages.getString("MainWindow.31")); //$NON-NLS-1$
		btnSalir.setForeground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date fecha = new Date();
				try {
					
					Usuario usuarioAntiguo = (Usuario) u.clone();
					u.setUltVezConectado(fecha.toString());
					gdao.editarUsuario(u,usuarioAntiguo);
					
				} catch (IOException e1) {
					System.out.println(e1.toString());
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		mnUser = new JMenu(u.getNombre());
		mnUser.setToolTipText(Messages.getString("MainWindow.32")); //$NON-NLS-1$
		mnUser.setBackground(Color.BLACK);
		mnUser.setHorizontalAlignment(SwingConstants.TRAILING);
		mnUser.setBorder(new EmptyBorder(5, 5, 5, 5));
		mnUser.setForeground(Color.WHITE);
		barraOpciones.add(mnUser);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Paleta.azul_turquesa2);
		panel.setBounds(100, 100, 808, 734);;
		mnUser.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 50, 0, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 0, 29, 10, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		fotoUsuario = new JLabel(""); //$NON-NLS-1$
		fotoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		fotoUsuario.setIcon(new ImageIcon(MainWindow.class.getResource(Messages.getString("MainWindow.13")))); //$NON-NLS-1$
		GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
		gbc_fotoUsuario.gridheight = 3;
		gbc_fotoUsuario.anchor = GridBagConstraints.WEST;
		gbc_fotoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_fotoUsuario.gridx = 1;
		gbc_fotoUsuario.gridy = 1;
		panel.add(fotoUsuario, gbc_fotoUsuario);
		
		lblNombre = new JLabel(u.getNombre());
		lblNombre.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		lblApellidos = new JLabel(u.getApellidos());
		lblApellidos.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 2;
		gbc_lblApellidos.gridy = 2;
		panel.add(lblApellidos, gbc_lblApellidos);
		
		lblUltVezConect = new JLabel(Messages.getString("MainWindow.35")+u.getUltVezConectado()+" "); //$NON-NLS-1$ //$NON-NLS-2$
		lblUltVezConect.setForeground(Color.WHITE);
		lblUltVezConect.setMaximumSize(new Dimension(200, 13));
		lblUltVezConect.setRequestFocusEnabled(false);
		lblUltVezConect.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblUltVezConect = new GridBagConstraints();
		gbc_lblUltVezConect.insets = new Insets(0, 0, 5, 5);
		gbc_lblUltVezConect.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUltVezConect.gridx = 2;
		gbc_lblUltVezConect.gridy = 3;
		panel.add(lblUltVezConect, gbc_lblUltVezConect);
		
		
		
		btnSalir.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnSalir.setBackground(new Color(0,0,0,0));
		btnSalir.setOpaque(false);
		btnSalir.setIcon(new ImageIcon(MainWindow.class.getResource("/Iconos/006-logout.png"))); //$NON-NLS-1$
		barraOpciones.add(btnSalir);
		
		
		pnlOpciones = new JPanel();
		panelSuperior.add(pnlOpciones, BorderLayout.SOUTH);
		pnlOpciones.setLayout(new BorderLayout(0, 0));
		
		tbAcciones = new JToolBar();
		tbAcciones.setBorder(null);
		tbAcciones.setBackground(Paleta.azul_turquesa2);
		tbAcciones.setFloatable(false);
		pnlOpciones.add(tbAcciones);
		
		btnConsultarInformacion = new JButton(Messages.getString("MainWindow.38")); //$NON-NLS-1$
		btnConsultarInformacion.setToolTipText(Messages.getString("MainWindow.39")); //$NON-NLS-1$
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
		
		btnRealizarReserva = new JButton(Messages.getString("MainWindow.40")); //$NON-NLS-1$
		btnRealizarReserva.setToolTipText(Messages.getString("MainWindow.41")); //$NON-NLS-1$
		btnRealizarReserva.setFocusable(false);
		btnRealizarReserva.setFocusTraversalKeysEnabled(false);
		btnRealizarReserva.setFocusPainted(false);
		btnRealizarReserva.setVerifyInputWhenFocusTarget(false);
		btnRealizarReserva.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnRealizarReserva.setBackground(Paleta.azul_turquesa2);
		btnRealizarReserva.setForeground(Color.WHITE);
		btnRealizarReserva.addActionListener(new btnComunAcciones());
		tbAcciones.add(btnRealizarReserva);
		
		btnPersonal = new JButton(Messages.getString("MainWindow.42")); //$NON-NLS-1$
		btnPersonal.setToolTipText(Messages.getString("MainWindow.43")); //$NON-NLS-1$
		btnPersonal.setFocusable(false);
		btnPersonal.setFocusTraversalKeysEnabled(false);
		btnPersonal.setFocusPainted(false);
		btnPersonal.setVerifyInputWhenFocusTarget(false);
		btnPersonal.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnPersonal.setBackground(Paleta.azul_turquesa2);
		btnPersonal.setForeground(Color.WHITE);
		btnPersonal.addActionListener(new btnComunAcciones());
		tbAcciones.add(btnPersonal);
		
		btnDibujarRuta = new JButton(Messages.getString("MainWindow.44")); //$NON-NLS-1$
		btnDibujarRuta.setToolTipText(Messages.getString("MainWindow.45")); //$NON-NLS-1$
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
			if(e.getActionCommand().equals("Consultar Información")|| e.getActionCommand().equals("Show information")) { //$NON-NLS-1$ //$NON-NLS-2$
				resetearColor();				
				btnConsultarInformacion.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, Messages.getString("MainWindow.25")); //$NON-NLS-1$
			}
			if(e.getActionCommand().equals("Realizar Reserva")|| e.getActionCommand().equals("Booking")) { //$NON-NLS-1$ //$NON-NLS-2$
				resetearColor();	
				btnRealizarReserva.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, Messages.getString("MainWindow.22")); //$NON-NLS-1$
			}
			if(e.getActionCommand().equals("Personal")) { //$NON-NLS-1$
				resetearColor();				
				btnPersonal.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, Messages.getString("MainWindow.26")); //$NON-NLS-1$
			}
			if(e.getActionCommand().equals("Dibujar Ruta")||e.getActionCommand().equals("Draw route")) { //$NON-NLS-1$ //$NON-NLS-2$
				resetearColor();				
				btnDibujarRuta.setBackground(Paleta.azul_oscuro);
				panelSeleccionado.show(panelCentral, Messages.getString("MainWindow.27")); //$NON-NLS-1$
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
			case "12": //$NON-NLS-1$
				fuenteDefault = new Font(fuenteDefault.getFontName(), Font.PLAIN, 12);
				break;
			case "16": //$NON-NLS-1$
				fuenteDefault = new Font(fuenteDefault.getFontName(), Font.PLAIN, 16);
				break;
			case "20": //$NON-NLS-1$
				fuenteDefault = new Font(fuenteDefault.getFontName(), Font.PLAIN, 20);
				break;
			case "Arial": //$NON-NLS-1$
				fuenteDefault = new Font("Arial", Font.PLAIN, fuenteDefault.getSize()); //$NON-NLS-1$
				break;
				
			case "Verdana": //$NON-NLS-1$
				fuenteDefault = new Font("Avenir Next LT Pro", Font.PLAIN, fuenteDefault.getSize()); //$NON-NLS-1$
				break;
				
			case "Franklin Gothic Book": //$NON-NLS-1$
				fuenteDefault = new Font("Franklin Gothic Book", Font.PLAIN, fuenteDefault.getSize()); //$NON-NLS-1$
				break;

			}
			nuevaFuente(new FontUIResource(fuenteDefault));
		}
	}
	private class MnIdiomaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
					MainWindow mw = null;
					try {
					if (mntmIngles.isSelected()) {
						Messages.setIdioma("inglés"); //$NON-NLS-1$
						mw = new MainWindow(usuario, "ingles"); //$NON-NLS-1$
						mw.mntmIngles.setSelected(true);
						Locale locale = new Locale("en"); //$NON-NLS-1$
						JOptionPane.setDefaultLocale(locale);
					} else {
						Messages.setIdioma("español"); //$NON-NLS-1$
						mw = new MainWindow(usuario,"castellano"); //$NON-NLS-1$
						mw.mntmEspañol.setSelected(true);
						Locale locale = new Locale("es"); //$NON-NLS-1$
						JOptionPane.setDefaultLocale(locale);
					}
					mw.setVisible(true);
					dispose();
					}catch (Exception e2) {
						e2.printStackTrace();
					}
				}
	}
	public static void nuevaFuente(FontUIResource f) {
        @SuppressWarnings("rawtypes")
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