package presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;



public class ErrorReserva extends JDialog{

	public JFrame frmErrorReserva;
	public JPanel contentPane;
	private JButton btnAceptarError;
	private JLabel lblErrorReserva;
	private JLabel lblImagenError;
	
	public ErrorReserva() {
		setUndecorated(true);
		frmErrorReserva = new JFrame();
		frmErrorReserva.setBounds(new Rectangle(300, 300, 600, 300));
		frmErrorReserva.setType(Type.POPUP);
		frmErrorReserva.setTitle("basura");
		frmErrorReserva.setSize(new Dimension(600, 300));
		frmErrorReserva.getContentPane().setSize(new Dimension(600, 300));
		frmErrorReserva.setResizable(false);
		frmErrorReserva.setUndecorated(true);
		frmErrorReserva.getContentPane().setLayout(new BorderLayout(0, 0));
		
		contentPane= new JPanel();
		contentPane.setBackground(Paleta.azul_oscuro);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptarError = new JButton("Aceptar");
		btnAceptarError.setFocusTraversalKeysEnabled(false);
		btnAceptarError.setFocusPainted(false);
		btnAceptarError.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnAceptarError.setBackground(Color.GREEN);
		btnAceptarError.setBounds(238, 237, 75, 17);
		contentPane.add(btnAceptarError);
		
		lblErrorReserva = new JLabel("Se ha producido un error al reservar, comprueba los datos.");
		lblErrorReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorReserva.setForeground(Color.WHITE);
		lblErrorReserva.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorReserva.setBounds(98, 172, 374, 27);
		contentPane.add(lblErrorReserva);
		
		lblImagenError = new JLabel("");
		lblImagenError.setIcon(new ImageIcon(ErrorReserva.class.getResource("/imagenes/error.png")));
		lblImagenError.setBounds(247, 53, 145, 93);
		contentPane.add(lblImagenError);
	}
}