package manager;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sql.DataSource;

import dao.ComprasDao;
import dto.ComprasDto;
import dto.EmpleadoDto;
import dto.ProductosListaDto;
import util.PersistUtil;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase recibe la informacion de ComprasCommand y hace las validaciones.
 * Ejecuta la accion de agregar la compra del command y la manda al dao.
 * En esta capa se hacen validaciones.
 */
public class ComprasManager {
	private DataSource dataSource;
	ComprasDao comprasDao= new ComprasDao();
	ProductosManager productoManager= new ProductosManager();
	
	public ComprasManager(){
		dataSource= PersistUtil.getDataSource();
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param ProductosListaDto
	 * @return boolean
	 */
	public boolean agregarCompra(EmpleadoDto empleado, ProductosListaDto productosLista) throws Exception{
		ComprasDto comprasDto= new ComprasDto();
		Connection con= dataSource.getConnection();
		Calendar c= Calendar.getInstance();
		SimpleDateFormat formatDate= new SimpleDateFormat("dd/MM/yyyy");
		comprasDto.setDia_compra(formatDate.format(c.getTime()));
		comprasDto.setValor_compra(productoManager.valorFacturar(productosLista));
		comprasDto.setEmp_compra(empleado.getId_empleado());
		System.out.println(comprasDto.getDia_compra());
		System.out.println(comprasDto.getValor_compra());
		System.out.println(comprasDto.getEmp_compra());
		return comprasDao.agregarCompra(comprasDto, con);	
	}
}
