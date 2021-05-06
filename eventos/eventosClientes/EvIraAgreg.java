package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;

public class EvIraAgreg implements ActionListener {

	private VistaRegistroClient vistaContenedor;

	private VistaGestionCliente panelCambiar;

	public EvIraAgreg(VistaGestionCliente panelCambiar, VistaRegistroClient vistaContenedor) {
		this.panelCambiar = panelCambiar;
		this.vistaContenedor = vistaContenedor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vistaContenedor.cambiarVista(panelCambiar);
		vistaContenedor.getBotAnt().setVisible(true);
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
