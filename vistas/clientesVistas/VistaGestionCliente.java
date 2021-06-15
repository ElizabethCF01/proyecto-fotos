package clientesVistas;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import conexion.ConexionBD;
import eventosClientes.AgregarNuClient;
import eventosClientes.EvCajaVisible;
import eventosClientes.EvVolver;

public class VistaGestionCliente extends JPanel {

	private JLabel nombreYapell, edad, telef, acomp;

	private JTextField cajaNombreA, cajaEdad, cajaTelef;

	private JCheckBox verifAcomp;

	private JTextArea areaOf;

	// private ControlOffers co;

	// private ArrayList<Oferta> ofertas;

	private ArrayList<JLabel> etiquetasOf;

	private ArrayList<JCheckBox> casillasOf;

	private ArrayList<JTextField> cajasCantOf;

	private EvCajaVisible verCaja;

	private JPanel panelSup, panelCent, panelInf;

	private JButton agregarCl, volverARegistro;

	private AgregarNuClient evAgr;

	private EvVolver evVolver;

	private Statement s;

	private ConexionBD conex;

	public VistaGestionCliente() {

		setLayout(new BorderLayout());

		// co = new ControlOffers();
		// ofertas = co.getOffers();
		etiquetasOf = new ArrayList<JLabel>();
		casillasOf = new ArrayList<JCheckBox>();
		cajasCantOf = new ArrayList<JTextField>();

		nombreYapell = new JLabel("Nobre y Apellidos:");
		edad = new JLabel("Edad:");
		telef = new JLabel("Tel�fono:");
		acomp = new JLabel("Acompa�ante:");

		cajaNombreA = new JTextField(20);

		cajaEdad = new JTextField(4);

		cajaTelef = new JTextField(10);

		verifAcomp = new JCheckBox();

		agregarCl = new JButton("Agregar");

		volverARegistro = new JButton("Volver");
		evVolver = new EvVolver(this);
		volverARegistro.addActionListener(evVolver);

		areaOf = new JTextArea();
		areaOf.setEditable(false);

		panelSup = new JPanel();
		panelCent = new JPanel();
		panelInf = new JPanel();

		conex = new ConexionBD();
		s = conex.getState();

		panelSup.add(nombreYapell);
		panelSup.add(cajaNombreA);

		panelSup.add(edad);
		panelSup.add(cajaEdad);

		panelSup.add(telef);
		panelSup.add(cajaTelef);

		panelSup.add(acomp);
		panelSup.add(verifAcomp);

		panelSup.add(areaOf);

		// this.AddCheckOffer(ofertas, panelCent);

		evAgr = new AgregarNuClient(this, cajaNombreA, cajaEdad, cajaTelef, verifAcomp, casillasOf, cajasCantOf);
		agregarCl.addActionListener(evAgr);

		panelInf.add(agregarCl);
		panelInf.add(volverARegistro);

		add(panelSup, BorderLayout.NORTH);
		add(panelCent, BorderLayout.CENTER);
		add(panelInf, BorderLayout.SOUTH);

	}

	public void AddCheckOffer(/* ArrayList<Oferta> o, */ JPanel p) {

		Box cajaVertical = Box.createVerticalBox();

		// String nameOffer = "Oferta: " + o.get(i).getNombre() + " Precio: " +
		// o.get(i).getPrecio();

		try {

			ResultSet r = s.executeQuery("SELECT COUNT(*) AS NumOf FROM ofertas WHERE CodigoOF IS NOT NULL ");

			int n = 0;
			if (r.next()) {
				n = r.getInt(1);
			}

			r = s.executeQuery("SELECT NombreOferta FROM ofertas ORDER BY (CodigoOf) ");

			for (int i = 0; i < n; i++) {

				Box cajaHorizontal = Box.createHorizontalBox();

				String nameOffer = "";

				if (r.next()) {

					nameOffer = r.getString(1);

				}

				etiquetasOf.add(new JLabel(nameOffer));
				casillasOf.add(new JCheckBox());
				cajasCantOf.add(new JTextField(3));

				cajasCantOf.get(i).setVisible(false);

				verCaja = new EvCajaVisible(casillasOf.get(i), cajasCantOf.get(i), this);
				casillasOf.get(i).addActionListener(verCaja);

				cajaHorizontal.add(etiquetasOf.get(i));
				cajaHorizontal.add(casillasOf.get(i));
				cajaHorizontal.add(cajasCantOf.get(i));

				cajaVertical.add(cajaHorizontal);

			}

		} catch (SQLException ev) {

			ev.printStackTrace();
		}

		p.add(cajaVertical);
	}

	public void removeCheckOffers(JPanel p) {

		etiquetasOf.removeAll(etiquetasOf);
		casillasOf.removeAll(casillasOf);
		cajasCantOf.removeAll(cajasCantOf);

		p.removeAll();

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

	public ArrayList<JCheckBox> getCasillasOf() {
		return casillasOf;
	}

	public ArrayList<JTextField> getCajasCantOf() {
		return cajasCantOf;

	}

	public JButton getBotAgregar() {
		return agregarCl;
	}
}
