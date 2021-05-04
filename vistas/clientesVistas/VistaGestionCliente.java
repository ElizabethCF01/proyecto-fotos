package clientesVistas;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaGestionCliente extends JPanel {

	private JLabel nombreYapell, edad, telef, acomp;
	private JTextField cajaNombreA, cajaEdad, cajaTelef;
	private JCheckBox verifAcomp;

	public VistaGestionCliente() {

		nombreYapell = new JLabel("Nobre y Apellidos:");
		edad = new JLabel("Edad:");
		telef = new JLabel("Teléfono:");
		acomp = new JLabel("Acompañante:");

		cajaNombreA = new JTextField(20);
		cajaNombreA.setEnabled(false);

		cajaEdad = new JTextField(4);
		cajaEdad.setEnabled(false);

		cajaTelef = new JTextField(10);
		cajaTelef.setEnabled(false);

		verifAcomp = new JCheckBox();
		verifAcomp.setEnabled(false);

		add(nombreYapell);
		add(cajaNombreA);

		add(edad);
		add(cajaEdad);

		add(telef);
		add(cajaTelef);

		add(acomp);
		add(verifAcomp);

	}

	public JTextField getCajaNombre() {
		return cajaNombreA;
	}

	public JTextField getCajaEdad() {
		return cajaEdad;
	}

	public JTextField getCajaTel() {
		return cajaTelef;
	}

	public JCheckBox getVerifAcomp() {
		return verifAcomp;
	}
}
