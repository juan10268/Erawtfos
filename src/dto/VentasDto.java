package dto;

import javax.faces.bean.ManagedBean;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase contiene los atributos de las ventas
 */

@ManagedBean
public class VentasDto {
	public int id_ventas, emp_ventas;	
	private String fecha_venta, nom_empventas;
	private double val_ventas;
	
	public int getId_ventas() {
		return id_ventas;
	}
	public void setId_ventas(int id_ventas) {
		this.id_ventas = id_ventas;
	}
	public int getEmp_ventas() {
		return emp_ventas;
	}
	public void setEmp_ventas(int emp_ventas) {
		this.emp_ventas = emp_ventas;
	}
	public String getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public String getNom_empventas() {
		return nom_empventas;
	}
	public void setNom_empventas(String nom_empventas) {
		this.nom_empventas = nom_empventas;
	}
	public double getVal_ventas() {
		return val_ventas;
	}
	public void setVal_ventas(double val_ventas) {
		this.val_ventas = val_ventas;
	}
}
	
	