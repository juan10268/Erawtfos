package manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.VentasDao;
import dto.EmpleadoDto;
import dto.ProductosListaDto;
import dto.VentasDto;
import dto.VentasListasDto;

public class VentasManager {
	VentasDao ventasDao= new VentasDao();
	ProductosManager productoManager= new ProductosManager();

	public void consultarVentasporId(int id_empleado, VentasListasDto ventasListaDto) throws Exception{
		ventasDao.consultarVentasId(id_empleado, ventasListaDto);			
	}
	public double calcularVentasTotales(VentasListasDto ventasListaDto) throws Exception{
		double suma=0;
		for(int i=0; i<ventasDao.consultarTotalVentas(ventasListaDto).size();i++){
			double valor= ventasDao.consultarTotalVentas(ventasListaDto).get(i).getVal_ventas();
			suma=suma+valor;
		}
		return suma;
	}
	public void consultarVentasTotal(VentasListasDto ventasListaDto) throws Exception {
		ventasDao.consultarTotalVentas(ventasListaDto);
		double suma=0;
		for(int i=0; i<ventasDao.consultarTotalVentas(ventasListaDto).size();i++){
			double valor= ventasDao.consultarTotalVentas(ventasListaDto).get(i).getVal_ventas();
			suma=suma+valor;
		}
	}
	public double calcularVentasporId(int id_empleado,VentasListasDto ventasListaDto) throws Exception {
		double suma=0;
		for(int i=0; i<ventasDao.consultarVentasId(id_empleado, ventasListaDto).size();i++){
			double valor= ventasDao.consultarVentasId(id_empleado, ventasListaDto).get(i).getVal_ventas();
			suma=suma+valor;
		}
		return suma;
	}
	public void consultarDiasVenta(VentasListasDto ventasListaDto) throws Exception {
		ventasDao.consultarDiasdeVenta(ventasListaDto);
	}
	public void mostrarDiaVentas(VentasDto ventas, VentasListasDto ventasListaDto) throws Exception {
		ventasDao.mostrarVentasDia(ventas, ventasListaDto);
	}
	public double calcularventasPorDia(VentasDto ventas,VentasListasDto ventasListaDto) throws Exception {
		double suma=0;
		for(int i=0; i<ventasDao.mostrarVentasDia(ventas, ventasListaDto).size();i++){
			double valor= ventasDao.mostrarVentasDia(ventas, ventasListaDto).get(i).getVal_ventas();
			suma=suma+valor;
		}
		return suma;
	}
	public boolean agregar(EmpleadoDto empleado, ProductosListaDto productosLista) throws Exception {
		Calendar c= Calendar.getInstance();
		SimpleDateFormat formatDate= new SimpleDateFormat("dd/MM/yyyy");
		String fecha_venta=formatDate.format(c.getTime());
		double valor_venta= productoManager.valorFacturar(productosLista);
		return ventasDao.agregarVenta(empleado, valor_venta, fecha_venta);		
	}
}