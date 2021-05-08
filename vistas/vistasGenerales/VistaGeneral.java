package vistasGenerales;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
import eventosGeneral.EventoMenuGestCl;
import eventosGeneral.EventoMenuGestOf;
import ofertasVistas.VistaGestionOffer;

public class VistaGeneral extends JPanel {

	private JMenu acciones;

	private JMenuBar barra;

	private JMenuItem gestOfertas;

	private JMenuItem gestClientes;

	// private EventosMenuGestOf evGestOf;

	private EventoMenuGestCl evGestClient;

	private JPanel laminaMenu;

	private VistaGestionOffer vistaOffers;

	private static VistaRegistroClient vistaRClientes;

	private static VistaGestionCliente vistaGestCl;

	private EventoMenuGestOf evGestOf;

	public VistaGeneral() {

		setLayout(new BorderLayout(8, 8));

		laminaMenu = new JPanel();

		barra = new JMenuBar();

		acciones = new JMenu("Acciones");

		gestOfertas = new JMenuItem("Gestionar Ofertas");

		gestClientes = new JMenuItem("Gestionar Clientes");

		vistaOffers = new VistaGestionOffer();
		vistaOffers.setVisible(false);

		vistaRClientes = new VistaRegistroClient();
		vistaRClientes.setVisible(false);

		vistaGestCl = new VistaGestionCliente();
		vistaGestCl.setVisible(false);
		// vistaGestCl.setSize(0, 0);

		evGestClient = new EventoMenuGestCl(vistaOffers, vistaGestCl, vistaRClientes);
		gestClientes.addActionListener(evGestClient);

		evGestOf = new EventoMenuGestOf(vistaRClientes, vistaGestCl, vistaOffers);
		gestOfertas.addActionListener(evGestOf);

		acciones.add(gestOfertas);
		acciones.add(gestClientes);

		barra.add(acciones);

		laminaMenu.add(barra);

		add(laminaMenu, BorderLayout.WEST);

		add(vistaOffers, BorderLayout.CENTER);
		add(vistaRClientes, BorderLayout.CENTER);
		add(vistaGestCl, BorderLayout.CENTER);

	}

	public static VistaGestionCliente getVistaGestCl() {
		return vistaGestCl;
	}

	public static VistaRegistroClient getVistaRegCl() {
		return vistaRClientes;
	}
}
