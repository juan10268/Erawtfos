package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ComprasDto {
	private int id_compra, emp_compra, valor_compra;
	private String dia_compra;
	
	public int getId_compra() {
		return id_compra;
	}
	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}
	public int getEmp_compra() {
		return emp_compra;
	}
	public void setEmp_compra(int emp_compra) {
		this.emp_compra = emp_compra;
	}
	public int getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(int valor_compra) {
		this.valor_compra = valor_compra;
	}
	public String getDia_compra() {
		return dia_compra;
	}
	public void setDia_compra(String dia_compra) {
		this.dia_compra = dia_compra;
	}	
}
