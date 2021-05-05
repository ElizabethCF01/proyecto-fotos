package clientesVistas;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controladorOfertas.ControlOffers;
import eventosClientes.AgregarNuClient;
import eventosClientes.EvCajaVisible;
import ofertas.Oferta;

public class VistaGestionCliente extends JPanel {

	private JLabel nombreYapell, edad, telef, acomp;

	private JTextField cajaNombreA, cajaEdad, cajaTelef;

	private JCheckBox verifAcomp;

	private JTextArea areaOf;

	private ControlOffers co;

	private ArrayList<Oferta> ofertas;

	private ArrayList<JLabel> etiquetasOf;

	private ArrayList<JCheckBox> casillasOf;

	private ArrayList<JTextField> cajasCantOf;

	private EvCajaVisible verCaja;

	// private Map<Oferta,Integer> mapa;

	private JPanel panelSup, panelCent;

	private JButton agregarCl;

	private AgregarNuClient evAgr;

	public VistaGestionCliente() {

		setLayout(new BorderLayout());

		// mapa= new Map<Oferta,Integer>();
		co = new ControlOffers();
		ofertas = co.getOffers();
		etiquetasOf = new ArrayList<JLabel>();
		casillasOf = new ArrayList<JCheckBox>();
		cajasCantOf = new ArrayList<JTextField>();

		nombreYapell = new JLabel("Nobre y Apellidos:");
		edad = new JLabel("Edad:");
		telef = new JLabel("Teléfono:");
		acomp = new JLabel("Acompañante:");

		cajaNombreA = new JTextField(20);

		cajaEdad = new JTextField(4);

		cajaTelef = new JTextField(10);

		verifAcomp = new JCheckBox();

		agregarCl = new JButton("Agregar");

		areaOf = new JTextArea();
		areaOf.setEnabled(false);

		panelSup = new JPanel();
		panelCent = new JPanel();
		// panelCent.setVisible(false);

		panelSup.add(nombreYapell);
		panelSup.add(cajaNombreA);

		panelSup.add(edad);
		panelSup.add(cajaEdad);

		panelSup.add(telef);
		panelSup.add(cajaTelef);

		panelSup.add(acomp);
		panelSup.add(verifAcomp);

		panelSup.add(areaOf);

		this.AddCheckOffer(ofertas, panelCent);

		evAgr = new AgregarNuClient(cajaNombreA, cajaEdad, cajaTelef, verifAcomp, casillasOf, cajasCantOf);
		agregarCl.addActionListener(evAgr);

		panelCent.add(agregarCl);

		add(panelSup, BorderLayout.NORTH);
		add(panelCent, BorderLayout.CENTER);

	}

	public void AddCheckOffer(ArrayList<Oferta> o, JPanel p) {

		for (int i = 0; i < o.size(); i++) {

			String nameOffer = "Oferta: " + o.get(i).getNombre() + "   Precio: " + o.get(i).getPrecio();

			etiquetasOf.add(new JLabel(nameOffer));
			casillasOf.add(new JCheckBox());
			cajasCantOf.add(new JTextField(3));

			cajasCantOf.get(i).setVisible(false);

			verCaja = new EvCajaVisible(casillasOf.get(i), cajasCantOf.get(i), this);
			casillasOf.get(i).addActionListener(verCaja);

			p.add(etiquetasOf.get(i));
			p.add(casillasOf.get(i));
			p.add(cajasCantOf.get(i));

		}

	}

	public JTextField getCajaNombre() {
		return cajaNombreA;
	}

	public JTextField getCajaEdad() {
		return cajaEdad;
	}

	public JTextField getCajaTel() {
		return cajaTelef;
	}

	public JCheckBox getVerifAcomp() {
		return verifAcomp;
	}

	public JTextArea getAreaOf() {
		return areaOf;
	}

	public JPanel getPanelCent() {
		return panelCent;
	}
}
