package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import dto.ProductosDto;
import dto.ProductosListaDto;
import manager.ProductosManager;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase recibe la informacion de los productos de la vista y la manda a otra capa.
 * En esta capa no se hacen validaciones.
 */

@ManagedBean(name="producto")
@ViewScoped
public class ProductosCommand {
	ProductosManager productosManager= new ProductosManager();
	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 */	
	public void agregar(ProductosDto productosDto) throws Exception{
		FacesMessage message = null;
		if (productosManager.agregar(productosDto)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro en Tienda Cristhian","El producto "
		+ productosDto.getProducto_nombre() + " ha sido registrado");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Registro en Tienda Cristhian", "El producto "
					+ productosDto.getProducto_nombre() + " no ha sido registrado");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 */
	public void consultarId(ProductosDto productosDto) throws Exception{
		FacesMessage message=null;
		productosManager.consultarIdProducto(productosDto);		
		if(productosManager.consultarIdProducto(productosDto)!=null){
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Registro en Tienda Cristhian", "El producto esta registro con " + 
			productosManager.consultarIdProducto(productosDto));
		}
		else{
			message= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro en Tienda Cristhian", "Producto no registrado");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 */
	public void eliminar(ProductosDto productosDto) throws Exception{
		FacesMessage message = null;
		if (productosManager.eliminar(productosDto)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación exitosa", "El producto con ID="+ productosDto.getProducto_id()+ " ha sido eliminado");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación erronea", "El producto " + productosDto.getProducto_id()+ " no ha sido eliminado");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 */
	public void consultarProducto(ProductosListaDto productosListaDto) throws Exception{
		if(productosListaDto==null){
			productosListaDto= new ProductosListaDto();
		}
		productosManager.consultarProducto(productosListaDto);
		productosListaDto.getListaProducto();
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 */
	public void listartodosProductos(ProductosListaDto productosListaDto) throws Exception{
		if(productosListaDto==null){
			productosListaDto= new ProductosListaDto();
		}
		productosManager.consultartodosProductos(productosListaDto);
		productosListaDto.getLista();
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto, ProductosListaDto
	 */
	public void facturarProductoVenta(ProductosDto productoDto, ProductosListaDto productosLista) throws Exception{	
		FacesMessage message=null;
		if(productoDto.getProducto_cantidad()!=0){
			if(productosManager.restriccioninventario(productoDto)){
				productoDto=productosManager.facturarProducto(productoDto);	
				productosLista.getLista().add(productoDto);
				productosLista.getLista();	
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota de inventario", "La cantidad del producto requerida por el usuario"
						+ " se encuentra en nuestro inventario");
			}
			else{
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota de inventario", "La cantidad del producto requerida por el usuario"
						+ " no se encuentra en nuestro inventario");
			}			
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota sobre venta", "La cantidad del producto requerida por el usuario"
					+ " no es valida");			
		}		
		RequestContext.getCurrentInstance().showMessageInDialog(message);			
	}	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 */
	public double valorfacturar(ProductosListaDto productosLista) throws Exception{	
		return productosManager.valorFacturar(productosLista);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 */
	public int cantidadProductos(ProductosListaDto productosLista) throws Exception{
		return productosManager.cantidadProductos(productosLista);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 */
	public void canti_productoVenta(ProductosDto productoDto) throws Exception{
		FacesMessage message=null;
		if(productoDto.getProducto_cantidad()!=0){
			if(productosManager.inventariodisponibleporId(productoDto)<=10){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","El producto esta cerca de agotarse. Actualmente hay "+
						productosManager.inventariodisponibleporId(productoDto));
			}
			else{
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion sobre producto","El producto "
						+ "no esta cerca de agotarse. Actualmente hay "+ productosManager.inventariodisponibleporId(productoDto));
			}			
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion sobre venta","La cantidad ingresada " +
					"por el producto no es valida");
		}		
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 */
	public void canti_productoCompra(ProductosDto productoDto) throws Exception{
		FacesMessage message=null;
		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion sobre producto","Actualmente del producto hay "
		+ productosManager.inventariodisponibleporId(productoDto));		
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto, ProductosListaDto
	 */
	public void facturarProductoCompra(ProductosDto productoDto, ProductosListaDto productosLista) throws Exception{
		if(productoDto.getProducto_cantidad()!=0){
			productoDto=productosManager.facturarProducto(productoDto);	
			productosManager.pedidoInventario(productoDto);
			productosLista.getLista().add(productoDto);
			productosLista.getLista();			
		}
		else{
			productosLista.getLista().size();
		}			
	}
}