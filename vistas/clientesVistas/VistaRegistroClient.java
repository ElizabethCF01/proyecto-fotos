package clientesVistas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlClientes.ControlClient;
import eventosClientes.EVerDatosClient;
import eventosClientes.EvIraAgreg;
import eventosClientes.EvVolver;

public class VistaRegistroClient extends JPanel {

	private JTextArea area;

	private JPanel panelAux, panelAux2, panelInf;

	private JTextField numCl;

	private ControlClient cl;

	private JButton acceder, agregar, anterior;

	private EVerDatosClient evVerDatos;

	private VistaGestionCliente vVerDatosCl;

	private EvIraAgreg evIr;

	private EvVolver evVolver;

	public VistaRegistroClient() {

		setLayout(new BorderLayout());

		panelAux = new JPanel();
		panelAux2 = new JPanel();
		panelInf = new JPanel();

		vVerDatosCl = new VistaGestionCliente();

		area = new JTextArea();

		JLabel noClientes = new JLabel("No. Cliente");

		numCl = new JTextField(3);

		acceder = new JButton("Acceder");
		agregar = new JButton("Agregar nuevo cliente");
		anterior = new JButton("Regresar al registo");

		anterior.setVisible(false);

		cl = new ControlClient();

		for (int i = 0; i < cl.getClientes().size(); i++) {

			area.setText(area.getText() + (i + 1) + " " + cl.getClientes().get(i).getNombre() + System.lineSeparator());

		}

		evVerDatos = new EVerDatosClient(vVerDatosCl, this, vVerDatosCl.getCajaNombre(), vVerDatosCl.getCajaEdad(),
				vVerDatosCl.getCajaTel(), vVerDatosCl.getVerifAcomp(), numCl, vVerDatosCl.getAreaOf());

		acceder.addActionListener(evVerDatos);

		evIr = new EvIraAgreg(vVerDatosCl, this);
		agregar.addActionListener(evIr);

		evVolver = new EvVolver(panelAux, this, area);
		anterior.addActionListener(evVolver);

		panelAux.add(area);
		panelAux.add(noClientes);
		panelAux.add(numCl);
		panelAux.add(acceder);
		panelAux.add(agregar);

		panelInf.add(anterior);

		panelAux2.add(panelAux);
		add(panelAux2, BorderLayout.NORTH);

		add(panelInf, BorderLayout.SOUTH);

	}

	public void cambiarVista(JPanel p) {
		this.panelAux2.removeAll();
		this.panelAux2.add(p);
		this.updateUI();
	}

	public JButton getBotAnt() {
		return anterior;
	}

	public JTextArea getAreaTexto() {
		return area;
	}
}
