package eventosGeneral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controladorOfertas.ControlOffers;
import ofertasVistas.VistaGestionOffer;

public class EventosMenuGestOf implements ActionListener {

	// private VistaGeneral vistaG;

	private VistaGestionOffer vist;

	private JPanel panelAdd;

	private ControlOffers co;

	public EventosMenuGestOf(JPanel p, VistaGestionOffer vist) {

		// vistaG = vi;

		panelAdd = p;
		this.vist = vist;

		co = new ControlOffers();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		co.setAVistaOffers(panelAdd, vist);
	}

}
