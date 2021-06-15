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

public class EActualizarOffer implements ActionListener {

	private JTextField cajaNameOffer, cajaCostOffer, cajaCodOffer;

	private JTextArea areaTexto;

	private float costo;

	private String nombre;

	private int codOferta;

	private ControlOffers cOffers;

	private ConexionBD conexion;

	private Statement s;

	public EActualizarOffer(JTextField cajaNameOffer, JTextField cajaCostOffer, JTextField cajaCodOffer, JTextArea a) {

		this.cajaNameOffer = cajaNameOffer;
		this.cajaCostOffer = cajaCostOffer;
		this.cajaCodOffer = cajaCodOffer;
		areaTexto = a;

		cOffers = new ControlOffers();
		conexion = new ConexionBD();
		s = conexion.getState();
	}

	public void actionPerformed(ActionEvent e) {

		nombre = cajaNameOffer.getText();
		costo = Float.parseFloat(cajaCostOffer.getText());
		codOferta = Integer.parseInt(cajaCodOffer.getText());

		cOffers.ActualizarOffer(codOferta, nombre, costo);

		areaTexto.setText("");

		/*
		 * for (int i = 0; i < cOffers.getOffers().size(); i++) {
		 * 
		 * areaTexto.setText(areaTexto.getText() + "Oferta " + (i + 1) + " :" +
		 * cOffers.getOffers().get(i).getNombre() + "  Precio: " +
		 * cOffers.getOffers().get(i).getPrecio() + " USD" + System.lineSeparator());
		 * 
		 * }
		 */
		try {
			ResultSet r = s.executeQuery("SELECT CodigoOf, NombreOferta, Precio FROM ofertas ");
			while (r.next()) {

				areaTexto.setText(areaTexto.getText() + r.getString("CodigoOf") + " " + r.getString("NombreOferta")
						+ " " + r.getFloat("Precio") + " USD" + System.lineSeparator());
			}
		} catch (SQLException ev) {

			ev.printStackTrace();
		}

	}
}
