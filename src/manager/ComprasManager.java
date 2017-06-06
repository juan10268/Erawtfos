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

public class ComprasManager {
	private DataSource dataSource;
	ComprasDao comprasDao= new ComprasDao();
	ProductosManager productoManager= new ProductosManager();
	
	public ComprasManager(){
		dataSource= PersistUtil.getDataSource();
	}

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
