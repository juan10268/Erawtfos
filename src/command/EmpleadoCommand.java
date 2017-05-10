package command;

import javax.faces.bean.ManagedBean;
import dto.EmpleadoDto;
import manager.EmpleadoManager;

@ManagedBean(name="empleado")
public class EmpleadoCommand {
	EmpleadoManager empleadoManager= new EmpleadoManager();
	
	public void loginEmpleado(EmpleadoDto empleadoDto) throws Exception{
		empleadoManager.loginEmpleado(empleadoDto.getId_empleado(), empleadoDto.getPass_empleado());	
	}
}
