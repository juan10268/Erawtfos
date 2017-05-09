package manager;

import dao.EmpleadoDao;
import dto.EmpleadoDto;

public class EmpleadoManager {
	EmpleadoDao empleadoDao= new EmpleadoDao();
		
	public String loginEmpleado(int id_persona, String pass_persona) throws Exception {	
		return "";
	}
	public void ingresarUsuario (EmpleadoDto empleado) throws Exception {
		empleadoDao.ingresar(empleado);
	}
	public String consultarPassword(int id_Persona, String pass) throws Exception {
		String password= empleadoDao.consultarPass(id_Persona);	
		String comprobation_Password;
		if(password.equals(pass)){
			comprobation_Password="paso";
		}
		else{
			comprobation_Password=null;
		}
		return comprobation_Password;
	}
}