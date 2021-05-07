package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
import controlClientes.ControlClient;
import controladorOfertas.ControlOffers;

public class EvIraAgreg implements ActionListener {

	private VistaRegistroClient vistaContenedor;

	private VistaGestionCliente panelCambiar;

	private ControlOffers ctrlOf;

	private ControlClient ctrlCli;

	public EvIraAgreg(VistaGestionCliente panelCambiar, VistaRegistroClient vistaContenedor) {
		this.panelCambiar = panelCambiar;
		this.vistaContenedor = vistaContenedor;

		ctrlOf = new ControlOffers();
		ctrlCli = new ControlClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// vistaContenedor.cambiarVista(panelCambiar);
		ctrlCli.setAVistaCliente(vistaContenedor.getPanelDeCambio(), panelCambiar);

		vistaContenedor.getBotAnt().setVisible(true);
		panelCambiar.getBotAgregar().setVisible(true);

		panelCambiar.removeCheckOffers(panelCambiar.getPanelCent());
		panelCambiar.AddCheckOffer(ctrlOf.getOffers(), panelCambiar.getPanelCent());
		panelCambiar.getPanelCent().setVisible(true);

		panelCambiar.getCajaNombre().setEnabled(true);
		panelCambiar.getCajaNombre().setText("");

		panelCambiar.getCajaEdad().setEnabled(true);
		panelCambiar.getCajaEdad().setText("");

		panelCambiar.getCajaTel().setEnabled(true);
		panelCambiar.getCajaTel().setText("");

		panelCambiar.getVerifAcomp().setEnabled(true);
		panelCambiar.getVerifAcomp().setSelected(false);

		panelCambiar.getAreaOf().setVisible(false);

		for (int i = 0; i < panelCambiar.getCasillasOf().size(); i++) {
			panelCambiar.getCasillasOf().get(i).setSelected(false);
			panelCambiar.getCajasCantOf().get(i).setVisible(false);
			panelCambiar.getCajasCantOf().get(i).setText("");
		}
	}

}
