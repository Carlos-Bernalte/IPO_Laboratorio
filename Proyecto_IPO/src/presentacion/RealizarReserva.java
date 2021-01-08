package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import dominio.Alojamiento;
import dominio.GenericDAO;
import dominio.Reserva;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.beans.PropertyChangeEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.List;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;

public class RealizarReserva extends JPanel {
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblFEntrada;
	private JLabel lblFSalida;
	private JTextField textNombre;
	private JTextField textCorreo;
	private JTextArea textAreaSolicitudesEspeciales;
	private JDateChooser dateChooserComingDay;
	private JDateChooser dateChooserExitDate;
	private JFormattedTextField textTelefono;
	private JButton btnReservar;
	private JButton btnLimpiarReserva;
	private JLabel lblSolicitudes;
	private JList<Alojamiento> listAlojamientos;
	private java.util.Date fecha;
	private JPanel InformacionReserva;
	private JScrollPane scrollPane;
	private Label label;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public RealizarReserva(GenericDAO gdao) throws ParseException {
		fecha = new Date();
		
		setBackground(Paleta.azul_oscuro);
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{500, 10, 40};
		gridBagLayout.rowHeights = new int[]{10, 312, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		InformacionReserva = new JPanel();
		InformacionReserva.setBackground(Paleta.azul_turquesa2);
		InformacionReserva.setForeground(Color.WHITE);
		GridBagConstraints gbc_InformacionReserva = new GridBagConstraints();
		gbc_InformacionReserva.insets = new Insets(0, 0, 5, 5);
		gbc_InformacionReserva.fill = GridBagConstraints.BOTH;
		gbc_InformacionReserva.gridx = 0;
		gbc_InformacionReserva.gridy = 1;
		add(InformacionReserva, gbc_InformacionReserva);
		GridBagLayout gbl_InformacionReserva = new GridBagLayout();
		gbl_InformacionReserva.columnWidths = new int[]{100, 206, 100, 50, 100, 0};
		gbl_InformacionReserva.rowHeights = new int[]{40, 0, 10, 0, 0, 0, 0, 0, 20, 0, 200, 0, 10, 0, 0};
		gbl_InformacionReserva.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_InformacionReserva.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		InformacionReserva.setLayout(gbl_InformacionReserva);
		
		label = new Label("Información de la reserva:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		InformacionReserva.add(label, gbc_label);
		
		lblNombre = new JLabel("*Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		InformacionReserva.add(lblNombre, gbc_lblNombre);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textNombre = new JTextField();
		textNombre.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridwidth = 2;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.gridx = 2;
		gbc_textNombre.gridy = 3;
		InformacionReserva.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		lblTelefono = new JLabel("*Teléfono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 4;
		InformacionReserva.add(lblTelefono, gbc_lblTelefono);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		MaskFormatter mascara = new MaskFormatter("#########");
		textTelefono = new JFormattedTextField(mascara);
		textTelefono.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefono.gridx = 2;
		gbc_textTelefono.gridy = 4;
		InformacionReserva.add(textTelefono, gbc_textTelefono);
		
		lblCorreo = new JLabel("Correo electrónico:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 5;
		InformacionReserva.add(lblCorreo, gbc_lblCorreo);
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textCorreo = new JTextField();
		textCorreo.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_textCorreo = new GridBagConstraints();
		gbc_textCorreo.gridwidth = 2;
		gbc_textCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_textCorreo.gridx = 2;
		gbc_textCorreo.gridy = 5;
		InformacionReserva.add(textCorreo, gbc_textCorreo);
		textCorreo.setColumns(10);
		
		lblFEntrada = new JLabel("*Fecha de entrada:");
		GridBagConstraints gbc_lblFEntrada = new GridBagConstraints();
		gbc_lblFEntrada.anchor = GridBagConstraints.EAST;
		gbc_lblFEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblFEntrada.gridx = 1;
		gbc_lblFEntrada.gridy = 6;
		InformacionReserva.add(lblFEntrada, gbc_lblFEntrada);
		lblFEntrada.setForeground(Color.WHITE);
		lblFEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		

		
		dateChooserComingDay = new JDateChooser();
		dateChooserComingDay.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_dateChooserComingDay = new GridBagConstraints();
		gbc_dateChooserComingDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserComingDay.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserComingDay.gridx = 2;
		gbc_dateChooserComingDay.gridy = 6;
		InformacionReserva.add(dateChooserComingDay, gbc_dateChooserComingDay);
		dateChooserComingDay.addPropertyChangeListener(new DateChooserComingDayPropertyChangeListener());
		
		dateChooserComingDay.setMinSelectableDate(fecha);
		
		lblFSalida = new JLabel("*Fecha de salida:");
		GridBagConstraints gbc_lblFSalida = new GridBagConstraints();
		gbc_lblFSalida.anchor = GridBagConstraints.EAST;
		gbc_lblFSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblFSalida.gridx = 1;
		gbc_lblFSalida.gridy = 7;
		InformacionReserva.add(lblFSalida, gbc_lblFSalida);
		lblFSalida.setForeground(Color.WHITE);
		lblFSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		
		dateChooserExitDate = new JDateChooser();
		dateChooserExitDate.setBorder(new LineBorder(Color.BLACK));
		GridBagConstraints gbc_dateChooserExitDate = new GridBagConstraints();
		gbc_dateChooserExitDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserExitDate.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserExitDate.gridx = 2;
		gbc_dateChooserExitDate.gridy = 7;
		InformacionReserva.add(dateChooserExitDate, gbc_dateChooserExitDate);
		dateChooserExitDate.addFocusListener(new DateChooserExitDateFocusListener());
		
		dateChooserExitDate.setMinSelectableDate(fecha);
		
		lblSolicitudes = new JLabel("Solicitudes Especiales:");
		GridBagConstraints gbc_lblSolicitudes = new GridBagConstraints();
		gbc_lblSolicitudes.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblSolicitudes.insets = new Insets(0, 0, 5, 5);
		gbc_lblSolicitudes.gridx = 1;
		gbc_lblSolicitudes.gridy = 9;
		InformacionReserva.add(lblSolicitudes, gbc_lblSolicitudes);
		lblSolicitudes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSolicitudes.setForeground(Color.WHITE);
		
		textAreaSolicitudesEspeciales = new JTextArea();
		GridBagConstraints gbc_textAreaSolicitudesEspeciales = new GridBagConstraints();
		gbc_textAreaSolicitudesEspeciales.fill = GridBagConstraints.BOTH;
		gbc_textAreaSolicitudesEspeciales.gridheight = 2;
		gbc_textAreaSolicitudesEspeciales.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaSolicitudesEspeciales.gridwidth = 3;
		gbc_textAreaSolicitudesEspeciales.gridx = 1;
		gbc_textAreaSolicitudesEspeciales.gridy = 10;
		InformacionReserva.add(textAreaSolicitudesEspeciales, gbc_textAreaSolicitudesEspeciales);
		
		
		btnLimpiarReserva = new JButton("Limpiar");
		GridBagConstraints gbc_btnLimpiarReserva = new GridBagConstraints();
		gbc_btnLimpiarReserva.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiarReserva.gridx = 1;
		gbc_btnLimpiarReserva.gridy = 13;
		InformacionReserva.add(btnLimpiarReserva, gbc_btnLimpiarReserva);
		btnLimpiarReserva.addActionListener(new BtnLimpiarReservaActionListener());
		btnLimpiarReserva.setFocusTraversalKeysEnabled(false);
		btnLimpiarReserva.setFocusPainted(false);
		btnLimpiarReserva.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLimpiarReserva.setBackground(Color.RED);
		
		btnReservar = new JButton("Reservar");
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.insets = new Insets(0, 0, 0, 5);
		gbc_btnReservar.gridx = 2;
		gbc_btnReservar.gridy = 13;
		InformacionReserva.add(btnReservar, gbc_btnReservar);
		btnReservar.addActionListener(new BtnReservarActionListener());
		btnReservar.setFocusTraversalKeysEnabled(false);
		btnReservar.setFocusPainted(false);
		btnReservar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnReservar.setBackground(Color.GREEN);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setBackground(Paleta.azul_oscuro);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		listAlojamientos = new JList<Alojamiento>();
		listAlojamientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAlojamientos.setForeground(Color.WHITE);
		listAlojamientos.setBackground(new Color(15, 48, 87));
		scrollPane.setViewportView(listAlojamientos);
		
		refresh(gdao);
		listAlojamientos.setCellRenderer(new RenderizadoAlojamiento());
		


	}
	
	private class DateChooserExitDateFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			Date minDate = dateChooserComingDay.getDate();
			dateChooserExitDate.setMinSelectableDate(minDate);
		}
	}
	private class DateChooserComingDayPropertyChangeListener implements PropertyChangeListener {
		public void propertyChange(PropertyChangeEvent evt) {
			Date minDate = dateChooserComingDay.getDate();
			dateChooserExitDate.setMinSelectableDate(minDate);
		}
	}
	private class BtnLimpiarReservaActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				textAreaSolicitudesEspeciales.setText("");
				textNombre.setText("");
				textTelefono.setText("");
				textCorreo.setText("");
				dateChooserComingDay.setDate(null);
				dateChooserExitDate.setDate(null);
			}
	}
	private class BtnReservarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int valor=0;
			try {
				String nombreAlojamiento =listAlojamientos.getSelectedValue().toStringNombreAlojamiento(listAlojamientos.getSelectedValue().toString());
				Reserva r = new Reserva(nombreAlojamiento ,textNombre.getText(),textTelefono.getText(),textCorreo.getText(),"5",dateChooserComingDay.getDate(),dateChooserExitDate.getDate(),textAreaSolicitudesEspeciales.getText());
				valor=r.guardarReserva(r);
				ErrorReserva windowError;
				AciertoReserva windowAcierto;
				if (valor ==1) {
					 windowAcierto = new AciertoReserva();
					windowAcierto.setVisible(true);
				}else {
					windowError = new ErrorReserva();
					windowError.setVisible(true);
				}
			} catch (IOException e1) {
				ErrorReserva windowError = new ErrorReserva();
				windowError.setVisible(true);
				e1.printStackTrace();
			}
		}
	}
	public void refresh(GenericDAO gdao) {
		DefaultListModel<Alojamiento> modeloLista = new DefaultListModel<Alojamiento>();
		listAlojamientos.setModel(modeloLista);
		Vector<Alojamiento> lAlojamiento=gdao.getListaAlojamientos();
		for(int i=0; i<lAlojamiento.size(); i++) {
			modeloLista.addElement(lAlojamiento.get(i));
			
		}
		
	}
}