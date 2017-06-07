package manager;

import javax.sql.DataSource;
import java.sql.Connection;

import dao.EmpleadoDao;
import dto.EmpleadoDto;
import dto.EmpleadoListaDto;
import util.PersistUtil;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase recibe la informacion de EmpleadoCommand y la manda a EmpleadoDao.
 * En esta capa se hacen validaciones.
 */
public class EmpleadoManager {
	private DataSource dataSource;
	EmpleadoDao empleadoDao= new EmpleadoDao();
	
	public EmpleadoManager(){
		dataSource= PersistUtil.getDataSource();
	}	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @return per_nombre
	 */
	public String loginEmpleado(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		if(empleadoDao.login(empleadoDto, con)!=null){
			return empleadoDao.login(empleadoDto, con);
		}
		else{
			return null;
		}
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoListaDto
	 */
	public void consultarEmpleado(EmpleadoListaDto empleadoListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		empleadoDao.consultarEmpleado(empleadoListaDto, con);		
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @return per_id
	 */
	public String consultarIdentificacion(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		if(empleadoDao.consultarIdentificacion(empleadoDto, con)!=null){
			return empleadoDao.consultarIdentificacion(empleadoDto, con); 			
		}else{
			return null;
		}
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @return boolean
	 */
	public boolean agregar(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return empleadoDao.ingresar(empleadoDto, con);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @return boolean
	 */
	public boolean eliminar(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return empleadoDao.eliminar(empleadoDto, con);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @return boolean
	 */
	public boolean actualizar(EmpleadoDto empleadoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return empleadoDao.actualizar(empleadoDto, con);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param EmpleadoListaDto
	 */
	public void consultarInfoEmpleado(EmpleadoDto empleadoDto, EmpleadoListaDto empleadoListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		empleadoDao.consultarInfo(empleadoDto, empleadoListaDto, con);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoListaDto
	 */
	public void consultarVentasEmpleado(EmpleadoListaDto empleadoListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		empleadoDao.consultarEmpleadoVentas(empleadoListaDto, con);
	}
}