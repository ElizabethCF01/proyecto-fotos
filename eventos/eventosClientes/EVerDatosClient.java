package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
import conexion.ConexionBD;
import controlClientes.ControlClient;
import vistasGenerales.VistaGeneral;

public class EVerDatosClient implements ActionListener {

	private JTextField name, age, phone, numCliente;

	private JCheckBox acomp;

	private VistaRegistroClient vistaACambiar;

	private VistaGestionCliente vistaAgre;

	private ControlClient controlCl;

	private int noClient;

	private JTextArea area;

	private ConexionBD conex;

	private Statement s;

	public EVerDatosClient(VistaRegistroClient vistaACambiar, JTextField numCliente) {

		this.numCliente = numCliente;

		this.vistaACambiar = vistaACambiar;

		controlCl = new ControlClient();

		conex = new ConexionBD();

		s = conex.getState();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vistaAgre = VistaGeneral.getVistaGestCl();
		// vistaConten.cambiarVista(panelCamb);
		controlCl.setVistaCl(vistaACambiar, vistaAgre);

		vistaAgre.getPanelCent().setVisible(false);
		vistaAgre.getBotAgregar().setVisible(false);

		// vistaConten.getBotAnt().setVisible(true);
		name = vistaAgre.getCajaNombre();
		age = vistaAgre.getCajaEdad();
		phone = vistaAgre.getCajaTel();
		acomp = vistaAgre.getVerifAcomp();
		area = vistaAgre.getAreaOf();

		noClient = Integer.parseInt(numCliente.getText());

		area.setVisible(true);

		name.setEditable(false);
		age.setEditable(false);
		phone.setEditable(false);
		acomp.setEnabled(false);

		/*
		 * name.setText(controlCl.getClientes().get(noClient - 1).getNombre());
		 * age.setText("" + controlCl.getClientes().get(noClient - 1).getEdad());
		 * phone.setText("" + controlCl.getClientes().get(noClient - 1).getTelefono());
		 * 
		 * if (controlCl.getClientes().get(noClient - 1).getAcompannante()) {
		 * acomp.setSelected(true); } else { acomp.setSelected(false); }
		 * 
		 * area.setText(""); for (int i = 0; i < controlCl.getClientes().get(noClient -
		 * 1).getTiposOfertasCant().size(); i++) {
		 * 
		 * area.setText(area.getText() + controlCl.getClientes().get(noClient -
		 * 1).getCadenaOfCant().get(i) + System.lineSeparator()); }
		 */

		try {

			ResultSet r = s.executeQuery("SELECT*  FROM clientes WHERE IdCli=" + noClient);

			boolean acompannante = false;

			if (r.next()) {

				name.setText(r.getString(2));
				age.setText(r.getString(3));
				phone.setText(r.getString(4));

				acompannante = r.getBoolean(5);

			}

			if (acompannante) {

				acomp.setSelected(true);
			} else {
				acomp.setSelected(false);
			}

			r = s.executeQuery(
					"SELECT ofertas.NombreOferta, ofertas_clientes.Cantidad FROM ofertas, ofertas_clientes WHERE ofertas_clientes.IDCliente="
							+ noClient + " AND ofertas.CodigoOf=ofertas_clientes.CodigoOF");

			area.setText("");

			while (r.next()) {

				area.setText(area.getText() + r.getString(1) + " " + r.getString(2) + System.lineSeparator());
			}

		} catch (SQLException ev) {

			ev.printStackTrace();
		}

		// System.out.println(controlCl.getClientes().get(noClient-
		// 1).getCadenaOfCant());
	}

}
