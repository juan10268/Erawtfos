package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.EmpleadoDto;

public class EmpleadoDao {
	EmpleadoDto empleado1= new EmpleadoDto();

	public boolean ingresar(EmpleadoDto empleado1) throws Exception {
		Connection con= new Conexion().obtenerConexion();
		try {
			String p = "INSERT INTO empleados (id_emp, nom_emp, rol_emp, pass_emp)"
					+ " VALUES (?,?,?,?)" ;
			PreparedStatement sentencia1=null;
			int rss=0;			
	       	sentencia1=con.prepareStatement(p);
	       	sentencia1.setInt(1, empleado1.getId_empleado());
	       	sentencia1.setString(2, empleado1.getNom_empleado());
	       	sentencia1.setInt(3, empleado1.getRol_empleado());
	       	sentencia1.setString(4, empleado1.getPass_empleado());
	    	rss=sentencia1.executeUpdate();	
	    	return true;
	    	}catch (Exception e) {
	    		return false;
	    	}
	}
	public String consultarNombre(int id) throws Exception{
		Connection con= new Conexion().obtenerConexion();
		PreparedStatement pst;
		pst= con.prepareStatement("SELECT * FROM empleados where id_emp=?");
		pst.setInt(1, id);
		ResultSet rs= pst.executeQuery();
		while(rs.next()){
			empleado1.setNom_empleado(rs.getString("nom_emp"));
		}
		String per_nombre = empleado1.getNom_empleado();
		rs.close();
		return per_nombre;
	}
	public String consultarPass(int id) throws Exception{
		Connection con= new Conexion().obtenerConexion();
		PreparedStatement pst;
		pst= con.prepareStatement("SELECT * FROM empleados where id_emp=?");
		pst.setInt(1, id);
		ResultSet rs= pst.executeQuery();
		while(rs.next()){
			empleado1.setPass_empleado(rs.getString("pass_emp"));
		}
		String per_pass= empleado1.getPass_empleado();
		return per_pass;
	}
}