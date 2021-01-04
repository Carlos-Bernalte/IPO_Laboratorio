package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.Label;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;

import dominio.Alojamiento;
import dominio.Empleado;
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
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class RealizarReserva extends JPanel {
	private JCheckBox chckbxParcela;
	private JCheckBox chckbxBungalow;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblNOcupantes;
	private JLabel lblFEntrada;
	private JLabel lblFSalida;
	private JTextField textNombre;
	private JTextField textCorreo;
	private JTextArea textAreaSolicitudesEspeciales;
	private JSpinner spinnerNumeroOcupantes;
	private JDateChooser dateChooserComingDay;
	private JDateChooser dateChooserExitDate;
	private JFormattedTextField textTelefono;
	private JButton btnReservar;
	private JButton btnLimpiarReserva;
	private JLabel lblSolicitudes;
	private JLabel lblListaAlojamientos;
	private JScrollPane scrollPane;
	private JList<Alojamiento> listAlojamientos;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public RealizarReserva(GenericDAO gdao) throws ParseException {
		setBackground(Paleta.azul_oscuro);
		setBorder(new TitledBorder(null, "Realizar Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{74, 118, 124, 47, 92, 222, 40};
		gridBagLayout.rowHeights = new int[]{34, 34, 34, 68, 46, 40, 34, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0,1.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		chckbxParcela = new JCheckBox("Parcela");
		chckbxParcela.setForeground(Color.WHITE);
		chckbxParcela.setBackground(Paleta.azul_oscuro);
		chckbxParcela.addActionListener(new ChckbxParcelaActionListener());
		GridBagConstraints gbc_chckbxParcela = new GridBagConstraints();
		gbc_chckbxParcela.anchor = GridBagConstraints.EAST;
		gbc_chckbxParcela.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxParcela.gridx = 1;
		gbc_chckbxParcela.gridy = 0;
		
		add(chckbxParcela, gbc_chckbxParcela);
		
		chckbxBungalow = new JCheckBox("Bungalow");
		chckbxBungalow.setForeground(Color.WHITE);
		chckbxBungalow.setBackground(Paleta.azul_oscuro);
		chckbxBungalow.addActionListener(new ChckbxBungalowActionListener());
		GridBagConstraints gbc_chckbxBungalow = new GridBagConstraints();
		gbc_chckbxBungalow.anchor = GridBagConstraints.WEST;
		gbc_chckbxBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBungalow.gridx = 2;
		gbc_chckbxBungalow.gridy = 0;
		add(chckbxBungalow, gbc_chckbxBungalow);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		lblListaAlojamientos = new JLabel("Lista de alojamientos:");
		lblListaAlojamientos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListaAlojamientos.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblListaAlojamientos = new GridBagConstraints();
		gbc_lblListaAlojamientos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblListaAlojamientos.gridwidth = 2;
		gbc_lblListaAlojamientos.insets = new Insets(0, 0, 5, 5);
		gbc_lblListaAlojamientos.gridx = 4;
		gbc_lblListaAlojamientos.gridy = 0;
		add(lblListaAlojamientos, gbc_lblListaAlojamientos);
		
		listAlojamientos = new JList<Alojamiento>();
		listAlojamientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAlojamientos.setForeground(Color.WHITE);
		listAlojamientos.setBackground(new Color(15, 48, 87));
		scrollPane.setViewportView(listAlojamientos);
		
		lblSolicitudes = new JLabel("Solicitudes Especiales:");
		lblSolicitudes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSolicitudes.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSolicitudes = new GridBagConstraints();
		gbc_lblSolicitudes.insets = new Insets(0, 0, 5, 5);
		gbc_lblSolicitudes.gridx = 1;
		gbc_lblSolicitudes.gridy = 7;
		add(lblSolicitudes, gbc_lblSolicitudes);
		refresh(gdao);
		scrollPane.setViewportView(listAlojamientos);
		listAlojamientos.setCellRenderer(new RenderizadoAlojamiento());
		
		textAreaSolicitudesEspeciales = new JTextArea();
		GridBagConstraints gbc_textAreaSolicitudesEspeciales = new GridBagConstraints();
		gbc_textAreaSolicitudesEspeciales.gridwidth = 2;
		gbc_textAreaSolicitudesEspeciales.gridheight = 2;
		gbc_textAreaSolicitudesEspeciales.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaSolicitudesEspeciales.fill = GridBagConstraints.BOTH;
		gbc_textAreaSolicitudesEspeciales.gridx = 1;
		gbc_textAreaSolicitudesEspeciales.gridy = 8;
		add(textAreaSolicitudesEspeciales, gbc_textAreaSolicitudesEspeciales);
		
		lblNombre = new JLabel("*Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.gridx = 2;
		gbc_textNombre.gridy = 1;
		add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		lblTelefono = new JLabel("*Teléfono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.gridwidth = 2;
		gbc_lblTelefono.fill = GridBagConstraints.BOTH;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 2;
		add(lblTelefono, gbc_lblTelefono);
		
		MaskFormatter mascara = new MaskFormatter("#########");
		textTelefono = new JFormattedTextField(mascara);
		GridBagConstraints gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefono.gridx = 2;
		gbc_textTelefono.gridy = 2;
		add(textTelefono, gbc_textTelefono);
		
		lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.gridwidth = 2;
		gbc_lblCorreo.fill = GridBagConstraints.BOTH;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 3;
		add(lblCorreo, gbc_lblCorreo);
		
		textCorreo = new JTextField();
		GridBagConstraints gbc_textCorreo = new GridBagConstraints();
		gbc_textCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_textCorreo.gridx = 2;
		gbc_textCorreo.gridy = 3;
		add(textCorreo, gbc_textCorreo);
		textCorreo.setColumns(10);
		
		lblNOcupantes = new JLabel("*Numero de ocupantes:");
		lblNOcupantes.setForeground(Color.WHITE);
		lblNOcupantes.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNOcupantes = new GridBagConstraints();
		gbc_lblNOcupantes.gridwidth = 2;
		gbc_lblNOcupantes.anchor = GridBagConstraints.EAST;
		gbc_lblNOcupantes.fill = GridBagConstraints.VERTICAL;
		gbc_lblNOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNOcupantes.gridx = 0;
		gbc_lblNOcupantes.gridy = 4;
		add(lblNOcupantes, gbc_lblNOcupantes);
		
		spinnerNumeroOcupantes = new JSpinner();
		spinnerNumeroOcupantes.setModel(new SpinnerNumberModel(0, 0, 6, 1));
		GridBagConstraints gbc_spinnerNumeroOcupantes = new GridBagConstraints();
		gbc_spinnerNumeroOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumeroOcupantes.gridx = 2;
		gbc_spinnerNumeroOcupantes.gridy = 4;
		add(spinnerNumeroOcupantes, gbc_spinnerNumeroOcupantes);
		
		lblFEntrada = new JLabel("*Fecha de entrada:");
		lblFEntrada.setForeground(Color.WHITE);
		lblFEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFEntrada = new GridBagConstraints();
		gbc_lblFEntrada.gridwidth = 2;
		gbc_lblFEntrada.fill = GridBagConstraints.BOTH;
		gbc_lblFEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblFEntrada.gridx = 0;
		gbc_lblFEntrada.gridy = 5;
		add(lblFEntrada, gbc_lblFEntrada);
		
		dateChooserComingDay = new JDateChooser();
		dateChooserComingDay.addPropertyChangeListener(new DateChooserComingDayPropertyChangeListener());
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 5;
		add(dateChooserComingDay, gbc_dateChooser);
		java.util.Date fecha= new Date();
		dateChooserComingDay.setMinSelectableDate(fecha);
		
		btnLimpiarReserva = new JButton("Limpiar");
		btnLimpiarReserva.addActionListener(new BtnLimpiarReservaActionListener());
		btnLimpiarReserva.setFocusTraversalKeysEnabled(false);
		btnLimpiarReserva.setFocusPainted(false);
		btnLimpiarReserva.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLimpiarReserva.setBackground(Color.RED);
		GridBagConstraints gbc_btnLimpiarReserva = new GridBagConstraints();
		gbc_btnLimpiarReserva.anchor = GridBagConstraints.WEST;
		gbc_btnLimpiarReserva.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiarReserva.gridx = 4;
		gbc_btnLimpiarReserva.gridy = 10;
		add(btnLimpiarReserva, gbc_btnLimpiarReserva);
		
		btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new BtnReservarActionListener());
		btnReservar.setFocusTraversalKeysEnabled(false);
		btnReservar.setFocusPainted(false);
		btnReservar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnReservar.setBackground(Color.GREEN);
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.anchor = GridBagConstraints.EAST;
		gbc_btnReservar.insets = new Insets(0, 0, 0, 5);
		gbc_btnReservar.gridx = 5;
		gbc_btnReservar.gridy = 10;
		add(btnReservar, gbc_btnReservar);
		
		lblFSalida = new JLabel("*Fecha de salida:");
		lblFSalida.setForeground(Color.WHITE);
		lblFSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFSalida = new GridBagConstraints();
		gbc_lblFSalida.gridwidth = 2;
		gbc_lblFSalida.fill = GridBagConstraints.BOTH;
		gbc_lblFSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblFSalida.gridx = 0;
		gbc_lblFSalida.gridy = 6;
		add(lblFSalida, gbc_lblFSalida);
		
		dateChooserExitDate = new JDateChooser();
		dateChooserExitDate.addFocusListener(new DateChooserExitDateFocusListener());
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 6;
		add(dateChooserExitDate, gbc_dateChooser_1);
		dateChooserExitDate.setMinSelectableDate(fecha);

	}
	private class ChckbxBungalowActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			chckbxParcela.setSelected(false);
		}
	}
	private class ChckbxParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			chckbxBungalow.setSelected(false);
		}
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
				chckbxBungalow.setSelected(false);
				chckbxParcela.setSelected(false);
				textAreaSolicitudesEspeciales.setText("");
				textNombre.setText("");
				textTelefono.setText("");
				textCorreo.setText("");
				spinnerNumeroOcupantes.setValue(0);
				dateChooserComingDay.setDate(null);
				dateChooserExitDate.setDate(null);
			}
	}
	private class BtnReservarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int valor=0;
			try {
				String nombreAlojamiento =listAlojamientos.getSelectedValue().toStringNombreAlojamiento(listAlojamientos.getSelectedValue().toString());
				Reserva r = new Reserva(nombreAlojamiento ,textNombre.getText(),textTelefono.getText(),textCorreo.getText(),spinnerNumeroOcupantes.getValue().toString(),dateChooserComingDay.getDate(),dateChooserExitDate.getDate(),textAreaSolicitudesEspeciales.getText());
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
