package controlClientes;

import java.util.ArrayList;

import clientes.Cliente;

public class ControlClient {

	private static ArrayList<Cliente> clientes;

	public ControlClient() {

		clientes = new ArrayList<Cliente>();

		clientes.add(new Cliente("Maria Gonzales Cue ", true, 18, 53457820));
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

}
