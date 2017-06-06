package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ComprasDto {
	private int emp_compra;
	private double valor_compra;
	private String dia_compra;
	
	public int getEmp_compra() {
		return emp_compra;
	}
	public void setEmp_compra(int emp_compra) {
		this.emp_compra = emp_compra;
	}
	public double getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	public String getDia_compra() {
		return dia_compra;
	}
	public void setDia_compra(String dia_compra) {
		this.dia_compra = dia_compra;
	}
}