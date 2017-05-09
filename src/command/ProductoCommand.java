package command;

import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import dto.ProductoDto;
import manager.ProductoManager;

@ManagedBean("producto")
public class ProductoCommand {
	ProductoManager productoManager= new ProductoManager();
	
	public void agregar(ProductoDto productoDto) throws SQLException{
		FacesMessage message = null;
		if (productoManager.agregar(productoDto)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso"," "+ productoDto.getProducto_id());
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro erroneo"," "+ productoDto.getProducto_id());
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public void eliminar (ProductoDto productoDto) throws Exception{
		FacesMessage message = null;
		if (productoManager.eliminar(productoDto)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación exitosa", "El elemento "+ productoDto.getProducto_id()+ "ha sido eliminado");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación erronea", "" + productoDto.getProducto_id());
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	public void modificar (ProductoDto productoDto) throws SQLException{
		FacesMessage message = null;
		if (productoManager.modificar(productoDto)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación exitosa", " "+ productoDto.getProducto_id()+" ");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación erronea", " "+ productoDto.getProducto_id()+" ");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}


