package dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase contiene los atributos para las listas de los empleados
 */

@ManagedBean
@ViewScoped
public class EmpleadoListaDto implements Serializable{
	private Map<String, Object> listaEmpleado;
	private EmpleadoDto seleccionaEmpleado;
	private String empleado;
	private List<EmpleadoDto> lista;
	
	public Map<String, Object> getListaEmpleado() {
		return listaEmpleado;
	}
	public List<EmpleadoDto> getLista() {
		return lista;
	}
	public void setLista(List<EmpleadoDto> lista) {
		this.lista = lista;
	}
	public void setListaEmpleado(Map<String, Object> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}
	public EmpleadoDto getSeleccionaEmpleado() {
		return seleccionaEmpleado;
	}
	public void setSeleccionaEmpleado(EmpleadoDto seleccionaEmpleado) {
		this.seleccionaEmpleado = seleccionaEmpleado;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
}
