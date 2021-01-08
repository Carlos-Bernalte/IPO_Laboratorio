package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import editorGrafico.AreaDibujo;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class DibujarRuta extends JPanel {
	private JPanel panelDibujo;
	private JPanel informacionRuta;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private AreaDibujo areaDibujo;
	private ImageIcon imagen;
	private JButton cargarMapa;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JDateChooser dateChooser;
	private JTextField txtHoraInicio;
	private JTextField txtHoraFin;
	private JButton btnNewButton_1;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public DibujarRuta() throws ParseException {
		setBackground(Paleta.azul_oscuro);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 10, 505, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panelDibujo = new JPanel();
		panelDibujo.setOpaque(false);
		GridBagConstraints gbc_panelDibujo = new GridBagConstraints();
		gbc_panelDibujo.insets = new Insets(0, 0, 0, 5);
		gbc_panelDibujo.fill = GridBagConstraints.BOTH;
		gbc_panelDibujo.gridx = 0;
		gbc_panelDibujo.gridy = 1;
		add(panelDibujo, gbc_panelDibujo);
		panelDibujo.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelDibujo.add(scrollPane, BorderLayout.CENTER);
		
		areaDibujo=new AreaDibujo();
		areaDibujo.setIcon(null);
		scrollPane.setViewportView(areaDibujo);
		
		menuBar = new JMenuBar();
		panelDibujo.add(menuBar, BorderLayout.NORTH);
		
		cargarMapa = new JButton("Nueva Ruta");
		cargarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fcAbrir = new JFileChooser();
				int valorDevuelto = fcAbrir.showOpenDialog(new Frame());
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					File file = fcAbrir.getSelectedFile();
					imagen = new ImageIcon(file.getAbsolutePath());
					areaDibujo.setIcon(imagen);
				}
			}
		});
		menuBar.add(cargarMapa);
		
		mnNewMenu = new JMenu("Puntos");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Inicio");
		mntmNewMenuItem_1.setSelectedIcon(new ImageIcon(DibujarRuta.class.getResource("/Iconos/bandera_inicio.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Llegada");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem = new JMenuItem("Fuentes de Agua");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_3 = new JMenuItem("Merenderos");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		informacionRuta = new JPanel();
		informacionRuta.setBackground(Paleta.azul_turquesa2);
		GridBagConstraints gbc_informacionRuta = new GridBagConstraints();
		gbc_informacionRuta.fill = GridBagConstraints.BOTH;
		gbc_informacionRuta.gridx = 2;
		gbc_informacionRuta.gridy = 1;
		add(informacionRuta, gbc_informacionRuta);
		GridBagLayout gbl_informacionRuta = new GridBagLayout();
		gbl_informacionRuta.columnWidths = new int[]{10, 154, 100, 50, 10, 0};
		gbl_informacionRuta.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_informacionRuta.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_informacionRuta.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		informacionRuta.setLayout(gbl_informacionRuta);
		
		lblNewLabel = new JLabel("Monitor:");
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		informacionRuta.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		informacionRuta.add(comboBox, gbc_comboBox);
		
		lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		informacionRuta.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 3;
		informacionRuta.add(dateChooser, gbc_dateChooser);
		
		lblNewLabel_1 = new JLabel("Hora de Inicio:");
		lblNewLabel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		informacionRuta.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		MaskFormatter mascara = new MaskFormatter("##:##");
		txtHoraInicio = new JFormattedTextField(mascara);
		GridBagConstraints gbc_txtHoraInicio = new GridBagConstraints();
		gbc_txtHoraInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraInicio.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraInicio.gridx = 2;
		gbc_txtHoraInicio.gridy = 4;
		informacionRuta.add(txtHoraInicio, gbc_txtHoraInicio);
		txtHoraInicio.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Hora de Fin");
		lblNewLabel_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		informacionRuta.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtHoraFin = new JFormattedTextField(mascara);
		GridBagConstraints gbc_txtHoraFin = new GridBagConstraints();
		gbc_txtHoraFin.insets = new Insets(0, 0, 5, 5);
		gbc_txtHoraFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoraFin.gridx = 2;
		gbc_txtHoraFin.gridy = 5;
		informacionRuta.add(txtHoraFin, gbc_txtHoraFin);
		txtHoraFin.setColumns(10);
		
		btnNewButton = new JButton("Limpiar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		informacionRuta.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Guardar Ruta");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		informacionRuta.add(btnNewButton_1, gbc_btnNewButton_1);

	}

}
