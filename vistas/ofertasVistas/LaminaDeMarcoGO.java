package ofertasVistas;

import java.awt.BorderLayout;

import javax.swing.*;

import eventosOfertas.EAñadirOferta;

public class LaminaDeMarcoGO extends JPanel {
	
	private JLabel Nombre;
	private JLabel Precio;
    public JTextField nomb;
	private JTextField pre;
	private JButton Aceptar;
	private JTextArea muestra;
	private EAñadirOferta ev;
	private JPanel panelSup,panelInf;
	
	public LaminaDeMarcoGO() {
		
		setLayout(new BorderLayout(8,8));
		
		panelSup= new JPanel();
		panelInf= new JPanel();
		
		
		Nombre= new JLabel("Nombre de la oferta");
		Precio= new JLabel("Precio");
		
		nomb= new JTextField("Fotos 4x5",20);
		pre= new JTextField("10",10);
		
		
		muestra= new JTextArea(10,20); 
		muestra.setEditable(false);
		muestra.setLineWrap(true);
		
		Aceptar= new JButton("Aceptar");
		
		ev= new EAñadirOferta(nomb,pre,muestra);
		Aceptar.addActionListener(ev);
		
		panelSup.add(Nombre);
		panelSup.add(nomb);
		panelSup.add(Precio);
		panelSup.add(pre);
		
		panelInf.add(Aceptar);
		
		panelInf.add(muestra);
		
		add(panelSup,BorderLayout.NORTH);
		add(panelInf,BorderLayout.CENTER);
		
	}
	
	
		
	}

