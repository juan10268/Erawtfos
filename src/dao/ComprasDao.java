package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.EmpleadoDto;

public class ComprasDao {
	public boolean agregarCompra(EmpleadoDto empleado, double valor_compra, String fecha_venta, Connection con) throws Exception {
		try {			
			PreparedStatement ps;
			ps=con.prepareStatement("INSERT INTO compras (valor_compras, dia_compras, emp_compras) VALUES (?,?,?)");
	      	ps.setDouble(1, valor_compra);
	       	ps.setString(2, fecha_venta);
	       	ps.setInt(3, empleado.getId_empleado());
	    	ps.executeUpdate();	
	    	return true;
	    	}
			catch (Exception e) {
	    		return false;
			}
	}
}
