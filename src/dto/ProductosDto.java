package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProductosDto {
	private int producto_id, producto_cantidad, producto_valor;
	private String producto_nombre;
	
	public int getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	public int getProducto_cantidad() {
		return producto_cantidad;
	}
	public void setProducto_cantidad(int producto_cantidad) {
		this.producto_cantidad = producto_cantidad;
	}
	public String getProducto_nombre() {
		return producto_nombre;
	}
	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
	}
	public int getProducto_valor() {
		return producto_valor;
	}
	public void setProducto_valor(int producto_valor) {
		this.producto_valor = producto_valor;
	}
}
