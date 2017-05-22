package dto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EmpleadoDto implements Serializable{
	private int id_empleado, rol_empleado;
	private String nom_empleado, pass_empleado;
		
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public int getRol_empleado() {
		return rol_empleado;
	}
	public void setRol_empleado(int rol_empleado) {
		this.rol_empleado = rol_empleado;
	}
	public String getNom_empleado() {
		return nom_empleado;
	}
	public void setNom_empleado(String nom_empleado) {
		this.nom_empleado = nom_empleado;
	}
	public String getPass_empleado() {
		return pass_empleado;
	}
	public void setPass_empleado(String pass_empleado) {
		this.pass_empleado = pass_empleado;
	}
}
