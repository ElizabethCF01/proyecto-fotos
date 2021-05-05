package eventosClientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import clientesVistas.VistaRegistroClient;

public class EvIraAgreg implements ActionListener {

	private VistaRegistroClient vistaContenedor;

	private JPanel panelCambiar;

	public EvIraAgreg(JPanel v, VistaRegistroClient r) {
		panelCambiar = v;
		vistaContenedor = r;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vistaContenedor.cambiarVista(panelCambiar);
		vistaContenedor.getBotAnt().setVisible(true);

	}

}
