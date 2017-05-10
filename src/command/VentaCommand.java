package command;

import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import dto.VentaDto;
import manager.VentaManager;

@ManagedBean(name="venta")
public class VentaCommand {
	VentaManager ventaManager= new VentaManager();
	public void agregar(VentaDto ventaDto) throws SQLException{
		FacesMessage message = null;
		if (ventaManager.agregar(ventaDto)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "venta exitosa"," "+ ventaDto.getId_venta());
		}
		else {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro erroneo"," "+ ventaDto.getId_venta());
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
