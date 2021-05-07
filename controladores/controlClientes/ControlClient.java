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

	public void setAVistaCliente(JPanel panelCont, JPanel panelAg) {
		// panelCont = vi.getPanelAux();
		panelCont.removeAll();
		panelCont.add(panelAg);
		panelCont.updateUI();
	}

}
