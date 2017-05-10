package dto;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductosListaDto implements Serializable{
	
	private List<ProductosDto> producto;
	private ProductosDto selectedProducto;
	
	
	public List<ProductosDto> getProducto() {
		return producto;
	}
	public void setProducto(List<ProductosDto> producto) {
		this.producto = producto;
	}
	public ProductosDto getSelectedProducto() {
		return selectedProducto;
	}
	public void setSelectedProducto(ProductosDto selectedProducto) {
		this.selectedProducto = selectedProducto;
	}
	
	

}


