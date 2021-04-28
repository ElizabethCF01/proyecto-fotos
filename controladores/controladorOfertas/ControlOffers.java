package controladorOfertas;

import javax.swing.JFrame;

import ofertas.Oferta;
import ofertasVistas.LaminaDeMarcoGO;
import ofertasVistas.MarcoGestionarOfertas;

public class ControlOffers {

	public static void main(String[] args) {
		
		MarcoGestionarOfertas m= new MarcoGestionarOfertas();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
          
	}
	public Oferta[] ofertas= {
			
			new Oferta("Offer ", 10), 
			new Oferta("Offer ", 10),
			new Oferta("Offer", 10)
	  };
}
