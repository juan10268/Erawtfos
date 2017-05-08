package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private static Connection con;
	public Connection obtenerConexion() throws Exception{
		String driver ="com.mysql.jdbc.Driver";
		String connection = "jdbc:mysql://localhost:3306/cristhian";
		String user = "root";
		String password = "root";
		Class.forName(driver);
		con = DriverManager.getConnection(connection, user, password);
		return con;
	}
}
