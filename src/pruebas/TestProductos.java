package pruebas;

import org.junit.Assert;

import org.junit.Test;

import dao.ProductosDao;
import dto.ProductosDto;
import dto.ProductosListaDto;

public class TestProductos {
	ProductosDto producto= new ProductosDto();
	ProductosListaDto listas= new ProductosListaDto();
	ProductosDao productoDao= new ProductosDao();	

	@Test
	public void insertar() throws Exception {
		producto.setProducto_id(10);
		producto.setProducto_nombre("Chocolatina");
		producto.setProducto_cantidad(10);
		producto.setProducto_valor(750);
		Assert.assertEquals(true, productoDao.agregar(producto));
	}
	@Test
	public void pkRepetida() throws Exception{
		producto.setProducto_id(10);
		producto.setProducto_nombre("ChocoCrispis");
		producto.setProducto_cantidad(11);
		producto.setProducto_valor(11212);
		Assert.assertEquals(true, productoDao.agregar(producto));
	}
	@Test
	public void eliminar() throws Exception{
		producto.setProducto_id(4);
		Assert.assertEquals(true, productoDao.eliminar(producto));	
	}
	@Test
	public void Listar() throws Exception{
		int contenido = 1;
		if(productoDao.consultartodosProductos(listas).size()>0){
			contenido = productoDao.consultartodosProductos(listas).size();
		}	
		Assert.assertEquals(contenido, productoDao.consultartodosProductos(listas).size());		
	}
}
