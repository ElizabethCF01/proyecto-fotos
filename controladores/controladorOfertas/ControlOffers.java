package controladorOfertas;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;

import conexion.ConexionBD;
import ofertas.Oferta;
import ofertasVistas.VistaGestionOffer;

public class ControlOffers {

	private static ArrayList<Oferta> ofertas;

	// private Connection conexion;

	private Statement state;

	// private ResultSet resultado;

	private ConexionBD conexion;

	private Oferta offer;

	public ControlOffers() {

		offer = new Oferta(0, "", 0);

		// ofertas = new ArrayList<Oferta>();

		/*
		 * ofertas.add(new Oferta("Fotos 5x8 ", 10)); ofertas.add(new
		 * Oferta("Fotos 10x12 ", 20)); ofertas.add(new Oferta("Fotos 15x20 ", 30));
		 */

		conexion = new ConexionBD();

		state = conexion.getState();

	}

	/*
	 * public ArrayList<Oferta> getOffers() { return ofertas; }
	 */

	/*
	 * public Statement getStateOfertas() {
	 * 
	 * return state; }
	 */

	public void ActualizarOffer(int CodOffer, String nombreOff, float precio) {
		// ofertas.set(numeroOff - 1, new Oferta(nombreOff, precio));
		offer.setNombre(nombreOff);
		offer.setPrecio(precio);

		try {

			state.executeUpdate("UPDATE ofertas SET NombreOferta='" + nombreOff + "' , Precio=" + precio
					+ "WHERE CodigoOf=" + CodOffer);

			offer.setNombre(nombreOff);
			offer.setPrecio(precio);

		} catch (SQLException e) {

			System.out.print("No funciona");
			e.printStackTrace();
		}

	}

	public void EliminarOffer(int CodigoOf) {
		// ofertas.remove(ofertas.get(n - 1));

		try {

			state.executeUpdate("DELETE FROM ofertas WHERE CodigoOf=" + CodigoOf);

		} catch (SQLException e) {

			System.out.print("No funciona");
			e.printStackTrace();
		}

	}

	public void AddOferta(int CodOferta, String NombreOferta, float precio) {

		// ofertas.add(new Oferta(NombreOferta, precio));
		Oferta ofertaNueva = new Oferta(CodOferta, NombreOferta, precio);

		int cod = ofertaNueva.getCodigo();
		String name = ofertaNueva.getNombre();
		float cost = ofertaNueva.getPrecio();

		try {

			state.executeUpdate("INSERT INTO ofertas VALUES(" + cod + ",'" + name + "'," + cost + ")");

		} catch (SQLException e) {

			System.out.print("No funciona");
			e.printStackTrace();
		}

	}

	public void setAVistaOffers(JPanel panelCamb1, JPanel panelCamb2, VistaGestionOffer panelAgr) {

		panelCamb1.setVisible(false);
		panelCamb1.setSize(0, 0);

		panelCamb2.setVisible(false);
		panelCamb2.setSize(0, 0);

		panelAgr.setVisible(true);
		panelAgr.setSize(850, 400);

	}

}
