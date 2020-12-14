package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dominio.Usuario;
import persistencia.GestorFicheros;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class LoginWindow {

	private JFrame frmGestorDeCamping;
	private JTextField txtFUsuario;
	private JPasswordField txtFContraseña;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GestorFicheros gf = new GestorFicheros();
		
		frmGestorDeCamping = new JFrame();
		frmGestorDeCamping.setFont(new Font("Hack NF", Font.PLAIN, 12));
		frmGestorDeCamping.setTitle("Gestor de Camping");
		frmGestorDeCamping.setResizable(false);
		frmGestorDeCamping.setBounds(100, 100, 697, 466);
		frmGestorDeCamping.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestorDeCamping.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTextPane txtFeedback = new JTextPane();
		txtFeedback.setText("Bienvenido al Gestor de Camping");
		frmGestorDeCamping.getContentPane().add(txtFeedback, BorderLayout.SOUTH);
		
		JPanel panelTitulo = new JPanel();
		frmGestorDeCamping.getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(null);
		
		JLabel Titulo = new JLabel("GESTOR CAMPING");
		Titulo.setFont(new Font("Hack NF", Font.PLAIN, 28));
		Titulo.setBounds(0, 0, 336, 125);
		panelTitulo.add(Titulo);
		
		JPanel presentacionPanel = new JPanel();
		frmGestorDeCamping.getContentPane().add(presentacionPanel, BorderLayout.CENTER);
		presentacionPanel.setLayout(null);
		
		JPanel datosUsuario = new JPanel();
		datosUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		datosUsuario.setBounds(372, 114, 243, 161);
		presentacionPanel.add(datosUsuario);
		datosUsuario.setLayout(null);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario[] listaUsuarios=gf.getUsuarios();
				
				for(int i=0; i<=listaUsuarios.length; i++) {
					Usuario usuario=listaUsuarios[i];
					System.out.print(usuario.toString());
					if(usuario.getNick().equals(txtFUsuario.getText()) && usuario.getContraseña().equals(String.valueOf(txtFContraseña.getPassword()))) {
						btnAcceder.setForeground(Color.GREEN);
						txtFeedback.setForeground(Color.GREEN);
						MainWindow window = new MainWindow();
						window.setVisible(true);
						frmGestorDeCamping.dispose();
					}else {
						txtFeedback.setText("Usuario o contraseña mal.");
						txtFeedback.setForeground(Color.RED);
						btnAcceder.setForeground(Color.RED);
					}
				}
				
			}
		});
		btnAcceder.setBounds(148, 130, 85, 21);
		datosUsuario.add(btnAcceder);
		
		txtFUsuario = new JTextField();
		txtFUsuario.setBounds(88, 30, 145, 19);
		datosUsuario.add(txtFUsuario);
		txtFUsuario.setColumns(10);
		
		txtFContraseña = new JPasswordField();
		txtFContraseña.setBounds(88, 84, 145, 19);
		datosUsuario.add(txtFContraseña);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(-18, 36, 96, 13);
		datosUsuario.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña.setBounds(-18, 90, 96, 13);
		datosUsuario.add(lblContraseña);
		
		JMenuBar menuBar = new JMenuBar();
		frmGestorDeCamping.setJMenuBar(menuBar);
		
		JMenu mnIdioma = new JMenu("Idioma");
		menuBar.add(mnIdioma);
	}
}
