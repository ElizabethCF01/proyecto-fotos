package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

	private static Connection conexion;

	private Statement state;

	public ConexionBD() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectophotos", "root", "");

			state = conexion.createStatement();

		} catch (SQLException e) {

			System.out.print("No se conecta");

			e.printStackTrace();
		}

	}

	public Statement getState() {

		return state;
	}

	public void cerrarConex() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
