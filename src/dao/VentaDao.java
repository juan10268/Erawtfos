package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.VentaDto;

public class VentaDao {
	public boolean ingresar(VentaDto venta, Connection con)
			throws SQLException {
		try {
			String p = "INSERT INTO venta (id_venta,canti_venta,hora_venta,id_producto,id_empleado,valor_venta)"
					+ " VALUES (?,?,?,?,?,?)" ;
			PreparedStatement sentencia = null;
			int rss = 0;	
	       	sentencia = con.prepareStatement(p);
	       	sentencia.setInt(1, venta.getId_venta());
	       	sentencia.setInt(2, venta.getCanti_venta());
	       	sentencia.setTime(3, venta.getHora_venta());
	       	sentencia.setInt(4, venta.getId_producto());
	       	sentencia.setInt(5, venta.getId_empleado());
	       	sentencia.setDouble(6, venta.getValor_venta());
	       	rss=sentencia.executeUpdate();		     
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
