package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.EmpleadoDto;
import dto.ProductosListaDto;
import manager.ComprasManager;

@ManagedBean(name="compras")
public class ComprasCommand {
	ComprasManager comprasManager= new ComprasManager();
	
	public void agregarCompra(EmpleadoDto empleado, ProductosListaDto productosLista) throws Exception{
		FacesMessage message = null;
		if(comprasManager.agregarCompra(empleado, productosLista)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra en Tienda Cristhian", "La compra ha sido registrado");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Compra en Tienda Cristhian", "La compra no ha sido registrada");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
