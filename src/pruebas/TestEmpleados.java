package pruebas;

import org.junit.Assert;
import org.junit.Test;

import dao.EmpleadoDao;
import dto.EmpleadoDto;
import dto.EmpleadoListaDto;

public class TestEmpleados {
	EmpleadoDao ejemploD= new EmpleadoDao();
	EmpleadoDto empleado= new EmpleadoDto();
	EmpleadoListaDto listas= new EmpleadoListaDto();

	@Test
	public void insertar() throws Exception{
		empleado.setId_empleado(14);
		empleado.setNom_empleado("Juan");
		empleado.setPass_empleado("1234");
		empleado.setRol_empleado(1);
		Assert.assertEquals(true, ejemploD.ingresar(empleado));
	}
	@Test
	public void pkRepetida() throws Exception{
		empleado.setId_empleado(14);
		empleado.setNom_empleado("Juan");
		empleado.setPass_empleado("1234");
		empleado.setRol_empleado(1);
		Assert.assertEquals(true, ejemploD.ingresar(empleado));
	}
	@Test
	public void eliminar() throws Exception{
		empleado.setId_empleado(5);		
		Assert.assertEquals(true, ejemploD.eliminar(empleado.getId_empleado()));		
	}
	@Test
	public void actualizar() throws Exception{
		empleado.setId_empleado(11);
		empleado.setRol_empleado(3);
		empleado.setPass_empleado("1234");
		Assert.assertEquals(true, ejemploD.actualizar(empleado));
	}
	@Test
	public void Listar() throws Exception{
		int contenido = 1;
		empleado.setId_empleado(5);
		if(ejemploD.consultarInfo(empleado.getId_empleado(), listas).size()>0){
			contenido = ejemploD.consultarInfo(empleado.getId_empleado(),listas).size();	
		}	
		Assert.assertEquals(contenido, ejemploD.consultarInfo(empleado.getId_empleado(), listas).size());		
	}
}
