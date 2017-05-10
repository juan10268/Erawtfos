package dto;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class VentaListaDto implements Serializable{
	
	private List<VentaDto> venta;
	private VentaDto selectedVenta;
	
	public List<VentaDto> getVenta() {
		return venta;
	}
	public void setVenta(List<VentaDto> venta) {
		this.venta = venta;
	}
	public VentaDto getSelectedVenta() {
		return selectedVenta;
	}
	public void setSelectedVenta(VentaDto selectedVenta) {
		this.selectedVenta = selectedVenta;
	}

}
