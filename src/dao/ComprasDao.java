package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.ComprasDto;

public class ComprasDao {
	public boolean agregarCompra(ComprasDto comprasDto, Connection con) throws Exception {
		try {			
			PreparedStatement ps;
			ps=con.prepareStatement("INSERT INTO compras (valor_compras, dia_compras, emp_compras) VALUES (?,?,?)");
	      	ps.setDouble(1, comprasDto.getValor_compra());
	       	ps.setString(2, comprasDto.getDia_compra());
	       	ps.setInt(3, comprasDto.getEmp_compra());
	    	ps.executeUpdate();	
	    	return true;
	    	}
			catch (Exception e) {
	    		return false;
			}
	}
}
