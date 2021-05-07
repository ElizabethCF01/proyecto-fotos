package vistasGenerales;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import eventosGeneral.EventoMenuGestCl;
import eventosGeneral.EventosMenuGestOf;
import ofertasVistas.VistaGestionOffer;

public class VistaGeneral extends JPanel {

	private JMenu acciones;

	private JMenuBar barra;

	private JMenuItem gestOfertas;

	private JMenuItem gestClientes;

	private EventosMenuGestOf evGestOf;

	private EventoMenuGestCl evGestClient;

	private JPanel laminaMenu;

	private VistaGestionOffer vistaOffers;

	// private VistaRegistroClient vistaClientes;

	private JPanel panelAux;

	public VistaGeneral() {

		panelAux = new JPanel();

		setLayout(new BorderLayout(8, 8));

		laminaMenu = new JPanel();

		barra = new JMenuBar();

		acciones = new JMenu("Acciones");

		gestOfertas = new JMenuItem("Gestionar Ofertas");

		gestClientes = new JMenuItem("Gestionar Clientes");

		vistaOffers = new VistaGestionOffer();

		// vistaClientes = new VistaRegistroClient();

		evGestOf = new EventosMenuGestOf(panelAux, vistaOffers);
		gestOfertas.addActionListener(evGestOf);

		evGestClient = new EventoMenuGestCl(panelAux);
		gestClientes.addActionListener(evGestClient);

		acciones.add(gestOfertas);
		acciones.add(gestClientes);

		barra.add(acciones);

		laminaMenu.add(barra);

		add(laminaMenu, BorderLayout.WEST);
		add(panelAux, BorderLayout.CENTER);

	}

	/*
	 * public void setVista(JPanel pa) { this.panelAux.removeAll();
	 * this.panelAux.add(pa, BorderLayout.CENTER); this.updateUI();
	 * 
	 * }
	 */

	public JPanel getPanelAux() {
		return panelAux;
	}
}
