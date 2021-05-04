package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
import controlClientes.ControlClient;

public class EVerDatosClient implements ActionListener {

	private JTextField name, age, phone, numCliente;

	private JCheckBox acomp;

	private VistaRegistroClient vistaConten;

	private VistaGestionCliente panelCamb;

	private ControlClient controlCl;

	private int noClient;

	public EVerDatosClient(VistaGestionCliente v, VistaRegistroClient r, JTextField n, JTextField e, JTextField tel,
			JCheckBox a, JTextField numCl) {

		numCliente = numCl;
		panelCamb = v;
		vistaConten = r;
		name = n;
		age = e;
		phone = tel;
		acomp = a;
		controlCl = new ControlClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vistaConten.cambiarVista(panelCamb);

		noClient = Integer.parseInt(numCliente.getText());

		name.setText(controlCl.getClientes().get(noClient - 1).getNombre());
		age.setText("" + controlCl.getClientes().get(noClient - 1).getEdad());
		phone.setText("" + controlCl.getClientes().get(noClient - 1).getTelefono());
		if (controlCl.getClientes().get(noClient - 1).getAcompannante()) {
			acomp.setSelected(true);
		} else {
			acomp.setSelected(false);
		}
	}

}
