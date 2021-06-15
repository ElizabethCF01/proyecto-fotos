package eventosOfertas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import conexion.ConexionBD;
import controladorOfertas.ControlOffers;

public class EAnnadirOffer implements ActionListener {

	private JTextField cajaTextN, cajaTextP, cajaCodOf;

	private JTextArea area;

	private String name;

	private float cost;

	private int cod;

	private ControlOffers c;

	private ConexionBD conex;

	private Statement s;

	// private int numeroOffer;

	public EAnnadirOffer(JTextField cajaTextN, JTextField cajaTextP, JTextField cajaCodOf, JTextArea a) {

		this.cajaTextN = cajaTextN;
		this.cajaTextP = cajaTextP;
		this.cajaCodOf = cajaCodOf;
		area = a;

		conex = new ConexionBD();
		c = new ControlOffers();
		s = conex.getState();

	}

	public void actionPerformed(ActionEvent evento) {

		name = cajaTextN.getText();
		cost = Float.parseFloat(cajaTextP.getText());
		cod = Integer.parseInt(cajaCodOf.getText());

		// numeroOffer = c.getOffers().size() + 1;

		// cajaNoOf.setText("" + numeroOffer);

		// c.getOffers().add(new Oferta(name, cost));

		c.AddOferta(cod, name, cost);

		area.setText("");

		/*
		 * for (int i = 0; i < c.getOffers().size(); i++) {
		 * 
		 * area.setText(area.getText() + "Oferta " + (i + 1) + " :" +
		 * c.getOffers().get(i).getNombre() + "  Precio: " +
		 * c.getOffers().get(i).getPrecio() + " USD" + System.lineSeparator());
		 * 
		 * }
		 */
		try {
			ResultSet r = s.executeQuery("SELECT CodigoOf, NombreOferta, Precio  FROM ofertas ");
			while (r.next()) {

				// System.out.println(r.getString("CodigoOf") + " " +
				// r.getString("NombreOferta") + " " + r.getFloat("Precio"));
				area.setText(area.getText() + r.getInt("CodigoOf") + " " + r.getString("NombreOferta") + " "
						+ r.getFloat("Precio") + " USD" + System.lineSeparator());
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
