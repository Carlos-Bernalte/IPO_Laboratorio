package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class LoginWindow {

	private JFrame frmGestionDeCamping;
	private JPanel panelCentral;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmGestionDeCamping.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeCamping = new JFrame();
		frmGestionDeCamping.setResizable(false);
		frmGestionDeCamping.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/presentacion/\u00EDndice.png")));
		frmGestionDeCamping.setTitle("Gestion de Camping");
		frmGestionDeCamping.setBounds(100, 100, 712, 402);
		frmGestionDeCamping.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelCentral = new JPanel();
		frmGestionDeCamping.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JTextArea txtrGestorDe = new JTextArea();
		txtrGestorDe.setEditable(false);
		txtrGestorDe.setBackground(SystemColor.control);
		txtrGestorDe.setForeground(Color.BLACK);
		txtrGestorDe.setFont(new Font("Monospaced", Font.PLAIN, 30));
		txtrGestorDe.setBounds(36, 36, 310, 55);
		txtrGestorDe.setText("GESTOR DE CAMPING");
		panelCentral.add(txtrGestorDe);
		
		JTextArea txtrDatosDeUsuario = new JTextArea();
		txtrDatosDeUsuario.setEditable(false);
		txtrDatosDeUsuario.setBounds(384, 65, 132, 19);
		panelCentral.add(txtrDatosDeUsuario);
		txtrDatosDeUsuario.setBackground(SystemColor.control);
		txtrDatosDeUsuario.setText("Datos de usuario");
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(384, 92, 301, 177);
		panelCentral.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrUsuario = new JTextArea();
		txtrUsuario.setEditable(false);
		txtrUsuario.setBackground(SystemColor.control);
		txtrUsuario.setText("Usuario:");
		txtrUsuario.setBounds(68, 31, 68, 22);
		panel.add(txtrUsuario);
		
		textField = new JTextField();
		textField.setBounds(173, 31, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.setBackground(SystemColor.control);
		txtrContrasea.setText("Contrase\u00F1a:");
		txtrContrasea.setBounds(43, 66, 93, 22);
		panel.add(txtrContrasea);
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.setBounds(68, 135, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(192, 135, 97, 25);
		panel.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 66, 116, 22);
		panel.add(passwordField);
		
		JPanel panelSur = new JPanel();
		panelSur.setBorder(new LineBorder(SystemColor.desktop, 2));
		panelCentral.add(panelSur);
		panelSur.setBounds(new Rectangle(0, 331, 706, 34));
		panelSur.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1ol", "Ingl\u00E9s"}));
		comboBox.setBounds(77, 5, 87, 21);
		panelSur.add(comboBox);
		
		JTextArea txtrIdioma = new JTextArea();
		txtrIdioma.setEditable(false);
		txtrIdioma.setBackground(SystemColor.control);
		txtrIdioma.setText("Idioma:");
		txtrIdioma.setBounds(21, 4, 60, 22);
		panelSur.add(txtrIdioma);
		
		JTextPane txtpnAquSeMuestran = new JTextPane();
		txtpnAquSeMuestran.setEditable(false);
		txtpnAquSeMuestran.setBackground(SystemColor.control);
		txtpnAquSeMuestran.setText("Aqu\u00ED se muestran los errores");
		txtpnAquSeMuestran.setBounds(24, 299, 322, 19);
		panelCentral.add(txtpnAquSeMuestran);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogo.setIcon(new ImageIcon(LoginWindow.class.getResource("/presentacion/Camping-portada.jpg")));
		lblLogo.setBounds(46, 92, 300, 177);
		panelCentral.add(lblLogo);
	}
}