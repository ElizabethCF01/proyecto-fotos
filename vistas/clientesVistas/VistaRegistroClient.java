package clientesVistas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlClientes.ControlClient;
import eventosClientes.EVerDatosClient;

public class VistaRegistroClient extends JPanel {

	private JTextArea area;

	private JLabel noClientes;

	private JPanel panelAux;

	private JTextField numCl, nom;

	private ControlClient cl;

	private JButton acceder, agregar;

	private EVerDatosClient evVerDatos;

	private VistaGestionCliente vVerDatosCl;

	public VistaRegistroClient() {

		panelAux = new JPanel();
		vVerDatosCl = new VistaGestionCliente();
		nom = vVerDatosCl.getCajaNombre();

		area = new JTextArea();

		JLabel noClientes = new JLabel("No. Cliente");

		numCl = new JTextField(3);

		acceder = new JButton("Acceder");
		agregar = new JButton("Agregar nuevo cliente");

		cl = new ControlClient();

		for (int i = 0; i < cl.getClientes().size(); i++) {

			area.setText(area.getText() + (i + 1) + " " + cl.getClientes().get(i).getNombre() + System.lineSeparator());

		}

		evVerDatos = new EVerDatosClient(vVerDatosCl, this, vVerDatosCl.getCajaNombre(), vVerDatosCl.getCajaEdad(),
				vVerDatosCl.getCajaTel(), vVerDatosCl.getVerifAcomp(), numCl);

		acceder.addActionListener(evVerDatos);

		panelAux.add(area);
		panelAux.add(noClientes);
		panelAux.add(numCl);
		panelAux.add(acceder);
		panelAux.add(agregar);

		add(panelAux);
	}

	public void cambiarVista(JPanel p) {
		this.panelAux.removeAll();
		this.panelAux.add(p);
		this.updateUI();
	}
}
