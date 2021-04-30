package eventosOfertas;

import java.awt.event.*;

import javax.swing.*;


import controladorOfertas.ControlOffers;
import ofertas.Oferta;


public class EAnnadirOffer implements ActionListener {
	
	private JTextField CajaTextN,CajaTextP;
	private JTextArea area;
	private String name;
	private int cost;
	private ControlOffers c;
	
	public EAnnadirOffer(JTextField n,JTextField p, JTextArea a) {
		
		CajaTextN=n;
		CajaTextP=p;
		area=a;
		
		c=new ControlOffers();
	}

	  
	  public void actionPerformed(ActionEvent evento) {
		
		  name= CajaTextN.getText();
		  cost=Integer.parseInt(CajaTextP.getText());
		  
		  c.getOffers().add(new Oferta(name,cost));
		  
		  area.setText("");
		  
		 for(int i=0;i<c.getOffers().size();i++) {
			 
		  
		  area.setText(area.getText()+"Oferta "+(i+1)+" :"+c.getOffers().get(i).getNombre()
			        + "   Precio: "+c.getOffers().get(i).getPrecio()+ System.lineSeparator());

		  

		 }
		
	  }
		
	}

	
	


