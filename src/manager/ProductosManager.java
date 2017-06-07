package manager;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.ProductosDao;
import dto.ProductosDto;
import dto.ProductosListaDto;
import util.PersistUtil;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase recibe la informacion de ProductosCommand y la manda a ProductosDao.
 * En esta capa se hacen validaciones.
 */
public class ProductosManager {
	private DataSource dataSource;	
	ProductosDao productosDao= new ProductosDao();
	
	public ProductosManager(){
		dataSource= PersistUtil.getDataSource();
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 * @return boolean
	 */
	public boolean agregar(ProductosDto productosDto) throws Exception{
		Connection con= dataSource.getConnection();
		return productosDao.agregar(productosDto, con);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 */
	public void consultarProducto(ProductosListaDto productosListaDto) throws Exception {
		Connection con= dataSource.getConnection();
		productosDao.consultarProducto(productosListaDto, con);		
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 * @return boolean
	 */
	public boolean eliminar(ProductosDto productosDto) throws Exception {
		Connection con= dataSource.getConnection();
		return productosDao.eliminar(productosDto, con);
	}	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 * @return nombre del producto
	 */
	public String consultarIdProducto(ProductosDto productosDto) throws Exception {
		Connection con= dataSource.getConnection();
		if(productosDao.consultarIdProducto(productosDto, con)!=null){
			return productosDao.consultarIdProducto(productosDto, con); 			
		}else{
			return null;
		}
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 * @return lista de productos
	 */
	public List<ProductosDto> consultartodosProductos(ProductosListaDto productosListaDto) throws Exception {
		Connection con= dataSource.getConnection();	
		 return productosDao.consultartodosProductos(productosListaDto, con);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 * @return producto
	 */
	public ProductosDto facturarProducto(ProductosDto productoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return productosDao.consultarProductosporId(productoDto, con);			
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 * @return boolean
	 */
	public boolean restriccioninventario(ProductosDto productoDto) throws Exception{
		Connection con= dataSource.getConnection();
		int can_pedido=productosDao.consultarProductosporId(productoDto, con).getProducto_cantidad();
		int can_disponible= productosDao.inventariodisponibleporId(productoDto, con);
		if(can_pedido>can_disponible){
			return false;
		}
		else{
			productosDao.disminuirProducto(productoDto, con);
			return true;
		}
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 * @return suma de la factura
	 */
	public double valorFacturar(ProductosListaDto productosLista) {
		double suma=0;
		for(int i=0; i<productosLista.getLista().size(); ++i){
			double valor= productosLista.getLista().get(i).getProducto_valor();
			suma= suma+ valor;			
		}	
		return suma;
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosListaDto
	 * @return suma de los productos
	 */
	public int cantidadProductos(ProductosListaDto productosLista) {
		int suma=0;
		for(int i=0; i<productosLista.getLista().size(); ++i){
			int valor= productosLista.getLista().get(i).getProducto_cantidad();
			suma= suma+ valor;			
		}	
		return suma;
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 * @return canti_produc
	 */
	public int inventariodisponibleporId(ProductosDto productoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return productosDao.inventariodisponibleporId(productoDto, con);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param ProductosDto
	 */
	public void pedidoInventario(ProductosDto productosDto) throws Exception{
		Connection con= dataSource.getConnection();
		productosDao.aumentarProducto(productosDto, con);
	}
}