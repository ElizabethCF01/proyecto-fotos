package clientesVistas;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import conexion.ConexionBD;
import controlClientes.ControlClient;
import eventosClientes.EVerDatosClient;
import eventosClientes.EvIraAgreg;

public class VistaRegistroClient extends JPanel {

	private JTextArea area;

	private JPanel panelNor, panelCent;

	private JTextField idCliente;

	private ControlClient cl;

	private JButton acceder, agregar;

	private EVerDatosClient evVerDatos;

	private VistaGestionCliente vVerDatosCl;

	private EvIraAgreg evIr;

	private ConexionBD conex;

	private Statement s;

	public VistaRegistroClient() {

		setLayout(new BorderLayout());

		conex = new ConexionBD();
		s = conex.getState();

		panelNor = new JPanel();
		panelCent = new JPanel();

		vVerDatosCl = new VistaGestionCliente();
		vVerDatosCl.setVisible(false);

		area = new JTextArea();
		area.setEditable(false);

		JLabel noClientes = new JLabel("ID Cliente");

		idCliente = new JTextField(3);

		acceder = new JButton("Acceder");
		agregar = new JButton("Agregar nuevo cliente");

		cl = new ControlClient();

		/*
		 * for (int i = 0; i < cl.getClientes().size(); i++) {
		 * 
		 * area.setText(area.getText() + (i + 1) + " " +
		 * cl.getClientes().get(i).getNombre() + System.lineSeparator());
		 * 
		 * }
		 */

		try {
			ResultSet r = s.executeQuery("SELECT  IdCli, Nombre FROM clientes ");
			while (r.next()) {

				area.setText(area.getText() + r.getString(1) + " " + r.getString(2) + System.lineSeparator());

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		evVerDatos = new EVerDatosClient(this, idCliente);

		acceder.addActionListener(evVerDatos);

		evIr = new EvIraAgreg(this);
		agregar.addActionListener(evIr);

		panelCent.add(area);
		panelNor.add(noClientes);
		panelNor.add(idCliente);
		panelNor.add(acceder);
		panelNor.add(agregar);

		add(panelNor, BorderLayout.NORTH);

		add(panelCent, BorderLayout.CENTER);

	}

	public JTextArea getAreaTexto() {
		return area;
	}

}
