package presentacion;

import javax.swing.JPanel;
import java.util.Vector;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import dominio.Empleado;
import dominio.GenericDAO;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;

public class Personal extends JPanel {
	private JScrollPane scrollPane;
	private JList<Empleado> listaPersonal;
	private JPanel pnlInfoPersonal;
	private JLabel fotoEmpleado;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDNI;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JTextField txtFieldNombre;
	private JTextField txtFieldApellidos;
	private JTextField txtFieldDNI;
	private JTextField txtFieldTelefono;
	private JTextField txtFieldEmail;
	private JButton btnDarDeAlta;
	private JButton btnDarDeBaja;

	/**
	 * Create the panel.
	 */
	public Personal(GenericDAO gdao) {
		setBackground(Paleta.azul_oscuro);
		setForeground(Paleta.azul_oscuro);
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1155, 10, 80, 10, 0};
		gridBagLayout.rowHeights = new int[]{10, 590, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(Paleta.azul_turquesa);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		listaPersonal = new JList<Empleado>();
		listaPersonal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaPersonal.setBorder(null);
		listaPersonal.setForeground(Color.BLACK);
		listaPersonal.setBackground(Paleta.azul_oscuro);
		listaPersonal.setSelectionBackground(Paleta.azul_turquesa2);
		listaPersonal.setSelectionForeground(Color.WHITE);
		
		listaPersonal.setCellRenderer(new RenderizadoPersonal());
		refresh(gdao);
		scrollPane.setViewportView(listaPersonal);
		
		listaPersonal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Empleado empleado = (Empleado) listaPersonal.getSelectedValue();
				txtFieldNombre.setText(empleado.getNombre());
				txtFieldApellidos.setText(empleado.getApellido());
				txtFieldDNI.setText(empleado.getDni());
				txtFieldTelefono.setText(empleado.getTelefono());
				txtFieldEmail.setText(empleado.getEmail());
			}
		});
		
		pnlInfoPersonal = new JPanel();
		pnlInfoPersonal.setBackground(Paleta.azul_turquesa2);
		GridBagConstraints gbc_pnlInfoPersonal = new GridBagConstraints();
		gbc_pnlInfoPersonal.insets = new Insets(0, 0, 0, 5);
		gbc_pnlInfoPersonal.fill = GridBagConstraints.BOTH;
		gbc_pnlInfoPersonal.gridx = 2;
		gbc_pnlInfoPersonal.gridy = 1;
		add(pnlInfoPersonal, gbc_pnlInfoPersonal);
		GridBagLayout gbl_pnlInfoPersonal = new GridBagLayout();
		gbl_pnlInfoPersonal.columnWidths = new int[]{10, 10, 10, 100, 80, 80, 15, 0};
		gbl_pnlInfoPersonal.rowHeights = new int[]{10, 0, 20, 0, 0, 0, 0, 0, 20, 10, 0, 0};
		gbl_pnlInfoPersonal.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlInfoPersonal.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlInfoPersonal.setLayout(gbl_pnlInfoPersonal);
		
		fotoEmpleado = new JLabel("");
		fotoEmpleado.setForeground(Color.WHITE);
		fotoEmpleado.setIcon(new ImageIcon(Personal.class.getResource("/imagenes/usuario.png")));
		GridBagConstraints gbc_fotoEmpleado = new GridBagConstraints();
		gbc_fotoEmpleado.gridwidth = 6;
		gbc_fotoEmpleado.insets = new Insets(0, 0, 5, 5);
		gbc_fotoEmpleado.gridx = 0;
		gbc_fotoEmpleado.gridy = 1;
		pnlInfoPersonal.add(fotoEmpleado, gbc_fotoEmpleado);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 3;
		pnlInfoPersonal.add(lblNombre, gbc_lblNombre);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_txtFieldNombre = new GridBagConstraints();
		gbc_txtFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldNombre.gridx = 3;
		gbc_txtFieldNombre.gridy = 3;
		pnlInfoPersonal.add(txtFieldNombre, gbc_txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 2;
		gbc_lblApellidos.gridy = 4;
		pnlInfoPersonal.add(lblApellidos, gbc_lblApellidos);
		
		txtFieldApellidos = new JTextField();
		txtFieldApellidos.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_txtFieldApellidos = new GridBagConstraints();
		gbc_txtFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldApellidos.gridwidth = 2;
		gbc_txtFieldApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldApellidos.gridx = 3;
		gbc_txtFieldApellidos.gridy = 4;
		pnlInfoPersonal.add(txtFieldApellidos, gbc_txtFieldApellidos);
		txtFieldApellidos.setColumns(10);
		
		lblDNI = new JLabel("NIF: ");
		lblDNI.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 2;
		gbc_lblDNI.gridy = 5;
		pnlInfoPersonal.add(lblDNI, gbc_lblDNI);
		
		txtFieldDNI = new JTextField();
		txtFieldDNI.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_txtFieldDNI = new GridBagConstraints();
		gbc_txtFieldDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldDNI.gridx = 3;
		gbc_txtFieldDNI.gridy = 5;
		pnlInfoPersonal.add(txtFieldDNI, gbc_txtFieldDNI);
		txtFieldDNI.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 2;
		gbc_lblTelefono.gridy = 6;
		pnlInfoPersonal.add(lblTelefono, gbc_lblTelefono);
		
		txtFieldTelefono = new JTextField();
		txtFieldTelefono.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_txtFieldTelefono = new GridBagConstraints();
		gbc_txtFieldTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldTelefono.gridx = 3;
		gbc_txtFieldTelefono.gridy = 6;
		pnlInfoPersonal.add(txtFieldTelefono, gbc_txtFieldTelefono);
		txtFieldTelefono.setColumns(10);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 7;
		pnlInfoPersonal.add(lblEmail, gbc_lblEmail);
		
		txtFieldEmail = new JTextField();
		txtFieldEmail.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_txtFieldEmail = new GridBagConstraints();
		gbc_txtFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldEmail.gridwidth = 3;
		gbc_txtFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldEmail.gridx = 3;
		gbc_txtFieldEmail.gridy = 7;
		pnlInfoPersonal.add(txtFieldEmail, gbc_txtFieldEmail);
		txtFieldEmail.setColumns(10);
		
		btnDarDeAlta = new JButton("Dar Alta");
		btnDarDeAlta.setFocusTraversalKeysEnabled(false);
		btnDarDeAlta.setFocusPainted(false);
		btnDarDeAlta.setBackground(Color.GREEN);
		btnDarDeAlta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_btnDarDeAlta = new GridBagConstraints();
		gbc_btnDarDeAlta.fill = GridBagConstraints.BOTH;
		gbc_btnDarDeAlta.insets = new Insets(0, 0, 5, 5);
		gbc_btnDarDeAlta.gridx = 4;
		gbc_btnDarDeAlta.gridy = 9;
		pnlInfoPersonal.add(btnDarDeAlta, gbc_btnDarDeAlta);
		
		btnDarDeBaja = new JButton("Dar Baja");
		btnDarDeBaja.setFocusTraversalKeysEnabled(false);
		btnDarDeBaja.setFocusPainted(false);
		btnDarDeBaja.setBackground(Color.RED);
		btnDarDeBaja.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_btnDarDeBaja = new GridBagConstraints();
		gbc_btnDarDeBaja.fill = GridBagConstraints.BOTH;
		gbc_btnDarDeBaja.insets = new Insets(0, 0, 5, 5);
		gbc_btnDarDeBaja.gridx = 5;
		gbc_btnDarDeBaja.gridy = 9;
		pnlInfoPersonal.add(btnDarDeBaja, gbc_btnDarDeBaja);

	}

	public void refresh(GenericDAO gdao) {
		DefaultListModel<Empleado> modeloLista = new DefaultListModel<Empleado>();
		listaPersonal.setModel(modeloLista);
		Vector<Empleado> lEmpleados=gdao.getListaEmpleados();
		for(int i=0; i<lEmpleados.size(); i++) {
			modeloLista.addElement(lEmpleados.get(i));
			
		}
		
	}

}
