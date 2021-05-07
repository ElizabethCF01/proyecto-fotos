package eventosGeneral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import clientesVistas.VistaRegistroClient;
import controlClientes.ControlClient;

public class EventoMenuGestCl implements ActionListener {

	private JPanel panelCont;

	private VistaRegistroClient vistaR;

	private ControlClient controlC;

	public EventoMenuGestCl(JPanel panelCont) {

		this.panelCont = panelCont;

		vistaR = new VistaRegistroClient();
		controlC = new ControlClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controlC.setAVistaCliente(panelCont, vistaR);
	}

}
