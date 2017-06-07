package pruebas;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import dao.VentasDao;
import dto.EmpleadoDto;
import dto.VentasDto;
import dto.VentasListasDto;
import util.PersistUtil;

public class TestVentas {
	VentasDao ventasD= new VentasDao();
	VentasDto ventas= new VentasDto();
	VentasListasDto listas= new VentasListasDto();	
	EmpleadoDto empleadoDto= new EmpleadoDto();
	
	private DataSource dataSource;
	public TestVentas(){
		dataSource= PersistUtil.getDataSource();		
	}
		
	@Test
	public void insertarOK() throws Exception {
		Connection con= dataSource.getConnection();
		VentasDto ventas = new VentasDto();
		ventas.setEmp_ventas(12333);
		ventas.setFecha_venta("05/06/2017");
		ventas.setId_ventas(1);
		ventas.setNom_empventas("david");
		ventas.setVal_ventas(12000);
		
		Assert.assertEquals(true, ventasD.agregarVenta(ventas,con));
		
	}
	@Test
	public void Listar() throws Exception{
		Connection con= dataSource.getConnection();
		int contenido = 1;
		ventas.setId_ventas(1);
		if(ventasD.consultarVentasId(empleadoDto, listas, con).size()>0){
			contenido = ventasD.consultarVentasId(empleadoDto, listas, con).size();	
		}	
		Assert.assertEquals(contenido, ventasD.consultarVentasId(empleadoDto, listas, con).size());		
	}
	

}
