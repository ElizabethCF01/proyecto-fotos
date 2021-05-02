package eventosOfertas;

import java.awt.event.*;

import javax.swing.*;

import controladorOfertas.ControlOffers;

public class EEliminarOferta implements ActionListener {
	
	private JTextField cajaNumeroOf;
	
	private JTextArea areaT;
	
	private ControlOffers controlOf;
	
	public EEliminarOferta(JTextField c,JTextArea a) {
		
		cajaNumeroOf=c;
		areaT=a;
		controlOf = new ControlOffers();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		int numOferta= Integer.parseInt(cajaNumeroOf.getText());
		
		controlOf.EliminarOffer(numOferta);
		
		areaT.setText("");
	  
	  for(int i=0;i<controlOf.getOffers().size();i++) {
		 
	  
	  areaT.setText(areaT.getText()+"Oferta "+(i+1)+" :"+controlOf.getOffers().get(i).getNombre()
		        + "  Precio: "+controlOf.getOffers().get(i).getPrecio()+" USD" + System.lineSeparator());

	  
     

	  }
   
		
	}

}
