package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.EmpleadoDto;
import dto.ProductosListaDto;
import dto.VentasDto;
import dto.VentasListasDto;
import manager.VentasManager;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase recibe la informacion de las ventas de la vista y la manda a otra capa.
 * En esta capa no se hacen validaciones.
 */

@ManagedBean(name="ventas")
public class VentasCommand {
	VentasManager ventasManager= new VentasManager();
	EmpleadoCommand empleado= new EmpleadoCommand();
	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto, VentasListasDto
	 */
	public void mostrarVentas(EmpleadoDto empleadoDto, VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.consultarVentasporId(empleadoDto, ventasListaDto);
		ventasListaDto.getListaVentas();		
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param VentasListasDto
	 */
	public void mostrarTotalVentas(VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.consultarVentasTotal(ventasListaDto);
		ventasListaDto.getListaVentas();		
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param VentasListasDto
	 */
	public void mostrarVentaspordia(VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.consultarDiasVenta(ventasListaDto);
		ventasListaDto.getLista();	
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param VentasListasDto, VentasDto
	 */
	public void mostrarDiaVenta(VentasDto ventas, VentasListasDto ventasListaDto) throws Exception{
		if(ventasListaDto==null){
			ventasListaDto= new VentasListasDto();
		}
		ventasManager.mostrarDiaVentas(ventas, ventasListaDto);
		ventasListaDto.getListaVentasDia();		
	}	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto, ProductosListasDto
	 */
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
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param VentasListasDto
	 */
	public double ventasEmpleadosTotales(VentasListasDto ventasListaDto) throws Exception{
		return ventasManager.calcularVentasTotales(ventasListaDto);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param VentasListasDto, EmpleadoDto
	 */
	public double ventasEmpleadosPorid(EmpleadoDto empleadoDto, VentasListasDto ventasListaDto) throws Exception{
		return ventasManager.calcularVentasporId(empleadoDto, ventasListaDto);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param VentasListasDto, VentasDto
	 */
	public double ventasporDia(VentasDto ventas,VentasListasDto ventasListaDto) throws Exception{
		return ventasManager.calcularventasPorDia(ventas, ventasListaDto);
	}
}