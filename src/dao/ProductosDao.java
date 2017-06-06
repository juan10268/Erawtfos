package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dto.ProductosDto;
import dto.ProductosListaDto;

public class ProductosDao {
	ProductosDto productosDto= new ProductosDto();	

	public boolean agregar(ProductosDto producto, Connection con) throws Exception {
		try {			
			PreparedStatement ps;
			ps=con.prepareStatement("INSERT INTO productos (id_producto, nombre_producto, cantidad_producto, valor_producto)" 
					+ " VALUES (?,?,?,?)") ;
			ps.setInt(1, producto.getProducto_id());
	    	ps.setString(2, producto.getProducto_nombre());
	    	ps.setInt(3, producto.getProducto_cantidad());
	    	ps.setInt(4, producto.getProducto_valor());
	    	ps.executeUpdate();		     
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	public boolean eliminar(ProductosDto productos, Connection con) throws Exception {
		String sql = "DELETE FROM productos WHERE id_producto= ?";		
		PreparedStatement instruccion = con.prepareStatement(sql);
		instruccion.setInt(1, productos.getProducto_id());
		if (instruccion.executeUpdate() >= 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean compras(ProductosDto productos, Connection con) throws Exception {
		PreparedStatement ps;
		ps= con.prepareStatement("UPDATE productos SET cantidad_producto = cantidad_producto + ? WHERE id_producto=?");
		ps.setInt(1, productos.getProducto_cantidad());
		ps.setInt(2, productos.getProducto_id());    	  	
		if (ps.executeUpdate()>=1) {
		   return true;
	    } else {
		    return false;
	    }
	}
	public void consultarProducto(ProductosListaDto productosListaDto, Connection con) throws Exception  {
		PreparedStatement ps;
		ps= con.prepareStatement("SELECT * FROM productos");
		Map<String, Object> producto= new LinkedHashMap<String, Object>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			producto.put(rs.getString("nombre_producto"), rs.getInt("id_producto"));			
		}
		rs.close();
		productosListaDto.setListaProducto(producto);
	}
	public String consultarIdProducto(ProductosDto productosDto, Connection con) throws Exception {
		PreparedStatement pst;
		pst= con.prepareStatement("SELECT * FROM productos where id_producto=?");
		pst.setInt(1, productosDto.getProducto_id());
		ResultSet rs= pst.executeQuery();
		while(rs.next()){
			productosDto.setProducto_nombre(rs.getString("nombre_producto"));	
		}
		String nom_produc= productosDto.getProducto_nombre();
		return nom_produc;
	}
	public List<ProductosDto> consultartodosProductos(ProductosListaDto productosListaDto, Connection con) throws Exception {
		List<ProductosDto> listaproductos = new ArrayList<ProductosDto>();
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM productos");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductosDto producto = new ProductosDto();
			producto.setProducto_cantidad(rs.getInt("cantidad_producto"));
			producto.setProducto_id(rs.getInt("id_producto"));
			producto.setProducto_nombre(rs.getString("nombre_producto"));
			producto.setProducto_valor(rs.getInt("valor_producto"));
			listaproductos.add(producto);
		}
		productosListaDto.setLista(listaproductos);
		rs.close();
		return listaproductos;
	}
	public ProductosDto consultarProductosporId(ProductosDto productoDto, Connection con) throws Exception {
		ProductosDto producto = new ProductosDto();
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM productos where id_producto=?");
		ps.setInt(1, productoDto.getProducto_id());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			producto.setProducto_cantidad(productoDto.getProducto_cantidad());
			producto.setProducto_id(rs.getInt("id_producto"));
			producto.setProducto_nombre(rs.getString("nombre_producto"));
			producto.setProducto_valor(rs.getInt("valor_producto")* productoDto.getProducto_cantidad());			
		}
		rs.close();
		return producto;
	}
	public boolean disminuirProducto(ProductosDto productos, Connection con) throws Exception {
		PreparedStatement ps;
		ps=con.prepareStatement("UPDATE productos SET cantidad_producto = cantidad_producto-? where id_producto=?");
		ps.setInt(1, productos.getProducto_cantidad());
		ps.setInt(2, productos.getProducto_id());    	  	
		if (ps.executeUpdate()>=1) {
		   return true;
	    } else {
		    return false;
	    }
	}
	public int inventariodisponibleporId(ProductosDto productoDto, Connection con) throws Exception {
		PreparedStatement ps;
		ps= con.prepareStatement("SELECT * FROM productos where id_producto=?");
		ps.setInt(1, productoDto.getProducto_id());
		int canti_produc = 0;
		ResultSet rs = ps.executeQuery();
		while(rs.next()){			
			productosDto.setProducto_cantidad(rs.getInt("cantidad_producto"));
			canti_produc= productosDto.getProducto_cantidad();
		}		
		return canti_produc;
	}
	public boolean aumentarProducto(ProductosDto productos, Connection con) throws Exception {
		PreparedStatement ps;
		ps=con.prepareStatement("UPDATE productos SET cantidad_producto = cantidad_producto +? where id_producto=?");
		ps.setInt(1, productos.getProducto_cantidad());
		ps.setInt(2, productos.getProducto_id());    	  	
		if (ps.executeUpdate()>=1) {
		   return true;
	    } else {
		    return false;
	    }
	}
}