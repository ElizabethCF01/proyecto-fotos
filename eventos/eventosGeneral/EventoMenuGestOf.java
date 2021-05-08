package eventosGeneral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controladorOfertas.ControlOffers;
import ofertasVistas.VistaGestionOffer;

public class EventoMenuGestOf implements ActionListener {

	// private VistaGeneral vistaG;

	private VistaGestionOffer vistOf;

	private JPanel panelCamb1;

	private JPanel panelCamb2;

	private ControlOffers co;

	public EventoMenuGestOf(JPanel panelCamb1, JPanel panelCamb2, VistaGestionOffer vistOf) {

		this.panelCamb1 = panelCamb1;
		this.panelCamb2 = panelCamb2;
		this.vistOf = vistOf;

		co = new ControlOffers();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		co.setAVistaOffers(panelCamb1, panelCamb2, vistOf);
	}

}
