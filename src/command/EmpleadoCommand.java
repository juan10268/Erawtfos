package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dto.EmpleadoDto;
import dto.EmpleadoListaDto;
import manager.EmpleadoManager;

@ManagedBean(name="empleado")
public class EmpleadoCommand {
	EmpleadoManager empleadoManager= new EmpleadoManager();
	ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
	
	public void loginEmpleado(EmpleadoDto empleadoDto) throws Exception{
		String per_login=empleadoManager.loginEmpleado(empleadoDto);		
		if(per_login!=null){
			context.redirect(context.getRequestContextPath()+"/MenuPrincipal.xhtml");
		}
		else{
			context.redirect(context.getRequestContextPath()+"/Login.xhtml");			
		}
	}
	public void consultarEmpleado(EmpleadoListaDto empleadoListaDto) throws Exception{
		if(empleadoListaDto==null){
			empleadoListaDto= new EmpleadoListaDto();
		}
		empleadoManager.consultarEmpleado(empleadoListaDto);
		empleadoListaDto.getListaEmpleado();
	}
	public void consultarInfo(EmpleadoDto empleadoDto, EmpleadoListaDto empleadoListaDto) throws Exception{		
		if(empleadoListaDto==null){
			empleadoListaDto= new EmpleadoListaDto();
		}
		empleadoManager.consultarInfoEmpleado(empleadoDto, empleadoListaDto);
		empleadoListaDto.getLista();
	}
	public void consultarId(EmpleadoDto empleadoDto) throws Exception{
		FacesMessage message=null;
		empleadoManager.consultarIdentificacion(empleadoDto);
		if(empleadoManager.consultarIdentificacion(empleadoDto)!=null){
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Registro en Tienda Cristhian", "La identidad esta registro con " + 
			empleadoManager.consultarIdentificacion(empleadoDto));			
		}
		else{
			message= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro en Tienda Cristhian", "Identidad no registrada");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public void insertarEmpleado(EmpleadoDto empleadoDto) throws Exception{
		FacesMessage message = null;
		if (empleadoManager.agregar(empleadoDto)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "El empleado " + empleadoDto.getNom_empleado() + " ha sido registrado");
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro erroneo", "El empleado con ID: " + empleadoDto.getId_empleado()
			+ " no ha sido registrado");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public void actualizarEmpleado(EmpleadoDto empleadoDto) throws Exception{
		FacesMessage message= null;
		if(empleadoManager.actualizar(empleadoDto)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion exitosa", "El empleado con ID: " + empleadoDto.getId_empleado()
			+ " ha sido actualizados");			
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion erronea", "El empleado con ID: " + empleadoDto.getId_empleado()
			+ " no ha sido actualizado");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);		
	}
	public void eliminarEmpleado(EmpleadoDto empleadoDto) throws Exception{
		FacesMessage message= null;
		if(empleadoManager.eliminar(empleadoDto)){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminacion exitosa", "El empleado con ID: "
			+ empleadoDto + " ha sido eliminado");
		}else{
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eliminacion erronea", "El empleado con ID: "
		    + empleadoDto + " no ha sido registrado");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);	
	}
	public void consultarEmpleadoVentas(EmpleadoListaDto empleadoListaDto) throws Exception{
		if(empleadoListaDto==null){
			empleadoListaDto= new EmpleadoListaDto();
		}
		empleadoManager.consultarVentasEmpleado(empleadoListaDto);
		empleadoListaDto.getListaEmpleado();
	}	
}
