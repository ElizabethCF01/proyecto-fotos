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

public class EEliminarOferta implements ActionListener {

	private JTextField cajaCodigoOf;

	private JTextArea areaT;

	private ControlOffers controlOf;

	private ConexionBD conecta;

	private Statement s;

	public EEliminarOferta(JTextField cajaCodigoOf, JTextArea areaT) {

		this.cajaCodigoOf = cajaCodigoOf;
		this.areaT = areaT;

		controlOf = new ControlOffers();
		conecta = new ConexionBD();
		s = conecta.getState();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		int codigo = Integer.parseInt(cajaCodigoOf.getText());

		controlOf.EliminarOffer(codigo);

		/*
		 * 
		 * 
		 * for (int i = 0; i < controlOf.getOffers().size(); i++) {
		 * 
		 * areaT.setText(areaT.getText() + "Oferta " + (i + 1) + " :" +
		 * controlOf.getOffers().get(i).getNombre() + "  Precio: " +
		 * controlOf.getOffers().get(i).getPrecio() + " USD" + System.lineSeparator());
		 * 
		 * }
		 */
		areaT.setText("");
		try {
			ResultSet r = s.executeQuery("SELECT DISTINCTROW NombreOferta, Precio, CodigoOf FROM ofertas ");
			while (r.next()) {

				areaT.setText(areaT.getText() + r.getString("CodigoOf") + " " + r.getString("NombreOferta") + " "
						+ r.getFloat("Precio") + " USD" + System.lineSeparator());
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
