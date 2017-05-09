package manager;

import java.sql.SQLException;
import dao.ConectarBase;
import dao.ProductoDao;
import dto.ProductoDto;

public class ProductoManager {
	ProductoDao productoDao= new ProductoDao();
	ConectarBase con = new ConectarBase();
	public String comprobarproductoporId(int id) throws Exception{
		String id_producto= productoDao.comprobarproductoId(id);
		if(id_producto!=null){	
		}
		return id_producto;
	}
	public boolean agregar(ProductoDto ProductoDto) throws SQLException{
		return productoDao.agregar(ProductoDto, ConectarBase.ObtenerConnection());
	}
	public boolean eliminar(ProductoDto ProductoDto) throws SQLException {
		return productoDao.eliminar(ProductoDto, ConectarBase.ObtenerConnection());
	}
	public boolean modificar(ProductoDto ProductoDto) throws SQLException {
		return productoDao.modificar(ProductoDto, ConectarBase.ObtenerConnection());
	}
}
