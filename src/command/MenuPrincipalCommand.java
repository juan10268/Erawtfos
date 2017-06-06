package command;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name= "menu")
public class MenuPrincipalCommand{
	public void redirigeEmpleado() throws Exception{
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath()+"/IngresarEmpleado.xhtml");	
	}
	public void redirigeProducto() throws Exception{
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath()+"/IngresarProducto.xhtml");	
	}
	public void redirigeVentas() throws Exception{
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath()+"/Ventas.xhtml");	
	}
	public void redirigeCompras() throws Exception{
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath()+"/Compras.xhtml");	
	}
	public void redirigeFacturacion() throws Exception{
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath()+"/Facturacion.xhtml");	
	}
}
		