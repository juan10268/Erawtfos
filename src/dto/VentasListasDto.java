package dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase contiene los atributos para las listas de las ventas
 */
@ManagedBean
@ViewScoped
public class VentasListasDto implements Serializable {
	private Map<String, Object> lista;	
	private List<VentasDto> listaVentas;
	private String ventas;
	private VentasDto seleccionaVentas;
	private List<VentasDto> listaVentasDia;
	
	public List<VentasDto> getListaVentasDia() {
		return listaVentasDia;
	}
	public void setListaVentasDia(List<VentasDto> listaVentasDia) {
		this.listaVentasDia = listaVentasDia;
	}
	public Map<String, Object> getLista() {
		return lista;
	}
	public void setLista(Map<String, Object> lista) {
		this.lista = lista;
	}	
	public List<VentasDto> getListaVentas() {
		return listaVentas;
	}
	public void setListaVentas(List<VentasDto> listaVentas) {
		this.listaVentas = listaVentas;
	}
	public String getVentas() {
		return ventas;
	}
	public void setVentas(String ventas) {
		this.ventas = ventas;
	}
	public VentasDto getSeleccionaVentas() {
		return seleccionaVentas;
	}
	public void setSeleccionaVentas(VentasDto seleccionaVentas) {
		this.seleccionaVentas = seleccionaVentas;
	}
}
