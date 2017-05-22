package manager;

import dao.ConectarBase;
import dao.ProductosDao;
import dto.ProductosDto;
import dto.ProductosListaDto;

public class ProductosManager {
	
	ProductosDao productosDao= new ProductosDao();
	ConectarBase con = new ConectarBase();
	
	public boolean agregar(ProductosDto productosDto) throws Exception{
		return productosDao.agregar(productosDto);
	}
	public void consultarProducto(ProductosListaDto productosListaDto) throws Exception {
	    productosDao.consultarProducto(productosListaDto);		
	}
	public boolean eliminar(ProductosDto productosDto) throws Exception {
		return productosDao.eliminar(productosDto);
	}	
	public String consultarIdProducto(int id_producto) throws Exception {
		if(productosDao.consultarIdProducto(id_producto)!=null){
			return productosDao.consultarIdProducto(id_producto); 			
		}else{
			return null;
		}
	}
	public void consultartodosProductos(ProductosListaDto productosListaDto) throws Exception {
		productosDao.consultartodosProductos(productosListaDto);
	}
	public ProductosDto facturarProducto(ProductosDto productoDto) throws Exception {
		return productosDao.consultarProductosporId(productoDto);			
	}
	public boolean restriccioninventario(ProductosDto productoDto) throws Exception{
		int can_pedido=productosDao.consultarProductosporId(productoDto).getProducto_cantidad();
		int can_disponible= productosDao.inventariodisponibleporId(productoDto);
		if(can_pedido>can_disponible){
			return false;
		}
		else{
			productosDao.disminuirProducto(productoDto);
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
		return productosDao.inventariodisponibleporId(productoDto);		
	}
	public void pedidoInventario(ProductosDto productos) throws Exception{
		productosDao.aumentarProducto(productos);
	}
}