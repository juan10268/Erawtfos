package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.EmpleadoDto;
import dto.ProductosListaDto;
import dto.VentasDto;
import dto.VentasListasDto;
import manager.VentasManager;

@ManagedBean(name="ventas")
public class VentasCommand {
	VentasManager ventasManager= new VentasManager();
	EmpleadoCommand empleado= new EmpleadoCommand();
	
	public void mostrarVentas(EmpleadoDto empleadoDto, VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.consultarVentasporId(empleadoDto, ventasListaDto);
		ventasListaDto.getListaVentas();		
	}
	public void mostrarTotalVentas(VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.consultarVentasTotal(ventasListaDto);
		ventasListaDto.getListaVentas();		
	}
	public void mostrarVentaspordia(VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.consultarDiasVenta(ventasListaDto);
		ventasListaDto.getLista();	
	}
	public void mostrarDiaVenta(VentasDto ventas, VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.mostrarDiaVentas(ventas, ventasListaDto);
		ventasListaDto.getListaVentasDia();		
	}	
	public void agregarVentas(EmpleadoDto empleado, ProductosListaDto productosLista) throws Exception{
		FacesMessage message = null;
		if(productosLista.getLista().size()!=0){
			if(ventasManager.agregar(empleado, productosLista)) {
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra en Tienda Cristhian", "La venta ha sido registrado");
			}
			else {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Compra en Tienda Cristhian", "La venta no ha sido registrado");
			}
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Compra en Tienda Cristhian", "Proceso no ha sido registrado");
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public double ventasEmpleadosTotales(VentasListasDto ventasListaDto) throws Exception{
		return ventasManager.calcularVentasTotales(ventasListaDto);
	}
	public double ventasEmpleadosPorid(EmpleadoDto empleadoDto, VentasListasDto ventasListaDto) throws Exception{
		return ventasManager.calcularVentasporId(empleadoDto, ventasListaDto);
	}
	public double ventasporDia(VentasDto ventas,VentasListasDto ventasListaDto) throws Exception{
		return ventasManager.calcularventasPorDia(ventas, ventasListaDto);
	}
}