package pruebas;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import dao.ComprasDao;
import dto.ComprasDto;
import util.PersistUtil;


public class TestCompras {
	ComprasDao comprasD= new ComprasDao();
	ComprasDto compras= new ComprasDto();
	private DataSource dataSource;

	public TestCompras(){
		dataSource= PersistUtil.getDataSource();
	}

	@Test
	public void agregar() throws Exception{
		Connection con= dataSource.getConnection();
		compras.setEmp_compra(1);
		compras.setValor_compra(12000);
		compras.setDia_compra("05/06/2017");
		Assert.assertEquals(true,comprasD.agregarCompra(compras, con));
		
	}
}
