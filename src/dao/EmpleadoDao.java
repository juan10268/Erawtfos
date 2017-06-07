package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dto.EmpleadoDto;
import dto.EmpleadoListaDto;
import util.PersistUtil;

/**
 * @author Tienda Cristhian
 * @version 1.0
 * Esta clase hace la insercion en la base de datos del objeto empleado.
 * En esta capa se hacen validaciones unicamente de conexión.
 */
public class EmpleadoDao {
	EmpleadoDto empleado1= new EmpleadoDto();
	
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param Connection
	 * @return boolean
	 */
	public boolean ingresar(EmpleadoDto empleado1, Connection con) throws Exception {
		PreparedStatement ps = null;	
		try {
			ps=con.prepareStatement("INSERT INTO empleados (id_emp, nom_emp, rol_emp, pass_emp) VALUES (?,?,?,?)");
	       	ps.setInt(1, empleado1.getId_empleado());
	       	ps.setString(2, empleado1.getNom_empleado());
	       	ps.setInt(3, empleado1.getRol_empleado());
	       	ps.setString(4, empleado1.getPass_empleado());
	       	ps.executeUpdate();
	    	return true;
		} catch (SQLException sql) {
			con.rollback();
           throw new Exception(sql.toString());
		} finally {
			PersistUtil.closeResources(ps);
		}
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param Connection
	 * @return nombre de usuario, en caso de que el login sea correcto
	 */
	public String login(EmpleadoDto empleadoDto, Connection con) throws Exception{	
		PreparedStatement pst;
		pst= con.prepareStatement("SELECT * FROM empleados where id_emp=? AND pass_emp=?");
		pst.setInt(1, empleadoDto.getId_empleado());
		pst.setString(2, empleadoDto.getPass_empleado());
		ResultSet rs= pst.executeQuery();
		String per_nombre=null;
		if(rs.next()==true){
			empleado1.setNom_empleado(rs.getString("nom_emp"));
			per_nombre = empleado1.getNom_empleado();
		}
		rs.close();
		return per_nombre;
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoListaDto
	 * @param Connection
	 */
	public void consultarEmpleado(EmpleadoListaDto empleadoListaDto, Connection con) throws Exception {
		PreparedStatement ps;
		ps= con.prepareStatement("SELECT * FROM empleados");
		Map<String, Object> empleado= new LinkedHashMap<String, Object>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			empleado.put(rs.getString("nom_emp"), rs.getInt("id_emp"));			
		}
		rs.close();
		empleadoListaDto.setListaEmpleado(empleado);
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param Connection
	 * @return identificacion del empleado para revisar si existe
	 */
	public String consultarIdentificacion(EmpleadoDto empleadoDto, Connection con) throws Exception {
		PreparedStatement ps;
		ps= con.prepareStatement("SELECT * FROM empleados WHERE id_emp=?");
		ps.setInt(1, empleadoDto.getId_empleado());
		ResultSet rs= ps.executeQuery();
		String per_id= null;
		while(rs.next()){
			empleado1.setNom_empleado(rs.getString("nom_emp"));
			per_id=empleado1.getNom_empleado();
		}
		rs.close();
		return per_id;		
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param Connection
	 * @return boolean
	 */
	public boolean eliminar(EmpleadoDto empleadoDto, Connection con) throws Exception {
		PreparedStatement ps;
		ps= con.prepareStatement("DELETE FROM empleados WHERE id_emp=?");
		ps.setInt(1, empleadoDto.getId_empleado());
		if(ps.executeUpdate()>= 1) {
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param Connection
	 * @return boolean
	 */
	public boolean actualizar(EmpleadoDto empleadoDto, Connection con) throws Exception {
		PreparedStatement ps;
		ps= con.prepareStatement("UPDATE empleados SET rol_emp=?, pass_emp=? WHERE id_emp=?");
		ps.setInt(1, empleadoDto.getRol_empleado());
		ps.setString(2, empleadoDto.getPass_empleado());
		ps.setInt(3, empleadoDto.getId_empleado());
		if (ps.executeUpdate() >= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoDto
	 * @param EmpleadoListaDto
	 * @param Connection
	 * @return informacion de un empleado
	 */
	public List<EmpleadoDto> consultarInfo(EmpleadoDto empleadoDto, EmpleadoListaDto empleadoListaDto, Connection con) throws Exception {
		List<EmpleadoDto> listaEmpleado = new ArrayList<EmpleadoDto>();
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM empleados WHERE id_emp=?");
		ps.setInt(1, empleadoDto.getId_empleado());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			EmpleadoDto empleado = new EmpleadoDto();
			empleado.setId_empleado(rs.getInt("id_emp"));
			empleado.setNom_empleado(rs.getString("nom_emp"));
			empleado.setRol_empleado(rs.getInt("rol_emp"));	
			listaEmpleado.add(empleado);
		}
		empleadoListaDto.setLista(listaEmpleado);
		rs.close();
		return listaEmpleado;
	}
	/**
	 * @author Tienda Cristhian
	 * @version 1.0
	 * @param EmpleadoListaDto
	 * @param Connection
	 */
	public void consultarEmpleadoVentas(EmpleadoListaDto empleadoListaDto, Connection con) throws Exception {
		PreparedStatement ps;
		ps= con.prepareStatement("SELECT id_emp, nom_emp from empleados, ventas where id_emp=emp_ventas;");
		Map<String, Object> empleado= new LinkedHashMap<String, Object>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			empleado.put(rs.getString("nom_emp"), rs.getInt("id_emp"));			
		}
		rs.close();
		empleadoListaDto.setListaEmpleado(empleado);
	}
}