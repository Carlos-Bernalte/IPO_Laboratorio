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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
	private Label labelSolicitudesEspeciales;
	private JTextArea textAreaSolicitudesEspeciales;
	private JSpinner spinnerNumeroOcupantes;
	private JButton btnLimpiarReserva;
	private JButton btnReservar;
	private JDateChooser dateChooserComingDay;
	private JDateChooser dateChooserExitDate;
	private JFormattedTextField textTelefono;
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public RealizarReserva() throws ParseException {
		setBorder(new TitledBorder(null, "Realizar Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{74, 118, 124, 47, 92, 222, 40};
		gridBagLayout.rowHeights = new int[]{34, 34, 34, 34, 68, 46, 40, 34, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0,1.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		labelSolicitudesEspeciales = new Label("Solicitudes especiales:");
		GridBagConstraints gbc_labelSolicitudesEspeciales = new GridBagConstraints();
		gbc_labelSolicitudesEspeciales.gridwidth = 2;
		gbc_labelSolicitudesEspeciales.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelSolicitudesEspeciales.insets = new Insets(0, 0, 5, 5);
		gbc_labelSolicitudesEspeciales.gridx = 4;
		gbc_labelSolicitudesEspeciales.gridy = 0;
		add(labelSolicitudesEspeciales, gbc_labelSolicitudesEspeciales);
		
		chckbxParcela = new JCheckBox("Parcela");
		chckbxParcela.addActionListener(new ChckbxParcelaActionListener());
		GridBagConstraints gbc_chckbxParcela = new GridBagConstraints();
		gbc_chckbxParcela.anchor = GridBagConstraints.EAST;
		gbc_chckbxParcela.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxParcela.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxParcela.gridx = 1;
		gbc_chckbxParcela.gridy = 1;
		add(chckbxParcela, gbc_chckbxParcela);
		
		chckbxBungalow = new JCheckBox("Bungalow");
		chckbxBungalow.addActionListener(new ChckbxBungalowActionListener());
		GridBagConstraints gbc_chckbxBungalow = new GridBagConstraints();
		gbc_chckbxBungalow.anchor = GridBagConstraints.WEST;
		gbc_chckbxBungalow.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBungalow.gridx = 2;
		gbc_chckbxBungalow.gridy = 1;
		add(chckbxBungalow, gbc_chckbxBungalow);
		
		textAreaSolicitudesEspeciales = new JTextArea();
		GridBagConstraints gbc_textAreaSolicitudesEspeciales = new GridBagConstraints();
		gbc_textAreaSolicitudesEspeciales.gridwidth = 2;
		gbc_textAreaSolicitudesEspeciales.gridheight = 5;
		gbc_textAreaSolicitudesEspeciales.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaSolicitudesEspeciales.fill = GridBagConstraints.BOTH;
		gbc_textAreaSolicitudesEspeciales.gridx = 4;
		gbc_textAreaSolicitudesEspeciales.gridy = 1;
		add(textAreaSolicitudesEspeciales, gbc_textAreaSolicitudesEspeciales);
		
		lblNombre = new JLabel("*Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.gridx = 2;
		gbc_textNombre.gridy = 2;
		add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		lblTelefono = new JLabel("*Teléfono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.gridwidth = 2;
		gbc_lblTelefono.fill = GridBagConstraints.BOTH;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 3;
		add(lblTelefono, gbc_lblTelefono);
		
		MaskFormatter mascara = new MaskFormatter("#########");
		textTelefono = new JFormattedTextField(mascara);
		GridBagConstraints gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefono.gridx = 2;
		gbc_textTelefono.gridy = 3;
		add(textTelefono, gbc_textTelefono);
		
		lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.gridwidth = 2;
		gbc_lblCorreo.fill = GridBagConstraints.BOTH;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 0;
		gbc_lblCorreo.gridy = 4;
		add(lblCorreo, gbc_lblCorreo);
		
		textCorreo = new JTextField();
		GridBagConstraints gbc_textCorreo = new GridBagConstraints();
		gbc_textCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_textCorreo.gridx = 2;
		gbc_textCorreo.gridy = 4;
		add(textCorreo, gbc_textCorreo);
		textCorreo.setColumns(10);
		
		lblNOcupantes = new JLabel("*Numero de ocupantes:");
		lblNOcupantes.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNOcupantes = new GridBagConstraints();
		gbc_lblNOcupantes.gridwidth = 2;
		gbc_lblNOcupantes.anchor = GridBagConstraints.EAST;
		gbc_lblNOcupantes.fill = GridBagConstraints.VERTICAL;
		gbc_lblNOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNOcupantes.gridx = 0;
		gbc_lblNOcupantes.gridy = 5;
		add(lblNOcupantes, gbc_lblNOcupantes);
		
		spinnerNumeroOcupantes = new JSpinner();
		spinnerNumeroOcupantes.setModel(new SpinnerNumberModel(0, 0, 6, 1));
		GridBagConstraints gbc_spinnerNumeroOcupantes = new GridBagConstraints();
		gbc_spinnerNumeroOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumeroOcupantes.gridx = 2;
		gbc_spinnerNumeroOcupantes.gridy = 5;
		add(spinnerNumeroOcupantes, gbc_spinnerNumeroOcupantes);
		
		lblFEntrada = new JLabel("*Fecha de entrada:");
		lblFEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFEntrada = new GridBagConstraints();
		gbc_lblFEntrada.gridwidth = 2;
		gbc_lblFEntrada.fill = GridBagConstraints.BOTH;
		gbc_lblFEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblFEntrada.gridx = 0;
		gbc_lblFEntrada.gridy = 6;
		add(lblFEntrada, gbc_lblFEntrada);
		
		dateChooserComingDay = new JDateChooser();
		dateChooserComingDay.addPropertyChangeListener(new DateChooserComingDayPropertyChangeListener());
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 6;
		add(dateChooserComingDay, gbc_dateChooser);
		java.util.Date fecha= new Date();
		dateChooserComingDay.setMinSelectableDate(fecha);
		
		btnLimpiarReserva = new JButton("Limpiar");
		btnLimpiarReserva.addActionListener(new BtnLimpiarReservaActionListener());
		GridBagConstraints gbc_btnLimpiarReserva = new GridBagConstraints();
		gbc_btnLimpiarReserva.anchor = GridBagConstraints.WEST;
		gbc_btnLimpiarReserva.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiarReserva.gridx = 4;
		gbc_btnLimpiarReserva.gridy = 6;
		add(btnLimpiarReserva, gbc_btnLimpiarReserva);
		
		btnReservar = new JButton("Reservar");
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.anchor = GridBagConstraints.EAST;
		gbc_btnReservar.insets = new Insets(0, 0, 5, 5);
		gbc_btnReservar.gridx = 5;
		gbc_btnReservar.gridy = 6;
		add(btnReservar, gbc_btnReservar);
		
		lblFSalida = new JLabel("*Fecha de salida:");
		lblFSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFSalida = new GridBagConstraints();
		gbc_lblFSalida.gridwidth = 2;
		gbc_lblFSalida.fill = GridBagConstraints.BOTH;
		gbc_lblFSalida.insets = new Insets(0, 0, 0, 5);
		gbc_lblFSalida.gridx = 0;
		gbc_lblFSalida.gridy = 7;
		add(lblFSalida, gbc_lblFSalida);
		
		dateChooserExitDate = new JDateChooser();
		dateChooserExitDate.addFocusListener(new DateChooserExitDateFocusListener());
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 7;
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
	private class BtnLimpiarReservaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			chckbxBungalow.setSelected(false);
			chckbxParcela.setSelected(false);
			textAreaSolicitudesEspeciales.setText("");
			textNombre.setText("");
			textTelefono.setText("");
			textCorreo.setText("");
			spinnerNumeroOcupantes.setValue(0);
			java.util.Date fecha= new Date();
			dateChooserComingDay.setDate(fecha);
			dateChooserExitDate.setDate(fecha);
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
}
