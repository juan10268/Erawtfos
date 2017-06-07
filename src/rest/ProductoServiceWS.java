package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.ProductosDto;
import dto.ProductosListaDto;
import manager.ProductosManager;

@Path("/producto")
public class ProductoServiceWS {
	ProductosManager productoManager= new ProductosManager();

	@POST
	@Path("/agregarproducto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean agregarProducto(ProductosDto productoDto) throws Exception{
		return productoManager.agregar(productoDto);
	}
	@GET
	@Path("/eliminarproducto/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public boolean eliminarProducto(@PathParam("id") Integer id, ProductosDto productoDto) throws Exception{
		return productoManager.eliminar(productoDto);
	}
	@GET
	@Path("/listarproducto")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductosDto> Listar(ProductosListaDto productosListaDto) throws Exception {
		return productoManager.consultartodosProductos(productosListaDto);
	}
	@GET
	@Path("/comprobarproducto/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarPorId(@PathParam("id") Integer id, ProductosDto productoDto) throws Exception {
		return productoManager.consultarIdProducto(productoDto);
	}
}