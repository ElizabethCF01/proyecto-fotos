package eventosGeneral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controlClientes.ControlClient;

public class EventoMenuGestCl implements ActionListener {

	private JPanel panelCambiar1, panelCambiar2, panelPoner;

	// private VistaRegistroClient vistaR;

	private ControlClient controlC;

	public EventoMenuGestCl(JPanel panelCambiar1, JPanel panelCambiar2, JPanel panelPoner) {

		this.panelCambiar1 = panelCambiar1;

		this.panelCambiar2 = panelCambiar2;

		this.panelPoner = panelPoner;

		// vistaR = new VistaRegistroClient();
		controlC = new ControlClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controlC.setVista(panelCambiar1, panelCambiar2, panelPoner);
	}

	/*
	 * public static void addV() { controlC.setAVistaCliente(panelCont, vistaR); }
	 */
}
