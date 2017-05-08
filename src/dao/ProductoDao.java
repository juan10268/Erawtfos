package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.ProductoDto;

public class ProductoDao {
	ProductoDto productoDto= new ProductoDto();	

	public String comprobarproductoId(int id) throws Exception {
		Connection con= new Conexion().obtenerConexion();
		PreparedStatement pst;
		pst= con.prepareStatement("SELECT * FROM producto where id_producto =?");
		pst.setInt(1, id);
		ResultSet rs= pst.executeQuery();
		while(rs.next()){
			productoDto.setProducto_nombre(rs.getString("nom_producto"));			
		}
		String nom_produc= productoDto.getProducto_nombre();		
		return nom_produc;
	}
}
