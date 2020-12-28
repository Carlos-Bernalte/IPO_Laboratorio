package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RealizarReserva extends JPanel {
	private JPanel datosReserva;

	/**
	 * Create the panel.
	 */
	public RealizarReserva() {
		setBorder(new TitledBorder(null, "Realizar Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 492, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		datosReserva = new JPanel();
		datosReserva.setBorder(new TitledBorder(null, "Datos Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_datosReserva = new GridBagConstraints();
		gbc_datosReserva.fill = GridBagConstraints.HORIZONTAL;
		gbc_datosReserva.anchor = GridBagConstraints.NORTH;
		gbc_datosReserva.insets = new Insets(0, 0, 0, 5);
		gbc_datosReserva.gridx = 1;
		gbc_datosReserva.gridy = 2;
		add(datosReserva, gbc_datosReserva);

	}

}
