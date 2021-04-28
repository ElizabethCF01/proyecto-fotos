package eventosOfertas;

import java.awt.event.*;

import javax.swing.*;


import controladorOfertas.ControlOffers;


public class EAñadirOferta implements ActionListener {
	
	private JTextField CajaTextN,CajaTextP;
	private JTextArea area;
	private static int cont;
	private String name;
	private int cost;
	
	public EAñadirOferta(JTextField n,JTextField p, JTextArea a) {
		CajaTextN=n;
		CajaTextP=p;
		area=a;
		cont=0;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		ControlOffers c= new ControlOffers();
		
		name= CajaTextN.getText();
		cost=Integer.parseInt(CajaTextP.getText());
		
		
		c.ofertas[cont].setNombre(name);
		c.ofertas[cont].setPrecio(cost);
		
		area.setText(area.getText()+"Oferta "+(cont+1)+": "
		+c.ofertas[cont].getNombre()+"     Precio:"+
		c.ofertas[cont].getPrecio()+" MN"+System.lineSeparator());
		
		cont++;
		
		
		}
		
	}

	
	


