package pruebas;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Assert;

import org.junit.Test;

import dao.ProductosDao;
import dto.ProductosDto;
import dto.ProductosListaDto;
import util.PersistUtil;

public class TestProductos {
	ProductosDto producto= new ProductosDto();
	ProductosListaDto listas= new ProductosListaDto();
	ProductosDao productoDao= new ProductosDao();	
	private DataSource datasource;
	
	public TestProductos(){
		datasource= PersistUtil.getDataSource();
	}

	@Test
	public void insertar() throws Exception {
		Connection con= datasource.getConnection();
		producto.setProducto_id(10);
		producto.setProducto_nombre("Chocolatina");
		producto.setProducto_cantidad(10);
		producto.setProducto_valor(750);
		Assert.assertEquals(true, productoDao.agregar(producto, con));
	}
	@Test
	public void pkRepetida() throws Exception{
		Connection con= datasource.getConnection();
		producto.setProducto_id(10);
		producto.setProducto_nombre("ChocoCrispis");
		producto.setProducto_cantidad(11);
		producto.setProducto_valor(11212);
		Assert.assertEquals(true, productoDao.agregar(producto, con));
	}
	@Test
	public void eliminar() throws Exception{
		Connection con= datasource.getConnection();
		producto.setProducto_id(4);
		Assert.assertEquals(true, productoDao.eliminar(producto, con));	
	}
	@Test
	public void Listar() throws Exception{
		Connection con= datasource.getConnection();
		int contenido = 1;
		if(productoDao.consultartodosProductos(listas, con).size()>0){
			contenido = productoDao.consultartodosProductos(listas, con).size();
		}	
		Assert.assertEquals(contenido, productoDao.consultartodosProductos(listas, con).size());		
	}
}
