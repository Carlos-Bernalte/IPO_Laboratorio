package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Empleado;
import dominio.GenericDAO;

import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Personal extends JPanel {
	private JPanel pnlInformacionPersonal;
	private JLabel imgPersonal;
	private JLabel lblNombre;
	private JTextField txtFieldNombre;
	private JLabel lblNewLabel;
	private JTextField textFieldApellidos;
	private JLabel lblDNI;
	private JTextField textFieldDNI;
	private JTextField textFieldTelefono;
	private JLabel lblTelefono;
	private JTextField textFieldEmail;
	private JLabel lblEmail;
	private JScrollPane scrollPane;
	private JList listaPersonal;

	/**
	 * Create the panel.
	 */
	public Personal(GenericDAO gdao) {
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		pnlInformacionPersonal = new JPanel();
		pnlInformacionPersonal.setBackground(Paleta.fuente);
		pnlInformacionPersonal.setBorder(new TitledBorder(null, "Datos Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pnlInformacionPersonal, BorderLayout.EAST);
		GridBagLayout gbl_pnlInformacionPersonal = new GridBagLayout();
		gbl_pnlInformacionPersonal.columnWidths = new int[]{37, 65, 71, 199, 28, 0};
		gbl_pnlInformacionPersonal.rowHeights = new int[]{37, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlInformacionPersonal.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlInformacionPersonal.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlInformacionPersonal.setLayout(gbl_pnlInformacionPersonal);
		
		imgPersonal = new JLabel("");
		imgPersonal.setIcon(new ImageIcon(Personal.class.getResource("/imagenes/usuario.png")));
		GridBagConstraints gbc_imgPersonal = new GridBagConstraints();
		gbc_imgPersonal.fill = GridBagConstraints.HORIZONTAL;
		gbc_imgPersonal.insets = new Insets(0, 0, 5, 5);
		gbc_imgPersonal.gridx = 1;
		gbc_imgPersonal.gridy = 1;
		pnlInformacionPersonal.add(imgPersonal, gbc_imgPersonal);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		pnlInformacionPersonal.add(lblNombre, gbc_lblNombre);
		
		txtFieldNombre = new JTextField();
		GridBagConstraints gbc_txtFieldNombre = new GridBagConstraints();
		gbc_txtFieldNombre.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldNombre.gridx = 3;
		gbc_txtFieldNombre.gridy = 2;
		pnlInformacionPersonal.add(txtFieldNombre, gbc_txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		lblNewLabel = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		pnlInformacionPersonal.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setPreferredSize(new Dimension(5, 19));
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellidos.gridx = 3;
		gbc_textFieldApellidos.gridy = 3;
		pnlInformacionPersonal.add(textFieldApellidos, gbc_textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		lblDNI = new JLabel("DNI:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 2;
		gbc_lblDNI.gridy = 4;
		pnlInformacionPersonal.add(lblDNI, gbc_lblDNI);
		
		textFieldDNI = new JTextField();
		GridBagConstraints gbc_textFieldDNI = new GridBagConstraints();
		gbc_textFieldDNI.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldDNI.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDNI.gridx = 3;
		gbc_textFieldDNI.gridy = 4;
		pnlInformacionPersonal.add(textFieldDNI, gbc_textFieldDNI);
		textFieldDNI.setColumns(10);
		
		lblTelefono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.gridx = 2;
		gbc_lblTelefono.gridy = 5;
		pnlInformacionPersonal.add(lblTelefono, gbc_lblTelefono);
		
		textFieldTelefono = new JTextField();
		GridBagConstraints gbc_textFieldTelefono = new GridBagConstraints();
		gbc_textFieldTelefono.anchor = GridBagConstraints.WEST;
		gbc_textFieldTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono.gridx = 3;
		gbc_textFieldTelefono.gridy = 5;
		pnlInformacionPersonal.add(textFieldTelefono, gbc_textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		lblEmail = new JLabel("Correo electrónico:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 6;
		pnlInformacionPersonal.add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldEmail.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldEmail.gridx = 3;
		gbc_textFieldEmail.gridy = 6;
		pnlInformacionPersonal.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		listaPersonal = new JList();
		listaPersonal.setValueIsAdjusting(true);
		refresh(gdao);
		listaPersonal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Empleado empleado = (Empleado) listaPersonal.getSelectedValue();
				txtFieldNombre.setText(empleado.getNombre());
				textFieldApellidos.setText(empleado.getApellido());
				textFieldDNI.setText(empleado.getDni());
				textFieldTelefono.setText(empleado.getTelefono());
				textFieldEmail.setText(empleado.getEmail());
			}
		});
		
		listaPersonal.setCellRenderer(new RenderizadoPersonal());
		
		scrollPane.setViewportView(listaPersonal);

	}
	public void refresh(GenericDAO gdao) {
		DefaultListModel modeloLista = new DefaultListModel();
		listaPersonal.setModel(modeloLista);
		Vector<Empleado> lEmpleados=gdao.getListaEmpleados();
		for(int i=0; i<lEmpleados.size(); i++) {
			modeloLista.addElement(lEmpleados.get(i));
			
		}
		
	}

}
