package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import clientesVistas.VistaGestionCliente;

public class EvCajaVisible implements ActionListener {

	private JCheckBox casillaVerif;

	private JTextField cajaCant;

	private VistaGestionCliente vista;

	// private int cant;

	// private Oferta offerAux, offerGuard;

	public EvCajaVisible(JCheckBox casillaVerif, JTextField cajaCant, VistaGestionCliente vista) {
		this.casillaVerif = casillaVerif;
		this.cajaCant = cajaCant;
		// this.offerAux = offerAux;
		this.vista = vista;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (casillaVerif.isSelected()) {

			cajaCant.setVisible(true);
			vista.updateUI();

			// cant = Integer.parseInt(cajaCant.getText());
			// offerGuard = offerAux;
		}

	}

}
