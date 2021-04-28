package ofertasVistas;

import javax.swing.*;

public class MarcoGestionarOfertas extends JFrame{
	
	
public MarcoGestionarOfertas() {
	setVisible(true);
	setTitle("Photograph");
	setBounds(400,200,650,400);
	
	LaminaDeMarcoGO l= new LaminaDeMarcoGO();
	add(l);
}
}
