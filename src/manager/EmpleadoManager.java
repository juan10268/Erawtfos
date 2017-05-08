package manager;

import dao.EmpleadoDao;
import dto.EmpleadoDto;

public class EmpleadoManager {
	EmpleadoDao empleadoDao= new EmpleadoDao();
		
	public String consultarUsuario(int cod) throws Exception {	
		String user_Name=empleadoDao.consultarNombre(cod);
		String user_Comprobation;
		if(user_Name==null){			
			user_Comprobation= null;
		}
		else{
			user_Comprobation= "" + user_Name;
		}
		System.out.println(user_Comprobation);
		return user_Comprobation;
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