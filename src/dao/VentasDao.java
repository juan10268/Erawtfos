package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dto.EmpleadoDto;
import dto.VentasDto;
import dto.VentasListasDto;

public class VentasDao {
	public List<VentasDto> consultarVentasId(int id_empleado, VentasListasDto ventasListaDto) throws Exception {
		Connection con= new Conexion().obtenerConexion();
		List<VentasDto> listaVentas = new ArrayList<VentasDto>();
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM ventas WHERE emp_ventas=?");
		ps.setInt(1, id_empleado);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			VentasDto ventas = new VentasDto();
			ventas.setEmp_ventas(rs.getInt("emp_ventas"));
			ventas.setId_ventas(rs.getInt("id_ventas"));
			ventas.setFecha_venta(rs.getString("fecha_ventas"));
			ventas.setVal_ventas(rs.getInt("valor_ventas"));
			listaVentas.add(ventas);
		}
		ventasListaDto.setListaVentas(listaVentas);
		rs.close();
		return listaVentas;
	}
	public List<VentasDto> consultarTotalVentas(VentasListasDto ventasListaDto) throws Exception {
		Connection con= new Conexion().obtenerConexion();
		List<VentasDto> listaVentas = new ArrayList<VentasDto>();
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT nom_emp, fecha_ventas, valor_ventas, id_ventas from empleados, ventas where id_emp=emp_ventas;");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			VentasDto ventas = new VentasDto();
			ventas.setNom_empventas(rs.getString("nom_emp"));
			ventas.setId_ventas(rs.getInt("id_ventas"));
			ventas.setFecha_venta(rs.getString("fecha_ventas"));
			ventas.setVal_ventas(rs.getInt("valor_ventas"));
			listaVentas.add(ventas);
		}
		ventasListaDto.setListaVentas(listaVentas);
		rs.close();
		return listaVentas;
	}
	public void consultarDiasdeVenta(VentasListasDto ventasListaDto) throws Exception {
		Connection con= new Conexion().obtenerConexion();
		PreparedStatement ps;
		ps= con.prepareStatement("SELECT * FROM ventas");
		Map<String, Object> fecha= new LinkedHashMap<String, Object>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			fecha.put(rs.getString("fecha_ventas"), rs.getString("fecha_ventas"));			
		}
		rs.close();
		ventasListaDto.setLista(fecha);
	}
	public List<VentasDto> mostrarVentasDia(VentasDto ventas, VentasListasDto ventasListaDto) throws Exception {
		Connection con= new Conexion().obtenerConexion();
		List<VentasDto> listaVentas = new ArrayList<VentasDto>();
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT nom_emp, valor_ventas, id_ventas from empleados, ventas where id_emp=emp_ventas AND fecha_ventas=?");
		ps.setString(1, ventas.getFecha_venta());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			VentasDto ventasDto = new VentasDto();
			ventasDto.setNom_empventas(rs.getString("nom_emp"));
			ventasDto.setId_ventas(rs.getInt("id_ventas"));
			ventasDto.setVal_ventas(rs.getInt("valor_ventas"));
			listaVentas.add(ventasDto);
		}
		ventasListaDto.setListaVentasDia(listaVentas);
		rs.close();
		return listaVentas;		
	}
	public boolean agregarVenta(EmpleadoDto empleado, double valor_venta, String fecha_venta) throws Exception {
		Connection con= new Conexion().obtenerConexion();
		try {
			PreparedStatement ps;			
	       	ps=con.prepareStatement("INSERT INTO ventas (emp_ventas, valor_ventas, fecha_ventas) VALUES (?,?,?)");
	       	ps.setInt(1, empleado.getId_empleado() );
	       	ps.setDouble(2, valor_venta);
	       	ps.setString(3, fecha_venta);
	       	ps.executeUpdate();
	    	return true;
	    	}catch (Exception e) {
	    		return false;
	    	}
	}
}