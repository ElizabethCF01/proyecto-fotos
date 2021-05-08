package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientesVistas.VistaGestionCliente;
import clientesVistas.VistaRegistroClient;
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

	public EVerDatosClient(VistaRegistroClient vistaACambiar, JTextField numCliente) {

		this.numCliente = numCliente;

		this.vistaACambiar = vistaACambiar;

		controlCl = new ControlClient();

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

		name.setEnabled(false);
		age.setEnabled(false);
		phone.setEnabled(false);
		acomp.setEnabled(false);

		name.setText(controlCl.getClientes().get(noClient - 1).getNombre());
		age.setText("" + controlCl.getClientes().get(noClient - 1).getEdad());
		phone.setText("" + controlCl.getClientes().get(noClient - 1).getTelefono());

		if (controlCl.getClientes().get(noClient - 1).getAcompannante()) {
			acomp.setSelected(true);
		} else {
			acomp.setSelected(false);
		}

		area.setText("");
		for (int i = 0; i < controlCl.getClientes().get(noClient - 1).getTiposOfertasCant().size(); i++) {

			area.setText(area.getText() + controlCl.getClientes().get(noClient - 1).getCadenaOfCant().get(i)
					+ System.lineSeparator());
		}

		// System.out.println(controlCl.getClientes().get(noClient-
		// 1).getCadenaOfCant());
	}

}
