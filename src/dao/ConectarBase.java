package dao;

import java.sql.Connection;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class ConectarBase {
	public static Connection ObtenerConnection() {
		try{
			ServletContext sc = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
			Connection cn=(Connection)sc.getAttribute("datasource");
			return cn;
			
		}catch(Exception e){
			return null;
	//		throw new SQLException("Esta es una excepcion en el getConection: "+e.getMessage());
		}
	}	
}