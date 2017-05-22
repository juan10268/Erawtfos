package manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.ComprasDao;
import dto.EmpleadoDto;
import dto.ProductosListaDto;

public class ComprasManager {
	ComprasDao comprasDao= new ComprasDao();
	ProductosManager productoManager= new ProductosManager();

	public boolean agregarCompra(EmpleadoDto empleado, ProductosListaDto productosLista) throws Exception{
		Calendar c= Calendar.getInstance();
		SimpleDateFormat formatDate= new SimpleDateFormat("dd/MM/yyyy");
		String fecha_venta=formatDate.format(c.getTime());
		double valor_venta= productoManager.valorFacturar(productosLista);
		return comprasDao.agregarCompra(empleado, valor_venta, fecha_venta);	
	}
}
