package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
import conexion.ConexionBD;
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

	private ConexionBD conex;

	private Statement s;

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

		conex = new ConexionBD();
		s = conex.getState();

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

		// **************************************************************************

		boolean annadido = false;

		try {

			ResultSet r = s.executeQuery("SELECT COUNT(*) AS NumOf FROM ofertas WHERE CodigoOF IS NOT NULL ");

			int n = 0;
			if (r.next()) {
				n = r.getInt(1);
			}

			for (int i = 0; i < n; i++) {

				if (casillasOf.get(i).isSelected()) {

					cantOf = Integer.parseInt(cajasCant.get(i).getText());

					r = s.executeQuery("SELECT MAX(ID) FROM ofertas_clientes");

					int ID = 0;
					if (r.next()) {
						ID = r.getInt(1) + 1;
					}

					r = s.executeQuery("SELECT MAX(IdCli) FROM clientes");

					int IDCli = 0;

					if (r.next()) {
						IDCli = r.getInt(1) + 10;
					}

					if (annadido == false) {
						controlClient.AnnadirCliente(IDCli, name, edad, telef, acomp);
						annadido = true;
					}

					s.executeUpdate("INSERT INTO ofertas_clientes VALUES(" + ID + "," + IDCli + "," + (i + 1) + ","
							+ cantOf + ")");

					// Offer = controlOfert.getOffers().get(i);

					// mapaAux.put(Offer, cantOf);
				}

			}

			ResultSet r1 = s.executeQuery("SELECT * FROM clientes ");

			area.setText("");
			while (r1.next()) {

				// System.out.println(r.getString(1) + " " +
				// r1.getString(2) + " " + r1.getFloat(3)+ " " + r1.getFloat(4));

				area.setText(area.getText() + r1.getString(1) + " " + r1.getString(2) + System.lineSeparator());
			}

		} catch (SQLException ev) {

			ev.printStackTrace();
		}

		/*
		 * for (int i = 0; i < controlOfert.getOffers().size(); i++) {
		 * 
		 * if (casillasOf.get(i).isSelected()) {
		 * 
		 * cantOf = Integer.parseInt(cajasCant.get(i).getText()); Offer =
		 * controlOfert.getOffers().get(i);
		 * 
		 * mapaAux.put(Offer, cantOf); }
		 * 
		 * } controlClient.getClientes().add(new Cliente(name, acomp, edad, telef));
		 * 
		 * int n = controlClient.getClientes().size() - 1;
		 * 
		 * controlClient.getClientes().get(n).getTiposOfertasCant().putAll(mapaAux);
		 * 
		 */

		// System.out.println(controlClient.getClientes().size());

		/*
		 * area.setText("");
		 * 
		 * for (int i = 0; i < controlClient.getClientes().size(); i++) {
		 * 
		 * area.setText(area.getText() + (i + 1) + "  " +
		 * controlClient.getClientes().get(i).getNombre() + System.lineSeparator()); }
		 */
	}

}
