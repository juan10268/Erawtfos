package pruebas;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

import dao.EmpleadoDao;
import dto.EmpleadoDto;
import dto.EmpleadoListaDto;
import util.PersistUtil;

public class TestEmpleados {
	EmpleadoDao ejemploD= new EmpleadoDao();
	EmpleadoDto empleado= new EmpleadoDto();
	EmpleadoListaDto listas= new EmpleadoListaDto();
	private DataSource dataSource;
	
	public TestEmpleados(){
		dataSource= PersistUtil.getDataSource();
	}

	@Test
	public void insertar() throws Exception{
		Connection con= dataSource.getConnection();
		empleado.setId_empleado(14);
		empleado.setNom_empleado("Juan");
		empleado.setPass_empleado("1234");
		empleado.setRol_empleado(1);
		Assert.assertEquals(true, ejemploD.ingresar(empleado,con));
	}
	@Test
	public void pkRepetida() throws Exception{
		Connection con= dataSource.getConnection();
		empleado.setId_empleado(14);
		empleado.setNom_empleado("Juan");
		empleado.setPass_empleado("1234");
		empleado.setRol_empleado(1);
		Assert.assertEquals(true, ejemploD.ingresar(empleado, con));
	}
	@Test
	public void eliminar() throws Exception{
		Connection con= dataSource.getConnection();
		empleado.setId_empleado(5);		
		Assert.assertEquals(true, ejemploD.eliminar(empleado, con));		
	}
	@Test
	public void actualizar() throws Exception{
		Connection con= dataSource.getConnection();
		empleado.setId_empleado(11);
		empleado.setRol_empleado(3);
		empleado.setPass_empleado("1234");
		Assert.assertEquals(true, ejemploD.actualizar(empleado, con));
	}
	@Test
	public void Listar() throws Exception{
		Connection con= dataSource.getConnection();
		int contenido = 1;
		empleado.setId_empleado(5);
		if(ejemploD.consultarInfo(empleado, listas, con).size()>0){
			contenido = ejemploD.consultarInfo(empleado,listas, con).size();	
		}	
		Assert.assertEquals(contenido, ejemploD.consultarInfo(empleado, listas, con).size());		
	}
}
