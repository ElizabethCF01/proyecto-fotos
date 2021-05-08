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

public class VistaRegistroClient extends JPanel {

	private JTextArea area;

	private JPanel panelNor, panelCent;

	private JTextField numCl;

	private ControlClient cl;

	private JButton acceder, agregar;

	private EVerDatosClient evVerDatos;

	private VistaGestionCliente vVerDatosCl;

	private EvIraAgreg evIr;

	public VistaRegistroClient() {

		setLayout(new BorderLayout());

		panelNor = new JPanel();
		panelCent = new JPanel();

		vVerDatosCl = new VistaGestionCliente();
		vVerDatosCl.setVisible(false);

		area = new JTextArea();
		area.setEnabled(false);

		JLabel noClientes = new JLabel("No. Cliente");

		numCl = new JTextField(3);

		acceder = new JButton("Acceder");
		agregar = new JButton("Agregar nuevo cliente");

		cl = new ControlClient();

		for (int i = 0; i < cl.getClientes().size(); i++) {

			area.setText(area.getText() + (i + 1) + " " + cl.getClientes().get(i).getNombre() + System.lineSeparator());

		}

		evVerDatos = new EVerDatosClient(this, numCl);

		acceder.addActionListener(evVerDatos);

		evIr = new EvIraAgreg(this);
		agregar.addActionListener(evIr);

		panelCent.add(area);
		panelNor.add(noClientes);
		panelNor.add(numCl);
		panelNor.add(acceder);
		panelNor.add(agregar);

		add(panelNor, BorderLayout.NORTH);

		add(panelCent, BorderLayout.CENTER);

	}

	public JTextArea getAreaTexto() {
		return area;
	}

}
