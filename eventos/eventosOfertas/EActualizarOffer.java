package eventosOfertas;

import java.awt.event.*;

import javax.swing.*;

import controladorOfertas.ControlOffers;

public class EActualizarOffer implements ActionListener{
	
    private JTextField cajaNameOffer,cajaCostOffer,cajaNumberOffer;
	
	private JTextArea areaTexto;
	
	private float costo;
	
	private String nombre;
	
	private int numOferta;
	
	private ControlOffers cOffers;
	
	public EActualizarOffer(JTextField n, JTextField c,JTextField nu, JTextArea a) {
		
		cajaNameOffer=n;
		cajaCostOffer=c;
		cajaNumberOffer=nu;
		areaTexto=a;
		
		cOffers= new ControlOffers();
	}
	public void actionPerformed(ActionEvent e) {
		
		nombre= cajaNameOffer.getText();
		costo=Float.parseFloat(cajaCostOffer.getText());
		numOferta= Integer.parseInt(cajaNumberOffer.getText());
		
		cOffers.ActualizarOffer(nombre, numOferta, costo);
		
		areaTexto.setText("");
	  
	  for(int i=0;i<cOffers.getOffers().size();i++) {
		 
	  
	  areaTexto.setText(areaTexto.getText()+"Oferta "+(i+1)+" :"+cOffers.getOffers().get(i).getNombre()
		        + "  Precio: "+cOffers.getOffers().get(i).getPrecio()+" USD" + System.lineSeparator());

		
		
	 }

   }
}
