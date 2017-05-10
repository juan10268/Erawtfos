package manager;

import java.sql.SQLException;
import dao.ConectarBase;
import dao.ProductosDao;
import dto.ProductosDto;

public class ProductosManager {
	ProductosDao productosDao= new ProductosDao();
	ConectarBase con = new ConectarBase();
	public String comprobarproductoporId(int id) throws Exception{
		String id_producto= productosDao.comprobarproductoId(id);
		if(id_producto!=null){	
		}
		return id_producto;
	}
	public boolean agregar(ProductosDto ProductosDto) throws SQLException{
		return productosDao.agregar(ProductosDto, ConectarBase.ObtenerConnection());
	}
	public boolean eliminar(ProductosDto ProductosDto) throws SQLException {
		return productosDao.eliminar(ProductosDto, ConectarBase.ObtenerConnection());
	}
	public boolean modificar(ProductosDto ProductosDto) throws SQLException {
		return productosDao.modificar(ProductosDto, ConectarBase.ObtenerConnection());
	}
}
