package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import clientesVistas.VistaRegistroClient;
import controlClientes.ControlClient;
import controladorOfertas.ControlOffers;

public class EvVolver implements ActionListener {

	private VistaRegistroClient vistaCon;

	private JPanel panelCamb;

	private JTextArea area;

	private ControlClient ctrlCl;

	private ControlOffers ctrlOff;

	public EvVolver(JPanel panelCamb, VistaRegistroClient vistaCon, JTextArea area) {

		this.panelCamb = panelCamb;
		this.vistaCon = vistaCon;
		this.area = area;

		ctrlCl = new ControlClient();
		ctrlOff = new ControlOffers();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vistaCon.cambiarVista(panelCamb);
		vistaCon.getBotAnt().setVisible(false);

		area.setText("");

		for (int i = 0; i < ctrlCl.getClientes().size(); i++) {

			area.setText(
					area.getText() + (i + 1) + "  " + ctrlCl.getClientes().get(i).getNombre() + System.lineSeparator());
		}

	}

}
