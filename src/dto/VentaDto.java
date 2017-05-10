package dto;

import java.sql.Time;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class VentaDto {
	
	public Integer id_venta;
	public Integer canti_venta;
	public Time hora_venta;
	public Integer id_producto;
	public Integer id_empleado;
	public Double valor_venta;
	
	public Integer getId_venta() {
		return id_venta;
	}
	public void setId_venta(Integer id_venta) {
		this.id_venta = id_venta;
	}
	public Integer getCanti_venta() {
		return canti_venta;
	}
	public void setCanti_venta(Integer canti_venta) {
		this.canti_venta = canti_venta;
	}
	public Time getHora_venta() {
		return hora_venta;
	}
	public void setHora_venta(Time hora_venta) {
		this.hora_venta = hora_venta;
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public Integer getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_ventas(Double valor_venta) {
		this.valor_venta = valor_venta;
	}

}
