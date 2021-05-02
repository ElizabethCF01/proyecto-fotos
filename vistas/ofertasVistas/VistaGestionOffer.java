package ofertasVistas;

import java.awt.BorderLayout;

import javax.swing.*;

import controladorOfertas.ControlOffers;

import eventosOfertas.*;

public class VistaGestionOffer extends JPanel {
	
	private JLabel nombre,precio,numOffer;
	
    private JTextField cajaTNomb,cajaTPre, cajaNumOffer;
    
	private JButton annadir,eliminar,actualizar;
	
	private JTextArea muestra;
	
	private EAnnadirOffer evAnnadirOffer;
	
	private EEliminarOferta evEliminarOffer;
	
	private EActualizarOffer evActualizarOffer;
	
	private JPanel panelSup,panelCentral;
	
	private ControlOffers controlOff;
	
    public VistaGestionOffer() {
		
		controlOff= new ControlOffers();
		
		setLayout(new BorderLayout(8,8));
		
		panelSup= new JPanel();
		panelCentral= new JPanel();
		
		
		nombre= new JLabel("Nombre de la oferta");
		precio= new JLabel("Precio");
		numOffer= new JLabel("No. Oferta");
		
		cajaTNomb= new JTextField(20);
		cajaTPre= new JTextField(10);
		cajaNumOffer= new JTextField("3",5);
		
		
		muestra= new JTextArea(10,20); 
		muestra.setEditable(false);
		muestra.setLineWrap(true);
		
		for(int i=0;i<3;i++) {
			
		 muestra.setText(muestra.getText()+"Oferta "+(i+1)+": "+controlOff.getOffers().get(i).getNombre()
				     + "  Precio: "+controlOff.getOffers().get(i).getPrecio()+" USD" + System.lineSeparator());

			}
		
		annadir= new JButton("Añadir");
		
		evAnnadirOffer= new EAnnadirOffer(cajaTNomb,cajaTPre,cajaNumOffer,muestra);
		annadir.addActionListener(evAnnadirOffer);
		
		eliminar= new JButton("Eliminar");
		
		evEliminarOffer = new  EEliminarOferta(cajaNumOffer,muestra);
		eliminar.addActionListener(evEliminarOffer);
		
		actualizar= new JButton("Actualizar"); 
		
		evActualizarOffer= new EActualizarOffer(cajaTNomb,cajaTPre,cajaNumOffer,muestra);
		actualizar.addActionListener(evActualizarOffer);
		
		
		panelSup.add(nombre);
		panelSup.add(cajaTNomb);
		panelSup.add(precio);
		panelSup.add(cajaTPre);
		panelSup.add(numOffer);
		panelSup.add(cajaNumOffer);
		
		panelCentral.add(annadir);
		panelCentral.add(muestra);
		panelCentral.add(eliminar);
		panelCentral.add(actualizar);
		
		add(panelSup,BorderLayout.NORTH);
		add(panelCentral,BorderLayout.CENTER);
		}
}
