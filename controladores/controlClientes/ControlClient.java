package controlClientes;

import java.util.ArrayList;

import javax.swing.JPanel;

import clientes.Cliente;
import ofertas.Oferta;

public class ControlClient {

	private static ArrayList<Cliente> clientes;

	public ControlClient() {

		clientes = new ArrayList<Cliente>();

		Cliente cliente1 = new Cliente("Maria Gonzales Cue ", true, 18, 53457820);
		cliente1.getTiposOfertasCant().put(new Oferta("Fotos 5x8", 25), 3);

		clientes.add(cliente1);

	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setVista(JPanel panelCamb1, JPanel panelCamb2, JPanel panelAgr) {
		// panelCont = vi.getPanelAux();
		/*
		 * panelCont.removeAll(); panelCont.add(panelAg); panelCont.updateUI();
		 */
		panelCamb1.setVisible(false);
		panelCamb1.setSize(0, 0);
		panelCamb2.setVisible(false);
		panelCamb2.setSize(0, 0);
		panelAgr.setVisible(true);
		panelAgr.setSize(800, 400);

	}

	public void setVistaCl(JPanel panelCamb, JPanel panelAgr) {

		panelCamb.setVisible(false);
		panelCamb.setSize(0, 0);
		panelAgr.setVisible(true);
		panelAgr.setSize(870, 400);

	}

}
