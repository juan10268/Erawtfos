package manager;

import java.sql.Connection;

import javax.sql.DataSource;

import dao.ProductosDao;
import dto.ProductosDto;
import dto.ProductosListaDto;
import util.PersistUtil;

public class ProductosManager {
	private DataSource dataSource;	
	ProductosDao productosDao= new ProductosDao();
	
	public ProductosManager(){
		dataSource= PersistUtil.getDataSource();
	}
	
	public boolean agregar(ProductosDto productosDto) throws Exception{
		Connection con= dataSource.getConnection();
		return productosDao.agregar(productosDto, con);
	}
	public void consultarProducto(ProductosListaDto productosListaDto) throws Exception {
		Connection con= dataSource.getConnection();
	    productosDao.consultarProducto(productosListaDto, con);		
	}
	public boolean eliminar(ProductosDto productosDto) throws Exception {
		Connection con= dataSource.getConnection();
		return productosDao.eliminar(productosDto, con);
	}	
	public String consultarIdProducto(ProductosDto productosDto) throws Exception {
		Connection con= dataSource.getConnection();
		if(productosDao.consultarIdProducto(productosDto, con)!=null){
			return productosDao.consultarIdProducto(productosDto, con); 			
		}else{
			return null;
		}
	}
	public void consultartodosProductos(ProductosListaDto productosListaDto) throws Exception {
		Connection con= dataSource.getConnection();	
		productosDao.consultartodosProductos(productosListaDto, con);
	}
	public ProductosDto facturarProducto(ProductosDto productoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return productosDao.consultarProductosporId(productoDto, con);			
	}
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
	public double valorFacturar(ProductosListaDto productosLista) {
		double suma=0;
		for(int i=0; i<productosLista.getLista().size(); ++i){
			double valor= productosLista.getLista().get(i).getProducto_valor();
			suma= suma+ valor;			
		}	
		return suma;
	}
	public int cantidadProductos(ProductosListaDto productosLista) {
		int suma=0;
		for(int i=0; i<productosLista.getLista().size(); ++i){
			int valor= productosLista.getLista().get(i).getProducto_cantidad();
			suma= suma+ valor;			
		}	
		return suma;
	}
	public int inventariodisponibleporId(ProductosDto productoDto) throws Exception {
		Connection con= dataSource.getConnection();
		return productosDao.inventariodisponibleporId(productoDto, con);
	}
	public void pedidoInventario(ProductosDto productosDto) throws Exception{
		Connection con= dataSource.getConnection();
		productosDao.aumentarProducto(productosDto, con);
	}
}