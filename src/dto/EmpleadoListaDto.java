package dto;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EmpleadoListaDto implements Serializable{
	
	private List<EmpleadoDto> empleado;
	private EmpleadoDto selectedEmpleado;
	
	public List<EmpleadoDto> getEmpleado() {
		return empleado;
	}
	public void setEmpleado(List<EmpleadoDto> empleado) {
		this.empleado = empleado;
	}
	public EmpleadoDto getSelectedEmpleado() {
		return selectedEmpleado;
	}
	public void setSelectedEmpleado(EmpleadoDto selectedEmpleado) {
		this.selectedEmpleado = selectedEmpleado;
	}
	

}
