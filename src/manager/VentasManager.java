package manager;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sql.DataSource;

import dao.VentasDao;
import dto.EmpleadoDto;
import dto.ProductosListaDto;
import dto.VentasDto;
import dto.VentasListasDto;
import util.PersistUtil;

public class VentasManager {
	private DataSource dataSource;
	VentasDao ventasDao= new VentasDao();
	ProductosManager productoManager= new ProductosManager();
	
	public VentasManager(){
		dataSource= PersistUtil.getDataSource();
	}

	public void consultarVentasporId(EmpleadoDto empleadoDto, VentasListasDto ventasListaDto) throws Exception{
		Connection con= dataSource.getConnection();
		ventasDao.consultarVentasId(empleadoDto, ventasListaDto, con);			
	}
	public double calcularVentasTotales(VentasListasDto ventasListaDto) throws Exception{
		Connection con= dataSource.getConnection();
		double suma=0;
		for(int i=0; i<ventasDao.consultarTotalVentas(ventasListaDto, con).size();i++){
			double valor= ventasDao.consultarTotalVentas(ventasListaDto, con).get(i).getVal_ventas();
			suma=suma+valor;
		}
		return suma;
	}
	public void consultarVentasTotal(VentasListasDto ventasListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		ventasDao.consultarTotalVentas(ventasListaDto, con);
		double suma=0;
		for(int i=0; i<ventasDao.consultarTotalVentas(ventasListaDto, con).size();i++){
			double valor= ventasDao.consultarTotalVentas(ventasListaDto, con).get(i).getVal_ventas();
			suma=suma+valor;
		}
	}
	public double calcularVentasporId(EmpleadoDto empleadoDto,VentasListasDto ventasListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		double suma=0;
		for(int i=0; i<ventasDao.consultarVentasId(empleadoDto, ventasListaDto, con).size();i++){
			double valor= ventasDao.consultarVentasId(empleadoDto, ventasListaDto, con).get(i).getVal_ventas();
			suma=suma+valor;
		}
		return suma;
	}
	public void consultarDiasVenta(VentasListasDto ventasListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		ventasDao.consultarDiasdeVenta(ventasListaDto, con);
	}
	public void mostrarDiaVentas(VentasDto ventas, VentasListasDto ventasListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		ventasDao.mostrarVentasDia(ventas, ventasListaDto, con);
	}
	public double calcularventasPorDia(VentasDto ventas,VentasListasDto ventasListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		double suma=0;
		for(int i=0; i<ventasDao.mostrarVentasDia(ventas, ventasListaDto, con).size();i++){
			double valor= ventasDao.mostrarVentasDia(ventas, ventasListaDto, con).get(i).getVal_ventas();
			suma=suma+valor;
		}
		return suma;
	}
	public boolean agregar(EmpleadoDto empleado, ProductosListaDto productosLista) throws Exception {
		Connection con= dataSource.getConnection();
		VentasDto ventas= new VentasDto();
		Calendar c= Calendar.getInstance();
		SimpleDateFormat formatDate= new SimpleDateFormat("dd/MM/yyyy");
		ventas.setFecha_venta(formatDate.format(c.getTime()));
		ventas.setVal_ventas(productoManager.valorFacturar(productosLista));
		ventas.setId_ventas(empleado.getId_empleado());
		return ventasDao.agregarVenta(ventas, con);			
	}
}