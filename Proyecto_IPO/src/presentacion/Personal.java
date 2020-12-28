package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

public class Personal extends JPanel {

	/**
	 * Create the panel.
	 */
	public Personal() {
		setBorder(new TitledBorder(null, "Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

	}

}
