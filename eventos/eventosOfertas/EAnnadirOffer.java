package eventosOfertas;

import java.awt.event.*;

import javax.swing.*;

import controladorOfertas.ControlOffers;
import ofertas.Oferta;

public class EAnnadirOffer implements ActionListener  {
	
	private JTextField cajaTextN,cajaTextP,cajaNoOf;
	
	private JTextArea area;
	
	private String name;
	
	private float cost;
	
	private ControlOffers c;
	
	private int numeroOffer;
	
public EAnnadirOffer(JTextField n,JTextField p,JTextField no, JTextArea a) {
		
		cajaTextN=n;
		cajaTextP=p;
		cajaNoOf=no;
		area=a;
		
		c=new ControlOffers();
	}

   public void actionPerformed(ActionEvent evento) {
	
	  name= cajaTextN.getText();
	  cost=Float.parseFloat(cajaTextP.getText());
	  numeroOffer= c.getOffers().size()+1; 
	  
	  cajaNoOf.setText(""+numeroOffer);
	  
	  c.getOffers().add(new Oferta(name,cost));
	  
	  area.setText("");
	  
	  for(int i=0;i<c.getOffers().size();i++) {
		 
	  
	  area.setText(area.getText()+"Oferta "+(i+1)+" :"+c.getOffers().get(i).getNombre()
		        + "  Precio: "+c.getOffers().get(i).getPrecio()+" USD" + System.lineSeparator());

	 

	  }
	  
  }
}
