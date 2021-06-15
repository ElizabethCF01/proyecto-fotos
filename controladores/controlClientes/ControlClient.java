package controlClientes;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;

import clientes.Cliente;
import conexion.ConexionBD;

public class ControlClient {

	// private static ArrayList<Cliente> clientes;

	private Cliente clienteNuevo;

	private Statement statem;

	private ConexionBD conect;

	public ControlClient() {

		/*
		 * clientes = new ArrayList<Cliente>();
		 * 
		 * Cliente cliente1 = new Cliente("Maria Gonzales Cue ", true, 18, 53457820);
		 * cliente1.getTiposOfertasCant().put(new Oferta("Fotos 5x8", 25), 3);
		 * 
		 * clientes.add(cliente1);
		 */

		conect = new ConexionBD();

		statem = conect.getState();

	}
	/*
	 * public ArrayList<Cliente> getClientes() { return clientes; }
	 */

	public void AnnadirCliente(int IdCliente, String nombre, int edad, int telef, boolean Acompannante) {
		clienteNuevo = new Cliente(IdCliente, nombre, Acompannante, edad, telef);

		int ID = clienteNuevo.getID();
		String name = clienteNuevo.getNombre();
		boolean acomp = clienteNuevo.getAcompannante();
		int tel = clienteNuevo.getTelefono();
		int age = clienteNuevo.getEdad();

		try {

			statem.executeUpdate(
					"INSERT INTO clientes VALUES(" + ID + ",'" + name + "'," + age + "," + tel + "," + acomp + ")");

		} catch (SQLException e) {

			System.out.print("No funciona");
			e.printStackTrace();
		}

	}

	public void setVista(JPanel panelCamb1, JPanel panelCamb2, JPanel panelAgr) {
		// panelCont = vi.getPanelAux();
		/*
		 * panelCont.removeAll(); panelCont.add(panelAg); panelCont.updateUI();
		 */
		panelCamb1.setVisible(false);
		panelCamb1.setSize(0, 0);
		panelCamb2.setVisible(false);
		panelCamb2.setSize(0, 0);
		panelAgr.setVisible(true);
		panelAgr.setSize(800, 400);

	}

	public void setVistaCl(JPanel panelCamb, JPanel panelAgr) {

		panelCamb.setVisible(false);
		panelCamb.setSize(0, 0);
		panelAgr.setVisible(true);
		panelAgr.setSize(870, 400);

	}

}
