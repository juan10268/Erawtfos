package manager;

import dao.ConectarBase;
import dao.VentaDao;
import dto.VentaDto;

public class VentaManager {
	
	VentaDao ventaDao = new VentaDao();
	ConectarBase con = new ConectarBase();
	
	public VentaDao getVentaDao() {
		return ventaDao;
	}
	public void setVentaDao(VentaDao ventaDao) {
		this.ventaDao = ventaDao;
	}
	public ConectarBase getCon() {
		return con;
	}
	public void setCon(ConectarBase con) {
		this.con = con;
	}
	public boolean agregar(VentaDto ventaDto) {
		return false;
	}
	

}
