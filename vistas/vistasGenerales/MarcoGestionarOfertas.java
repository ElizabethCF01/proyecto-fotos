package vistasGenerales;

import javax.swing.JFrame;
import javax.swing.JPanel;

import eventosGeneral.cerrarConexion;

public class MarcoGestionarOfertas extends JFrame {

	public static void main(String[] args) {

		MarcoGestionarOfertas m = new MarcoGestionarOfertas();
		m.setVisible(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private JPanel vistaGen;

	public MarcoGestionarOfertas() {

		setTitle("Photograph");
		setBounds(200, 100, 950, 500);

		vistaGen = new VistaGeneral();
		add(vistaGen);

		addWindowListener(new cerrarConexion());
	}

}
