package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ProductosDto;

public class ProductosDao {
	ProductosDto productoDto= new ProductosDto();	
	public String comprobarproductoId(int id) throws Exception {
		Connection con = new Conexion().obtenerConexion();
		PreparedStatement pst;
		pst= con.prepareStatement("SELECT * FROM producto where idProduc =?");
		pst.setInt(1, id);
		ResultSet rs= pst.executeQuery();
		while(rs.next()){
			productoDto.setProducto_nombre(rs.getString("nomProduc"));			
		}
		String nom_produc= productoDto.getProducto_nombre();		
		return nom_produc;
	}
	public boolean IngresarProducto(ProductosDto producto, Connection con){
		try {
			String sql = "INSERT INTO `cristhian`.`productos` (`id_producto`, `nombre_producto`, `cantidad_producto`) VALUES (?,?,?)" ;		
			PreparedStatement sentencia=null;
			int rss=0;	
			sentencia = (PreparedStatement) con.prepareStatement(sql);	
	       	sentencia.setInt(1, producto.getProducto_id());
	    	sentencia.setString(2, producto.getProducto_nombre());
	    	sentencia.setInt(3, producto.getProducto_cantidad());
	    	sentencia.setInt(4, producto.getProducto_valor());
	    	rss=sentencia.executeUpdate();		     
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}
	public boolean agregar(ProductosDto producto, Connection con) {
		try {
			String sql = "INSERT INTO producto (idProduc,nomProduc,cantiProduc,valorProducto" 
					+ " VALUES (?,?,?,?)" ;
			PreparedStatement sentencia=null;
			int rss=0;	
			sentencia = (PreparedStatement) con.prepareStatement(sql);	
	       	sentencia.setInt(1, producto.getProducto_id());
	    	sentencia.setString(2, producto.getProducto_nombre());
	    	sentencia.setInt(3, producto.getProducto_cantidad());
	    	sentencia.setInt(4, producto.getProducto_valor());
	    	rss=sentencia.executeUpdate();		     
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}
	public boolean eliminar(ProductosDto ProductoDto, Connection con)
			throws SQLException {
		String sql = "DELETE FROM producto  WHERE idProduc= ?";		
		PreparedStatement instruccion = con.prepareStatement(sql);
		instruccion.setInt(1, ProductoDto.getProducto_id());
		if (instruccion.executeUpdate() >= 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean modificar(ProductosDto producto, Connection con)
			throws SQLException {
		String sql = "UPDATE `tienda`.`producto` SET `idProduc`=?, `nomProduc`=? WHERE `cantiProduc`=?;`valorProducto`";
		PreparedStatement sentencia=null;
		int rss=0;
		sentencia.setInt(1, producto.getProducto_id());
    	sentencia.setString(2, producto.getProducto_nombre());
    	sentencia.setInt(3, producto.getProducto_cantidad());
    	sentencia.setInt(4, producto.getProducto_valor());
		if (sentencia.executeUpdate() >= 1) {
			return true;
		} else {
			return false;
		}
	}
}
