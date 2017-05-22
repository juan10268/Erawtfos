package manager;

import dao.EmpleadoDao;
import dto.EmpleadoDto;
import dto.EmpleadoListaDto;

public class EmpleadoManager {
	EmpleadoDao empleadoDao= new EmpleadoDao();
		
	public String loginEmpleado(int id_persona, String pass_persona) throws Exception {	
		if(empleadoDao.login(id_persona, pass_persona)!=null){
			return empleadoDao.login(id_persona, pass_persona);
		}
		else{
			return null;
		}
	}
	public void consultarEmpleado(EmpleadoListaDto empleadoListaDto) throws Exception {
		empleadoDao.consultarEmpleado(empleadoListaDto);		
	}
	public String consultarIdentificacion(int id_persona) throws Exception {
		if(empleadoDao.consultarIdentificacion(id_persona)!=null){
			return empleadoDao.consultarIdentificacion(id_persona); 			
		}else{
			return null;
		}
	}
	public boolean agregar(EmpleadoDto empleadoDto) throws Exception {
		return empleadoDao.ingresar(empleadoDto);
	}
	public boolean eliminar(int id_empleado) throws Exception {
		return empleadoDao.eliminar(id_empleado);
	}
	public boolean actualizar(EmpleadoDto empleadoDto) throws Exception {
		return empleadoDao.actualizar(empleadoDto);
	}
	public void consultarInfoEmpleado(int id_empleado, EmpleadoListaDto empleadoListaDto) throws Exception {
		empleadoDao.consultarInfo(id_empleado, empleadoListaDto);
	}
	public void consultarVentasEmpleado(EmpleadoListaDto empleadoListaDto) throws Exception {
		empleadoDao.consultarEmpleadoVentas(empleadoListaDto);
	}
}