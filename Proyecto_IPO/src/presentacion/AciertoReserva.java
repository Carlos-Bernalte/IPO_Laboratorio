package presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Frame;



public class AciertoReserva extends JFrame{

	public JFrame frmAciertoReserva;
	private JPanel contentPane;
	private JButton btnAceptarError;
	private JLabel lblReservaRealizadaCorrectamente;
	private JLabel lblNewLabel;
	
	public AciertoReserva() {
		setTitle("Reserva correcta");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setBounds(100, 100, 808, 734);
		frmAciertoReserva = new JFrame();
		frmAciertoReserva.setBounds(new Rectangle(300, 300, 600, 300));
		frmAciertoReserva.setTitle("adsbkhadsbhads");
		frmAciertoReserva.setSize(new Dimension(600, 300));
		frmAciertoReserva.setResizable(false);
		frmAciertoReserva.setUndecorated(true);
		
		contentPane= new JPanel();
		contentPane.setBackground(Paleta.azul_oscuro);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptarError = new JButton("Aceptar");
		btnAceptarError.addActionListener(new BtnAceptarErrorActionListener());
		btnAceptarError.setFocusTraversalKeysEnabled(false);
		btnAceptarError.setFocusPainted(false);
		btnAceptarError.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnAceptarError.setBackground(Color.GREEN);
		btnAceptarError.setBounds(244, 236, 75, 17);
		contentPane.add(btnAceptarError);
		
		lblReservaRealizadaCorrectamente = new JLabel("Reserva realizada correctamente");
		lblReservaRealizadaCorrectamente.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservaRealizadaCorrectamente.setForeground(Color.WHITE);
		lblReservaRealizadaCorrectamente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReservaRealizadaCorrectamente.setBounds(134, 189, 304, 27);
		contentPane.add(lblReservaRealizadaCorrectamente);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AciertoReserva.class.getResource("/imagenes/checked.png")));
		lblNewLabel.setBounds(227, 31, 130, 128);
		contentPane.add(lblNewLabel);
	}
	private class BtnAceptarErrorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmAciertoReserva.dispose();
		}
	}
}