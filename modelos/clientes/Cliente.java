package clientes;

import java.util.ArrayList;
import java.util.HashMap;

import controladorOfertas.ControlOffers;
import ofertas.Oferta;

public class Cliente {

	private String nombreApellidos;

	private boolean acompannante;

	private int edad;

	private int telef;

	private ArrayList<Oferta> tiposOffers;

	private HashMap<String, Integer> tiposOfferCant;

	private ControlOffers controlOf;

	public Cliente(String name, boolean acomp, int ed, int tel) {

		nombreApellidos = name;
		acompannante = acomp;
		edad = ed;
		telef = tel;
		tiposOffers = new ArrayList<Oferta>();
		tiposOfferCant = new HashMap<String, Integer>();

	}

	public String getNombre() {
		return nombreApellidos;
	}

	public boolean getAcompannante() {
		return acompannante;
	}

	public int getEdad() {
		return edad;
	}

	public int getTelefono() {
		return telef;
	}

	public ArrayList<Oferta> getTiposOffers() {
		return tiposOffers;
	}

	public HashMap<String, Integer> getTiposOfertasCant() {
		return tiposOfferCant;
	}

	public void setNombre(String name) {
		nombreApellidos = name;
	}

	public void setAcompannante(boolean acomp) {
		acompannante = acomp;
	}

	public void setEdad(int ed) {
		edad = ed;
	}

	public void setTelef(int tel) {
		telef = tel;
	}

}
