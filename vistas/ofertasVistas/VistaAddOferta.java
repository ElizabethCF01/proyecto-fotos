package ofertasVistas;

import java.awt.BorderLayout;

import javax.swing.*;

import controladorOfertas.ControlOffers;
import eventosOfertas.EAnnadirOffer;


public class VistaAddOferta extends JPanel {
	
	private JLabel Nombre,Precio;
    private JTextField nomb,pre;
	private JButton Annadir;
	private JTextArea muestra;
	private EAnnadirOffer ev;
	private JPanel panelSup,panelInf;
	private ControlOffers controlOff;

	
	public VistaAddOferta() {
		
		controlOff= new ControlOffers();
		
		setLayout(new BorderLayout(8,8));
		
		panelSup= new JPanel();
		panelInf= new JPanel();
		
		
		Nombre= new JLabel("Nombre de la oferta");
		Precio= new JLabel("Precio");
		
		nomb= new JTextField(20);
		pre= new JTextField(10);
		
		
		muestra= new JTextArea(10,20); 
		muestra.setEditable(false);
		muestra.setLineWrap(true);
		
		for(int i=0;i<3;i++) {
			
		 muestra.setText(muestra.getText()+"Oferta "+(i+1)+" "+controlOff.getOffers().get(i).getNombre()
				         + "   Precio: "+controlOff.getOffers().get(i).getPrecio()+ System.lineSeparator());

			}
		
		Annadir= new JButton("Añadir");
		
		
		ev= new EAnnadirOffer(nomb,pre,muestra);
		Annadir.addActionListener(ev);
		
		panelSup.add(Nombre);
		panelSup.add(nomb);
		panelSup.add(Precio);
		panelSup.add(pre);
		
		panelInf.add(Annadir);
		
		panelInf.add(muestra);
		
		add(panelSup,BorderLayout.NORTH);
		add(panelInf,BorderLayout.CENTER);
		
	}
	
	
		
	}

