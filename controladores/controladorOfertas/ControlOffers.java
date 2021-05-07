package controladorOfertas;

import java.util.ArrayList;

import javax.swing.JPanel;

import ofertas.Oferta;
import ofertasVistas.VistaGestionOffer;

public class ControlOffers {

	private static ArrayList<Oferta> ofertas;

	public ControlOffers() {

		ofertas = new ArrayList<Oferta>();

		ofertas.add(new Oferta("Fotos 5x8 ", 10));
		ofertas.add(new Oferta("Fotos 10x12 ", 20));
		ofertas.add(new Oferta("Fotos 15x20 ", 30));

	}

	public ArrayList<Oferta> getOffers() {
		return ofertas;
	}

	public void ActualizarOffer(String nombreOff, int numeroOff, float precio) {
		ofertas.set(numeroOff - 1, new Oferta(nombreOff, precio));
	}

	public void EliminarOffer(int n) {
		ofertas.remove(ofertas.get(n - 1));
	}

	public void setAVistaOffers(JPanel p, VistaGestionOffer v) {
		p.removeAll();
		p.add(v);
		p.updateUI();

	}
}
