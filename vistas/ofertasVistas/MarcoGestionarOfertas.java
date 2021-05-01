package ofertasVistas;

import javax.swing.*;

public class MarcoGestionarOfertas extends JFrame{

	public static void main(String[] args) {

		MarcoGestionarOfertas m= new MarcoGestionarOfertas();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	private JPanel vistaOffers;
	
	public MarcoGestionarOfertas() {
		setVisible(true);
		setTitle("Photograph");
		setBounds(400,200,650,400);
		
		
		vistaOffers= new VistaAddOferta();
		add(vistaOffers);
	}
}
