package command;

import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import dto.ProductosDto;
import manager.ProductosManager;

@ManagedBean("producto")
public class ProductosCommand {
	ProductosManager productosManager= new ProductosManager();
	
	public void agregar(ProductosDto productosDto) throws SQLException{
		FacesMessage message = null;
		if (productosManager.agregar(productosDto)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso"," "+ productosDto.getProducto_id());
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro erroneo"," "+ productosDto.getProducto_id());
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public void eliminar (ProductosDto productosDto) throws Exception{
		FacesMessage message = null;
		if (productosManager.eliminar(productosDto)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación exitosa", "El elemento "+ productosDto.getProducto_id()+ "ha sido eliminado");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación erronea", "" + productosDto.getProducto_id());
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	public void modificar (ProductosDto productosDto) throws SQLException{
		FacesMessage message = null;
		if (productosManager.modificar(productosDto)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación exitosa", " "+ productosDto.getProducto_id()+" ");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación erronea", " "+ productosDto.getProducto_id()+" ");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}


