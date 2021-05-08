package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientes.Cliente;
import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
import controlClientes.ControlClient;
import controladorOfertas.ControlOffers;
import ofertas.Oferta;
import vistasGenerales.VistaGeneral;

public class AgregarNuClient implements ActionListener {

	private JTextField cajaNomb, cajaEdad, cajaTel;

	private JCheckBox casillaAcomp;

	private String name;

	private int edad, telef;

	private boolean acomp;

	private Oferta Offer;

	private int cantOf;

	private ControlOffers controlOfert;

	private ControlClient controlClient;

	private ArrayList<JCheckBox> casillasOf;

	private ArrayList<JTextField> cajasCant;

	private HashMap<Oferta, Integer> mapaAux;

	private VistaGestionCliente vistaGest;

	private VistaRegistroClient vistaReg;

	private JTextArea area;

	// private JPanel p;

	// private VistaRegistroClient v;

	public AgregarNuClient(VistaGestionCliente vistaGest, JTextField cajaNomb, JTextField cajaEdad, JTextField cajaTel,
			JCheckBox casillaAcomp, ArrayList<JCheckBox> casillasOf, ArrayList<JTextField> cajasCant) {

		this.vistaGest = vistaGest;
		this.cajaNomb = cajaNomb;
		this.cajaEdad = cajaEdad;
		this.cajaTel = cajaTel;
		this.casillaAcomp = casillaAcomp;
		this.casillasOf = casillasOf;
		this.cajasCant = cajasCant;

		controlOfert = new ControlOffers();
		controlClient = new ControlClient();

		mapaAux = new HashMap<Oferta, Integer>();

		// this.p=p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vistaReg = VistaGeneral.getVistaRegCl();

		controlClient.setVistaCl(vistaGest, vistaReg);
		// v.getPanelAux());
		area = vistaReg.getAreaTexto();

		name = cajaNomb.getText();
		edad = Integer.parseInt(cajaEdad.getText());
		telef = Integer.parseInt(cajaTel.getText());

		if (casillaAcomp.isSelected()) {
			acomp = true;
		} else {
			acomp = false;
		}

		for (int i = 0; i < controlOfert.getOffers().size(); i++) {

			if (casillasOf.get(i).isSelected()) {

				cantOf = Integer.parseInt(cajasCant.get(i).getText());
				Offer = controlOfert.getOffers().get(i);

				mapaAux.put(Offer, cantOf);
			}

		}
		controlClient.getClientes().add(new Cliente(name, acomp, edad, telef));

		int n = controlClient.getClientes().size() - 1;

		controlClient.getClientes().get(n).getTiposOfertasCant().putAll(mapaAux);
		// System.out.println(controlClient.getClientes().size());

		area.setText("");

		for (int i = 0; i < controlClient.getClientes().size(); i++) {

			area.setText(area.getText() + (i + 1) + "  " + controlClient.getClientes().get(i).getNombre()
					+ System.lineSeparator());
		}
	}

}
