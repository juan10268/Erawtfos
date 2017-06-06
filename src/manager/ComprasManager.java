package manager;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sql.DataSource;

import dao.ComprasDao;
import dto.EmpleadoDto;
import dto.ProductosListaDto;
import util.PersistUtil;

public class ComprasManager {
	private DataSource dataSource;
	ComprasDao comprasDao= new ComprasDao();
	ProductosManager productoManager= new ProductosManager();
	
	public ComprasManager(){
		dataSource= PersistUtil.getDataSource();
	}

	public boolean agregarCompra(EmpleadoDto empleado, ProductosListaDto productosLista) throws Exception{
		Connection con= dataSource.getConnection();
		Calendar c= Calendar.getInstance();
		SimpleDateFormat formatDate= new SimpleDateFormat("dd/MM/yyyy");
		String fecha_venta=formatDate.format(c.getTime());
		double valor_venta= productoManager.valorFacturar(productosLista);
		return comprasDao.agregarCompra(empleado, valor_venta, fecha_venta, con);	
	}
}
