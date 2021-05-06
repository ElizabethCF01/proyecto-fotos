package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
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

	private JTextArea area;

	public EVerDatosClient(VistaGestionCliente panelCamb, VistaRegistroClient vistaConten, JTextField name,
			JTextField age, JTextField phone, JCheckBox acomp, JTextField numCliente, JTextArea area) {

		this.numCliente = numCliente;
		this.panelCamb = panelCamb;
		this.vistaConten = vistaConten;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.acomp = acomp;
		controlCl = new ControlClient();
		this.area = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vistaConten.cambiarVista(panelCamb);

		panelCamb.getPanelCent().setVisible(false);

		vistaConten.getBotAnt().setVisible(true);

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
