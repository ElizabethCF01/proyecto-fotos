package controladorOfertas;

import java.util.ArrayList;

import ofertas.Oferta;

public class ControlOffers {

	
	 
	ArrayList <Oferta> ofertas;
	
	public ControlOffers() {
		
		ofertas= new ArrayList<Oferta>();
		
		ofertas.add(new Oferta("Fotos 5x8 ", 10));
		ofertas.add(new Oferta("Fotos 10x12 ", 20));
		ofertas.add(new Oferta("Fotos 15x20 ", 30));
	}
	
	public ArrayList<Oferta> getOffers(){
		return ofertas;
	}
	
}
