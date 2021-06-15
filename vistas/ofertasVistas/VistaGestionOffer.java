package ofertasVistas;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import conexion.ConexionBD;
import controladorOfertas.ControlOffers;
import eventosOfertas.EActualizarOffer;
import eventosOfertas.EAnnadirOffer;
import eventosOfertas.EEliminarOferta;

public class VistaGestionOffer extends JPanel {

	private JLabel nombre, precio, codOffer;

	private JTextField cajaTNomb, cajaTPre, cajaCodOffer;

	private JButton annadir, eliminar, actualizar;

	private JTextArea muestra;

	private EAnnadirOffer evAnnadirOffer;

	private EEliminarOferta evEliminarOffer;

	private EActualizarOffer evActualizarOffer;

	private JPanel panelSup, panelCentral;

	private ControlOffers controlOff;

	private ConexionBD conex;

	private Statement s;

	public VistaGestionOffer() {

		controlOff = new ControlOffers();
		conex = new ConexionBD();
		s = conex.getState();

		setLayout(new BorderLayout(8, 8));

		panelSup = new JPanel();
		panelCentral = new JPanel();

		nombre = new JLabel("Nombre de la oferta");
		precio = new JLabel("Precio");
		codOffer = new JLabel("Código oferta");

		cajaTNomb = new JTextField(20);
		cajaTPre = new JTextField(10);
		cajaCodOffer = new JTextField(6);

		muestra = new JTextArea(10, 20);
		muestra.setEditable(false);
		muestra.setLineWrap(true);

		/*
		 * for (int i = 0; i < 3; i++) {
		 * 
		 * muestra.setText(muestra.getText() + "Oferta " + (i + 1) + ": " +
		 * controlOff.getOffers().get(i).getNombre() + "  Precio: " +
		 * controlOff.getOffers().get(i).getPrecio() + " USD" + System.lineSeparator());
		 * 
		 * }
		 */
		try {
			ResultSet r = s.executeQuery("SELECT  CodigoOf, NombreOferta, Precio FROM ofertas ");
			while (r.next()) {

				muestra.setText(muestra.getText() + r.getString("CodigoOf") + " " + r.getString("NombreOferta") + " "
						+ r.getFloat("Precio") + " USD" + System.lineSeparator());

				cajaCodOffer.setText(r.getString("CodigoOf"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		annadir = new JButton("Añadir");

		evAnnadirOffer = new EAnnadirOffer(cajaTNomb, cajaTPre, cajaCodOffer, muestra);
		annadir.addActionListener(evAnnadirOffer);

		eliminar = new JButton("Eliminar");

		evEliminarOffer = new EEliminarOferta(cajaCodOffer, muestra);
		eliminar.addActionListener(evEliminarOffer);

		actualizar = new JButton("Actualizar");

		evActualizarOffer = new EActualizarOffer(cajaTNomb, cajaTPre, cajaCodOffer, muestra);
		actualizar.addActionListener(evActualizarOffer);

		panelSup.add(nombre);
		panelSup.add(cajaTNomb);
		panelSup.add(precio);
		panelSup.add(cajaTPre);
		panelSup.add(codOffer);
		panelSup.add(cajaCodOffer);

		panelCentral.add(annadir);
		panelCentral.add(muestra);
		panelCentral.add(eliminar);
		panelCentral.add(actualizar);

		add(panelSup, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
	}
}
