package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PersistUtil {
private static DataSource dataSource;
	
	public static DataSource getDataSource(){  	
    	try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/CristhianDS");
		} catch (Exception e) {
			e.toString();
		}
    	return dataSource;
    }

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void closeResources(PreparedStatement instruccion, ResultSet resultado) throws Exception{
		instruccion.close();
		resultado.close();
		
	}

	public static void closeResources(PreparedStatement instruccion) throws Exception {
		instruccion.close();
	}	
}
