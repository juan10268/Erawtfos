package manager;

import dao.ProductoDao;

public class ProductoManager {
	ProductoDao productoDao= new ProductoDao();

	public String comprobarproductoporId(int id) throws Exception{
		String id_producto= productoDao.comprobarproductoId(id);
		if(id_producto!=null){
			
		}
		return id_producto;
	}
}
