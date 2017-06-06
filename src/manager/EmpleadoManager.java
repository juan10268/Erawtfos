package manager;

import javax.sql.DataSource;
import java.sql.Connection;

import dao.EmpleadoDao;
import dto.EmpleadoDto;
import dto.EmpleadoListaDto;
import util.PersistUtil;

public class EmpleadoManager {
	private DataSource dataSource;
	EmpleadoDao empleadoDao= new EmpleadoDao();
	
	public EmpleadoManager(){
		dataSource= PersistUtil.getDataSource();
	}	
		
	public String loginEmpleado(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		if(empleadoDao.login(empleadoDto, con)!=null){
			return empleadoDao.login(empleadoDto, con);
		}
		else{
			return null;
		}
	}
	public void consultarEmpleado(EmpleadoListaDto empleadoListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		empleadoDao.consultarEmpleado(empleadoListaDto, con);		
	}
	public String consultarIdentificacion(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		if(empleadoDao.consultarIdentificacion(empleadoDto, con)!=null){
			return empleadoDao.consultarIdentificacion(empleadoDto, con); 			
		}else{
			return null;
		}
	}
	public boolean agregar(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return empleadoDao.ingresar(empleadoDto, con);
	}
	public boolean eliminar(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return empleadoDao.eliminar(empleadoDto, con);
	}
	public boolean actualizar(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return empleadoDao.actualizar(empleadoDto, con);
	}
	public void consultarInfoEmpleado(EmpleadoDto empleadoDto, EmpleadoListaDto empleadoListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		empleadoDao.consultarInfo(empleadoDto, empleadoListaDto, con);
	}
	public void consultarVentasEmpleado(EmpleadoListaDto empleadoListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		empleadoDao.consultarEmpleadoVentas(empleadoListaDto, con);
	}
}