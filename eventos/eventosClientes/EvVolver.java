package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
import controlClientes.ControlClient;
import vistasGenerales.VistaGeneral;

public class EvVolver implements ActionListener {

	private VistaRegistroClient vistaAVolv;

	private VistaGestionCliente panelASust;

	private ControlClient ctrlCl;

	public EvVolver(VistaGestionCliente panelASust) {

		this.panelASust = panelASust;

		ctrlCl = new ControlClient();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vistaAVolv = VistaGeneral.getVistaRegCl();

		ctrlCl.setVistaCl(panelASust, vistaAVolv);

	}

}
