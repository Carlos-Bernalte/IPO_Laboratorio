package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.Vector;
import java.text.ParseException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

import dominio.GenericDAO;
import dominio.Usuario;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LoginWindow {
	public JFrame frmGestorDeCamping;
	private JTextField txtFUsuario;
	private JPasswordField txtFContraseña;
	private JButton btnAcceder;
	private JPanel datosUsuario;
	private JPanel panelTitulo;
	private JPanel presentacionPanel;
	private JLabel Titulo;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JTextPane txtFeedback;
	private JMenuBar menuBar;
	private JMenu mnIdioma;
	private JRadioButtonMenuItem mnInglés;
	private JRadioButtonMenuItem mnEspañol;
	private JMenu mnAjustes;
	private JMenu mnFuente;
	private JMenu mnTamañoFuente;
	private JMenuItem fuenteArial;
	private JMenuItem mnTFuente12;
	private JButton btnSalir;
	private JMenuItem fuenteAvenir;
	private JMenuItem fuenteFranklin;
	private final ButtonGroup btnGroupFuente = new ButtonGroup();
	private Font fuenteDefault;
	private JMenuItem mnTFuente20;
	private JMenuItem mnTFuente16;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmGestorDeCamping.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		frmGestorDeCamping = new JFrame();
		frmGestorDeCamping.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/Iconos/003-tent.png")));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmGestorDeCamping.setUndecorated(true);
		fuenteDefault = new Font("Avenir Next LT Pro", 0, 12); //$NON-NLS-1$
		nuevaFuente(new FontUIResource(fuenteDefault));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		frmGestorDeCamping.setBounds(pantalla.width/3, pantalla.height/3, 614, 300);
		frmGestorDeCamping.getContentPane().setLayout(new BorderLayout(0, 0));
		
		txtFeedback = new JTextPane();
		txtFeedback.setToolTipText(Messages.getString("LoginWindow.txtFeedback.toolTipText")); //$NON-NLS-1$
		txtFeedback.setEditable(false);
		txtFeedback.setBackground(Paleta.azul_oscuro);
		txtFeedback.setForeground(Color.WHITE);
		txtFeedback.setText(Messages.getString("LoginWindow.1")); //$NON-NLS-1$
		frmGestorDeCamping.getContentPane().add(txtFeedback, BorderLayout.SOUTH);
		
		panelTitulo = new JPanel();
		frmGestorDeCamping.getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(null);
		
		Titulo = new JLabel(Messages.getString("LoginWindow.2")); //$NON-NLS-1$
		Titulo.setBounds(0, 0, 336, 125);
		panelTitulo.add(Titulo);
		
		presentacionPanel = new JPanel();
		presentacionPanel.setBackground(Paleta.blanco_gris);
		frmGestorDeCamping.getContentPane().add(presentacionPanel, BorderLayout.CENTER);
		presentacionPanel.setLayout(null);	


		datosUsuario = new JPanel();
		datosUsuario.setForeground(Color.WHITE);
		datosUsuario.setBackground(Paleta.azul_turquesa2);
		datosUsuario.setBorder(new TitledBorder(null, Messages.getString("LoginWindow.3"), TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE)); //$NON-NLS-1$

		datosUsuario.setBounds(272, 40, 243, 161);
		presentacionPanel.add(datosUsuario);
		datosUsuario.setLayout(null);
		
		btnAcceder = new JButton(Messages.getString("LoginWindow.4")); //$NON-NLS-1$
		btnAcceder.setToolTipText(Messages.getString("LoginWindow.btnAcceder.toolTipText")); //$NON-NLS-1$
		btnAcceder.setForeground(Color.WHITE);
		btnAcceder.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAcceder.setBackground(Paleta.azul_turquesa);
		btnAcceder.setEnabled(false);
		btnAcceder.setIcon(new ImageIcon(LoginWindow.class.getResource("/Iconos/005-enter.png"))); //$NON-NLS-1$
		btnAcceder.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainWindow window;
				try {
					GenericDAO gdao= new GenericDAO();
					Vector<Usuario> listaUsuarios=gdao.getListaUsuarios();
					for(int i=0; i<listaUsuarios.size();i++) {
						Usuario u = listaUsuarios.elementAt(i);

						if(String.valueOf(txtFUsuario.getText()).equals(u.getNick()) && String.valueOf(txtFContraseña.getPassword()).equals(u.getContraseña())) {
							txtFeedback.setForeground(Color.GREEN);
							txtFeedback.setText(Messages.getString("LoginWindow.6")); //$NON-NLS-1$
							if (mnEspañol.isSelected()) {
								MainWindow mw = new MainWindow(u, "castellano");
								mw.setVisible(true);
							}
							else if (mnInglés.isSelected()){
								MainWindow mw = new MainWindow(u, "ingles");
								mw.setVisible(true);
							}
							frmGestorDeCamping.dispose();
						}
					}
					txtFUsuario.setText(""); //$NON-NLS-1$
					txtFContraseña.setText(""); //$NON-NLS-1$
					txtFeedback.setForeground(Color.RED);
					txtFeedback.setText(Messages.getString("LoginWindow.9")); //$NON-NLS-1$
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAcceder.setBounds(124, 130, 109, 21);
		datosUsuario.add(btnAcceder);
		
		txtFUsuario = new JTextField();
		txtFUsuario.setToolTipText(Messages.getString("LoginWindow.txtFUsuario.toolTipText")); //$NON-NLS-1$
		txtFUsuario.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtFUsuario.setBounds(88, 30, 145, 19);
		datosUsuario.add(txtFUsuario);
		txtFUsuario.setColumns(10);
		txtFUsuario.setText(""); //$NON-NLS-1$
		
		txtFContraseña = new JPasswordField();
		txtFContraseña.setToolTipText(Messages.getString("LoginWindow.txtFContraseña.toolTipText")); //$NON-NLS-1$
		txtFContraseña.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtFContraseña.addKeyListener(new TxtFContraseñaKeyListener());
		txtFContraseña.setBounds(88, 84, 145, 19);
		datosUsuario.add(txtFContraseña);
		txtFContraseña.setText(""); //$NON-NLS-1$
		
		lblUsuario = new JLabel(Messages.getString("LoginWindow.12")); //$NON-NLS-1$
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(-18, 36, 96, 13);
		datosUsuario.add(lblUsuario);
		
		lblContraseña = new JLabel(Messages.getString("LoginWindow.13")); //$NON-NLS-1$
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña.setBounds(-18, 90, 96, 13);
		datosUsuario.add(lblContraseña);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Paleta.azul_oscuro);
		frmGestorDeCamping.setJMenuBar(menuBar);
		
		mnIdioma = new JMenu(Messages.getString("LoginWindow.14")); //$NON-NLS-1$
		mnIdioma.setToolTipText(Messages.getString("LoginWindow.mnIdioma.toolTipText")); //$NON-NLS-1$
		mnIdioma.setForeground(Color.WHITE);
		mnIdioma.setIcon(new ImageIcon(LoginWindow.class.getResource("/Iconos/007-language.png"))); //$NON-NLS-1$
		menuBar.add(mnIdioma);
		
		mnEspañol = new JRadioButtonMenuItem(Messages.getString("LoginWindow.16")); //$NON-NLS-1$
		mnEspañol.setToolTipText(Messages.getString("LoginWindow.mnEspañol.toolTipText")); //$NON-NLS-1$
		buttonGroup.add(mnEspañol);
		mnEspañol.setSelected(true);
		mnEspañol.addActionListener(new MnIdiomaActionListener());
		mnEspañol.setIcon(new ImageIcon(LoginWindow.class.getResource("/Iconos/001-spain.png"))); //$NON-NLS-1$
		mnIdioma.add(mnEspañol);
		
		mnInglés = new JRadioButtonMenuItem(Messages.getString("LoginWindow.18"));
		mnInglés.setToolTipText(Messages.getString("LoginWindow.mnInglés.toolTipText")); //$NON-NLS-1$
		buttonGroup.add(mnInglés);
		mnInglés.addActionListener(new  MnIdiomaActionListener());
		mnInglés.setIcon(new ImageIcon(LoginWindow.class.getResource("/Iconos/002-united-kingdom.png"))); //$NON-NLS-1$
		mnIdioma.add(mnInglés);
		
		mnAjustes = new JMenu(Messages.getString("LoginWindow.20")); //$NON-NLS-1$
		mnAjustes.setToolTipText(Messages.getString("LoginWindow.mnAjustes.toolTipText")); //$NON-NLS-1$
		mnAjustes.setForeground(Color.WHITE);
		mnAjustes.setIcon(new ImageIcon(LoginWindow.class.getResource("/Iconos/004-settings.png"))); //$NON-NLS-1$
		menuBar.add(mnAjustes);
		
		mnFuente = new JMenu(Messages.getString("LoginWindow.22")); //$NON-NLS-1$
		mnAjustes.add(mnFuente);
		
		fuenteArial = new JMenuItem(Messages.getString("LoginWindow.23")); //$NON-NLS-1$
		fuenteArial.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteArial);
		mnFuente.add(fuenteArial);
		
		fuenteAvenir = new JMenuItem(Messages.getString("LoginWindow.24")); //$NON-NLS-1$
		fuenteAvenir.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteAvenir);
		mnFuente.add(fuenteAvenir);
		
		fuenteFranklin = new JMenuItem(Messages.getString("LoginWindow.25")); //$NON-NLS-1$
		fuenteFranklin.addActionListener(new fuenteListener());
		btnGroupFuente.add(fuenteFranklin);
		mnFuente.add(fuenteFranklin);
		
		mnTamañoFuente = new JMenu(Messages.getString("LoginWindow.26")); //$NON-NLS-1$
		mnAjustes.add(mnTamañoFuente);
		
		mnTFuente12 = new JMenuItem("12"); //$NON-NLS-1$
		mnTFuente12.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente12);
		
		mnTFuente16 = new JMenuItem("16"); //$NON-NLS-1$
		mnTFuente16.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente16);
		
		mnTFuente20 = new JMenuItem("20"); //$NON-NLS-1$
		mnTFuente20.addActionListener(new fuenteListener());
		mnTamañoFuente.add(mnTFuente20);
		
		btnSalir = new JButton(Messages.getString("LoginWindow.30")); //$NON-NLS-1$
		btnSalir.setToolTipText(Messages.getString("LoginWindow.btnSalir.toolTipText")); //$NON-NLS-1$
		btnSalir.setForeground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestorDeCamping.dispose();
			}
		});
		btnSalir.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnSalir.setBackground(new Color(0,0,0,0));
		btnSalir.setOpaque(false);
		btnSalir.setIcon(new ImageIcon(LoginWindow.class.getResource(Messages.getString("LoginWindow.31")))); //$NON-NLS-1$
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(btnSalir);
		
	}
	private class TxtFContraseñaKeyListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			if(txtFUsuario.getText()!="" && String.valueOf(txtFContraseña.getPassword())!=""){ //$NON-NLS-1$ //$NON-NLS-2$
					btnAcceder.setEnabled(true);
		}
	}
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
				fuenteDefault = new Font(Messages.getString("LoginWindow.38"), Font.PLAIN, fuenteDefault.getSize()); //$NON-NLS-1$
				break;
				
			case "Verdana": //$NON-NLS-1$
				fuenteDefault = new Font(Messages.getString("LoginWindow.40"), Font.PLAIN, fuenteDefault.getSize()); //$NON-NLS-1$
				break;
				
			case "Franklin Gothic Book": //$NON-NLS-1$
				fuenteDefault = new Font(Messages.getString("LoginWindow.42"), Font.PLAIN, fuenteDefault.getSize()); //$NON-NLS-1$
				break;

			}
			nuevaFuente(new FontUIResource(fuenteDefault));
		}
	}
	private class MnIdiomaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginWindow vl = null;
			if (mnInglés.isSelected()) {
				Messages.setIdioma("inglés");
				vl = new LoginWindow();
				vl.mnInglés.setSelected(true);
			}else {
				Messages.setIdioma("español");
				vl = new LoginWindow();
			}
			vl.getGestorDeCamping().setVisible(true);
			frmGestorDeCamping.dispose();
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
	public JFrame getGestorDeCamping() {
		return frmGestorDeCamping;
	}
}