package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class ConsultarInformacion extends JPanel {
	private JTabbedPane tabbedPaneConsultarInformacion;
	private JPanel tabParcelas;
	private JPanel tabBungalows;
	private JPanel tabRutas;
	private JPanel tabActividades;

	/**
	 * Create the panel.
	 */
	public ConsultarInformacion() {
		setBackground(Paleta.azul_oscuro);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		tabbedPaneConsultarInformacion = new JTabbedPane(JTabbedPane.LEFT);
		add(tabbedPaneConsultarInformacion);
		
		tabParcelas = new JPanel();
		tabbedPaneConsultarInformacion.addTab("Parcelas", null, tabParcelas, null);
		
		tabBungalows = new JPanel();
		tabbedPaneConsultarInformacion.addTab("Bungalows", null, tabBungalows, null);
		
		tabRutas = new JPanel();
		tabbedPaneConsultarInformacion.addTab("Rutas", null, tabRutas, null);
		
		tabActividades = new JPanel();
		tabbedPaneConsultarInformacion.addTab("Actividades", null, tabActividades, null);

	}
}
