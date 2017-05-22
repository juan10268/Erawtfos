package dto;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductosListaDto implements Serializable{	
	private List<ProductosDto> lista= new ArrayList<ProductosDto>();
	private Map<String, Object> listaProducto;
	private ProductosDto seleccionaProducto;
	private ProductosDto producto;	
	
	public List<ProductosDto> getLista() {
		return lista;
	}
	public void setLista(List<ProductosDto> lista) {
		this.lista = lista;
	}
	public Map<String, Object> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(Map<String, Object> listaProducto) {
		this.listaProducto = listaProducto;
	}
	public ProductosDto getSeleccionaProducto() {
		return seleccionaProducto;
	}
	public void setSeleccionaProducto(ProductosDto seleccionaProducto) {
		this.seleccionaProducto = seleccionaProducto;
	}
	public ProductosDto getProducto() {
		return producto;
	}
	public void setProducto(ProductosDto producto) {
		this.producto = producto;
	}	
}


