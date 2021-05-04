package eventosGeneral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vistasGenerales.VistaGeneral;

public class EventosMenuGest implements ActionListener {

	private VistaGeneral vistaG;

	private JPanel panelAdd;

	public EventosMenuGest(VistaGeneral vi, JPanel p) {

		vistaG = vi;

		panelAdd = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		vistaG.setVista(panelAdd);
	}

}
